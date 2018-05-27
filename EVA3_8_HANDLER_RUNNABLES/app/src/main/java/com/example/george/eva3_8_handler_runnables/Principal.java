package com.example.george.eva3_8_handler_runnables;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    TextView Datos;
    Handler hnManejador = new Handler();

    Runnable rnInteractuaUI = new Runnable() {
        int iVal = 0;
        @Override
        public void run() {//INTERACCION CON LA UI
            Datos.append((iVal++)+" - ");

        }//run()
    };//Runnable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Datos = (TextView)findViewById(R.id.Datos);
        MiHilo mhHilo = new MiHilo();
        mhHilo.start();
    }

    class MiHilo extends Thread{
        @Override
        public void run(){
            super.run();
            for (int i = 1; i <= 50; i++){
                try{
                    hnManejador.post(rnInteractuaUI);
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }//run
    }
}
