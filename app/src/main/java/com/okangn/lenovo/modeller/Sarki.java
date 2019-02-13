package com.okangn.lenovo.modeller;

public class Sarki {
    private String baslik;
    private String resimURL;

    public Sarki(String sbaslik, String sresimURL) {
        baslik = sbaslik;
        resimURL = sresimURL;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getResimURL() {
        return resimURL;
    }

    public void setResimURL(String resimURL) {
        this.resimURL = resimURL;
    }
}
