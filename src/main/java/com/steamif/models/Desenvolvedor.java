package com.steamif.models;

public class Desenvolvedor {

    // Atributos
    private int id;
    private String nomeDev;

    // Construtores
    public Desenvolvedor(int id, String nomeDev) {
        this.id = id;
        this.nomeDev = nomeDev;
    }

    public Desenvolvedor(String nomeDev) {
        this.nomeDev = nomeDev;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDev() {
        return nomeDev;
    }

    public void setNomeDev(String nomeDev) {
        this.nomeDev = nomeDev;
    }

}