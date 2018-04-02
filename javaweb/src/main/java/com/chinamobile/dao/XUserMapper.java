package com.chinamobile.dao;

import com.chinamobile.pojo.XUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface XUserMapper {

    @Insert("insert into xuser(user_id,user_status,user_level,user_balance,mobiles_num,cus_id)" +
            "values(#{userId},#{userStatus},#{userLevel},#{userBalance},#{mobilesNum},#{cusId})")
    @SelectKey(statement = "select seq_xuser.nextval from dual",
                keyProperty = "userId",resultType = int.class,before = true)
    int addXUser(XUser xUser);

    /**
     *  查询 手机 或者 身份证号码
     * @param mobilesNum
     * @param cusNumber
     * @return
     */
    @Results({
            @Result( property = "userId",column = "user_id"),
            @Result( property = "userStatus",column = "user_status"),
            @Result( property = "userLevel",column = "user_level"),
            @Result( property = "userBalance",column = "user_balance"),
            @Result( property = "mobilesNum",column = "mobiles_num"),
            @Result( property = "cusId",column = "cus_id"),
            @Result( property = "cusType",column = "cus_type"),
            @Result( property = "cusNumber",column = "cus_number"),
            @Result( property = "cusName",column = "CUS_NAME"),
            @Result( property = "cusBirth",column = "CUS_BIRTH"),
            @Result( property = "cusSex",column = "CUS_SEX"),
            @Result( property = "cusAdd",column = "CUS_ADD"),
            }
    )
    List<XUser> findByParam(@Param("mobilesNum")String mobilesNum,
                            @Param("cusNumber")String cusNumber,
                            @Param("cusType")String cusType);


    // 根据ID 查询
    @Results({
            @Result( property = "userId",column = "user_id"),
            @Result( property = "userStatus",column = "user_status"),
            @Result( property = "userLevel",column = "user_level"),
            @Result( property = "userBalance",column = "user_balance"),
            @Result( property = "mobilesNum",column = "mobiles_num"),
            @Result( property = "cusId",column = "cus_id")
    }
    )
    @Select("select user_id,user_status,user_level,user_balance,mobiles_num,cus_id from xuser where user_id=#{userId}")
    XUser findById(Integer userId);

    // 根据手机号码查询
    @Results({
            @Result( property = "userId",column = "user_id"),
            @Result( property = "userStatus",column = "user_status"),
            @Result( property = "userLevel",column = "user_level"),
            @Result( property = "userBalance",column = "user_balance"),
            @Result( property = "mobilesNum",column = "mobiles_num"),
            @Result( property = "cusId",column = "cus_id")
    }
    )
    @Select("select user_id,user_status,user_level,user_balance,mobiles_num,cus_id from xuser where mobiles_num=#{mobilesNum}")
    XUser findByNum(String mobilesNum);

    // 充值金额
    @Update("update xuser set user_balance=user_balance+${userBalance} where user_id=${userId}")
    int modifyXUser(@Param("userId")Integer userId,
                    @Param("userBalance")Double userBalance);

    // 根据手机号充值金额
    @Update("update xuser set user_balance=user_balance+${userBalance} where mobiles_num=${mobilesNum}")
    int modifyByNum(@Param("mobilesNum")String mobilesNum,
                    @Param("userBalance")Double userBalance);

}
