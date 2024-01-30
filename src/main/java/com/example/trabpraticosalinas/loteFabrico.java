package com.example.trabpraticosalinas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class loteFabrico implements Serializable {
    public String tipo;
    public double peso;
    public tipoTanque crist;
    public Date diaTrabalho;
    List<Marnoto> marnotos;

    public loteFabrico(String tipo, double peso, tipoTanque crist, Date diaTrabalho, List<Marnoto> marnotos) {
        this.tipo = tipo;
        this.peso = peso;
        this.crist = crist;
        this.diaTrabalho = diaTrabalho;
        this.marnotos = marnotos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public tipoTanque getCrist() {
        return crist;
    }

    public void setCrist(tipoTanque crist) {
        this.crist = crist;
    }

    public Date getDiaTrabalho() {
        return diaTrabalho;
    }

    public void setDiaTrabalho(Date diaTrabalho) {
        this.diaTrabalho = diaTrabalho;
    }

    public List<Marnoto> getMarnotos() {
        return marnotos;
    }

    public void setMarnotos(List<Marnoto> marnotos) {
        this.marnotos = marnotos;
    }
}
