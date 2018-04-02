package com.chinamobile.test;


import com.chinamobile.dao.XUserDao;
import com.chinamobile.pojo.XUser;
import org.junit.Before;
import org.junit.Test;

public class XUserDaoTest {
    private XUserDao dao;

    // 添加用户
    @Test
    public void add() {
        //{userId=null, userStatus='P', userLevel='C', userBalance=0.0, mobilesNum='18390844581', cusId=1}
        XUser xUser = new XUser();
        xUser.setUserStatus("P");
        xUser.setUserLevel("C");
        xUser.setUserBalance(0.00);
        xUser.setMobilesNum("18390844581");
        xUser.setCusId(1);
        if(dao.addXUser(xUser)>0){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }


    }

    // 条件查询
    @Test
    public void findByParam() {
        String mobileNum = "18199998883";
        String cusNum = null;
        String cusType = "身份证";
        for(XUser xu:dao.findByParam(mobileNum,cusNum,cusType)){
            System.out.println(xu.getMobilesNum()+"--"+xu.getXcustomer().getCusNumber()+"--"+xu.getXcustomer().getCusType()+"--"+xu.getXmobiles().getMobilesType());
        }
    }

    // 根据 ID 查询
    @Test
    public void findByid() {
        XUser xu= dao.findById(4);
        System.out.println(xu.getMobilesNum());
    }

    // 根据 手机号 查询
    @Test
    public void findBy() {
        XUser xu= dao.findByNum("18199998884");
        System.out.println(xu);
    }

    // 充值话费
    @Test
    public void modify() {
        if(dao.modifyXUser(4,10.0)>0){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }
    }

    // 充值话费
    @Test
    public void modify2() {
        if(dao.modifyByNum("0",20.0)>0){
            System.out.println("ok");
        }else{
            System.out.println("error");
        }
    }


    @Before
    public void init() {
        dao = new XUserDao();
    }
}
