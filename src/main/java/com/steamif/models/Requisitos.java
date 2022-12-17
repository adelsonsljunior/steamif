package com.steamif.models;

public class Requisitos {

    // Atributos
    private int id;
    private int ram;
    private double armazenamento;
    private String sistemaOp;

    // Construtores
    public Requisitos(int id, int ram, double armazenamento, String sistemaOp) {
        this.id = id;
        this.ram = ram;
        this.armazenamento = armazenamento;
        this.sistemaOp = sistemaOp;
    }

    public Requisitos(int ram, double armazenamento, String sistemaOp) {
        this.ram = ram;
        this.armazenamento = armazenamento;
        this.sistemaOp = sistemaOp;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(double armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getSistemaOp() {
        return sistemaOp;
    }

    public void setSistemaOp(String sistemaOp) {
        this.sistemaOp = sistemaOp;
    }

}
