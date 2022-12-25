package com.steamif.models;

public class Distribuidora {

    // Atributos
    private int id;
    private String nomeDist;

    // Construtores
    public Distribuidora(int id, String nomeDist) {
        this.id = id;
        this.nomeDist = nomeDist;
    }

    public Distribuidora(String nomeDist) {
        this.nomeDist = nomeDist;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDist() {
        return nomeDist;
    }

    public void setNomeDist(String nomeDist) {
        this.nomeDist = nomeDist;
    }
}
