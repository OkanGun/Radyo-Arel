package com.okangn.lenovo.arel_radyo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.okangn.lenovo.arel_radyo.Models.AllData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    List<AllData> kullaniciList;
    LayoutInflater layoutInflater;
    Activity activity;
    Context context;

    public ListAdapter(List<AllData> kullaniciList, Activity activity) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.kullaniciList = kullaniciList;
        this.activity = activity;
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
    public View getView(int position, View convertView,ViewGroup parent) {
        View view =layoutInflater.inflate(R.layout.listxml,parent,false);

        TextView id =(TextView)view.findViewById(R.id.textView25);
        id.setText(kullaniciList.get(position).getId());
        TextView Fname =(TextView)view.findViewById(R.id.textView24);
        Fname.setText(kullaniciList.get(position).getFullName());
        TextView umail =(TextView)view.findViewById(R.id.textView23);
        umail.setText(kullaniciList.get(position).getMail());
        TextView pass =(TextView)view.findViewById(R.id.textView21);
        pass.setText(kullaniciList.get(position).getPassword());
        TextView Uname =(TextView)view.findViewById(R.id.textView17);
        Uname.setText(kullaniciList.get(position).getUserName());

        return view;
    }
}
