package com.example.noticiasandroid;

public class Noticia {
    private String titular;
    private String cuerpo;

    public Noticia(String titular, String cuerpo) {
        this.titular = titular;
        this.cuerpo = cuerpo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}
