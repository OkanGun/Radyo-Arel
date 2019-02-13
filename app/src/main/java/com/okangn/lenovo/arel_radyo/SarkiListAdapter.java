package com.okangn.lenovo.arel_radyo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.okangn.lenovo.modeller.Sarki;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SarkiListAdapter extends ArrayAdapter<Sarki> {

    ArrayList<Sarki> sarkis;
    Context context;
    int resource;
    Activity activity;
    LayoutInflater layoutInflater;

    public SarkiListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Sarki> sarkis) {
        super(context, resource, sarkis);
        this.sarkis=sarkis;
        this.context=context;
        this.resource=resource;
        this.activity=activity;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            layoutInflater =(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.listtasarimi,null,true);

        }

        Sarki sarki01= getItem(position);
        ImageView img1=(ImageView) convertView.findViewById(R.id.listimg);
       Picasso.get().load(sarki01.getResimURL()).into(img1);



        TextView textisim=(TextView) convertView.findViewById(R.id.listtext);
        textisim.setText(sarki01.getBaslik());

        return convertView;
    }
}
