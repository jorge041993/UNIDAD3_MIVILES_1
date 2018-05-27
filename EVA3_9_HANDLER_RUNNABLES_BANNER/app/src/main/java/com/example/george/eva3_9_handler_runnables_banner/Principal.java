package com.example.george.eva3_9_handler_runnables_banner;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {

    ImageView Cloudy;
    int iImagen = 1;
    Handler hManejador = new Handler();
    Runnable rnInteractuaUI = new Runnable() {
        @Override
        public void run() {
            switch (iImagen){
                case 1: iImagen++;
                    Cloudy.setImageResource(R.drawable.light_rain);break;
                case 2: iImagen++;
                    Cloudy.setImageResource(R.drawable.sunny);break;
                case 3: iImagen++;
                    Cloudy.setImageResource(R.drawable.cloudy);break;
                default:iImagen = 1;
                    Cloudy.setImageResource(R.drawable.rainy);break;
            }//switch
        }//run
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Cloudy=(ImageView)findViewById(R.id.Cloudy);
        MiHilo miHilo = new MiHilo();
        miHilo.start();
    }//onCreate
    class MiHilo extends Thread{
        @Override
        public void run(){
            super.run();
            while (true) {
                try {
                    hManejador.post(rnInteractuaUI);
                    Thread.sleep(1000);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }//while
        }//run()
    }//MiHilo

    boolean stopThread = true;
    @Override
    protected void onStop() {
        super.onStop();
        // stopThread;
    }
}
