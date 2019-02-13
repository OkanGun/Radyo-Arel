package com.okangn.lenovo.arel_radyo.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uppro {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("info")
    @Expose
    private String info;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
