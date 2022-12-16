package com.steamif.models;

public class Classificacao {

    // Atributos
    private int id;
    private int idade_minima;

    // Construtor
    public Classificacao(int id, int idade_minima) {
        this.id = id;
        this.idade_minima = idade_minima;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade_minima() {
        return idade_minima;
    }

    public void setIdade_minima(int idade_minima) {
        this.idade_minima = idade_minima;
    }

}
