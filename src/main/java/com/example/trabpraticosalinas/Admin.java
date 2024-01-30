package com.example.trabpraticosalinas;

import java.io.Serializable;

public class Admin implements Serializable {
    public String nome;
    public String numCC;
    public String NIF;
    public String telefone;
    public String morada;
    public String localidade;

    public Admin(String nome, String numCC, String NIF, String telefone, String morada, String localidade) {
        this.nome = nome;
        this.numCC = numCC;
        this.NIF = NIF;
        this.telefone = telefone;
        this.morada = morada;
        this.localidade = localidade;
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
}
