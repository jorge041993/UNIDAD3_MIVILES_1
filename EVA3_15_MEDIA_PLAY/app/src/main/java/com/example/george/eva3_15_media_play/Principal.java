package com.example.george.eva3_15_media_play;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal extends AppCompatActivity {
    MediaPlayer mpReproductor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        mpReproductor= MediaPlayer.create(getApplicationContext(),R.raw.cancion);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mpReproductor != null){
            mpReproductor.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpReproductor !=null){
            mpReproductor.stop();
            mpReproductor.release();
        }
    }
}
