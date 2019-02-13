package com.okangn.lenovo.arel_radyo;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public  class MusicPlay  {
    public static MediaPlayer mp;
    public Context context;
    public String URL;
    public int sayi=0;
    public  MusicPlay(String URL,Context cntx) {
        context=cntx;
       this.URL=URL;

    }
    public void CreatMusic(){
        mp = MediaPlayer.create(context, Uri.parse(URL));
        mp.setLooping(true);
        mp.seekTo(0);
        mp.setVolume(0.5f, 0.5f);
    }
    public void PlayMusic(){
        mp.start();
    }
    public  void PauseMusic(){
        mp.pause();
    }

}
