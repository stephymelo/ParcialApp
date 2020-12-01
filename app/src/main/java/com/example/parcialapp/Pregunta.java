package com.example.parcialapp;

public class Pregunta {
    private String id,preguntica;

    public Pregunta (String id, String preguntica){
        this.preguntica=preguntica;
        this.id=id;
    }

    public Pregunta(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreguntica() {
        return preguntica;
    }

    public void setPreguntica(String preguntica) {
        this.preguntica = preguntica;
    }
}
