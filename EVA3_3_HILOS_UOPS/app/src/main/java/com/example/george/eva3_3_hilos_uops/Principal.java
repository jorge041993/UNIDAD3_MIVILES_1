package com.example.george.eva3_3_hilos_uops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {
    boolean bBande = false;
    @Override
    protected void onPause() {
        super.onPause();
        bBande=true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Thread rhOtroHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try {
                        Thread.sleep(400);
                        Log.w("Thread de clase anonima", "Clase anonima");
                        if(bBande)break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }//catch
                }//while
            }
        };
        rhOtroHilo.start();
    }
}
