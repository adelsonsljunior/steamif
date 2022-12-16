package com.steamif.models;

import java.util.ArrayList;

public class Jogo {

    // Atributos
    private int id;
    private double desconto;
    private double preco;
    private String data_lancamento;
    private String descricao;
    private String nome_jogo;
    private Classificacao classificacao_indic;
    private Desenvolvedor desenvolvedor;
    private Distribuidora distribuidora;
    private Requisitos requisitos;
    private ArrayList<Genero> genero;

    // Construtor
    public Jogo(int id, double desconto, double preco, String data_lancamento, String descricao, String nome_jogo,
            Classificacao classificacao_indic, Desenvolvedor desenvolvedor, Distribuidora distribuidora,
            Requisitos requisitos, ArrayList<Genero> genero) {
        this.id = id;
        this.desconto = desconto;
        this.preco = preco;
        this.data_lancamento = data_lancamento;
        this.descricao = descricao;
        this.nome_jogo = nome_jogo;
        this.classificacao_indic = classificacao_indic;
        this.desenvolvedor = desenvolvedor;
        this.distribuidora = distribuidora;
        this.requisitos = requisitos;
        this.genero = genero;
    }

    // Getters e Setters
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

    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome_jogo() {
        return nome_jogo;
    }

    public void setNome_jogo(String nome_jogo) {
        this.nome_jogo = nome_jogo;
    }

    public Classificacao getClassificacao_indic() {
        return classificacao_indic;
    }

    public void setClassificacao_indic(Classificacao classificacao_indic) {
        this.classificacao_indic = classificacao_indic;
    }

    public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Distribuidora distribuidora) {
        this.distribuidora = distribuidora;
    }

    public Requisitos getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Requisitos requisitos) {
        this.requisitos = requisitos;
    }

    public ArrayList<Genero> getGenero() {
        return genero;
    }

    public void setGenero(ArrayList<Genero> genero) {
        this.genero = genero;
    }

}