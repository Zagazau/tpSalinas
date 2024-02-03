package com.example.trabpraticosalinas;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Utilizador {
    private List<Encomenda> encomendas;

    public Cliente(String nome, String username, String password, String numCC, String NIF, String telefone, String morada, String localidade, List<Encomenda> encomendas) {
        super(nome, username, password, numCC, NIF, telefone, morada, localidade);
        this.encomendas = encomendas != null ? encomendas : new ArrayList<>();
    }

    public Cliente() {
        super();
        this.encomendas = new ArrayList<>();
    }

    public List<Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(List<Encomenda> encomendas) {
        this.encomendas = encomendas != null ? encomendas : new ArrayList<>();
    }

    @Serial
    private static final long serialVersionUID = -1174136247644363844L;
}

