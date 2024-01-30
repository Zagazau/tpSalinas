package com.example.trabpraticosalinas;

import java.util.List;

public class ClienteBll {
    private Repositorio repositorio;

    public ClienteBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void registarNovoCliente(String nome, String username, String password, String numCC, String NIF, String telefone, String morada, String localidade) {
        Cliente novoCliente = new Cliente(nome, username, password, numCC, NIF, telefone, morada, localidade, null); // Inicialmente sem encomendas
        repositorio.lock();

        try {
            repositorio.getClientesMap().put(NIF, novoCliente);
        } finally {
            repositorio.unlock();
        }
    }

    public List<Encomenda> consultarEncomendas(String NIF) {
        repositorio.lock();

        try {
            Cliente cliente = repositorio.getClientesMap().get(NIF);
            if (cliente != null) {
                return cliente.getEncomendas();
            }
        } finally {
            repositorio.unlock();
        }

        return null; // Cliente não encontrado ou sem encomendas
    }
}

