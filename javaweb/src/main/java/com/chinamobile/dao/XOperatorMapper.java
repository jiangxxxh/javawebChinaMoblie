package com.chinamobile.dao;

import com.chinamobile.pojo.XOperator;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface XOperatorMapper {
    @Select("select op_Id,op_Name,op_Pwd,op_Mark from XOPERATOR where op_Name=#{opName} and op_Pwd=#{opPwd}")
    @Results({
            @Result(property = "opId",column = "op_Id"),
            @Result(property = "opName",column = "op_Name"),
            @Result(property = "opPwd",column = "op_Pwd"),
            @Result(property = "opMark",column = "op_Mark")
    }
    )
    XOperator findByParam(@Param("opName") String opName,
                   @Param("opPwd") String opPwd);


    /**
     * 查询所有
     * @return
     */
    @Select("select op_id,op_name,op_pwd,op_mark from xoperator")
    @Results({
            @Result(property = "opId", column = "op_id"),
            @Result(property = "opName", column = "op_name"),
            @Result(property = "opPwd", column = "op_pwd"),
            @Result(property = "opMark", column = "op_mark")
    }
    )
    List<XOperator> find();

    /**
     * 根据ID查询
     */
    @Select("select op_id,op_name,op_pwd,op_mark from xoperator where op_id=#{id}")
    @Results({
            @Result(property = "opId", column = "op_id"),
            @Result(property = "opName", column = "op_name"),
            @Result(property = "opPwd", column = "op_pwd"),
            @Result(property = "opMark", column = "op_mark")
    }
    )
    XOperator findById(String id);

    /**
     * 新增操作员
     * @return
     */
    @Insert("insert into xoperator(op_id,op_name,op_pwd,op_mark) values(#{opId},#{opName},#{opPwd},#{opMark})")
    int add(XOperator xo);

    /**
     * 修改操作员
     */
    @Update("update xoperator set op_name=#{opName},op_pwd=#{opPwd},op_mark=#{opMark} where op_id=#{opId}")
    int modify(XOperator  x);

    @Delete("delete from xoperator where op_id=#{opId}")
    int remove(String id);

}
