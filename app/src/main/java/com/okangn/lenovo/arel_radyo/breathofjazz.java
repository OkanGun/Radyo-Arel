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

public class breathofjazz extends AppCompatActivity {

    ListView list1,list2,list3,list4,list5,list6,list7;
    Button geri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathofjazz);

        list1=(ListView)findViewById(R.id.jazlist1);
        list2=(ListView)findViewById(R.id.jazlist2);
        list3=(ListView)findViewById(R.id.jazlist3);
        list4=(ListView)findViewById(R.id.jazlist4);
        list5=(ListView)findViewById(R.id.jazlist5);
        list6=(ListView)findViewById(R.id.jazlist6);
        list7=(ListView)findViewById(R.id.jazlist7);

        geri=(Button)findViewById(R.id.anabut08);

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Breathjazz();

    }

    private void Breathjazz() {
        ArelRadyoService arelRadyoService;
        ApiUtils apiUtils = new ApiUtils();
        arelRadyoService= apiUtils.getAPIService(ApiUtils.RADYO_URL);



        Call<Example> call=arelRadyoService.getMyRadyoBreathjazz("tracks","1","40");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old4=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old4), breathofjazz.this);
                list1.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call1=arelRadyoService.getMyRadyoBreathjazz1("tracks","1","40");

        call1.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old4=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old4), breathofjazz.this);
                list2.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call2=arelRadyoService.getMyRadyoBreathjazz2("tracks","1","40");

        call2.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old4=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old4), breathofjazz.this);
                list3.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call3=arelRadyoService.getMyRadyoBreathjazz3("tracks","1","40");

        call3.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old4=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old4), breathofjazz.this);
                list4.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call4=arelRadyoService.getMyRadyoBreathjazz4("tracks","1","40");

        call4.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old4=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old4), breathofjazz.this);
                list5.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call5=arelRadyoService.getMyRadyoBreathjazz5("tracks","1","40");

        call5.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old4=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old4), breathofjazz.this);
                list6.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call6=arelRadyoService.getMyRadyoBreathjazz6("tracks","1","40");

        call6.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example old4=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(old4), breathofjazz.this);
                list7.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });


    }
}
