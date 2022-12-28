package com.steamif.models;

import java.util.ArrayList;

public class Usuario {

    // Atributos
    private int id;
    private String email;
    private String nome;
    private String senha;
    private boolean adm;
    private ArrayList<Jogo> biblioteca;

    // Construtores
    public Usuario(String nome, String email, String senha, boolean adm) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.adm = adm;
    }

    public Usuario(int id, String nome, String email, String senha, boolean adm, ArrayList<Jogo> biblioteca) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.biblioteca = biblioteca;
        this.adm = adm;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Jogo> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(ArrayList<Jogo> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

}
