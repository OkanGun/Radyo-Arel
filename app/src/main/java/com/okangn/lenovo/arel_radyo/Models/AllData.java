package com.okangn.lenovo.arel_radyo.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllData {
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Full_Name")
    @Expose
    private String fullName;
    @SerializedName("Mail")
    @Expose
    private String mail;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("UserName")
    @Expose
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
