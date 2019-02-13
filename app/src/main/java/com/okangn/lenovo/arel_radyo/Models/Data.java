package com.okangn.lenovo.arel_radyo.Models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("User_UserName")
    @Expose
    private String userUserName;
    @SerializedName("User_FullName")
    @Expose
    @Nullable
    private String userFullName;
    @SerializedName("User_Email")
    @Expose
    @Nullable
    private String userEmail;
    @SerializedName("User_Password")
    @Expose
    @Nullable
    private String userPassword;

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

    public String getUserUserName() {
        return userUserName;
    }

    public void setUserUserName(String userUserName) {
        this.userUserName = userUserName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
