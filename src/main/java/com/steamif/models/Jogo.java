package com.steamif.models;

import java.util.ArrayList;

public class Jogo {

    // Atributos
    private int id;
    private double desconto;
    private double preco;
    private String dataLancamento;
    private String descricao;
    private String nomeJogo;
    private Classificacao classificacaoIndic;
    private Desenvolvedor desenvolvedor;
    private Distribuidora distribuidora;
    private Requisitos requisitos;
    private ArrayList<Genero> genero;

    // Construtores
    public Jogo(int id, double desconto, double preco, String dataLancamento, String descricao, String nomeJogo,
            Classificacao classificacaoIndic, Desenvolvedor desenvolvedor, Distribuidora distribuidora,
            Requisitos requisitos, ArrayList<Genero> genero) {
        this.id = id;
        this.desconto = desconto;
        this.preco = preco;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.nomeJogo = nomeJogo;
        this.classificacaoIndic = classificacaoIndic;
        this.desenvolvedor = desenvolvedor;
        this.distribuidora = distribuidora;
        this.requisitos = requisitos;
        this.genero = genero;
    }

    public Jogo(double desconto, double preco, String dataLancamento, String descricao, String nomeJogo,
            Classificacao classificacaoIndic, Desenvolvedor desenvolvedor, Distribuidora distribuidora,
            Requisitos requisitos, ArrayList<Genero> genero) {
        this.desconto = desconto;
        this.preco = preco;
        this.dataLancamento = dataLancamento;
        this.descricao = descricao;
        this.nomeJogo = nomeJogo;
        this.classificacaoIndic = classificacaoIndic;
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

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public Classificacao getClassificacaoIndic() {
        return classificacaoIndic;
    }

    public void setClassificacaoIndic(Classificacao classificacaoIndic) {
        this.classificacaoIndic = classificacaoIndic;
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