package com.example.trabpraticosalinas;

import java.io.Serializable;

public class Utilizador implements Serializable {
    protected String nome;
    protected String username;
    protected String password;
    protected String numCC;
    protected String NIF;
    protected String telefone;
    protected String morada;
    protected String localidade;

    public Utilizador(String nome, String username, String password, String numCC, String NIF, String telefone, String morada, String localidade) {
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.numCC = numCC;
        this.NIF = NIF;
        this.telefone = telefone;
        this.morada = morada;
        this.localidade = localidade;
    }
    public Utilizador() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
