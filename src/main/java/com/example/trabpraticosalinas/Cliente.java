package com.example.trabpraticosalinas;

import java.io.Serializable;
import java.util.List;

public class Cliente implements Serializable {
    public String nome;
    public String numCC;
    public String NIF;
    public String telefone;
    public String morada;
    public String localidade;
    List<Encomenda> encomendas;

    public Cliente(String nome, String numCC, String NIF, String telefone, String morada, String localidade, List<Encomenda> encomendas) {
        this.nome = nome;
        this.numCC = numCC;
        this.NIF = NIF;
        this.telefone = telefone;
        this.morada = morada;
        this.localidade = localidade;
        this.encomendas = encomendas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumCC() {
        return numCC;
    }

    public void setNumCC(String numCC) {
        this.numCC = numCC;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(List<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }
}
