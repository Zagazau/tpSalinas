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
            repositorio.getEncomendasMap().put(gerarIdEncomenda(), novaEncomenda);
        } finally {
            repositorio.unlock();
        }
    }

    public List<Encomenda> consultarEncomendasCliente(String NIFCliente) {
        repositorio.lock();

        try {
            Cliente cliente = repositorio.getClientesMap().get(NIFCliente);
            if (cliente != null) {
                return cliente.getEncomendas();
            }
        } finally {
            repositorio.unlock();
        }

        return null; // Cliente não encontrado ou sem encomendas
    }

    private String gerarIdEncomenda() {
        return "ENC" + (repositorio.getEncomendasMap().size() + 1);
    }
}

