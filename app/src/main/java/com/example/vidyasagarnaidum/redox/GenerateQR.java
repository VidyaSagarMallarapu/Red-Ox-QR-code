package com.example.vidyasagarnaidum.redox;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateQR extends AppCompatActivity {

    ImageView im;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        im=findViewById(R.id.image);
        Intent i=getIntent();
        String str=i.getStringExtra("QWERTYUIOP");
        MultiFormatWriter mt=new MultiFormatWriter();
        try{
            BitMatrix bitMatrix =mt.encode(str, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder bar=new BarcodeEncoder();
            Bitmap bt=bar.createBitmap(bitMatrix);
            im.setImageBitmap(bt);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public void goHome(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
