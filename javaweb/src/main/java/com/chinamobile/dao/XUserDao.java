package com.chinamobile.dao;

import com.chinamobile.pojo.XUser;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class XUserDao {

    // 新增用户
    public int addXUser(XUser xUser){
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        int count = 0;
        try {
            XUserMapper mapper = session.getMapper(XUserMapper.class);
            count = mapper.addXUser(xUser);

            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count;
    }

    // 根据手机号和证件号码 证件类型查询
    public List<XUser> findByParam(String mobilesNum,String cusNumber,String cusType){
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        List<XUser> xUsers = null;
        try {
            XUserMapper mapper = session.getMapper(XUserMapper.class);
            xUsers = mapper.findByParam(mobilesNum,cusNumber,cusType);
        } finally {
            session.close();
        }
        return xUsers;
    }

    // 根据ID 查询
    public XUser findById(Integer userId){
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        XUser xUser = null;
        try {
            XUserMapper mapper = session.getMapper(XUserMapper.class);
            xUser = mapper.findById(userId);
        } finally {
            session.close();
        }
        return xUser;
    }

    // 根据手机号码查询
    public XUser findByNum(String mobilesNum){
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        XUser xUser = null;
        try {
            XUserMapper mapper = session.getMapper(XUserMapper.class);
            xUser = mapper.findByNum(mobilesNum);
        } finally {
            session.close();
        }
        return xUser;
    }

    // 充话费
    public int modifyXUser(Integer userId,Double userBalance){
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        int count=0;
        try {
            XUserMapper mapper = session.getMapper(XUserMapper.class);
            count = mapper.modifyXUser(userId,userBalance);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count;

    }

    public int modifyByNum(String mobilesNum,Double userBalance){
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        int count=0;
        try {
            XUserMapper mapper = session.getMapper(XUserMapper.class);
            count = mapper.modifyByNum(mobilesNum,userBalance);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count;

    }
}
