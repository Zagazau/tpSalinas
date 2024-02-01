package com.example.trabpraticosalinas;

import java.util.List;

public class EncomendaBll {
    private Repositorio repositorio;

    public EncomendaBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criarNovaEncomenda(Cliente cliente, List<produtoFinal> lotesProdutoFinal, String estado) {
        Encomenda novaEncomenda = new Encomenda(cliente, lotesProdutoFinal, estado);
        repositorio.lock();

        try {
            repositorio.getEncomendasMap().put(cliente.getUsername() + "_" + System.currentTimeMillis(), novaEncomenda);
            Repositorio.serialize(repositorio, "info.repo");
        } finally {
            repositorio.unlock();
        }
    }

    public Encomenda obterEncomendaPorCliente(Cliente cliente) {
        repositorio.lock();

        try {
            for (Encomenda encomenda : repositorio.getEncomendasMap().values()) {
                if (encomenda.getCliente().equals(cliente)) {
                    return encomenda;
                }
            }
            return null;
        } finally {
            repositorio.unlock();
        }
    }
}
