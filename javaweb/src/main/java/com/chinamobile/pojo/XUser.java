package com.chinamobile.pojo;

import java.io.Serializable;

public class XUser implements Serializable{
    private static final long serialVersionUID = -3059579692003972991L;
    private  Integer userId;
    private String userStatus;
    private String userLevel;
    private Double userBalance;
    private String mobilesNum;
    private Integer cusId;

    private XCustomer xcustomer;

    private XMobiles xmobiles;

    public XMobiles getXmobiles() {
        return xmobiles;
    }

    public void setXmobiles(XMobiles xmobiles) {
        this.xmobiles = xmobiles;
    }

    public XCustomer getXcustomer() {
        return xcustomer;
    }

    public void setXcustomer(XCustomer xcustomer) {
        this.xcustomer = xcustomer;
    }

    public XUser() {

    }


    public XUser(Integer userId, String userStatus, String userLevel, Double userBalance, String mobilesNum, Integer cusId) {
        this.userId = userId;
        this.userStatus = userStatus;
        this.userLevel = userLevel;
        this.userBalance = userBalance;
        this.mobilesNum = mobilesNum;
        this.cusId = cusId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMobilesNum() {
        return mobilesNum;
    }

    public void setMobilesNum(String mobilesNum) {
        this.mobilesNum = mobilesNum;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }

    @Override
    public String toString() {
        return "XUser{" +
                "userId=" + userId +
                ", userStatus='" + userStatus + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", userBalance=" + userBalance +
                ", mobilesNum='" + mobilesNum + '\'' +
                ", cusId=" + cusId +
                '}';
    }
}
