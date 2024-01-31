package com.example.trabpraticosalinas;

import java.util.HashMap;
import java.util.Map;

public class UtilizadorBll {
    private Repositorio repositorio;

    public UtilizadorBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criarNovoUtilizador(String nome, String username, String password, String numCC, String NIF, String telefone, String morada, String localidade) {
        Utilizador novoUtilizador = new Utilizador(nome, username, password, numCC, NIF, telefone, morada, localidade);
        repositorio.lock();

        try {
            // Verificar se o username já está em uso
            if (!repositorio.getClientesMap().containsKey(username) &&
                    !repositorio.getGestoresProducaoMap().containsKey(username) &&
                    !repositorio.getGestoresVendasMap().containsKey(username) &&
                    !repositorio.getAdminsMap().containsKey(username)) {
                // Adicionar o novo utilizador
                Map<String, Utilizador> utilizadores = new HashMap<>(repositorio.getClientesMap());
                utilizadores.put(username, novoUtilizador);

                // Atualizar o map no repositório
                repositorio.getClientesMap().clear();
                for (Map.Entry<String, Utilizador> entry : utilizadores.entrySet()) {
                    repositorio.getClientesMap().put(entry.getKey(), (Cliente) entry.getValue());
                }

                System.out.println("Utilizador criado com sucesso!");
                repositorio.serialize("info.repo");
            } else {
                System.out.println("Erro: O username " + username + " já está em uso.");
            }
        } finally {
            repositorio.unlock();
        }
    }
}
