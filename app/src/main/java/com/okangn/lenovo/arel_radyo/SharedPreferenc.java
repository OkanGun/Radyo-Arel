package com.okangn.lenovo.arel_radyo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.okangn.lenovo.arel_radyo.Models.Example;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreferenc {
    static final String PREE_NAME="loginn";



    public  void save(Context context,String key,String value){
        SharedPreferences setting=context.getSharedPreferences(PREE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=setting.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveBoolean(Context context,String key,Boolean value){
        SharedPreferences setting=context.getSharedPreferences(PREE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=setting.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public String getValue(Context context,String key) {
        SharedPreferences setting = context.getSharedPreferences(PREE_NAME, Context.MODE_PRIVATE);
        String text=setting.getString(key,null);
        return  text;
    }
    public Boolean getValueBoolean(Context context,String key) {
        SharedPreferences setting = context.getSharedPreferences(PREE_NAME, Context.MODE_PRIVATE);
        Boolean text=setting.getBoolean(key,false);
        return  text;
    }
    public void clear(Context context){
        SharedPreferences setting = context.getSharedPreferences(PREE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=setting.edit();
        editor.clear();
        editor.commit();
    }
    public void remove(Context context,String key){
        SharedPreferences setting = context.getSharedPreferences(PREE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=setting.edit();
        editor.remove(key);
        editor.commit();
    }

/*
    public void addlistitem(Context context,Example example){
        SharedPreferences setting=context.getSharedPreferences(PREE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=setting.edit();

        Gson gson = new Gson();
        List<Example> textList = new ArrayList<Example>();


        Gson gson2 = new Gson();

        String getjsondata = setting.getString("favlist", null);
        String jsonText ;
        if( getjsondata != null){


        Example[] examples = gson2.fromJson(getjsondata, Example[].class);  //EDIT: gso to gson
        List<Example> mcList = Arrays.asList(examples);


                                     Log.e("Data Size",mcList.size()+"");
                                    Log.e("example data",example.getPermalink()+"");
            mcList.add(example);
            jsonText =    gson.toJson(mcList);
        }else{
            textList.add(example);
            jsonText =    gson.toJson(textList);
        }


        editor.putString("favlist", jsonText);
        editor.apply();
    }

    public  List<Example> getlist(Context context){
        SharedPreferences setting=context.getSharedPreferences(PREE_NAME,Context.MODE_PRIVATE);


        Gson gson = new Gson();
        String jsonText = setting.getString("favlist", null);
        Example[] examples = gson.fromJson(jsonText, Example[].class);  //EDIT: gso to gson
        List<Example> mcList = Arrays.asList(examples);

        return mcList;
    }*/

    public static void saveData(Context context, List<Example> model) {

        String s = new Gson().toJson(model);
        SharedPreferences preferences = context.getSharedPreferences(PREE_NAME, Context.MODE_PRIVATE);
        preferences.edit().putString("favlistdata", s).apply();

    }
    public static List<Example> getData(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREE_NAME, Context.MODE_PRIVATE);
        String s = preferences.getString("favlistdata", "");
        Gson gson = new Gson();
        Type type = new TypeToken<List<Example>>() {
        }.getType();
        List<Example> list = gson.fromJson(s, type);
        return list;
    }
}
