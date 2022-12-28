package com.steamif.models;

public class Jogo {

    // Atributos
    private int id;
    private double desconto;
    private double preco;
    private String nome;
    private int classificacao;
    private String desenvolvedor;
    private String distribuidora;
    private String genero;

    //Construtores
    public Jogo(double desconto, double preco,  String nome,
            int classificacao, String desenvolvedor, String distribuidora, String genero) {
        this.desconto = desconto;
        this.preco = preco;
        this.nome = nome;
        this.classificacao = classificacao;
        this.desenvolvedor = desenvolvedor;
        this.distribuidora = distribuidora;
        this.genero = genero;
    }

    public Jogo(int id, double desconto, double preco, String nome,
            int classificacao, String desenvolvedor, String distribuidora, String requisitos, String genero) {
        this.id = id;
        this.desconto = desconto;
        this.preco = preco;
        this.nome = nome;
        this.classificacao = classificacao;
        this.desenvolvedor = desenvolvedor;
        this.distribuidora = distribuidora;
        this.genero = genero;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(String desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}