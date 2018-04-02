package com.chinamobile.test;

import com.chinamobile.dao.XOperatorDao;
import com.chinamobile.md5.MD5;
import com.chinamobile.pojo.XOperator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class XOperatorDaoTest {

    private XOperatorDao dao;

    @Before
    public void init() {
        dao = new XOperatorDao();
    }

    @Test
    public void findByParam() {
        String name = "admin";
        String pws = "2de6266ff6f07dacbbc0c9e36c282d6f";
        XOperator xo = dao.findByParam(name,pws);
        System.out.println(xo);
    }

    @Test
    public void findAll() {
        List<XOperator> list = dao.find();
        for(XOperator x:list){
            System.out.println(x);
        }
    }

    @Test
    public void add() {
        XOperator x=new XOperator("A000000003","boss", MD5.getMD5("admin123"),"Y");
        int i=dao.add(x);
        if (i>0){
            System.out.println("增加成功");
        }else {
            System.out.println("增加失败");
        }
    }

    @Test
    public  void modify(){
        XOperator x=new XOperator("A000000002","张大彪", MD5.getMD5("123456"),"N");
        int i=dao.modify(x);
        if (i>0){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void delete(){
        int i=dao.remove("A000000003");
        if (i>0){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
}
