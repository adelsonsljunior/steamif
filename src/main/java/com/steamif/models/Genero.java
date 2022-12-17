package com.steamif.models;

public class Genero {

    // Atributos
    private int id;
    private String nomeGenero;

    // Construtores
    public Genero(int id, String nomeGenero) {
        this.id = id;
        this.nomeGenero = nomeGenero;
    }

    public Genero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nome_genero) {
        this.nomeGenero = nome_genero;
    }

}
