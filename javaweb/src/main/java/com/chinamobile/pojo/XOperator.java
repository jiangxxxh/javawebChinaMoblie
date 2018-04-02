package com.chinamobile.pojo;

import java.io.Serializable;

public class XOperator implements Serializable {
    private static final long serialVersionUID = 7465202738351624982L;
    private String opId;
    private String opName;
    private String opPwd;
    private String opMark;

    public XOperator() {
    }

    public XOperator(String opId, String opName, String opPwd, String opMark) {
        this.opId = opId;
        this.opName = opName;
        this.opPwd = opPwd;
        this.opMark = opMark;
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getOpPwd() {
        return opPwd;
    }

    public void setOpPwd(String opPwd) {
        this.opPwd = opPwd;
    }

    public String getOpMark() {
        return opMark;
    }

    public void setOpMark(String opMark) {
        this.opMark = opMark;
    }

    @Override
    public String toString() {
        return "XOperator{" +
                "opId='" + opId + '\'' +
                ", opName='" + opName + '\'' +
                ", opPwd='" + opPwd + '\'' +
                ", opMark='" + opMark + '\'' +
                '}';
    }
}
