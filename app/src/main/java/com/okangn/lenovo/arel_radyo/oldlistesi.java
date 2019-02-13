package com.okangn.lenovo.arel_radyo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.okangn.lenovo.arel_radyo.Models.Example;
import com.okangn.lenovo.arel_radyo.Service.ApiUtils;
import com.okangn.lenovo.arel_radyo.Service.ArelRadyoService;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class oldlistesi extends AppCompatActivity {
    ListView list1,list2,list3,list4,list5,list6,list7,list8;
    Button geri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oldlistesi);

        list1=(ListView)findViewById(R.id.oldlist1);
        list2=(ListView)findViewById(R.id.oldlist2);
        list3=(ListView)findViewById(R.id.oldlist3);
        list4=(ListView)findViewById(R.id.oldlist4);
        list5=(ListView)findViewById(R.id.oldlist5);
        list6=(ListView)findViewById(R.id.oldlist6);
        list7=(ListView)findViewById(R.id.oldlist7);
        list8=(ListView)findViewById(R.id.oldlist8);
        geri=(Button)findViewById(R.id.anabut08);

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        OldSchoolTpy();

    }
    private void OldSchoolTpy() {
        ArelRadyoService arelRadyoService;
        ApiUtils apiUtils = new ApiUtils();
        arelRadyoService= apiUtils.getAPIService(ApiUtils.RADYO_URL);



        Call<Example> call=arelRadyoService.getMyRadyoOld4("tracks","1","40");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old4=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old4), oldlistesi.this);
                list1.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call1=arelRadyoService.getMyRadyoOld("tracks","1","40");

        call1.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old), oldlistesi.this);
                list2.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call2=arelRadyoService.getMyRadyoOld3("tracks","1","40");

        call2.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old), oldlistesi.this);
                list3.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call3=arelRadyoService.getMyRadyoOld2("tracks","1","40");

        call3.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old), oldlistesi.this);
                list4.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call4=arelRadyoService.getMyRadyoOld5("tracks","1","40");

        call4.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old), oldlistesi.this);
                list5.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call5=arelRadyoService.getMyRadyoOld6("tracks","1","40");

        call5.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old), oldlistesi.this);
                list6.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call6=arelRadyoService.getMyRadyoOld7("tracks","1","40");

        call6.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old), oldlistesi.this);
                list7.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call7=arelRadyoService.getMyRadyoOld8("tracks","1","40");

        call7.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old), oldlistesi.this);
                list8.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

    }
}
