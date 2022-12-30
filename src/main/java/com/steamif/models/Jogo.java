package com.steamif.models;

public class Jogo {

    // Atributos
    private int id;
    private double desconto;
    private double preco;
    private String nome;
    private int classificacao;
    private String desenvolvedora;
    private String distribuidora;
    private String genero;

    //Construtores
    public Jogo(double desconto, double preco,  String nome, int classificacao, String desenvolvedora, String distribuidora, String genero) {
        this.desconto = desconto;
        this.preco = preco;
        this.nome = nome;
        this.classificacao = classificacao;
        this.desenvolvedora = desenvolvedora;
        this.distribuidora = distribuidora;
        this.genero = genero;
    }

    public Jogo(int id, double desconto, double preco, String nome,  String desenvolvedora, String distribuidora, String genero, int classificacao) {
        this.id = id;
        this.desconto = desconto;
        this.preco = preco;
        this.nome = nome;
        this.classificacao = classificacao;
        this.desenvolvedora = desenvolvedora;
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

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora){
        this.desenvolvedora = desenvolvedora;
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