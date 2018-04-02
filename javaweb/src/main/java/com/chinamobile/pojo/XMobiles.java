package com.chinamobile.pojo;

import java.io.Serializable;

public class XMobiles implements Serializable{
    private static final long serialVersionUID = -1265310437055873585L;
    private String mobilesNum;
    private String mobilesType;
    private String cardNum;
    private String isAvailable;

    public XMobiles() {
    }

    public XMobiles(String mobilesNum, String mobilesType, String cardNum, String isAvailable) {
        this.mobilesNum = mobilesNum;
        this.mobilesType = mobilesType;
        this.cardNum = cardNum;
        this.isAvailable = isAvailable;
    }

    public String getMobilesNum() {
        return mobilesNum;
    }

    public void setMobilesNum(String mobilesNum) {
        this.mobilesNum = mobilesNum;
    }

    public String getMobilesType() {
        return mobilesType;
    }

    public void setMobilesType(String mobilesType) {
        this.mobilesType = mobilesType;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "XMobiles{" +
                "mobilesNum='" + mobilesNum + '\'' +
                ", mobilesType='" + mobilesType + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", isAvailable='" + isAvailable + '\'' +
                '}';
    }
}
