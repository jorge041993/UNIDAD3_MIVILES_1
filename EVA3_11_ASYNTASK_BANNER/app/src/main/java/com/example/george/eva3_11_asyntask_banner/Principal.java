package com.example.george.eva3_11_asyntask_banner;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {

    ImageView Cloudy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Cloudy = (ImageView)findViewById(R.id.Cloudy);

        ClaseAsincrona claseAsincrona = new ClaseAsincrona();
        claseAsincrona.execute(500);
    }//onCreate
    class ClaseAsincrona extends AsyncTask<Integer, Integer, Integer> {
        int iImagen = 1;
        @Override
        protected Integer doInBackground(Integer... integers) {
            int imgTiempo = integers[0];
            while (true) {
                try {
                    Thread.sleep(imgTiempo);
                    onProgressUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }//catch
            }//while
        }//doInBackground
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            switch (iImagen) {
                case 1:
                    iImagen++;
                    Cloudy.setImageResource(R.drawable.light_rain);
                    break;
                case 2:
                    iImagen++;
                    Cloudy.setImageResource(R.drawable.sunny);
                    break;
                case 3:
                    iImagen++;
                    Cloudy.setImageResource(R.drawable.cloudy);
                    break;
                default:
                    iImagen = 1;
                    Cloudy.setImageResource(R.drawable.rainy);
                    break;
            }//switch
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

        }
    }
}
