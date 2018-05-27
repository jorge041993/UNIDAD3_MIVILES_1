package com.example.george.eva3_5_hilos_interfaz_grafica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        mensaje = (TextView)findViewById(R.id.mensaje);
        mensaje.setText("MiHilo - Inicio");
        MiHilo mhHilo = new MiHilo();
        mhHilo.start();
    }
    class MiHilo extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i = 0; i <20; i++){
                mensaje.append(i + " - ");
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException E){
                    E.printStackTrace();
                }
            }
        }
    }
}
