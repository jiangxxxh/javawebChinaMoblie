package com.chinamobile.condition;

public class MobileCondition extends Condition {

    private String mobilesType;

    public MobileCondition() {
    }

    public MobileCondition(Integer page, Integer rows, String sort, String order, String mobilesType) {
        super(page, rows, sort, order);
        this.mobilesType = mobilesType;
    }

    public String getMobilesType() {
        return mobilesType;
    }

    public void setMobilesType(String mobilesType) {
        this.mobilesType = mobilesType;
    }

    @Override
    public String toString() {
        return "MobileCondition{" +
                "mobilesType='" + mobilesType + '\'' +
                '}';
    }
}
