package com.okangn.lenovo.arel_radyo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.okangn.lenovo.arel_radyo.Models.AllData;
import com.okangn.lenovo.arel_radyo.Models.Data;
import com.okangn.lenovo.arel_radyo.Models.Example;
import com.okangn.lenovo.arel_radyo.Models.User;
import com.okangn.lenovo.arel_radyo.Service.ApiUtils;
import com.okangn.lenovo.arel_radyo.Service.ArelRadyoService;
import com.okangn.lenovo.modeller.Sarki;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class anasayfa extends AppCompatActivity {

    LinearLayout linoynat,lindetay;
    ConstraintLayout profil,favoriler;
    ListView listView;
    Context context;
    private String TAG = "anasayfa";
    int i=0;
    ImageView musres;
    TextView musad;
    SharedPreferenc sharedPreferenc;
    String isim="";
    LinearLayout linearLayout;
    Button anaOldSchool,anaSprt70,funkthe,decandec,rastazon,deephouse,nightblues,alternate,breatjaz,rockfre;
    SearchView searchView;
   static int z;
    ListAdapterSarkiisim listAdapter;
  //  public static List<Example> allDataList = new ArrayList<Example>();

 //   List<Sarki> sarkilar = new ArrayList<Sarki>();
 static String[] listelerana;

//  static final   String meyveler [] = new String[]{"elma","armut","karpuz","kavun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

      //  final ListAdapterSarkiisim listAdapter = new ListAdapterSarkiisim(allDataList, anasayfa.this);


        linoynat=(LinearLayout)findViewById(R.id.lineroynat);
         musad=(TextView)findViewById(R.id.textView22);
         musres=(ImageView)findViewById(R.id.imageView6);
        listView = (ListView) findViewById(R.id.listview1);
        linearLayout=(LinearLayout)findViewById(R.id.linearLayout10);
        anaOldSchool=(Button)findViewById(R.id.but8);
        anaSprt70=(Button)findViewById(R.id.but06);
        funkthe=(Button)findViewById(R.id.but2);
        decandec=(Button)findViewById(R.id.but1);
        rastazon=(Button)findViewById(R.id.but3);
        deephouse=(Button)findViewById(R.id.but4);
        nightblues=(Button)findViewById(R.id.but05);
        alternate=(Button)findViewById(R.id.but5);
        breatjaz=(Button)findViewById(R.id.but6);
        rockfre=(Button)findViewById(R.id.but9);

        searchView=(SearchView)findViewById(R.id.aramabutonu);



        profil = (ConstraintLayout) findViewById(R.id.container);
        favoriler = (ConstraintLayout) findViewById(R.id.favconst);

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pro = new Intent(getApplicationContext(), profil.class);
                startActivity(pro);
            }
        });

        favoriler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fav = new Intent(getApplicationContext(), favoriler.class);
                startActivity(fav);
            }
        });

          userSignIn();
        //  userSignInUser();
      //  Sarkiadi();



        anaOldSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent old = new Intent(getApplicationContext(), oldlistesi.class);
                startActivity(old);
            }
        });
        anaSprt70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent spr = new Intent(getApplicationContext(), spiritof70s.class);
                startActivity(spr);
            }
        });

        funkthe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fnk = new Intent(getApplicationContext(), funktheFun.class);
                startActivity(fnk);
            }
        });

        decandec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dec = new Intent(getApplicationContext(), decadence80s.class);
                startActivity(dec);
            }
        });

        rastazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ras = new Intent(getApplicationContext(), rastazone.class);
                startActivity(ras);
            }
        });

        deephouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dep = new Intent(getApplicationContext(), deepHause.class);
                startActivity(dep);
            }
        });

        nightblues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nig = new Intent(getApplicationContext(), nightblues.class);
                startActivity(nig);
            }
        });

        alternate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alt = new Intent(getApplicationContext(), alternative.class);
                startActivity(alt);
            }
        });

        breatjaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent br = new Intent(getApplicationContext(), breathofjazz.class);
                startActivity(br);
            }
        });

        rockfre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rk = new Intent(getApplicationContext(), rockfree.class);
                startActivity(rk);
            }
        });


    }
    /*

        public void listele () {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ApiUtils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            // ArelRadyoService= ApiUtils.getAPIService();

            ArelRadyoService service = retrofit.create(ArelRadyoService.class);

            Call<List<AllData>> call = service.getLIST_CALL();
            call.enqueue(new Callback<List<AllData>>() {
                @Override
                public void onResponse(Call<List<AllData>> call, Response<List<AllData>> response) {

                    if (response.code() == 200) {
                        List<AllData> kullaniciList = response.body();
                        ListAdapter listAdapter = new ListAdapter(kullaniciList, anasayfa.this);

                        listView.setAdapter(listAdapter);
                       // listAdapter.notifyDataSetChanged();
                    }


                }

                @Override
                public void onFailure(Call<List<AllData>> call, Throwable t) {

                }
            });
        }*/

   private void userSignIn() {


       ArelRadyoService arelRadyoService;
       ApiUtils apiUtils = new ApiUtils();
       arelRadyoService= apiUtils.getAPIService(ApiUtils.RADYO_URL);



        Call<List<Example>> call=arelRadyoService.getMyRadyoList("tracks","1","40");

        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {

                final List<Example> allDataList = response.body();




             //   for (int i=0;i<allDataList.size();i++){
              //     Log.e("obje  -->",allDataList.get(i).getId());

              //  }


                 listAdapter = new ListAdapterSarkiisim(allDataList, anasayfa.this);
                listView.setAdapter(listAdapter);

                z=allDataList.size();
                listelerana=new String[allDataList.size()];

                for (int i=0;i<allDataList.size();i++){
                    listelerana[i]= allDataList.get(i).getPermalink();

                }

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String text) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                         final List<Example> filterlister=filter(allDataList,newText);
                         listAdapter.setfilter(filterlister);

                        return true;
                    }
                });


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

   /* private void userSignInUser() {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUtils.RADYO_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArelRadyoService service = retrofit.create(ArelRadyoService.class);

        Call<List<User>> call=service.getUserMyRadyoList("track",1,5);

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                List<User> allDataList = response.body();

                String[] listeler=new String[allDataList.size()];

                for (int i=0;i<allDataList.size();i++){
                    Log.e("obje  -->",allDataList.get(i).getId());

                }


                for (int i=0;i<allDataList.size();i++){
                    listeler[i]= allDataList.get(i).getUsername();

                }


                ListAdapterUser listAdapter = new ListAdapterUser(allDataList, anasayfa.this);
                listView.setAdapter(listAdapter);




             /*   for (AllData h: allDataList){
                    Log.d("id",h.getId());
                    Log.d("fullName",h.getFullName());
                    Log.d("mail",h.getMail());
                    Log.d("password",h.getPassword());
                    Log.d("userName",h.getUserName());
                }//

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("obje hatası",t.getMessage());

            }
        });


    }
    */
   public void Sarkiadi(){

       Bundle extras = getIntent().getExtras();

       Example item = (Example) getIntent().getSerializableExtra("music_detay");
       musad.setText(item.getPermalink());
   }

   public List<Example> filter(List<Example> p1,String query){
       query=query.toLowerCase();
       final List<Example> filterlist=new ArrayList<>();
       for(Example model:p1){
           final String text=model.getPermalink().toLowerCase();
           if (text.startsWith(query)){
               filterlist.add(model);
           }
       }
       return filterlist;
   }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"sayfa resume oldu");

      //   userSignIn();

    }
}


