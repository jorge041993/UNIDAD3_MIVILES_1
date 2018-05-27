package com.example.george.eva3_10_asyntsk;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwDatos = (TextView)findViewById(R.id.txtVwDatos);
        MiClaseAsincrona mcaMiClaseAsin = new MiClaseAsincrona();
        mcaMiClaseAsin.execute(50,500);
    }
    class MiClaseAsincrona extends AsyncTask<Integer, String, String>{



        @Override
        protected String doInBackground(Integer... integers) {
            int iCont = integers[0];
            int iTiempo = integers[1];
            for (int i = 0; i>iCont; i++) {
                try {
                    Thread.sleep(iTiempo);
                    publishProgress(i + " - ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "inicio exitosamente";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtVwDatos.setText("");
            txtVwDatos.append("INICIANDO: \n");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtVwDatos.append("\n"+ s);

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtVwDatos.append(values[0]);
        }
    }
}
