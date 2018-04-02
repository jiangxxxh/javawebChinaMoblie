package com.chinamobile.dao;

import com.chinamobile.pojo.XFunction;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface XFunctionMapper {

    @Select("select func_code,func_name,charge_code from xfunction where func_code=#{funcCode}")
    @Results({
            @Result(property = "funcCode",column = "func_code"),
            @Result(property = "funcName",column = "func_name"),
            @Result(property = "chargeCode",column = "charge_code")
    })
    List<XFunction> fundByCode(String funcCode);

    @Insert("insert into xfunction(func_code,func_name,charge_code) values(#{funcCode},#{funcName},#{chargeCode})")
    int addXFunc(XFunction xFunction);

    @Delete("delete xfunction where func_code=#{funcCode}")
    int removeXFunc(String funcCode);
}
