package com.example.george.eva3_1_hilos_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //SIMULACION DE DEMORA EN LA APP
        for (int i=0; i<20; i++){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }//catch
        }//for
    }
}
