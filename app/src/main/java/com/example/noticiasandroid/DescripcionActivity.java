package com.example.noticiasandroid;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DescripcionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        Intent i = getIntent();
        String titular = i.getStringExtra("titular");
        String cuerpo = i.getStringExtra("cuerpo");

        TextView txtTitular = findViewById(R.id.textTitular);
        txtTitular.setText(titular);
        WebView txtCuerpo = findViewById(R.id.textCuerpo);
        txtCuerpo.getSettings().setDisplayZoomControls(false);
        txtCuerpo.getSettings().setLoadWithOverviewMode(true);
        txtCuerpo.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        try{
            txtCuerpo.getSettings().getJavaScriptEnabled();
            txtCuerpo.loadDataWithBaseURL("https://www.zaragoza.es/sede/servicio/noticia?rf=html&start=0&rows=20","<style>img{display: inline;height: auto;max-width: 100%;object-fit: contain;}</style>"+cuerpo,"text/html","UTF-8","");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}