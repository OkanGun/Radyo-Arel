package com.okangn.lenovo.arel_radyo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.StaticLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.okangn.lenovo.arel_radyo.Models.AllData;
import com.okangn.lenovo.arel_radyo.Models.Example;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.okangn.lenovo.arel_radyo.favoriler.favoriList1;
import static com.okangn.lenovo.arel_radyo.favoriler.favoriSil;
import static com.okangn.lenovo.arel_radyo.favoriler.listeler;

public class ListAdapterSarkiisim extends BaseAdapter {

    List<Example> kullaniciList;
    LayoutInflater layoutInflater;
    Activity activity;
   SharedPreferenc sharedPreferenc;
   Context context;
    MediaPlayer mp;
    ArrayList<Example> arrayList;
    private String TAG = "listsarkıadapter";
    static String[] listeler2;
    static String[] listelerkul;
    String mliste;
    String mfavori;
    String mfavoriler;
    String mlisteler;
    private int selectedposition;
    int k=0;

    favoriler favoriler;


    public ListAdapterSarkiisim(List<Example> kullaniciList, Activity activity) {
        context = activity.getApplicationContext();
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.kullaniciList = kullaniciList;
       // this.arrayList=new ArrayList<Example>();
      //  this.arrayList.addAll(kullaniciList);
        this.activity = activity;
        favoriler = new favoriler();
        sharedPreferenc = new SharedPreferenc();
    }

    @Override
    public int getCount() {
        return kullaniciList.size();
    }

    @Override
    public Object getItem(int i) {
        return kullaniciList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View view =layoutInflater.inflate(R.layout.listtasarimi,parent,false);

        ImageView resim =(ImageView) view.findViewById(R.id.listimg);
        Picasso.get().load(kullaniciList.get(position).getThumb()).into(resim);
        final TextView Sarkıname =(TextView)view.findViewById(R.id.listtext);
        Sarkıname.setText(kullaniciList.get(position).getPermalink());
     final    ImageView fav=(ImageView) view.findViewById(R.id.listbutton);
      LinearLayout Linerdetay=(LinearLayout)view.findViewById(R.id.linerdetay);




  /*   if (!favoriler.favoriList1.isEmpty() ) {
          /*  listeler2 = new String[favoriList1.size()];
            listelerkul = new String[anasayfa.z];
            for (int f = 0; f < anasayfa.z; f++) {
                listelerkul[f] = anasayfa.listelerana[f];
            }
            for (int h = 0; h < favoriList1.size(); h++) {
                listeler2[h] = favoriList1.get(h).getPermalink();
            }*/
      /*   for (int n = 0; n < anasayfa.z; n++){
               mliste=anasayfa.listelerana[n];
               Log.e("oblistelerrr11111  -->", mliste);
               for (int m = 0; m < favoriList1.size(); m++){
                   mfavori=favoriList1.get(m).getPermalink();
                   Log.e("oblistelerrr22222  -->", mfavori);
                   if (mliste.equals(mfavori)){
                       Log.e("objesonnnnn  -->", mliste);
                       Log.e("objesonnnnn222222  -->", mfavori);
                       fav.setBackgroundResource(R.drawable.carpi);

                   }else {
                      // fav.setBackgroundResource(R.drawable.artiradyo);
                       Log.e("objes0000002  -->", mfavori);
                       continue;
                   }
               }
           }*/

          /*  for (int n = 0; n < anasayfa.z; n++){
                mliste=anasayfa.listelerana[n];
                for (int m = 0; m < favoriList1.size(); m++){

                     mfavori=favoriList1.get(m).getPermalink();
                    if (mliste.equals(mfavori)){
                      //  Log.e(TAG, "444000--",anasayfa.listelerana[n]);
                        Log.e("555000--",anasayfa.listelerana[n]);
                        Log.e("5550101--",favoriList1.get(m).getPermalink());
                        fav.setBackgroundResource(R.drawable.carpi);
                    }
                    else {
                        Log.e(TAG,"5556644--");
                        fav.setBackgroundResource(R.drawable.artiradyo);
                    }
                }
            }
           for (int i=0;i<favoriList1.size();i++){
                   Log.e("obje012  -->",favoriList1.get(i).getPermalink());
               Log.e("oblistelerrr11111  -->", mliste);
               Log.e("oblistelerrr22222  -->", mfavori);

                 }

        }*/




        List<Example>  datas = sharedPreferenc.getData(context);



        if (  datas!=null && datas.size()>0) {

            for (int n = 0; n < kullaniciList.size(); n++) {

                for (int expitem = 0; expitem < datas.size(); expitem++)

                    if (datas != null)
                    {

                        if (kullaniciList.get(n).getPermalink().equals(datas.get(expitem).getPermalink())) {
                            Log.e(TAG,"kullanıcı listt---"+kullaniciList.get(n).getPermalink());
                            Log.e(TAG,"datasss listt-----"+datas.get(expitem).getPermalink());
                            fav.setBackgroundResource(R.drawable.carpi);
                        }
                        else {
                            fav.setBackgroundResource(R.drawable.artiradyo);
                        }
                    }
            }
        }



      fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Example item = kullaniciList.get(position);
                List<Example>  datas = sharedPreferenc.getData(context);
                if (view.getBackground().getConstantState() == activity.getResources().getDrawable(R.drawable.artiradyo).getConstantState()) {

                    Log.e(TAG, "2222.eklemede--");
                    List<Example>  maindata = new ArrayList<Example>();
                    if(datas != null){
                        datas.add(item);
                        maindata = datas;
                    }else{
                        maindata.add(item);
                    }


                    sharedPreferenc.saveData(context,maindata);
                    fav.setBackgroundResource(R.drawable.carpi);


                    Log.e("artiradyo","artiradyo");
                }

                else  if (view.getBackground().getConstantState() == activity.getResources().getDrawable(R.drawable.carpi).getConstantState()) {

                    Log.e("carpi","carpi");
                    if (  datas!=null && datas.size()>0) {


                        for (int i = 0; i < datas.size(); i++) {
                            if (item.getPermalink().equals(datas.get(i).getPermalink())) {
                                datas.remove(i);
                            }
                        }

                        sharedPreferenc.saveData(context, datas);
                        fav.setBackgroundResource(R.drawable.artiradyo);
                    }
                }







              /*  if (  datas!=null && datas.size()>0) {

                        Log.e(TAG, "11111--");
                        mlisteler=item.getPermalink();

                        for (int expitem=0;expitem<datas.size();expitem++)

                    if (datas!=null){
                        for (int i=0;i<datas.size();i++){
                            if (mlisteler.equals(datas.get(i).getPermalink())){
                                datas.remove(i);
                            }
                        }
                        sharedPreferenc.saveData(context,datas);
                    }

                        if (k==0){
                            Toast.makeText(activity.getApplicationContext(), "Favorilere alındı ", Toast.LENGTH_SHORT).show();
                            //favoriler.favorilereEkle(item.getPermalink(),item.getThumb(),item.getStreamUrl());
                            //favoriler.favorilereEkle2(item);
                            List<Example>  maindata = new ArrayList<Example>();

                            if(datas != null){
                                datas.add(item);
                                maindata = datas;
                            }else{
                                maindata.add(item);
                            }


                            sharedPreferenc.saveData(context,maindata);
                            fav.setBackgroundResource(R.drawable.carpi);
                            Log.e(TAG,"5555önce--");
                        }
                        else {
                            Log.e(TAG, "5555önce1111--");

                        }

                }
                else {
                    Toast.makeText(activity.getApplicationContext(), "Favorilere alındı ", Toast.LENGTH_SHORT).show();
                    //favoriler.favorilereEkle(item.getPermalink(),item.getThumb(),item.getStreamUrl());
                    //favoriler.favorilereEkle2(item);
                    List<Example>  maindata = new ArrayList<Example>();
                    if(datas != null){
                        datas.add(item);
                        maindata = datas;
                    }else{
                        maindata.add(item);
                    }


                    sharedPreferenc.saveData(context,maindata);
                    fav.setBackgroundResource(R.drawable.carpi);
                    Log.e(TAG,"5555--");
                }*/


            /*    if (  datas!=null && datas.size()>0) {

                             mliste=item.getPermalink();


                            if (datas != null) {
                                for (int expitem = 0; expitem < datas.size(); expitem++) {
                                if (mliste.equals(datas.get(expitem).getPermalink())) {
                                    Log.e(TAG, "1.eklemede--");
                                    List<Example> maindata = new ArrayList<Example>();
                                    if (datas != null) {
                                        datas.add(item);
                                        maindata = datas;
                                    } else {
                                        maindata.add(item);
                                    }


                                    sharedPreferenc.saveData(context, maindata);
                                    fav.setBackgroundResource(R.drawable.carpi);
                                } else {
                                    Log.e(TAG, "1.silmede--");
                                    datas.remove(expitem);
                                    sharedPreferenc.saveData(context, datas);
                                    fav.setBackgroundResource(R.drawable.artiradyo);
                                }
                            }
                        }
                }
                else {
                    Log.e(TAG, "2222.eklemede--");
                    List<Example>  maindata = new ArrayList<Example>();
                    if(datas != null){
                        datas.add(item);
                        maindata = datas;
                    }else{
                        maindata.add(item);
                    }


                    sharedPreferenc.saveData(context,maindata);
                    fav.setBackgroundResource(R.drawable.carpi);

                }*/


            }
        });


    /* fav.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
           //  Toast.makeText(activity.getApplicationContext(), "Favorilere alındı "+position, Toast.LENGTH_SHORT).show();
             Log.e("lisradapter",position+"");


                 if (fav.getDrawable() == getResources().getDrawable( R.drawable.artibuton)){
                Toast.makeText(activity.getApplicationContext(), "Favorilere alındı ", Toast.LENGTH_SHORT).show();
                Example item=kullaniciList.get(position);
                favoriler.favorilereEkle(item.getPermalink(),item.getThumb(),item.getStreamUrl());
                 fav.setBackgroundResource(R.drawable.carpi);
                    // fav.setVisibility(View.GONE);
                 k=1;
             }
            else {
                 Toast.makeText(activity.getApplicationContext(), "Favorilerden cıkartıldı ", Toast.LENGTH_SHORT).show();
                Example item=kullaniciList.get(position);
               favoriler.favoriSilana(item.getPermalink());

                 fav.setBackgroundResource(R.drawable.artiradyo);
                // favoriler.favoriSil(position);
                 k=0;
             }

         }
     });*/



   /*  Linerdetay.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
          Example item=kullaniciList.get(position);
             Bundle bundle = new Bundle();
             bundle.putSerializable("music_detay", item);
             Intent intent = new Intent(activity, muzik_detay.class);
             intent.putExtras(bundle);
             activity.getApplicationContext().startActivity(intent);

         }
     }); */


        Sarkıname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Example item=kullaniciList.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("music_detay", item);
              //  sharedPreferenc.save(context,"resim",item.getThumb());
                Intent intent = new Intent(activity, muzik_detay.class);
                intent.putExtras(bundle);
                Intent intent1 = new Intent(activity, anasayfa2.class);
               intent1.putExtras(bundle);
              //  activity.getApplicationContext().startActivity(intent1);
                activity.getApplicationContext().startActivity(intent);




             /*   Example item1=kullaniciList.get(position);
                Bundle bundle1 = new Bundle();
                bundle.putSerializable("music_detay1", item1);
                Intent intent1 = new Intent(activity, anasayfa2.class);
                intent1.putExtras(bundle1); */


            }
        });

     /*   if (favoriler.favoriList1!=null){
            for (int i=0;i<=favoriList1.size();i++){
                if (favoriler.listeler[i]==kullaniciList.get(i).getPermalink()){
                    // favoriSil(i);

                    fav.setBackgroundResource(R.drawable.artiradyo);
                }
                else {

                    fav.setBackgroundResource(R.drawable.carpi);
                }
            }
        }else {
           Log.e(TAG,"listadaapter en alt if----");

        }*/


        return view;
    }

    public void setfilter(List<Example> listitem){
        kullaniciList=new ArrayList<>();
        kullaniciList.addAll(listitem);
        notifyDataSetChanged();
    }

}
