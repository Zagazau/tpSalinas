package com.example.trabpraticosalinas;

import java.io.Serializable;
import java.util.UUID;

public class TanqueBll {
    private Repositorio repositorio;

    public TanqueBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criarNovoTanque(/*tipoTanque tipo*/ double capacidade, double quantidadeAguaSalgada) {
        Tanque novoTanque = new Tanque(/*tipo*/capacidade, quantidadeAguaSalgada);
        repositorio.lock();

        try {
            UUID idTanque = UUID.randomUUID(); // Gerar um ID único para o novo tanque
            if (!repositorio.getTanquesMap().containsKey(idTanque)) {
                repositorio.getTanquesMap().put(idTanque, novoTanque);
                System.out.println("Tanque adicionado com sucesso!");
                repositorio.serialize("info.repo");
            } else {
                System.out.println("Erro: Tanque com o ID " + idTanque + " já existe no repositório.");
            }
        } finally {
            repositorio.unlock();
        }
    }
}
