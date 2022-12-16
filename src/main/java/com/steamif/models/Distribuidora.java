package com.steamif.models;

public class Distribuidora {

    // Atributos
    private int id;
    private String nome_dist;

    // Construtor
    public Distribuidora(int id, String nome_dist) {
        this.id = id;
        this.nome_dist = nome_dist;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_dist() {
        return nome_dist;
    }

    public void setNome_dist(String nome_dist) {
        this.nome_dist = nome_dist;
    }
}
