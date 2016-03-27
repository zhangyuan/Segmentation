package com.evcheung.apps.segmentation.controllers;

public class DataResponse {
    private int status;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private Object data;

    public DataResponse(int status, Object data) {
        this.status = status;
        this.data = data;
    }
}
