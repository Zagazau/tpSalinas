package com.example.trabpraticosalinas;

import java.util.ArrayList;
import java.util.List;

public class gestorProducaoBll {
    private Repositorio repositorio;

    public gestorProducaoBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criarNovoGestorProducao(String nome, String username, String password, String numCC, String NIF, String telefone, String morada, String localidade) {
        gestorProducao novoGestorProducao = new gestorProducao(nome, username, password, numCC, NIF, telefone, morada, localidade);
        repositorio.lock();

        try {
            repositorio.getGestoresProducaoMap().put(username, novoGestorProducao);
            Repositorio.serialize(repositorio, "info.repo");        } finally {
            repositorio.unlock();
        }
    }

    public List<gestorProducao> listarGestoresProducao() {
        repositorio.lock();

        try {
            return new ArrayList<>(repositorio.getGestoresProducaoMap().values());
        } finally {
            repositorio.unlock();
        }
    }
}

