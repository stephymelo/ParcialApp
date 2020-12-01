package com.example.parcialapp;

public class Puntajes {
    private String id,idPregunta;
    private int puntaje;

    public Puntajes(String id,String idPregunta, int puntaje) {
        this.id=id;
        this.idPregunta=idPregunta;
        this.puntaje=puntaje;
    }

    public Puntajes(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
