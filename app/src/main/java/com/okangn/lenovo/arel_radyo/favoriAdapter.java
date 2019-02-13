package com.okangn.lenovo.arel_radyo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.okangn.lenovo.arel_radyo.Models.Example;
import com.okangn.lenovo.arel_radyo.Models.FavSarki;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class favoriAdapter extends BaseAdapter{
    public LayoutInflater layoutInflater;
    public static List<Example> favoriList;
    public Activity activity;
    private String TAG = "favoriadapter";
    SharedPreferenc sharedPreferenc;
    public favoriAdapter(List<Example> favoriList, Activity activity) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.favoriList = favoriList;
        // this.arrayList=new ArrayList<Example>();
        //  this.arrayList.addAll(kullaniciList);
        this.activity = activity;
        sharedPreferenc=new SharedPreferenc();

    }


    @Override
    public int getCount() {
        return favoriList.size();
    }

    @Override
    public Object getItem(int position) {
        return favoriList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view =layoutInflater.inflate(R.layout.favtasarimi,null);

        final ImageView sarkiResim = (ImageView) view.findViewById(R.id.favlistimg);
        Picasso.get().load(favoriList.get(position).getThumb()).into(sarkiResim);
        final ImageView FavResim = (ImageView) view.findViewById(R.id.favlistbutton);
        final TextView sarkiIsim =(TextView)view.findViewById(R.id.favlisttext);
        sarkiIsim.setText(favoriList.get(position).getPermalink());


        sarkiIsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Example item=favoriList.get(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("music_detay", item);
                //  sharedPreferenc.save(context,"resim",item.getThumb());
                Intent intent = new Intent(activity, muzik_detay.class);
                intent.putExtras(bundle);
                //  activity.getApplicationContext().startActivity(intent1);
                activity.getApplicationContext().startActivity(intent);




             /*   Example item1=kullaniciList.get(position);
                Bundle bundle1 = new Bundle();
                bundle.putSerializable("music_detay1", item1);
                Intent intent1 = new Intent(activity, anasayfa2.class);
                intent1.putExtras(bundle1); */
            }
        });

        FavResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Example item = favoriList.get(position);
                List<Example>  datas = sharedPreferenc.getData(activity.getApplicationContext());



                    Log.e("carpi","carpi");
                    if (  datas!=null && datas.size()>0) {
                        Log.e("carpi222","carpi222");

                        for (int i = 0; i < datas.size(); i++) {
                            if (item.getPermalink().equals(datas.get(i).getPermalink())) {
                                Log.e("333333","carpi222");
                                datas.remove(i);
                                favoriler.favoriSil(position);
                                Update();
                            }
                        }

                        sharedPreferenc.saveData(activity.getApplicationContext(), datas);
                        FavResim.setBackgroundResource(R.drawable.artiradyo);
                    }


            }
        });

        return view;
    }

    public void  Update(){
        this.notifyDataSetChanged();
    }


}
