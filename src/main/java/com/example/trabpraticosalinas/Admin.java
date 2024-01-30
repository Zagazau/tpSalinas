package com.example.trabpraticosalinas;

import java.io.Serializable;

public class Admin extends Utilizador {
    public Admin(String nome, String username, String password, String numCC, String NIF, String telefone, String morada, String localidade) {
        super(nome, username, password, numCC, NIF, telefone, morada, localidade);
    }
}
