package com.okangn.lenovo.arel_radyo;

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

public class spiritof70s extends AppCompatActivity {

    ListView list,list1,list2,list3,list4,list5,list6,list7,list8;
    Button geri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiritof70s);

        geri=(Button)findViewById(R.id.anabut08);
        list=(ListView)findViewById(R.id.sprtlist);
        list1=(ListView)findViewById(R.id.sprtlist1);
        list2=(ListView)findViewById(R.id.sprtlist2);
        list3=(ListView)findViewById(R.id.sprtlist3);
        list4=(ListView)findViewById(R.id.sprtlist4);
        list5=(ListView)findViewById(R.id.sprtlist5);
        list6=(ListView)findViewById(R.id.sprtlist6);
        list7=(ListView)findViewById(R.id.sprtlist7);
        list8=(ListView)findViewById(R.id.sprtlist8);



        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Spirittypr();
    }

    private void Spirittypr() {
        ArelRadyoService arelRadyoService;
        ApiUtils apiUtils = new ApiUtils();
        arelRadyoService= apiUtils.getAPIService(ApiUtils.RADYO_URL);



        Call<Example> call=arelRadyoService.getMyRadyoSprit("tracks","1","40");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example sprt=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(sprt), spiritof70s.this);
                list.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call1=arelRadyoService.getMyRadyoSprit1("tracks","1","40");

        call1.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example sprt=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(sprt), spiritof70s.this);
                list1.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call2=arelRadyoService.getMyRadyoSprit2("tracks","1","40");

        call2.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example sprt=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(sprt), spiritof70s.this);
                list2.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });
        Call<Example> call3=arelRadyoService.getMyRadyoSprit3("tracks","1","40");

        call3.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example sprt=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(sprt), spiritof70s.this);
                list3.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call4=arelRadyoService.getMyRadyoSprit4("tracks","1","40");

        call4.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example sprt=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(sprt), spiritof70s.this);
                list4.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call5=arelRadyoService.getMyRadyoSprit5("tracks","1","40");

        call5.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example sprt=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(sprt), spiritof70s.this);
                list5.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call6=arelRadyoService.getMyRadyoSprit6("tracks","1","40");

        call6.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example sprt=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(sprt), spiritof70s.this);
                list6.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call7=arelRadyoService.getMyRadyoSprit7("tracks","1","40");

        call7.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example sprt=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(sprt), spiritof70s.this);
                list7.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call8=arelRadyoService.getMyRadyoSprit8("tracks","1","40");

        call8.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example sprt=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(sprt), spiritof70s.this);
                list8.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

    }
}
