package com.okangn.lenovo.arel_radyo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.okangn.lenovo.arel_radyo.Models.Example;
import com.okangn.lenovo.arel_radyo.Service.ApiUtils;
import com.okangn.lenovo.arel_radyo.Service.ArelRadyoService;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class anasayfa2 extends AppCompatActivity {
    LinearLayout analinoynat,analindetay;
    ConstraintLayout anaprofil;
    ListView analistView;
    Context context;
    private String TAG = "anasayfa2";
    int i=0;
    ImageView anamusres,ımageView,ımageplay;
    TextView anamusad;
    SharedPreferenc sharedPreferenc;
    String anaisim,detayac="detay";
    LinearLayout analinearLayout;
    private Bundle extras = null;
    LinearLayout linoynat,analintext;
    int totalTime;
    public static String DENEME = "deneme";
    int k=0;
    Button OldSchool,sprt70s,funkfunk,decand,rastazo,dephause,nightblue,alter,breatjazz,rockfree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa2);

        anaprofil = (ConstraintLayout) findViewById(R.id.anacontainer);
        linoynat=(LinearLayout)findViewById(R.id.analineroynat);

        anaprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pro1 = new Intent(getApplicationContext(), profil.class);
                startActivity(pro1);
            }
        });

        anamusad=(TextView)findViewById(R.id.anatextView22);
        anamusres=(ImageView)findViewById(R.id.anaimageView6);
        analistView = (ListView) findViewById(R.id.analistview1);
        analintext=(LinearLayout) findViewById(R.id.analintext);
        ımageplay=(ImageView)findViewById(R.id.anaimageButton01);
        OldSchool=(Button)findViewById(R.id.anabut8);
        sprt70s=(Button)findViewById(R.id.anabut06);
        funkfunk=(Button)findViewById(R.id.anabut2);
        decand=(Button)findViewById(R.id.anabut1);
        rastazo=(Button)findViewById(R.id.anabut3);
        dephause=(Button)findViewById(R.id.anabut4);
        nightblue=(Button)findViewById(R.id.anabut05);
        alter=(Button)findViewById(R.id.anabut5);
        breatjazz=(Button)findViewById(R.id.anabut6);
        rockfree=(Button)findViewById(R.id.anabut9);

        userSignIn();




     //   anamusad.setText(item.getPermalink().toString());
      //  Picasso.get().load(item.getThumb()).into(anamusres);




        extras = getIntent().getExtras();
        anaisim = extras.getString(muzik_detay.NAME);
       anamusad.setText(anaisim);

        if (MusicPlay.mp.isPlaying()){
            ımageplay.setImageResource(R.drawable.pauser01);

        }
        else {
            ımageplay.setImageResource(R.drawable.plyer01);

        }


       //Bitmap bmp = (Bitmap) extras.getParcelable("resim");
      //  anamusres.setImageBitmap(bmp );

    /*    Intent ıntent=getIntent();
        anaisim=ıntent.getStringExtra("isim");
        anamusad.setText(anaisim);
        Intent ıntent1=getIntent();
        ımageView= (ImageView) ıntent1.getSerializableExtra("resim");
       anamusres.setImageDrawable((Drawable) ıntent1.getSerializableExtra("resim"));*/



        analintext.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   onBackPressed();
               }
           });
        linoynat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (MusicPlay.mp.isPlaying()){
            MusicPlay.mp.pause();
                    ımageplay.setImageResource(R.drawable.plyer01);

                }
                else {
                    MusicPlay.mp.start();
                    ımageplay.setImageResource(R.drawable.pauser01);

                }
            }
        });

        OldSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent old = new Intent(getApplicationContext(), oldlistesi.class);
                startActivity(old);
            }
        });

        sprt70s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sp = new Intent(getApplicationContext(), spiritof70s.class);
                startActivity(sp);
            }
        });

        funkfunk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fn = new Intent(getApplicationContext(), funktheFun.class);
                startActivity(fn);
            }
        });

        decand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fn = new Intent(getApplicationContext(), decadence80s.class);
                startActivity(fn);
            }
        });

        rastazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rst = new Intent(getApplicationContext(), rastazone.class);
                startActivity(rst);
            }
        });

        dephause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dep = new Intent(getApplicationContext(), deepHause.class);
                startActivity(dep);
            }
        });

        nightblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ngh = new Intent(getApplicationContext(), nightblues.class);
                startActivity(ngh);
            }
        });

        alter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent altr = new Intent(getApplicationContext(), alternative.class);
                startActivity(altr);
            }
        });

        breatjazz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent brt = new Intent(getApplicationContext(), breathofjazz.class);
                startActivity(brt);
            }
        });

        rockfree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rkf = new Intent(getApplicationContext(), rockfree.class);
                startActivity(rkf);
            }
        });


    }





    private void userSignIn() {


        ArelRadyoService arelRadyoService;
        ApiUtils apiUtils = new ApiUtils();
        arelRadyoService= apiUtils.getAPIService(ApiUtils.RADYO_URL);



        Call<List<Example>> call=arelRadyoService.getMyRadyoList("tracks","1","40");

        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

                List<Example> allDataList = response.body();


             //   for (int i=0;i<allDataList.size();i++){
               //     Log.e("obje  -->",allDataList.get(i).getId());

                //}


                ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(allDataList, anasayfa2.this);
                analistView.setAdapter(listAdapter);


             /*   for (AllData h: allDataList){
                    Log.d("id",h.getId());
                    Log.d("fullName",h.getFullName());
                    Log.d("mail",h.getMail());
                    Log.d("password",h.getPassword());
                    Log.d("userName",h.getUserName());
                }*/

            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Log.e("obje hatası",t.getMessage());

            }
        });




    }


}
