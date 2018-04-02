package com.chinamobile.dao;

import com.chinamobile.condition.Condition;
import com.chinamobile.condition.MobileCondition;
import com.chinamobile.pojo.XMobiles;
import com.chinamobile.util.Pager;
import org.apache.ibatis.session.SqlSession;

import java.io.*;
import java.util.List;

public class XMobilesDao {

    // 增加号码
    public int addXMobiles(XMobiles xMobiles){
        int count = 0;
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XMobilesMapper mapper = session.getMapper(XMobilesMapper.class);
            count = mapper.addXMobiles(xMobiles);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        return count;
    }

    // 批量增加 指定频段
    public boolean addMany(String snum1,String snum2,String mobilesType) {
        boolean flag = false;
        XMobiles xm = new XMobiles();
        xm.setMobilesType(mobilesType);
        xm.setCardNum("");
        xm.setIsAvailable("1");
        if ((snum1 != null && !"".equals(snum1)) && (snum2 != null && !"".equals(snum2))) {
            long num1 = Long.parseLong(snum1);
            long num2 = Long.parseLong(snum2);
            long sum = 0;
            for (long i = num1; i <= num2; i++) {
                xm.setMobilesNum(i + "");
                sum = sum + this.addXMobiles(xm);
            }
            if (sum == (num2 - num1 + 1)) {
                flag = true;
            }
        }
        return flag;
    }

    // 上传文件增加号码
    public int addByFile(File file,String mobilesType){
        XMobiles xm = new XMobiles();
        xm.setMobilesType(mobilesType);
        xm.setCardNum("");
        xm.setIsAvailable("1");
        int i=1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String number = br.readLine();
            while (number != null){
                if(number.trim().length() == 11) {
                    xm.setMobilesNum(number);
                    int count = this.addXMobiles(xm);
                    if(count <= 0){
                        throw new IOException();
                    };
                }else throw new IOException("第"+i+"行号码有错误");
                number = br.readLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (i-1);

    }


    // 更改号码使用状态
    public int midifyXMobiles(String mobilesNum){
        int count = 0;
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();

        try {
            XMobilesMapper mapper = session.getMapper(XMobilesMapper.class);
            count = mapper.midifyXMobiles(mobilesNum);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
        return count;
    }

    // 查询所有可用号码
    public List<XMobiles> findMobiles(){
        List<XMobiles> list = null;
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XMobilesMapper mapper = session.getMapper(XMobilesMapper.class);
            list = mapper.findMobiles();
        } finally {
            session.close();
        }
        return list;
    }

    // 查询所有号码
    public List<XMobiles> findAll(){
        List<XMobiles> list = null;
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XMobilesMapper mapper = session.getMapper(XMobilesMapper.class);
            list = mapper.findAll();
        } finally {
            session.close();
        }
        return list;
    }

    // 根据号码查询
    public XMobiles findByMobileNum(String mobilesNum){
        XMobiles xm = null;
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XMobilesMapper mapper = session.getMapper(XMobilesMapper.class);
            xm = mapper.findByMobileNum(mobilesNum);
        } finally {
            session.close();
        }
        return xm;
    }

    public List<XMobiles> findByParam(String mobilesType){
        List<XMobiles> list = null;
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XMobilesMapper mapper = session.getMapper(XMobilesMapper.class);
            list = mapper.findByParam(mobilesType);
        } finally {
            session.close();
        }
        return list;
    }

    // 删除号码
    public int removeMobiles(String mobilesNum){
        int count = 0;
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XMobilesMapper mapper = session.getMapper(XMobilesMapper.class);
            count = mapper.removeMobiles(mobilesNum);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
        return count;
    }

    // 分页查询数据
    public Pager<XMobiles> findPager(MobileCondition condition){
        Pager<XMobiles> pager = new Pager<>();
        SqlSession session = MybatisSessionFactory.getSessionFactory().openSession();
        try {
            XMobilesMapper mapper = session.getMapper(XMobilesMapper.class);
            // 计算开始行和结束行
            Integer page = condition.getPage();
            Integer rows = condition.getRows();
            condition.setPage((page-1)*rows);
            condition.setRows(page*rows);

            // 总数据记录
            pager.setTotal(mapper.findPagerTotal(condition));
            // 分页数据
            pager.setRows(mapper.findPager(condition));

        } finally {
            session.close();
        }
        return pager;
    }

}
