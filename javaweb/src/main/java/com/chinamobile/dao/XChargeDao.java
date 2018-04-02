package com.chinamobile.dao;

import com.chinamobile.pojo.XCharge;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class XChargeDao {
    public List<XCharge> find(){
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        List<XCharge> xc = null;
        try {
            XChargeMapper mapper = session.getMapper(XChargeMapper.class);
            xc = mapper.find();
        }finally {
            session.close();
        }
        return xc;
    }

    public int modify(XCharge xcharge){
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        int count = 0;
        try {
            XChargeMapper mapper =session.getMapper(XChargeMapper.class);
            count = mapper.modify(xcharge);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return count;
    }

    public XCharge findById(String chargeCode){
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        XCharge xcharge = null;
        try {
            XChargeMapper mapper =session.getMapper(XChargeMapper.class);
            xcharge = mapper.findById(chargeCode);
        }finally {
            session.close();
        }
        return xcharge;
    }

}
