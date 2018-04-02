package com.chinamobile.test;

import com.chinamobile.dao.XCustomerDao;
import com.chinamobile.pojo.XCustomer;
import com.chinamobile.pojo.XUser;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class XCustomerTest {
    private XCustomerDao dao;

    @Before
    public void init() {
        dao = new XCustomerDao();
    }

    @Test//模糊查询
    public void findByParam() {
        String cusType = "身份证";
        String cusNumber= "430111198007285521";
        XCustomer list = dao.findByParam(cusType,cusNumber);
        System.out.println(list);
    }


    @Test//添加顾客
    public void addXCustomer() {
        String sdate = "2017-1-1";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        XCustomer xCustomer = new XCustomer(1, "护照", "430102198901015536", "小马哥", date, "男", "中国北京");
        int count = dao.addXCustomer(xCustomer);

    }

    @Test
    // 修改顾客信息
    public void modifyXCustomer() {
    XCustomer xCustomer = new XCustomer();
    xCustomer.setCusId(2);
    xCustomer.setCusType("护照");
    xCustomer.setCusNumber("430102198901015536");
    xCustomer.setCusName("涛哥");
    xCustomer.setCusBirth(new Date());
    xCustomer.setCusSex("男");
    xCustomer.setCusAdd("洛杉矶");
    int count = dao.modifyXCustomer(xCustomer);
    if (count >0){
        System.out.println("ok");
    }else {
        System.out.println("error");
    }
    }



}
