package com.chinamobile.test;

import com.chinamobile.dao.XChargeDao;
import com.chinamobile.pojo.XCharge;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class XChargeDaoTest {
    private XChargeDao dao;

    @Before
    public void init() {
        dao = new XChargeDao();
    }

    @Test
    public void fandByid() {
        XCharge xc = dao.findById("A");
        System.out.println(xc);
    }

    @Test
    public void find() {
        List<XCharge> list = dao.find();
        for(XCharge xc:list){
            System.out.println(xc);
        }
    }

    @Test
    public void modify() {
        XCharge xc = new XCharge();
        xc.setCharge(80.00);
        xc.setChargeCode("C");
        xc.setChargeName("押金");
        if(dao.modify(xc)>0){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }
    }
}
