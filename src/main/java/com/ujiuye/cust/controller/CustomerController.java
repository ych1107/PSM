package com.ujiuye.cust.controller;

import com.github.pagehelper.PageInfo;
import com.ujiuye.cust.bean.Customer;
import com.ujiuye.cust.service.CustomerService;
import com.ujiuye.utils.MapUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-26 17:14
 **/
@Controller
@RequestMapping("/cust")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView custList() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customer");
        List<Customer> list = customerService.custList();
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
    public String saveInfo(Customer customer) {

        customerService.saveInfo(customer);
        return "redirect:/cust/searchBypage";


    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String getInfoById(@PathVariable("id") Integer id, Map<String, Object> map) {
        Customer customer = customerService.getInfoById(id);
        map.put("customer", customer);
        return "customer-look";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getInfo(@PathVariable("id") Integer id, Map<String, Object> map) {
        Customer customer = customerService.getInfoById(id);
        map.put("customer", customer);
        return "customer-edit";
    }

    @RequestMapping(value = "/updateCust", method = RequestMethod.PUT)
    public String updateCust(Customer customer) {
        customerService.updateCust(customer);
        return "redirect:/cust/list";
    }

    @RequestMapping("/find")
    public ModelAndView find(String cid, String keyword, String orderby) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("customer");
        List<Customer> list = customerService.find(cid, keyword, orderby);
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping(value = "/batchDelete/{cid}")
    @ResponseBody
    public Map<String, Object> batchDelete(@PathVariable("cid") String cid) {
        Map<String, Object> map = new HashMap<String, Object>();
        boolean i = customerService.batchDelete(cid);
        if (i) {
            map.put("status", "200");
            map.put("message", "删除成功");
        } else {
            map.put("message", "删除失败");
        }
        return map;
    }

    @RequestMapping(value = "/jsonListCust", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> jsonListCust() {
        List<Customer> list = customerService.custList();
        return list;
    }

    @RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
    @ResponseBody
    public String exportExcel(@RequestParam("ids[]") Integer[] ids, HttpServletResponse response) throws Exception {

        String fileName = "test.xls";
        response.setHeader("Content-disposition", "attachment;filename="
                + new String(fileName.getBytes("gb2312"), "ISO8859-1"));//设置文件头编码格式
        response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");//设置类型
        response.setHeader("Cache-Control", "no-cache");//设置头
        response.setDateHeader("Expires", 0);//设置日期头

        Map<String, Object> map = new HashMap<>();
        System.out.println("我进来了");
        List<Customer> list = customerService.exportExcel(ids);
        System.out.println(list.size());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Workbook wb = new HSSFWorkbook();
        FileOutputStream outputStream = null;
        ServletOutputStream outputStream1 = response.getOutputStream();
        try {
            Sheet sheet = wb.createSheet("第一个sheet");
            Row row = sheet.createRow(0);
            Cell[] cell = new HSSFCell[5];
            for (int i = 0; i < cell.length; i++) {
                cell[i] = row.createCell(i);
            }
            cell[0].setCellValue("序号");
            cell[1].setCellValue("联系人");
            cell[2].setCellValue("公司名称");
            cell[3].setCellValue("添加时间");
            cell[4].setCellValue("联系电话");
            for (int j = 0; j < list.size(); j++) {
                Customer customer = list.get(j);
                Row row1 = sheet.createRow(j + 1);
                Cell[] cell1 = new HSSFCell[5];
                for (int k = 0; k < cell1.length; k++) {
                    cell1[k] = row1.createCell(k);
                }
                cell1[0].setCellValue(j + 1);
                cell1[1].setCellValue(customer.getCompanyperson());
                cell1[2].setCellValue(customer.getComname());
                Date addtime = customer.getAddtime();
                String format = sdf.format(addtime);
                cell1[3].setCellValue(format);
                cell1[4].setCellValue(customer.getComphone());
            }
            outputStream = new FileOutputStream(new File("D://abc.xls"));
            wb.write(outputStream1);
            outputStream1.flush();
            outputStream1.close();
            map.put("message", "导出成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                outputStream.close();
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    @RequestMapping(value = "/import", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> importExcel(MultipartFile file) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Workbook wb = WorkbookFactory.create(file.getInputStream());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        List<Customer> customers = new ArrayList<Customer>();
        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            Sheet sheetAt = wb.getSheetAt(i);
            if (sheetAt != null) {
                for (int j = sheetAt.getFirstRowNum() + 1; j <= sheetAt.getLastRowNum(); j++) {
                    Row row = sheetAt.getRow(j);
                    Customer customer = new Customer();
                    int id = (int) row.getCell(0).getNumericCellValue();
                    customer.setId(id);
                    String stringCellValue = row.getCell(1).getStringCellValue();
                    customer.setCompanyperson(stringCellValue);
                    String companyName = row.getCell(2).getStringCellValue();
                    customer.setComname(companyName);
                    String date = row.getCell(3).getStringCellValue();
                    customer.setAddtime(sdf.parse(date));
                    customers.add(customer);
                    System.out.println();
                }
            }
        }
        System.out.println(customers);
        map.put("message", "导入成功");
        return map;
    }

    @RequestMapping("/getAllByPage")
    public ModelAndView getAllByPage(@RequestParam(value = "pageNum", defaultValue = "1") String pageNum) {
        ModelAndView mv = new ModelAndView();
        PageInfo<Customer> page = customerService.getAllByPage(pageNum);
        System.out.println(page.getList());
        mv.setViewName("customer");
        mv.addObject("page", page);
        return mv;
    }

    /**
     * @return org.springframework.web.servlet.ModelAndView
     * @Author Mr.C
     * @Description 查询结果分页显示
     * @Date 2019/12/3 14:21
     * @Param [request, pageNum] pageNum 表示传的页数
     **/
    @RequestMapping("/searchBypage")
    public ModelAndView searchBypage(HttpServletRequest request, @RequestParam(value = "pageNum", defaultValue = "1") String pageNum) {
        ModelAndView mv = new ModelAndView();
        String requestURI = request.getRequestURI();
        mv.setViewName("customer");
        Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request, "search_");
        PageInfo<Customer> page = customerService.searchBypage(paramMap, pageNum);
        String queryStr = MapUtils.parseParamMapToQueryStr(paramMap);
        mv.addObject("queryStr", queryStr);//将查询的参数保存到域中
        mv.addObject("page", page);//将查询的结果返回给前端
        mv.addObject("requestURI", requestURI);//将访问路径地址返回给前端
        return mv;
    }
}

