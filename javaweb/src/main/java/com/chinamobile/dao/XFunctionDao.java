package com.chinamobile.dao;

import com.chinamobile.pojo.XFunction;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class XFunctionDao {

    public List<XFunction> fundByCode(String funcCode){
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        List<XFunction> list = null;
        try {
            XFunctionMapper mapper = session.getMapper(XFunctionMapper.class);
            list = mapper.fundByCode(funcCode);
        } finally {
            session.close();
        }
        return list;
    }

    public int addXFunc(XFunction xFunction){
        int count=0;
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XFunctionMapper mapper = session.getMapper(XFunctionMapper.class);
            count = mapper.addXFunc(xFunction);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count;
    }

    public int removeXFunc(String funcCode){
        int count=0;
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XFunctionMapper mapper = session.getMapper(XFunctionMapper.class);
            count = mapper.removeXFunc(funcCode);
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
