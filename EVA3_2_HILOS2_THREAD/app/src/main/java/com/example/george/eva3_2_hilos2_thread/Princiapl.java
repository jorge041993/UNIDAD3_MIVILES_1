package com.example.george.eva3_2_hilos2_thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Princiapl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_princiapl);

        MiHilos mHilo = new MiHilos();
        mHilo.start();
        //mHilo.run();  es como si mandaras llamar a un metodos, hace que sea lento


        //HILO CLASE ANONIMA
        Thread rhOtroHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                for (int i=0; i<20; i++){
                    try{
                        Thread.sleep(400);
                        Log.w("Hey","'Sup");
                    }catch(Exception e){
                        e.printStackTrace();
                    }//catch
                }//for
            }
        };
        rhOtroHilo.start();

    }
}
