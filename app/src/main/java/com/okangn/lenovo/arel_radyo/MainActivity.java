package com.okangn.lenovo.arel_radyo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.okangn.lenovo.arel_radyo.Models.Info;
import com.okangn.lenovo.arel_radyo.Service.ApiUtils;
import com.okangn.lenovo.arel_radyo.Service.ArelRadyoService;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;//preferences referansı
    SharedPreferences.Editor editor; //preferences editor nesnesi referansı .prefernces nesnesine veri ekleyip cıkarmak için


    private String TAG = "MainActivity";
    ArelRadyoService arelRadyoService;


    Button kayıtol1;
    Button hesapvar;
    EditText k_adi,mailadresi,şifre,adSoyad;
   // RequestQueue requestQueue;

    String parola, kullanici_adi, ad_soyad, mail;

    TextView uyariparola,uyarikullanici_adi,uyariad_soyAd,uyarimail;

   String onlineKullanıcı, kullanıcıadbilgisi, kullanıcıad_soyad, kullanıcıMail,kullanıcıParola,kullanıcıiD,favoriler,begenilenler;

    int a = 0;

    private static String kayıtol1Url = "https://mobilapp.arel.edu.tr/radyoareltest/User/register";


    public static class Fonksiyonlar {

        public static boolean isEmailValid(String email) { //mail formatt kontrol eder
            boolean isValid = false;

            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            CharSequence inputStr = email;

            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(inputStr);
            if (matcher.matches()) {
                isValid = true;
            }
            return isValid;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uyariparola = findViewById(R.id.textView6);
        uyarikullanici_adi = findViewById(R.id.textView2);
        uyariad_soyAd = findViewById(R.id.textView8);
        uyarimail = findViewById(R.id.textView4);


        k_adi = (EditText) findViewById(R.id.textView);
        mailadresi = (EditText) findViewById(R.id.textView3);
        şifre = (EditText) findViewById(R.id.textView5);
        adSoyad = (EditText) findViewById(R.id.textView7);
        k_adi.setText("okan");
        mailadresi.setText("okangn@gmail.com");
        şifre.setText("okan");
        adSoyad.setText("okangün");


        final SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        onlineKullanıcı = sharedPreferences.getString("girisYapan", "");


     //   favoriler ="";
      //  begenilenler ="";


        kayıtol1=(Button) findViewById(R.id.button);
        hesapvar=(Button) findViewById(R.id.button3);


        hesapvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent grs1=new Intent(getApplicationContext(),girisyap.class);
                startActivity(grs1);
            }
        });



      kayıtol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                parola = şifre.getText().toString();
                kullanici_adi = k_adi.getText().toString();
                ad_soyad = adSoyad.getText().toString();
                mail = mailadresi.getText().toString();

                if (parola.isEmpty() || kullanici_adi.isEmpty() || ad_soyad.isEmpty() || mail.isEmpty())

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


                    if (sayiVarmi(kullanici_adi)) {
                        //  Toast.makeText(getApplicationContext(), "Ad ve soyadın  içinde sayı olamaz..", Toast.LENGTH_LONG).show();
                        uyarikullanici_adi.setText("Kullanıcı adı  içinde sayı olamaz..");

                    }

                    uyarikullanici_adi.setText(" ");

                  /*   else if (!sayiVarmi(ad_soyad)) {
                        //  Toast.makeText(getApplicationContext(), "Ad ve soyadın  içinde sayı olamaz..", Toast.LENGTH_LONG).show();
                        uyariad_soyAd.setText(" ");

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


                    if (!Fonksiyonlar.isEmailValid(mail)) {
                        //   Toast.makeText(getApplicationContext(), "Girdiğiniz mail formata uygun değildir..", Toast.LENGTH_LONG).show();
                        uyarimail.setText("Girdiğiniz mail formata uygun değildir.");
                    }

                    uyarimail.setText(" ");

                    if (sayiVarmi(kullanici_adi)) {
                        //  Toast.makeText(getApplicationContext(), "Ad ve soyadın  içinde sayı olamaz..", Toast.LENGTH_LONG).show();
                        uyarikullanici_adi.setText("Kullanıcı adı  içinde sayı olamaz..");

                    }

                    else       if (!Fonksiyonlar.isEmailValid(mail)) {
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

        }

    private void register() {
        Call<Info> mCall;
        ApiUtils apiUtils = new ApiUtils();
        arelRadyoService= apiUtils.getAPIService(ApiUtils.BASE_URL);

        mCall= arelRadyoService.register(
                k_adi.getText().toString(),adSoyad.getText().toString(),mailadresi.getText().toString(),şifre.getText().toString()
        );

        mCall.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, retrofit2.Response<Info> response) {
                Info info=response.body();
                Log.i(TAG,"register  Info -->"+info.getInfo());
                Log.i(TAG,"register  Success -->"+info.getSuccess());
                if (info.getSuccess()==1){

                    Toast.makeText(getApplicationContext(), "Üye kaydı yapıldı", Toast.LENGTH_LONG).show();
                    Intent ans01 = new Intent(getApplicationContext(), girisyap.class);
                    startActivity(ans01);
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


    public void yolla() {


        kayıtol1Url = "http://mobilapp.arel.edu.tr/radyoareltest/User/register";



        StringRequest request = new StringRequest(Request.Method.POST, kayıtol1Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

              //  System.out.println(response.toString());
                Log.i("kayit_ol",response.toString());
                Toast.makeText(getApplicationContext(), "Üye kaydı yapıldı", Toast.LENGTH_LONG).show();
                Intent ans01 = new Intent(getApplicationContext(), girisyap.class);
                startActivity(ans01);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: hsta " + error.getMessage() );
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();


                    parameters.put("User_UserName", k_adi.getText().toString());
                    parameters.put("User_FullName", adSoyad.getText().toString());
                    parameters.put("User_Email", mailadresi.getText().toString());
                    parameters.put("User_Password", şifre.getText().toString());
                 //   parameters.put("kullanici_favoriler", favoriler);
                 //   parameters.put("kullanici_begeniler", begenilenler);





                return parameters;
            }
        };

     RequestQueue    requestQueue = Volley.newRequestQueue(this);
       requestQueue.add(request);


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
