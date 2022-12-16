package com.steamif.models;

import java.util.ArrayList;

public class Usuario {

    // Atributos
    private int id;
    private double saldo;
    private String data_nascimento;
    private String email;
    private String nome_usuario;
    private String senha;
    private boolean adm;
    private ArrayList<Jogo> biblioteca;

    // Construtor
    public Usuario(int id, String nome_usuario, String email, String senha, String data_nascimento, double saldo, 
    boolean adm, ArrayList<Jogo> biblioteca) {
        this.id = id;
        this.nome_usuario = nome_usuario;
        this.email = email;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.saldo = saldo;
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

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
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

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
