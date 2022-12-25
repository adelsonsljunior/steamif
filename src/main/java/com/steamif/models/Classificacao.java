package com.steamif.models;

public class Classificacao {

    // Atributos
    private int id;
    private int idadeMinima;

    // Construtores
    public Classificacao(int id, int idadeMinima) {
        this.id = id;
        this.idadeMinima = idadeMinima;
    }

    public Classificacao(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

}
