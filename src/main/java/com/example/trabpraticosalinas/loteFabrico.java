package com.example.trabpraticosalinas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class loteFabrico implements Serializable {
    private UUID idLoteFabrico;
    public String tipo;
    public double peso;
   // public tipoTanque crist;
    public Date diaTrabalho;
    List<Marnoto> marnotos;

    public loteFabrico(UUID idLoteFabrico, String tipo, double peso, /*tipoTanque cris*/ Date diaTrabalho, List<Marnoto> marnotos) {
        this.idLoteFabrico = idLoteFabrico;
        this.tipo = tipo;
        this.peso = peso;
      //  this.crist = crist;
        this.diaTrabalho = diaTrabalho;
        this.marnotos = marnotos;
    }

    public UUID getIdLoteFabrico() {
        return idLoteFabrico;
    }
  /*  public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    */
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

   /* public tipoTanque getCrist() {
        return crist;
    }

    public void setCrist(tipoTanque crist) {
        this.crist = crist;
    }
    */
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
