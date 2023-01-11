package com.example.noticiasandroid;

import android.util.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class PeticionNoticias extends Thread{

    ArrayList<Noticia> lista;

    public PeticionNoticias(ArrayList<Noticia>lista){
        this.lista = lista;
    }

    @Override
    public void run() {

        try{
            URL url = new URL("https://www.zaragoza.es/sede/servicio/noticia?rf=html&start=0&rows=20");
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestProperty("Accept", "application/json");
            if(con.getResponseCode() == 200){
                InputStream is = con.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                JsonReader jr = new JsonReader(isr);
                String clave = "";
                String clave2 = "";
                String titulo = "";
                String cuerpo = "";
                jr.beginObject();
                while(jr.hasNext()){
                    clave = jr.nextName();
                    if (clave.equals("result")){
                        jr.beginArray();
                        while (jr.hasNext()){
                            jr.beginObject();
                            while (jr.hasNext()){
                                clave2 = jr.nextName();
                                if (clave2.equals("title")){
                                    titulo = jr.nextString();
                                }else if (clave2.equals("description")){
                                    cuerpo = jr.nextString();
                                    Noticia n = new Noticia(titulo, cuerpo);
                                    this.lista.add(n);
                                }else {
                                    jr.skipValue();
                                }
                            }
                            jr.endObject();
                        }
                        jr.endArray();
                    }else{
                        jr.skipValue();
                    }
                }
                jr.endObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
