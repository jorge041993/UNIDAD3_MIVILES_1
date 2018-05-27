package com.example.george.eva3_14_servicio_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwDatos;
    Intent inMiServicio;
    BroadcastReceiver brMiReceptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwDatos = (TextView)findViewById(R.id.txtVwDatos);

        txtVwDatos = (TextView)findViewById(R.id.txtVwDatos);

        // inMiServicio = new Intent(this, MyService.class);
        //startService(inMiServicio);

        IntentFilter ifMiFiltro = new IntentFilter("MI_SERVICIOTE");
        brMiReceptor = new MiReceptor();
        registerReceiver(brMiReceptor,ifMiFiltro);//el filtro que va a escuchar
    }


    @Override
    protected void onStop() {
        super.onStop();
        stopService(inMiServicio);
    }//onStop
    public class MiReceptor extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            txtVwDatos.append("\n");
            String sCade = intent.getStringExtra("MI_CADENA");
            txtVwDatos.append(sCade);
        }
    }
}
