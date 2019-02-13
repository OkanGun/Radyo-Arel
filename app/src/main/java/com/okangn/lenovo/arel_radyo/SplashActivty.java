package com.okangn.lenovo.arel_radyo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.okangn.lenovo.arel_radyo.MainActivity;

/**
 * Created by lenovo on 28.8.2018.
 */

public class SplashActivty extends AppCompatActivity {

    private static final int SPLASH_SURESI=3000;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivty.this,girisyap.class);
                startActivity(i);
            }
        },SPLASH_SURESI);
    }
}