package com.example.george.eva3_16_media_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServicioRola extends Service {
    MediaPlayer mpReproductor = null;
    public ServicioRola() {
    }



    @Override
    public void onCreate() {
        super.onCreate();
        mpReproductor= MediaPlayer.create(getApplicationContext(),R.raw.rumors);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (mpReproductor != null){
            mpReproductor.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mpReproductor !=null){
            mpReproductor.stop();
            mpReproductor.release();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
