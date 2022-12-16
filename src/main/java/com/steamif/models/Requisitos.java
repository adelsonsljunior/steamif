package com.steamif.models;

public class Requisitos {

    // Atributos
    private int id;
    private int ram;
    private double armazenamento;
    private String sistema_op;

    // Construtor
    public Requisitos(int id, int ram, double armazenamento, String sistema_op) {
        this.id = id;
        this.ram = ram;
        this.armazenamento = armazenamento;
        this.sistema_op = sistema_op;
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

    public String getSistema_op() {
        return sistema_op;
    }

    public void setSistema_op(String sistema_op) {
        this.sistema_op = sistema_op;
    }

}
