package com.example.trabpraticosalinas;

public class MarnotoBll {
    private Repositorio repositorio;

    public MarnotoBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criarNovoMarnoto(String nome, String username, String password, String numCC, String NIF, String telefone, String morada, String localidade) {
        Marnoto novoMarnoto = new Marnoto(nome, username, password, numCC, NIF, telefone, morada, localidade);
        repositorio.lock();

        try {
            repositorio.getMarnotosMap().put(username, novoMarnoto);
            Repositorio.serialize(repositorio, "info.repo");        } finally {
            repositorio.unlock();
        }
    }
}
