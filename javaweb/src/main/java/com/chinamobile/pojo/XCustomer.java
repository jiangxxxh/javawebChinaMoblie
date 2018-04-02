package com.chinamobile.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户信息表
 */
public class XCustomer implements Serializable {

    private static final long serialVersionUID = -4826975133995566153L;
    private Integer cusId;
    private  String cusType;
    private String cusNumber;
    private String cusName;
    private Date cusBirth;
    private String cusSex;
    private String cusAdd;

    public XCustomer() {
    }

    public XCustomer(Integer cusId, String cusType, String cusNumber, String cusName, Date cusBirth, String cusSex, String cusAdd) {
        this.cusId = cusId;
        this.cusType = cusType;
        this.cusNumber = cusNumber;
        this.cusName = cusName;
        this.cusBirth = cusBirth;
        this.cusSex = cusSex;
        this.cusAdd = cusAdd;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusType() {
        return cusType;
    }

    public void setCusType(String cusType) {
        this.cusType = cusType;
    }

    public String getCusNumber() {
        return cusNumber;
    }

    public void setCusNumber(String cusNumber) {
        this.cusNumber = cusNumber;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Date getCusBirth() {
        return cusBirth;
    }

    public void setCusBirth(Date cusBirth) {
        this.cusBirth = cusBirth;
    }

    public String getCusSex() {
        return cusSex;
    }

    public void setCusSex(String cusSex) {
        this.cusSex = cusSex;
    }

    public String getCusAdd() {
        return cusAdd;
    }

    public void setCusAdd(String cusAdd) {
        this.cusAdd = cusAdd;
    }

    @Override
    public String toString() {
        return "XCustomer{" +
                "cusId=" + cusId +
                ", cusType='" + cusType + '\'' +
                ", cusNumber='" + cusNumber + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusBirth=" + cusBirth +
                ", cusSex='" + cusSex + '\'' +
                ", cusAdd='" + cusAdd + '\'' +
                '}';
    }
}
