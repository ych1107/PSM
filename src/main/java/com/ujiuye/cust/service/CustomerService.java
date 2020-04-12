package com.ujiuye.cust.service;

import com.github.pagehelper.PageInfo;
import com.ujiuye.cust.bean.Customer;

import java.util.List;
import java.util.Map;


public interface CustomerService {
    List<Customer> custList();

    void saveInfo(Customer customer);

    Customer getInfoById(Integer id);

    void updateCust(Customer customer);

    List<Customer> find(String cid, String keyword,String orderby);

    boolean batchDelete(String cid);

    List<Customer> exportExcel(Integer[] ids);

    PageInfo<Customer> getAllByPage(String pageNum);

    PageInfo<Customer> searchBypage(Map<String, Object> paramMap, String pageNum);
}
