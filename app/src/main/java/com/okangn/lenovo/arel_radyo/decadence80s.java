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

public class decadence80s extends AppCompatActivity {

    ListView list1,list2,list3,list4,list5,list6,list7,list8;
    Button geri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decadence80s);


        list1=(ListView)findViewById(R.id.declist1);
        list2=(ListView)findViewById(R.id.declist2);
        list3=(ListView)findViewById(R.id.declist3);
        list4=(ListView)findViewById(R.id.declist4);
        list5=(ListView)findViewById(R.id.declist5);
        list6=(ListView)findViewById(R.id.declist6);
        list7=(ListView)findViewById(R.id.declist7);

        geri=(Button)findViewById(R.id.anabut08);

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        
        Deccandenc();

    }

    private void Deccandenc() {

        ArelRadyoService arelRadyoService;
        ApiUtils apiUtils = new ApiUtils();
        arelRadyoService= apiUtils.getAPIService(ApiUtils.RADYO_URL);



        Call<Example> call=arelRadyoService.getMyRadyoDecan1("tracks","1","40");

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example fnk=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(fnk), decadence80s.this);
                list1.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call1=arelRadyoService.getMyRadyoDecan2("tracks","1","40");

        call1.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example fnk=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(fnk), decadence80s.this);
                list2.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call2=arelRadyoService.getMyRadyoDecan3("tracks","1","40");

        call2.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example fnk=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(fnk), decadence80s.this);
                list3.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call3=arelRadyoService.getMyRadyoDecan4("tracks","1","40");

        call3.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example fnk=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(fnk), decadence80s.this);
                list4.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });


        Call<Example> call4=arelRadyoService.getMyRadyoDecan5("tracks","1","40");

        call4.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example fnk=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(fnk), decadence80s.this);
                list5.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call5=arelRadyoService.getMyRadyoDecan6("tracks","1","40");

        call5.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example fnk=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(fnk), decadence80s.this);
                list6.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });

        Call<Example> call6=arelRadyoService.getMyRadyoDecan7("tracks","1","40");

        call6.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example fnk=response.body();

                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(Collections.singletonList(fnk), decadence80s.this);
                list7.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("liste hatası-----",t.getMessage());
            }
        });


    }
}
