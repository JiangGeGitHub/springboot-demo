package com.example.demo.pojo;

import java.io.Serializable;

public class ResultEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer status = Integer.valueOf(200);
    private String statuMsg;
    private Object data;

    public ResultEntity() {
        this.status = Integer.valueOf(200);
    }

    public ResultEntity(String statuMsg) {
        this.status = Integer.valueOf(200);
        this.statuMsg = statuMsg;
    }

    public ResultEntity(Integer status, String statuMsg) {
        this.status = status;
        this.statuMsg = statuMsg;
    }

    public ResultEntity(Integer status, String statuMsg, Object data) {
        this.status = status;
        this.statuMsg = statuMsg;
        this.data = data;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatuMsg() {
        return this.statuMsg;
    }

    public void setStatuMsg(String statuMsg) {
        this.statuMsg = statuMsg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}