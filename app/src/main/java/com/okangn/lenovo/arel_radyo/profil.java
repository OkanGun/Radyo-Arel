package com.okangn.lenovo.arel_radyo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.okangn.lenovo.arel_radyo.Models.Data;
import com.okangn.lenovo.arel_radyo.Models.Info;
import com.okangn.lenovo.arel_radyo.Service.ApiUtils;
import com.okangn.lenovo.arel_radyo.Service.ArelRadyoService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class profil extends AppCompatActivity {

    private String TAG = "profil";
    ArelRadyoService arelRadyoService;

    TextView KulaniciAdi;
    EditText Kullanicimail, Kullanicisifre, KullaniciAdsoyad;
    Button prokaydet,cikisyap;
    String parola, kullanici_adi, ad_soyad, mail;
    SharedPreferenc sharedPreferenc;
    Context context = this;
    Button progeri;

    TextView uyariparola, uyariad_soyAd, uyarimail,uyarikullanici_adi;

    RequestQueue requestQueue;

    String girisYapanMusteri;

    int a = 0;

    StringBuilder result;

    String verileriAlUrl = "http://mobilapp.arel.edu.tr/radyoareltest/User/login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        KulaniciAdi = (TextView) findViewById(R.id.textView);
        Kullanicisifre = (EditText) findViewById(R.id.textView3);
        Kullanicimail = (EditText) findViewById(R.id.textView5);
        KullaniciAdsoyad = (EditText) findViewById(R.id.textView7);

        prokaydet=(Button)findViewById(R.id.button);
        cikisyap=(Button)findViewById(R.id.button3);
        progeri=(Button)findViewById(R.id.button7);


        uyarimail = (findViewById(R.id.textView6));
        uyariparola = (findViewById(R.id.textView4));
        uyariad_soyAd = (findViewById(R.id.textView8));



        init();

        KulaniciAdi.setText(sharedPreferenc.getValue(context, "kullaniciadi"));
        Kullanicisifre.setText(sharedPreferenc.getValue(context, "kullanicisifresi"));

        userSignIn();

        prokaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                parola = Kullanicisifre.getText().toString();
                kullanici_adi = KulaniciAdi.getText().toString();
                ad_soyad = KullaniciAdsoyad.getText().toString();
                mail = Kullanicimail.getText().toString();

                if (parola.isEmpty() ||  ad_soyad.isEmpty() || mail.isEmpty())

                {
                    Toast.makeText(getApplicationContext(), "Tüm bilgileri eksiksiz doldurmalısınız..", Toast.LENGTH_LONG).show();

                }
                else {

                   /*    if (4 == parola.length()){
                        uyariparola.setText(" ");
                    }*/

                    if (4 != parola.length()) {
                        //   Toast.makeText(getApplicationContext(), "Dört karakterden oluşmalıdır..", Toast.LENGTH_LONG).show();

                        uyariparola.setText("Dört karakterden oluşmalıdır..");

                    }

                    uyariparola.setText(" ");

              /*       else if (!sayiVarmi(kullanici_adi)) {
                        //  Toast.makeText(getApplicationContext(), "Ad ve soyadın  içinde sayı olamaz..", Toast.LENGTH_LONG).show();
                        uyarikullanici_adi.setText(" ");

                    } */



                    if (sayiVarmi(ad_soyad)) {
                        //  Toast.makeText(getApplicationContext(), "Ad ve soyadın  içinde sayı olamaz..", Toast.LENGTH_LONG).show();
                        uyariad_soyAd.setText("Ad ve soyadın  içinde sayı olamaz..");

                    }

                    uyariad_soyAd.setText(" ");

                 /*    else if (Fonksiyonlar.isEmailValid(mail)) {
                        //   Toast.makeText(getApplicationContext(), "Girdiğiniz mail formata uygun değildir..", Toast.LENGTH_LONG).show();
                        uyarimail.setText(" ");
                    } */


                    if (!MainActivity.Fonksiyonlar.isEmailValid(mail)) {
                        //   Toast.makeText(getApplicationContext(), "Girdiğiniz mail formata uygun değildir..", Toast.LENGTH_LONG).show();
                        uyarimail.setText("Girdiğiniz mail formata uygun değildir.");
                    }

                    uyarimail.setText(" ");

                    if (sayiVarmi(kullanici_adi)) {
                        //  Toast.makeText(getApplicationContext(), "Ad ve soyadın  içinde sayı olamaz..", Toast.LENGTH_LONG).show();
                        uyarikullanici_adi.setText("Kullanıcı adı  içinde sayı olamaz..");

                    }

                    else       if (!MainActivity.Fonksiyonlar.isEmailValid(mail)) {
                        //   Toast.makeText(getApplicationContext(), "Girdiğiniz mail formata uygun değildir..", Toast.LENGTH_LONG).show();
                        uyarimail.setText("Girdiğiniz mail formata uygun değildir.");
                    }

                    else     if (4 != parola.length()) {
                        //   Toast.makeText(getApplicationContext(), "Dört karakterden oluşmalıdır..", Toast.LENGTH_LONG).show();

                        uyariparola.setText("Dört karakterden oluşmalıdır..");

                    }


                    else      if (sayiVarmi(ad_soyad)) {
                        //  Toast.makeText(getApplicationContext(), "Ad ve soyadın  içinde sayı olamaz..", Toast.LENGTH_LONG).show();
                        uyariad_soyAd.setText("Ad ve soyadın  içinde sayı olamaz..");

                    }






                    else  {

                        //  yolla();

                         register();

                    }
                }

            }
        });



        cikisyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferenc.save(context,"kullaniciadi","");
                sharedPreferenc.save(context,"kullanicisifresi","");

                Intent cks = new Intent(getApplicationContext(), girisyap.class);
                startActivity(cks);
            }
        });

    }

    public void init() {
        sharedPreferenc = new SharedPreferenc();
        //  k_adi1.setText(sharedPreferenc.getValue(context,"kullaniciadi"));
        //sifre1.setText(sharedPreferenc.getValue(context,"kullanicisifresi"));
    }
    private void userSignIn() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();



        String KULadi = KulaniciAdi.getText().toString().trim();
        String Sifre = Kullanicisifre.getText().toString().trim();


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
                    Kullanicimail.setText((CharSequence) info.getUserEmail());
                    KullaniciAdsoyad.setText((CharSequence) info.getUserFullName());



                    //    sharedPreferenc.save(context,"kullaniciadi",KulaniciAdi.getText().toString());
                      //  sharedPreferenc.save(context,"kullanicisifresi",Kullanicisifre.getText().toString());


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

    private void register() {
        Call<Info> mCall;
        ApiUtils apiUtils = new ApiUtils();
        arelRadyoService= apiUtils.getAPIService(ApiUtils.BASE_URL);

        mCall= arelRadyoService.Update(
                KulaniciAdi.getText().toString(),KullaniciAdsoyad.getText().toString(),Kullanicimail.getText().toString(),Kullanicisifre.getText().toString()
        );

        mCall.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, retrofit2.Response<Info> response) {
                Info info=response.body();
                Log.i(TAG,"register  Info -->"+info.getInfo());
                Log.i(TAG,"register  Success -->"+info.getSuccess());
                if (info.getSuccess()==1){


                   sharedPreferenc.save(context,"kullaniciadi",KulaniciAdi.getText().toString());
                   sharedPreferenc.save(context,"kullanicisifresi",Kullanicisifre.getText().toString());

                    Toast.makeText(getApplicationContext(), "Üye kaydı yapıldı", Toast.LENGTH_LONG).show();
                   Intent ans001 = new Intent(getApplicationContext(), anasayfa.class);
                    startActivity(ans001);
                }
                else {
                    Toast.makeText(getApplicationContext(), " "+info.getInfo(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

                Log.e(TAG,"register hata var"+t.getMessage());
                Toast.makeText(getApplicationContext(), "İnternetinizi kontrol edin ", Toast.LENGTH_LONG).show();

            }
        });

    }


    public boolean sayiVarmi(String kelime) {



        for (int i = 0; i < kelime.length(); i++) {

            if(Character.isDigit(kelime.charAt(i)))
            {
                return true;
            }
        }


        return false;
    }


}
