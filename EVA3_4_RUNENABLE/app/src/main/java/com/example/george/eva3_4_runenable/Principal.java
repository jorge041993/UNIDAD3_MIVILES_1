package com.example.george.eva3_4_runenable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        MiHilo mHilo = new MiHilo();
        Thread thHilo = new Thread(mHilo);
        thHilo.start();

        final Runnable rnHiloRun = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<20; i++){
                    try{
                        Thread.sleep(1000);
                        Log.wtf("Clase","anonima");
                    }catch(Exception e){
                        e.printStackTrace();
                    }//catch
                }//for
            }
            //Thread thHilo1 = new Thread(rnHiloRun);
        };
    }
}
