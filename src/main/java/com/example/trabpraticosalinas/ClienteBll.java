package com.example.trabpraticosalinas;

import java.util.ArrayList;
import java.util.List;

public class ClienteBll {
    private Repositorio repositorio;

    public ClienteBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criarNovoCliente(String nome, String username, String password, String numCC, String NIF, String telefone, String morada, String localidade) {
        Cliente novoCliente = new Cliente(nome, username, password, numCC, NIF, telefone, morada, localidade, new ArrayList<>());
        repositorio.lock();

        try {
            repositorio.getClientesMap().put(NIF, novoCliente);
            Repositorio.serialize(repositorio, "info.repo");
        } finally {
            repositorio.unlock();
        }
    }

    public List<Cliente> listarClientes() {
        repositorio.lock();

        try {
            return new ArrayList<>(repositorio.getClientesMap().values());
        } finally {
            repositorio.unlock();
        }
    }
}

