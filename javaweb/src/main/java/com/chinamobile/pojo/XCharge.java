package com.chinamobile.pojo;

import java.io.Serializable;

public class XCharge implements Serializable {
    private static final long serialVersionUID = 4673084519594661041L;
    private String chargeCode;
    private String chargeName;
    private Double charge;

    public XCharge() {
    }


    public XCharge(String chargeCode, String chargeName, Double charge) {
        this.chargeCode = chargeCode;
        this.chargeName = chargeName;
        this.charge = charge;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "XCharge{" +
                "chargeCode='" + chargeCode + '\'' +
                ", chargeName='" + chargeName + '\'' +
                ", charge=" + charge +
                '}';
    }
}
