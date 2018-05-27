package com.example.george.eva3_12_camara;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Principal extends AppCompatActivity {
  ImageView img;
  private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        img = (ImageView)findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                abrirCamara();
            }
        });

    }

    private void abrirCamara() {
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    super.onActivityResult(requestCode, resultCode, data);
        InputStream stream= null;
        if (requestCode == 0 && resultCode == RESULT_OK){
            try {
                if (bitmap != null){
                    bitmap.recycle();
                }
                stream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(stream);
                img.setImageBitmap(resizeImage(this, bitmap, 700, 600));
            }catch (FileNotFoundException e){
                    e.printStackTrace();
            }finally {
                if (stream !=null)
                    try {
                    stream.close();
                    }catch (IOException e){
                    e.printStackTrace();
                    }
            }
        }
    }
    private static Bitmap resizeImage (Context Context, Bitmap bmpOriginal, float newWidth, float newHeight){
    Bitmap novoBmp = null;

    int w = bmpOriginal.getWidth();
    int h = bmpOriginal.getHeight();

    float densityFactor = Context.getResources().getDisplayMetrics().density;
    float novoW = newWidth * densityFactor;
    float novoH = newHeight * densityFactor;

    //calcular el tamaño en porcentaje
        float scalaW = novoW / w;
        float scalaH = novoH / h;

        //para malipular la matrix de una imagen
        Matrix matrix = new Matrix();

        //definiendo la proporcion de la escala de la matrix
        matrix.postScale(scalaW, scalaH);

        novoBmp =Bitmap.createBitmap(bmpOriginal, 0, 0, w, h, matrix, true);
        return novoBmp;
    }


    public void Girar(View view) {
    img.setRotation(90);
    }

    public void Voltear(View view) {
        img.setRotation(0);
    }
    public boolean onCreateoptionsMenu(Menu menu){
        //adicionar items para la barra que se le va a presentar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
