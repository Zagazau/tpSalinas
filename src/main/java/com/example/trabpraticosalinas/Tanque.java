package com.example.trabpraticosalinas;

import java.io.Serializable;

public class Tanque implements Serializable {
    public tipoTanque tipo;
    public double capacidade;
    public double quantidadeAguaSalgada;

    public Tanque(tipoTanque tipo, double capacidade, double quantidadeAguaSalgada) {
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.quantidadeAguaSalgada = quantidadeAguaSalgada;
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
