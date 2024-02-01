package com.example.trabpraticosalinas;

public class gestorVendasBll {
    private Repositorio repositorio;

    public gestorVendasBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criarNovoGestorVendas(String nome, String username, String password, String numCC, String NIF, String telefone, String morada, String localidade) {
        gestorVendas novoGestorVendas = new gestorVendas(nome, username, password, numCC, NIF, telefone, morada, localidade);
        repositorio.lock();

        try {
            repositorio.getGestoresVendasMap().put(username, novoGestorVendas);
            Repositorio.serialize(repositorio, "info.repo");        } finally {
            repositorio.unlock();
        }
    }

    public gestorVendas obterGestorVendasPorUsername(String username) {
        repositorio.lock();

        try {
            return repositorio.getGestoresVendasMap().get(username);
        } finally {
            repositorio.unlock();
        }
    }
}

