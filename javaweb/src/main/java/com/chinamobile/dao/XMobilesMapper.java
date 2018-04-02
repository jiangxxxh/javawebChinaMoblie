package com.chinamobile.dao;

import com.chinamobile.condition.Condition;
import com.chinamobile.condition.MobileCondition;
import com.chinamobile.pojo.XMobiles;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface XMobilesMapper {

    // 增加号码
    @Insert("insert into xmobiles(mobiles_num,mobiles_type,card_num,is_available) values (#{mobilesNum},#{mobilesType},#{cardNum},#{isAvailable})")
    int addXMobiles(XMobiles xMobiles);


    // 更改号码使用状态
    @Update("update xmobiles set is_available='0' where mobiles_num=#{mobilesNum}")
    int midifyXMobiles(String mobilesNum);

    // 查询所有可用号码
    @Select("select mobiles_num,mobiles_type,card_num,is_available from xmobiles where is_available='1'")
    @Results(
            {
                    @Result(property = "mobilesNum",column ="mobiles_num"),
                    @Result(property = "mobilesType",column ="mobiles_type"),
                    @Result(property = "cardNum",column ="card_num"),
                    @Result(property = "isAvailable",column ="is_available"),
            }
    )
    List<XMobiles> findMobiles();

    // 查询所有号码
    @Select("select mobiles_num,mobiles_type,card_num,is_available from xmobiles")
    @Results(
            {
                    @Result(property = "mobilesNum",column ="mobiles_num"),
                    @Result(property = "mobilesType",column ="mobiles_type"),
                    @Result(property = "cardNum",column ="card_num"),
                    @Result(property = "isAvailable",column ="is_available"),
            }
    )
    List<XMobiles> findAll();

    // 根据手机号码查询
    @Select("select mobiles_num,mobiles_type,card_num,is_available from xmobiles where mobiles_num=#{mobilesNum}")
    @Results(
            {
                    @Result(property = "mobilesNum",column ="mobiles_num"),
                    @Result(property = "mobilesType",column ="mobiles_type"),
                    @Result(property = "cardNum",column ="card_num"),
                    @Result(property = "isAvailable",column ="is_available"),
            }
    )
    XMobiles findByMobileNum(String mobilesNum);

    // 条件查询
    /*@Select("select mobiles_num,mobiles_type,card_num,is_available from xmobiles where mobiles_type=#{mobilesType}")
    @Results(
            {
                    @Result(property = "mobilesNum",column ="mobiles_num"),
                    @Result(property = "mobilesType",column ="mobiles_type"),
                    @Result(property = "cardNum",column ="card_num"),
                    @Result(property = "isAvailable",column ="is_available"),
            }
    )*/
    List<XMobiles> findByParam(@Param("mobilesType") String mobilesType);

    // 删除号码
    @Delete("delete xmobiles where mobiles_num=#{mobilesNum}")
    int removeMobiles(String mobilesNum);

    /**
     * 分页查询数据
     * @param mobileCondition
     * @return
     */
    List<XMobiles> findPager(MobileCondition mobileCondition);

    /**
     * 查询分页数据总数
     * @param mobileCondition
     * @return
     */
    int findPagerTotal(MobileCondition mobileCondition);

}
