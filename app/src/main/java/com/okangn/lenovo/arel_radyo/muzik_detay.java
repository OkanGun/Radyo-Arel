package com.okangn.lenovo.arel_radyo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.okangn.lenovo.arel_radyo.Models.Example;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.net.URL;
import java.util.List;

public class muzik_detay extends AppCompatActivity {

    String TAG = "detay",deneme1;
    TextView musicbil;
    ImageView musicresim, playtusu;
    Button musicdetaygeri;
  public   MediaPlayer mp;
    int totalTime;
    SharedPreferenc sharedPreferenc;
    Context context=this;
    SeekBar positionBar;
    SeekBar volumeBar;
    TextView textilk,textson;
    Activity activity;
   String strmusbil;
   ImageView ımageView;
    public static String NAME = "name";
    List<Example> kullaniciList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muzik_detay);


        Bundle extras = getIntent().getExtras();

        final Example item = (Example) getIntent().getSerializableExtra("music_detay");
        //Log.e(TAG, item.getTitle());
        Log.e(TAG,"-------------------");
        final   MusicPlay musicPlay=new MusicPlay(item.getStreamUrl(),context);


        musicresim = (ImageView) findViewById(R.id.imageView5);
        playtusu = (ImageView) findViewById(R.id.imageButton4);
        musicdetaygeri = (Button) findViewById(R.id.but20);

        musicbil = (TextView) findViewById(R.id.textView14);

        musicbil.setText(item.getPermalink().toString());
        Picasso.get().load(item.getThumb()).into(musicresim);


        musicdetaygeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //    Intent an = new Intent(getApplicationContext(), anasayfa2.class);
           //    an.putExtra("isim",musicbil.getText().toString());
          //     an.putExtra("res",ImageView(musicresim.setImageDrawable();));
          //      startActivity(an);

                strmusbil = musicbil.getText().toString().trim();
             //   musicresim.buildDrawingCache();
             //   Bitmap image= musicresim.getDrawingCache();

                Bundle extras = new Bundle();
                extras.putString(NAME, strmusbil);
              //  extras.putParcelable("resim", (Parcelable) ımageView.getDrawable());*/
              //  extras.putParcelable("resim", (Parcelable) musicresim.getDrawable());

                Intent intent = new Intent(getApplicationContext(), anasayfa2.class);
                intent.putExtras(extras);
                startActivity(intent);


              //  Picasso.get().load(item.getThumb()).into(ımageView);
            //    musicresim.buildDrawingCache();
              //  Bitmap ımageView= musicresim.getDrawingCache();

             /*   try {



                    Bundle extras = new Bundle();
                    extras.putString(NAME, strmusbil);
                    extras.putParcelable("resim", (Parcelable) musicresim);


                    /** Intent olusturalim */
                  //  Intent intent = new Intent(getApplicationContext(), anasayfa2.class);
                   // Intent intent = new Intent();

                    /** Bundle'i intente ekleyelim
                    intent.putExtras(extras);

                    /** Yeni sayfayi cagiralim
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                } */

            }
        });


     /*   mp = MediaPlayer.create(this, Uri.parse(item.getStreamUrl()));
        mp.setLooping(true);
        mp.seekTo(0);
        mp.setVolume(0.5f, 0.5f);
        totalTime = mp.getDuration();
    }*/


        final boolean oynuyor = true;
        if(musicPlay.mp!=null){
            if (musicPlay.mp.isPlaying() ){
                musicPlay.mp.stop();
                musicPlay.mp=null;
                Log.e(TAG,"oynuyor tue1");
                musicPlay.CreatMusic();
                musicPlay.mp.setLooping(true);
                musicPlay.mp.seekTo(0);
                musicPlay.mp.setVolume(0.5f,0.5f);
                totalTime=musicPlay.mp.getDuration();

            }
        }else if (musicPlay.mp!=null){
            if (musicPlay.mp.isPlaying() ){
                musicPlay.mp.stop();
                musicPlay.mp=null;
                Log.e(TAG,"oynuyor tue2");
                musicPlay.CreatMusic();
                musicPlay.mp.setLooping(true);
                musicPlay.mp.seekTo(0);
                musicPlay.mp.setVolume(0.5f,0.5f);
                totalTime=musicPlay.mp.getDuration();
            }
        }
        else {
            musicPlay.CreatMusic();
            musicPlay.mp.setLooping(true);
            musicPlay.mp.seekTo(0);
            musicPlay.mp.setVolume(0.5f,0.5f);
            totalTime=musicPlay.mp.getDuration();
            Log.e(TAG,"oynuyor tue3");
        }
        if (MusicPlay.mp.isPlaying()){
            playtusu.setImageResource(R.drawable.pause3);

        }
        else {
            playtusu.setImageResource(R.drawable.play);

        }



        textilk=(TextView)findViewById(R.id.textView26);
        textson=(TextView)findViewById(R.id.textView27);
        positionBar=(SeekBar)findViewById(R.id.seekBarpos);
        positionBar.setMax(totalTime);

        positionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromuser) {
                if (fromuser){
                    musicPlay.mp.seekTo(progress);
                    positionBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        volumeBar=(SeekBar)findViewById(R.id.seekBarvol);
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromuser) {
                float volumeNum=progress/100f;
                musicPlay.mp.setVolume(volumeNum,volumeNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (musicPlay.mp!=null){
                    try {
                        Message message=new Message();
                        message.what=musicPlay.mp.getCurrentPosition();
                        handler.sendMessage(message);
                        Thread.sleep(1000);
                    }catch (InterruptedException e){

                    }
                }
            }
        }).start();




        final boolean finalOynuyor = oynuyor;
        playtusu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    if (!musicPlay.mp.isPlaying()){
                     musicPlay.PlayMusic();
                        playtusu.setImageResource(R.drawable.pause3);

                     //   Intent intent= new Intent(getApplicationContext(), anasayfa.class);
                       // intent.putExtra("data", musicbil.getText().toString()); //pass data

                    }
                  else {
                        musicPlay.PauseMusic();
                        playtusu.setImageResource(R.drawable.play);


                    }

                }
            });



    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int currentPosition=msg.what;
            positionBar.setProgress(currentPosition);
            String ilktime=createTimeLabel(currentPosition);
            textilk.setText(ilktime);
            String sontime=createTimeLabel(totalTime-currentPosition);
            textson.setText("-"+sontime);
        }
    };

       public String createTimeLabel(int time){
           String timeLabel="";
           int min =time / 1000 / 60;
           int sec=time /1000 % 60;
           timeLabel= min + ":";
           if (sec<10) timeLabel +="0";
           timeLabel+=sec;
           return timeLabel;
       }


    }

