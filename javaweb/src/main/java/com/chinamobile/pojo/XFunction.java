package com.chinamobile.pojo;

import java.io.Serializable;

public class XFunction implements Serializable{
    private static final long serialVersionUID = -2155587215194432110L;

    private String funcCode;
    private String funcName;
    private String chargeCode;


    public XFunction() {

    }

    public XFunction(String funcCode, String funcName, String chargeCode) {
        this.funcCode = funcCode;
        this.funcName = funcName;
        this.chargeCode = chargeCode;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    @Override
    public String toString() {
        return "XFunction{" +
                "funcCode='" + funcCode + '\'' +
                ", funcName='" + funcName + '\'' +
                ", chargeCode='" + chargeCode + '\'' +
                '}';
    }
}
