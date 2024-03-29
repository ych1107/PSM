package com.ujiuye.pro.bean;

import com.ujiuye.cust.bean.Customer;
import com.ujiuye.emp.bean.Employee;

import java.util.Date;

public class Project {
    private Integer pid;  //序号

    private String pname;  //项目名称

    private Integer comname; //客户公司名称

    private String comper; //客户方负责人

    private Integer empFk1; //项目经理

    private Integer empcount;//开发人员数

    private Date starttime; //开始时间

    private Date buildtime;  //立项时间

    private Integer cost; //花销

    private String level; //等级

    private Date endtime; //结束时间

    private String remark;  //

    private Integer empFk;
    private Customer customer;
    private Employee employee;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Integer getComname() {
        return comname;
    }

    public void setComname(Integer comname) {
        this.comname = comname;
    }

    public String getComper() {
        return comper;
    }

    public void setComper(String comper) {
        this.comper = comper == null ? null : comper.trim();
    }

    public Integer getEmpFk1() {
        return empFk1;
    }

    public void setEmpFk1(Integer empFk1) {
        this.empFk1 = empFk1;
    }

    public Integer getEmpcount() {
        return empcount;
    }

    public void setEmpcount(Integer empcount) {
        this.empcount = empcount;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getEmpFk() {
        return empFk;
    }

    public void setEmpFk(Integer empFk) {
        this.empFk = empFk;
    }

    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", comname=" + comname +
                ", comper='" + comper + '\'' +
                ", empFk1=" + empFk1 +
                ", empcount=" + empcount +
                ", starttime=" + starttime +
                ", buildtime=" + buildtime +
                ", cost=" + cost +
                ", level='" + level + '\'' +
                ", endtime=" + endtime +
                ", remark='" + remark + '\'' +
                ", empFk=" + empFk +
                ", customer=" + customer +
                ", employee=" + employee +
                '}';
    }
}