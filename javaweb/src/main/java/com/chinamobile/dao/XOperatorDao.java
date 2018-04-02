package com.chinamobile.dao;

import com.chinamobile.pojo.XOperator;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class XOperatorDao {

    public XOperator findByParam(String opName,String opPwd){
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        XOperator xop = null;
        try {
            XOperatorMapper mapper = session.getMapper(XOperatorMapper.class);
            xop = mapper.findByParam(opName,opPwd);
        }finally {
            session.close();
        }
        return xop;
    }


    /**
     * 查询所有操作员信息
     * @return
     */
    public List<XOperator> find() {
        SqlSession session =
                MybatisSessionFactory.getSessionFactory().openSession();
        List<XOperator> ps = null;
        try {
            XOperatorMapper mapper = session.getMapper(XOperatorMapper.class);
            ps = mapper.find();
        } finally {
            session.close();
        }
        return ps;
    }

    /**
     * 根据ID 查询
     * @return
     */
    public XOperator findById(String id) {
        XOperator xo=null;
        SqlSession session =
                MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XOperatorMapper mapper = session.getMapper(XOperatorMapper.class);
            xo = mapper.findById(id);
        }finally {
            session.close();
        }
        return xo;
    }

    /**
     * 增加操作员
     */
    public int add(XOperator x){
        int count=0;
        SqlSession session =
                MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XOperatorMapper mapper = session.getMapper(XOperatorMapper.class);
            count = mapper.add(x);
            session.commit();
        } catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return  count;
    }



    /**
     * 更新操作员
     * @param
     * @return
     */
    public int modify(XOperator x){
        int count=0;
        SqlSession session =
                MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XOperatorMapper mapper = session.getMapper(XOperatorMapper.class);
            count = mapper.modify(x);
            session.commit();
        } catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return  count;
    }

    /**
     * 删除操作员
     */
    public int remove(String id){
        int count=0;
        SqlSession session =
                MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XOperatorMapper mapper = session.getMapper(XOperatorMapper.class);
            count = mapper.remove(id);
            session.commit();
        } catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return  count;
    }

}
