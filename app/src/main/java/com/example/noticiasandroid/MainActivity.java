package com.example.noticiasandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Noticia> lista = new ArrayList<>();


        PeticionNoticias hn = new PeticionNoticias(lista);
        hn.start();

        RecyclerView rv = findViewById(R.id.listaNoticias);
        rv.setHasFixedSize(true);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        try {
            hn.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MiAdaptador adaptador = new MiAdaptador(lista);
        rv.setAdapter(adaptador);
    }
}