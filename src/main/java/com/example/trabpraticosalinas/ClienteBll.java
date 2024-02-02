package com.example.trabpraticosalinas;

import java.util.ArrayList;
import java.util.List;
public class ClienteBll {
    public static void criarNovoCliente(Cliente cliente) {
        Repositorio.getRepositorio().getClientesMap().put(cliente.getNIF(), cliente);

        System.out.println("Cliente criado com sucesso.");
        Repositorio.getRepositorio().serialize(Repositorio.getRepositorio(), "info.repo");
    }
}

