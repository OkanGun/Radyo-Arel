package com.okangn.lenovo.arel_radyo.Service;

import retrofit2.Retrofit;

public class ApiUtils {

    public static final String BASE_URL="http://mobilapp.arel.edu.tr/radyoareltest/";
    public static final String RADYO_URL="http://api-v2.hearthis.at/";


    public ArelRadyoService getAPIService(String url){
        RetrofitClient retrofitClient = new RetrofitClient();
        return retrofitClient.getClient(url).create(ArelRadyoService.class);
    }

}
