package com.chinamobile.dao;

import com.chinamobile.pojo.XCharge;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface XChargeMapper {
    @Select("select charge_Code chargeCode,charge_Name chargeName,charge from XCharge")
    List<XCharge> find();

    @Update("update XCharge set charge=#{charge} where CHARGE_CODE=#{chargeCode}")
    int modify(XCharge xcharge);

    @Select("select charge_Code chargeCode,charge_Name chargeName,charge from XCharge where charge_Code=#{chargeCode}")
    XCharge findById(@Param("chargeCode") String chargeCode);
}

