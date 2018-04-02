package com.chinamobile.dao;

import com.chinamobile.pojo.XCustomer;
import com.chinamobile.pojo.XUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface XCustomerMapper {

    /**
     *  增加顾客
     * @param xCustomer
     * @return
     */
    @Insert("insert into xcustomer(CUS_ID,CUS_TYPE,cus_number,CUS_NAME,CUS_BIRTH,CUS_SEX,CUS_ADD) VALUES(#{cusId},#{cusType},#{cusNumber},#{cusName},#{cusBirth},#{cusSex},#{cusAdd})")
    @SelectKey(statement = "select seq_xcus.nextval from dual", keyProperty = "cusId", resultType = int.class, before = true)
    int add(XCustomer xCustomer);

    /**
     *  修改顾客信息
     * @param xCustomer
     * @return
     */
    @Update("update xcustomer set CUS_TYPE=#{cusType},cus_number=#{cusNumber},CUS_NAME=#{cusName},CUS_BIRTH=#{cusBirth},CUS_SEX=#{cusSex},CUS_ADD=#{cusAdd} where CUS_ID=#{cusId}")
    int modify(XCustomer xCustomer);

    /**
     * 模糊查询 身份证和身份证号码
     * @param cusType
     * @param cusNumber
     * @return
     */
    @Results({
            @Result( property = "cusId",column = "cus_id"),
            @Result( property = "cusType",column = "cus_type"),
            @Result( property = "cusNumber",column = "cus_number"),
            @Result( property = "cusName",column = "CUS_NAME"),
            @Result( property = "cusBirth",column = "CUS_BIRTH"),
            @Result( property = "cusSex",column = "CUS_SEX"),
            @Result( property = "cusAdd",column = "CUS_ADD")
    })
    @Select("SELECT CUS_ID ,CUS_TYPE ,cus_number,CUS_NAME,CUS_BIRTH,CUS_SEX,CUS_ADD FROM XCUSTOMER where cus_type=#{cusType} and cus_number=#{cusNumber}")
    XCustomer findByParam(@Param("cusType")String cusType,
                          @Param("cusNumber")String cusNumber);


}





