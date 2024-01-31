package com.example.trabpraticosalinas;

import java.io.Serializable;
import java.util.UUID;

public class Tanque implements Serializable {
    private UUID idTanque;
    private tipoTanque tipo;
    private double capacidade;
    private double quantidadeAguaSalgada;

    public Tanque(tipoTanque tipo, double capacidade, double quantidadeAguaSalgada) {
        this.idTanque = UUID.randomUUID();
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.quantidadeAguaSalgada = quantidadeAguaSalgada;
    }

    public UUID getId() {
        return idTanque;
    }

    public tipoTanque getTipo() {
        return tipo;
    }

    public void setTipo(tipoTanque tipo) {
        this.tipo = tipo;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public double getQuantidadeAguaSalgada() {
        return quantidadeAguaSalgada;
    }

    public void setQuantidadeAguaSalgada(double quantidadeAguaSalgada) {
        this.quantidadeAguaSalgada = quantidadeAguaSalgada;
    }
}
