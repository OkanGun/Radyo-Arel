package com.okangn.lenovo.arel_radyo;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.okangn.lenovo.arel_radyo.Models.Example;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class favoriler extends AppCompatActivity {

    public static ListView favoriListesi;
    public static List<Example> favoriList1 = new ArrayList<Example>();
    public static favoriAdapter favAdapter;
    int a=0;
    static String[] listeler;
    static String  bilgi;
    static Activity activity;
   private  SharedPreferenc sharedPreferenc;
    private static  Context c ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoriler);
        c = getApplicationContext();
        sharedPreferenc = new SharedPreferenc();

        favoriListesi = (ListView) findViewById(R.id.favlistview1);
        favoriList1 =   sharedPreferenc.getData(getApplication().getApplicationContext());


        favAdapter = new favoriAdapter(favoriList1, favoriler.this);
         listeler=new String[favoriList1.size()];
        for (int i=0;i<favoriList1.size();i++){
            Log.e("DATA",favoriList1.get(i).getPermalink());
            listeler[i]= favoriList1.get(i).getPermalink();

        }
        favoriListesi.setAdapter(favAdapter);

    }

    public static void favorilereEkle(String mIsim, String mResim,String mUrl) {
        favoriList1.add(new Example(mIsim, mResim,mUrl));
    }

    public  void favorilereEkle2(Example example) {
        favoriList1.add(example);

        //sharedPreferenc(c,example);

    }

    public static void favoriSil(int position) {
        favoriList1.remove(position);
        favAdapter.Update();

    }

    public static void favoriSilana(String mIsim) {

          for (int i=0;i<=favoriList1.size();i++){
              if (listeler[i]==mIsim){
                  favoriSil(i);
                //  Toast.makeText(activity.getApplicationContext(), "Favorilerden cıkartıldı ", Toast.LENGTH_SHORT).show();
              }
              else {
                  continue;
              }
          }

    }



}
