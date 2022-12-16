package com.steamif.models;

public class Desenvolvedor {

    // Atributos
    private int id;
    private String nome_dev;

    // Construtor
    public Desenvolvedor(int id, String nome_dev) {
        this.id = id;
        this.nome_dev = nome_dev;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_dev() {
        return nome_dev;
    }

    public void setNome_dev(String nome_dev) {
        this.nome_dev = nome_dev;
    }

}