package com.okangn.lenovo.arel_radyo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.okangn.lenovo.arel_radyo.Models.Data;
import com.okangn.lenovo.arel_radyo.Models.Info;
import com.okangn.lenovo.arel_radyo.Service.ApiUtils;
import com.okangn.lenovo.arel_radyo.Service.ArelRadyoService;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class girisyap extends AppCompatActivity implements View.OnClickListener {


    private String TAG = "girisyap";

    Button girisyap;
    Button kayıtolagit;
    EditText k_adi1,sifre1;

    String kul_parola, kullanici_adi,favoriler1,begenilenler1,kul_mail,kul_adsoyad;

    SharedPreferenc sharedPreferenc;
    Context context=this;
    CheckBox rememberme;

    TextView uyariparola,uyarikullanici_adi;

    RequestQueue requestQueue;

    String girisYapanKullanıcı;

    int a = 0;

    StringBuilder result;

    String verileriAlUrl = "https://mobilapp.arel.edu.tr/radyoareltest/User/login";



    int id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girisyap);




//        requestQueue = Volley.newRequestQueue(getApplicationContext());

        result = new StringBuilder();

        k_adi1=(EditText)findViewById(R.id.textView9);
        sifre1=(EditText)findViewById(R.id.textView11);

        uyariparola = findViewById(R.id.textView10);
        uyarikullanici_adi = findViewById(R.id.textView12);

        girisyap=(Button) findViewById(R.id.button2);

     //   sharedPreferenc.save(context,"sadi","");


        kayıtolagit=(Button) findViewById(R.id.button5);
        rememberme=(CheckBox) findViewById(R.id.checkBox2);



        kayıtolagit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(main);
            }
        });

        init();
        if (sharedPreferenc.getValueBoolean(context,"remember")){
            k_adi1.setText(sharedPreferenc.getValue(context,"kullaniciadi"));
            sifre1.setText(sharedPreferenc.getValue(context,"kullanicisifresi"));
            rememberme.setChecked(sharedPreferenc.getValueBoolean(context,"remember"));
         //   Intent ans01 = new Intent(getApplicationContext(), anasayfa.class);
           // startActivity(ans01);
        }

        girisyap.setOnClickListener(this);
         sharedPreferenc.save(context,"kullaniciadi","");
        sharedPreferenc.save(context,"kullanicisifresi","");
     //   Intent ans011 = new Intent(getApplicationContext(), girisyap.class);
       // startActivity(ans011);

    }




    private void userSignIn() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();



        String KULadi = k_adi1.getText().toString().trim();
         String Sifre = sifre1.getText().toString().trim();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArelRadyoService service = retrofit.create(ArelRadyoService.class);


        Call<Data> call = service.Login(KULadi, Sifre);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call,retrofit2.Response<Data> response) {
                Data info=response.body();

                Log.i(TAG,"login  Info -->"+info.getInfo());
                Log.i(TAG,"login  Success -->"+info.getSuccess());
                progressDialog.dismiss();
                if (response.body().getSuccess()==1) {

                    Toast.makeText(getApplicationContext(), "Giriş başarılı", Toast.LENGTH_SHORT).show();
                   Intent ans01 = new Intent(getApplicationContext(), anasayfa.class);
                    startActivity(ans01);
                    sharedPreferenc.save(context,"kullaniciadi",k_adi1.getText().toString());
                    sharedPreferenc.save(context,"kullanicisifresi",sifre1.getText().toString());
                /*   if (rememberme.isChecked()){
                       sharedPreferenc.save(context,"kullaniciadi",k_adi1.getText().toString());
                       sharedPreferenc.save(context,"kullanicisifresi",sifre1.getText().toString());
                   }
                   else {
                       sharedPreferenc.save(context,"kullaniciadi","");
                       sharedPreferenc.save(context,"kullanicisifresi","");
                   }*/

                   sharedPreferenc.saveBoolean(context,"remember",rememberme.isChecked());

                    //  finish();   sharedPreferenc.save(context,"kullaniciadi",k_adi1.getText().toString());
                    //                    sharedPreferenc.save(context,"kullanicisifresi",sifre1.getText().toString());
                 //   SharedPrefManager.getInstance(getApplicationContext()).Login(response.body().getUser());

                } else {

                    Toast.makeText(getApplicationContext(), "Kullanıcı bulunamadı", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "İnternetinizi kontrol edin ", Toast.LENGTH_LONG).show();
            }






            });
    }

    public void init(){
sharedPreferenc=new SharedPreferenc();
      //  k_adi1.setText(sharedPreferenc.getValue(context,"kullaniciadi"));
        //sifre1.setText(sharedPreferenc.getValue(context,"kullanicisifresi"));
    }

    @Override
    public void onClick(View view) {
        if (view == girisyap) {
            userSignIn();
        }
    }
}
