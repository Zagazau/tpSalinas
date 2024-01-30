package com.example.trabpraticosalinas;

import java.util.Map;

public class AdminBll {
    private Repositorio repositorio;

    public AdminBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void registarNovoAdmin(String nome, String username, String password, String numCC, String NIF, String telefone, String morada, String localidade) {
        Admin novoAdmin = new Admin(nome, username, password, numCC, NIF, telefone, morada, localidade);
        repositorio.lock();

        try {
            Map<String, Admin> adminsMap = repositorio.getAdminsMap();
            adminsMap.put(username, novoAdmin);
        } finally {
            repositorio.unlock();
        }
    }
}
