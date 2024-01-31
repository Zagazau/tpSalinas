package com.example.trabpraticosalinas;

import java.io.Serializable;
import java.util.List;

public class Cliente extends Utilizador {
    List<Encomenda> encomendas;

    public Cliente(String nome, String username, String password, String numCC, String NIF, String telefone, String morada, String localidade, List<Encomenda> encomendas) {
        super(nome, username, password, numCC, NIF, telefone, morada, localidade);
        this.encomendas = encomendas;
    }

    public Cliente() {
        super();
    }

    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(List<Encomenda> encomendas) {
        this.encomendas = encomendas;
    }
}
