package com.example.george.eva3_16_media_service;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Principal extends AppCompatActivity {
    Intent inSerrvicioRep;
    MediaPlayer mpReproductor = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inSerrvicioRep = new Intent(this,ServicioRola.class);
    }
    public void onClickIniciar (View v){
        startService(inSerrvicioRep);

    }
    public void onClickTerminar (View v){
        stopService(inSerrvicioRep);

    }
}
