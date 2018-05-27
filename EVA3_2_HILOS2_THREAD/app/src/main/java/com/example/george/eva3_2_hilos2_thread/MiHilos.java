package com.example.george.eva3_2_hilos2_thread;

import android.util.Log;

/**
 * Created by George on 16/04/2018.
 */

public class MiHilos extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i=0; i<20; i++){
            try{
                Thread.sleep(500);
                Log.wtf("Hilo con Thread","WTF!");
            }catch(Exception e){
                e.printStackTrace();
            }//catch
        }//for
    }
}
