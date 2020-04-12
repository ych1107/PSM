package com.ujiuye.usual.controller;

import com.github.pagehelper.PageInfo;
import com.ujiuye.emp.bean.Employee;
import com.ujiuye.usual.bean.Baoxiao;
import com.ujiuye.usual.service.BaoxiaoService;
import com.ujiuye.utils.MapUtils;
import com.ujiuye.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-03 16:30
 **/
@Controller
@RequestMapping("/bx")
public class BaoxiaoController {

    @Autowired
    private BaoxiaoService baoxiaoService;
    @RequestMapping("/saveInfo")
    public String saveInfo(Baoxiao baoxiao, HttpSession session){

        Employee loginUser = (Employee) session.getAttribute("loginUser");

        baoxiao.setEmpFk(loginUser.getEid());
        baoxiao.setBxstatus(0);
        baoxiaoService.saveInfo(baoxiao);
        return "redirect:/mybaoxiao-base.jsp";
    }
    /**
     * @Author Mr.C
     * @Description 同步请求的查询分页
     * @Date 2019/12/3 19:13
     * @Param [request, pageNum]
     * @return org.springframework.web.servlet.ModelAndView
    **/
    @RequestMapping("/getAll")
    public ModelAndView getAll(HttpServletRequest request,String pageNum){
        String requestURI = request.getRequestURI();
        ModelAndView mv = new ModelAndView();
        Map<String, Object> map = WebUtils.getParametersStartingWith(request, "search_");
        Map<String, Object> map1 = MapUtils.paramMapTomybatisMap(map);
        String queryStr = MapUtils.parseParamMapToQueryStr(map);
        PageInfo<Baoxiao> page = baoxiaoService.getAll(map1,pageNum);
        mv.setViewName("mybaoxiao-base");
        mv.addObject("page",page);
        mv.addObject("queryStr", queryStr);
        mv.addObject("requestURI", requestURI);
        return mv;
    }
    /**
     * @Author Mr.C
     * @Description  异步请求的分页以及查询
     * @Date 2019/12/3 21:37
     * @Param [request, pageNum, search_cid]
     * @return com.ujiuye.utils.ResultEntity
    **/
    @RequestMapping("/seachBypage")
    @ResponseBody
    public ResultEntity seachBypage(HttpServletRequest request, String pageNum){
        String requestURI = request.getRequestURI();
        ModelAndView mv = new ModelAndView();
        Map<String, Object> map = WebUtils.getParametersStartingWith(request, "search_");
        /*if (search_cid!=null){
            map.put("cid", search_cid);
        }*/
        System.out.println(map);
        Map<String, Object> map1 = MapUtils.paramMapTomybatisMap(map);
        String queryStr = MapUtils.parseParamMapToQueryStr(map);
        PageInfo<Baoxiao> page = baoxiaoService.getAll(map1,pageNum);
        mv.setViewName("mybaoxiao-base");
        mv.addObject("page",page);
        mv.addObject("queryStr", queryStr);
        mv.addObject("requestURI", requestURI);
        return ResultEntity.getResultEntity().put("page",page).put("queryStr",queryStr).put("requestURI",requestURI);
    }

}
