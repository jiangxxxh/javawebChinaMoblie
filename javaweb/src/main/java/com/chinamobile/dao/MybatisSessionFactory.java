package com.chinamobile.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisSessionFactory {
    private static SqlSessionFactory factory;
    private static String resource = "mybatis-config.xml";

    static {
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void rebuildSessionFactory() {
        try {
            InputStream in = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取会话工厂对象
     *
     * @return
     */
    public static SqlSessionFactory getSessionFactory() {
        if (factory == null) {
            rebuildSessionFactory();
        }
        return factory;
    }

    private MybatisSessionFactory() {

    }
}
