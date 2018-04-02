package com.chinamobile.test;

import com.chinamobile.condition.Condition;
import com.chinamobile.condition.MobileCondition;
import com.chinamobile.dao.XMobilesDao;
import com.chinamobile.pojo.XMobiles;
import com.chinamobile.util.Pager;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class XMobilesDaoTest {
    private XMobilesDao dao;

    @Test
    public void findMobiles() {
        List<XMobiles> list = dao.findMobiles();
        for(XMobiles m:list){
            System.out.println(m.getMobilesNum()+"--"+m.getMobilesType()+"--"+m.getIsAvailable());
        }
    }
    @Test
    public void findAll() {
        List<XMobiles> list = dao.findAll();
        for(XMobiles m:list){
            System.out.println(m.getMobilesNum()+"--"+m.getMobilesType()+"--"+m.getIsAvailable());
        }
    }

    // 根据号码查询
    @Test
    public void findByMobileNum() {
        String num = "";
        XMobiles xm = dao.findByMobileNum(num);
        System.out.println(xm);
    }

    // 条件查询
    @Test
    public void findbyParam() {
        String param = "UIM";
        List<XMobiles> list = dao.findByParam(param);
        for(XMobiles m:list){
            System.out.println(m.getMobilesNum()+"--"+m.getMobilesType()+"--"+m.getIsAvailable());
        }
    }

    @Test
    public void add() {
        XMobiles xm = new XMobiles();
        xm.setMobilesNum("18190854582");
        xm.setMobilesType("UIM");
        xm.setCardNum("");
        xm.setIsAvailable("1");
        if(dao.addXMobiles(xm)>0){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }
    }

    // 批量增加
    @Test
    public void addMany() {
        String snum1="18399000103";
        String snum2="18399000105";
       if(dao.addMany(snum1,snum2,"UIM")){
           System.out.println("ok");
       }else{
           System.out.println("error");
       }
    }

    @Test
    public void addByFile() {
        File file = new File("E:\\IdeaProjects\\中国移动收费\\phonenumber.txt");
        int i=dao.addByFile(file,"UIM");
        System.out.println("增加了"+i);
    }

    @Test
    public void modify() {
        if(dao.midifyXMobiles("18190854582")>0){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }
    }


    // 分页查询  查询总数
    @Test
    public void findPager() {
        MobileCondition condition = new MobileCondition();
        int page = 1;
        int rows = 3;
        condition.setPage(page);
        condition.setRows(rows);
        condition.setOrder("asc");
        condition.setSort("mobilesNum");
        //condition.setMobilesType("UIM");


        Pager<XMobiles> pager= dao.findPager(condition);
        System.out.println("总记录条数："+pager.getTotal());
        for(XMobiles x:pager.getRows()){
            System.out.println(x);
        }
    }

    @Before
    public void init() {
        dao = new XMobilesDao();
    }
}
