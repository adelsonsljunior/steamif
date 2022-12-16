package com.steamif.models;

public class Genero {

    // Atributos
    private int id;
    private String nome_genero;

    // Construtor
    public Genero(int id, String nome_genero) {
        this.id = id;
        this.nome_genero = nome_genero;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_genero() {
        return nome_genero;
    }

    public void setNome_genero(String nome_genero) {
        this.nome_genero = nome_genero;
    }

}
