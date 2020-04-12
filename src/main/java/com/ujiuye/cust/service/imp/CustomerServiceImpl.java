package com.ujiuye.cust.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.cust.bean.Customer;
import com.ujiuye.cust.bean.CustomerExample;
import com.ujiuye.cust.dao.CustomerMapper;
import com.ujiuye.cust.service.CustomerService;
import com.ujiuye.utils.MapUtils;
import com.ujiuye.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.*;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-26 17:13
 **/
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;
    @Autowired
    private JedisPool jedisPool;
    @Override
    public List<Customer> custList() {
//        Jedis jedis = jedisPool.getResource();
        List<Customer> list = null;
//        String customers = jedis.get("customers");
//        if ( customers== null|| customers=="") {
            CustomerExample example = new CustomerExample();
            list = customerMapper.selectByExample(example);
//            jedis.set("customers", JSON.toJSONString(customers));
//        } else {
//           list =  JSON.parseArray(customers,Customer.class);
//        }

//        jedis.close();
        return list;
    }

    @Override
    public void saveInfo(Customer customer) {
        customer.setAddtime(new Date());
        customerMapper.insert(customer);
    }

    @Override
    public Customer getInfoById(Integer id) {
        return  customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateCust(Customer customer) {
        CustomerExample example = new CustomerExample();
        customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public List<Customer> find(String cid, String keyword,String orderby) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        if("1".equals(cid)){
            criteria.andComnameLike("%"+keyword+"%");
        }
        if ("2".equals(cid)){
            criteria.andCompanypersonLike("%"+keyword+"%");
        }
        if("0".equals(cid)){
            CustomerExample.Criteria criteria1 = example.createCriteria();
            criteria.andComnameLike("%"+keyword+"%");
            criteria1.andCompanypersonLike("%"+keyword+"%");
            example.or(criteria1);
        }

        if ("1".equals(orderby)){
            example.setOrderByClause("id desc");
        }
        return customerMapper.selectByExample(example);
    }

    @Override
    public boolean batchDelete(String cid) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        String[] str = cid.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <str.length ; i++) {
            list.add(Integer.valueOf(str[i]));
        }
        criteria.andIdIn(list);
        int i = customerMapper.deleteByExample(example);
        return i==str.length;
    }

    @Override
    public List<Customer> exportExcel(Integer[] ids) {
        CustomerExample example = new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(Arrays.asList(ids));
        List<Customer> list = customerMapper.selectByExample(example);
        return list;
    }
    //
    @Override
    public PageInfo<Customer> getAllByPage(String pageNum) {
        //设置起始页
        int pageNo = 1;
        try {
            pageNo = Integer.parseInt(pageNum);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        PageHelper.startPage(pageNo, PageUtils.PAGE_SIZE);
        CustomerExample example = new CustomerExample();
        List<Customer> list = customerMapper.selectByExample(example);
        PageInfo<Customer> page = new PageInfo<>(list, PageUtils.NAVIGATE_PAGES);
        return page;
    }

    @Override
    public PageInfo<Customer> searchBypage(Map<String, Object> paramMap, String pageNum) {

        int pageNo = 1;
        try {
            pageNo = Integer.parseInt(pageNum);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        PageHelper.startPage(pageNo, PageUtils.PAGE_SIZE);
        Map<String, Object> map = MapUtils.paramMapTomybatisMap(paramMap);
        CustomerExample example =  new CustomerExample();
        CustomerExample.Criteria criteria = example.createCriteria();
        String s = (String)map.get("cid");
        if (map.get("cid")!=null){
            int cid = Integer.parseInt(s);
            String keyword = (String) map.get("keyword");
            if( cid == 0){
                CustomerExample.Criteria criteria1 = example.createCriteria();
                criteria.andComnameLike(keyword);
                criteria1.andCompanypersonLike(keyword);
                example.or(criteria1);
            }
            if(cid==1){
                criteria.andComnameLike(keyword);
            }
            if (cid==2){
                criteria.andCompanypersonLike(keyword);
            }
        }
        if (map.get("orderby")!=null){
            String o = (String)map.get("orderby");
            int orderby = Integer.parseInt(o);

            if (orderby==1){
                example.setOrderByClause("id desc");
            }
        }

        List<Customer> list = customerMapper.selectByExample(example);
        PageInfo<Customer> page = new PageInfo<>(list, PageUtils.NAVIGATE_PAGES);
        return page;
    }

}
