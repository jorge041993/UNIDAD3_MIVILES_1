package com.example.george.eva3_4_runenable;

import android.util.Log;

/**
 * Created by George on 17/04/2018.
 */

public class MiHilo implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<20; i++){
            try{
                Thread.sleep(1000);
                Log.wtf("Log","cat");
            }catch(Exception e){
                e.printStackTrace();
            }//catch
        }//for
    }
}
