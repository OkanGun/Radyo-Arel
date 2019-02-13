package com.okangn.lenovo.arel_radyo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.okangn.lenovo.arel_radyo.Models.Example;
import com.okangn.lenovo.arel_radyo.Models.User;

import java.util.List;

public class ListAdapterUser extends BaseAdapter {

    List<User> kullaniciListUser;
    LayoutInflater layoutInflater;
    Activity activity;

    public ListAdapterUser(List<User> kullaniciList, Activity activity) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.kullaniciListUser=kullaniciListUser;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return kullaniciListUser.size();
    }

    @Override
    public Object getItem(int i) {
        return kullaniciListUser.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =layoutInflater.inflate(R.layout.listxml,parent,false);

        TextView id =(TextView)view.findViewById(R.id.textView25);
        id.setText(kullaniciListUser.get(position).getUsername());
        TextView Fname =(TextView)view.findViewById(R.id.textView24);
        Fname.setText(kullaniciListUser.get(position).getUsername());
        TextView umail =(TextView)view.findViewById(R.id.textView23);
        umail.setText(kullaniciListUser.get(position).getUsername());
        TextView pass =(TextView)view.findViewById(R.id.textView21);
        pass.setText(kullaniciListUser.get(position).getUsername());
        TextView Uname =(TextView)view.findViewById(R.id.textView17);
        Uname.setText(kullaniciListUser.get(position).getUsername());

        return view;
    }
}