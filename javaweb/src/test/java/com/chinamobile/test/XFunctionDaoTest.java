package com.chinamobile.test;

import com.chinamobile.dao.XFunctionDao;
import com.chinamobile.pojo.XFunction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class XFunctionDaoTest {
    private XFunctionDao dao;

    @Before
    public void init() {
        dao = new XFunctionDao();
    }

    @Test
    public void findByCode() {
        List<XFunction> list = dao.fundByCode("O");
        for(XFunction x:list){
            System.out.println(x);
        }
    }

    @Test
    public void add() {
        XFunction xf = new XFunction();
        xf.setFuncCode("O");
        xf.setFuncName("开户业务");
        xf.setChargeCode("E");
        if(dao.addXFunc(xf)>0){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }
    }

    @Test
    public void remove() {
        String code = "O";
        if(dao.removeXFunc(code)>0){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }
    }
}
