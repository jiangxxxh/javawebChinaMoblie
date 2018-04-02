package com.chinamobile.dao;

import com.chinamobile.pojo.XCustomer;
import com.chinamobile.pojo.XUser;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class XCustomerDao {

    /**
     * 增加
     *
     * @param xCustomer
     * @return
     */
    public int addXCustomer(XCustomer xCustomer) {
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        int count = 0;
        try {
            XCustomerMapper mapper = session.getMapper(XCustomerMapper.class);
            count = mapper.add(xCustomer);
            session.commit();
        } finally {
            session.close();
        }
        return count;
    }

    /**
     * 修改
     *
     * @param xCustomer
     * @return
     */
    public Integer modifyXCustomer(XCustomer xCustomer) {
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        Integer count = 0;
        try {
            XCustomerMapper mapper = session.getMapper(XCustomerMapper.class);
            count = mapper.modify(xCustomer);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
        return count;
    }

    /**
     * 查询 身份证和号码
     *
     * @param cusType
     * @param cusNumber
     * @return
     */
    public XCustomer findByParam(String cusType, String cusNumber) {
        XCustomer xc = null;
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XCustomerMapper mapper = session.getMapper(XCustomerMapper.class);
            xc = mapper.findByParam(cusType, cusNumber);
        } finally {
            session.close();
        }
        return xc;
    }


}
