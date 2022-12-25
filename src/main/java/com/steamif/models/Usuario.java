package com.steamif.models;

import java.util.ArrayList;

public class Usuario {

    // Atributos
    private int id;
    private double saldo;
    private String dataNascimento;
    private String email;
    private String nomeUsuario;
    private String senha;
    private boolean adm;
    private ArrayList<Jogo> biblioteca;

    // Construtores
    public Usuario(int id, String nomeUsuario, String email, String senha, String dataNascimento, double saldo, 
    boolean adm, ArrayList<Jogo> biblioteca) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.saldo = saldo;
        this.biblioteca = biblioteca;
        this.adm = adm;
    }

    public Usuario(String nomeUsuario, String email, String senha, String dataNascimento, double saldo, 
    boolean adm, ArrayList<Jogo> biblioteca) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
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

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
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
