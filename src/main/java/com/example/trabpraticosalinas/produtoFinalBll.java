package com.example.trabpraticosalinas;

import java.util.Date;
import java.util.UUID;

public class produtoFinalBll {
    private Repositorio repositorio;

    public produtoFinalBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criarNovoProdutoFinal(UUID idProdutoFinal, Date dataCriacao) {
        repositorio.lock();

        try {
            if (!repositorio.getProdutosFinaisMap().containsKey(idProdutoFinal)) {
                produtoFinal novoProdutoFinal = new produtoFinal(idProdutoFinal, dataCriacao); // Não há necessidade de lotes na criação
                repositorio.getProdutosFinaisMap().put(idProdutoFinal, novoProdutoFinal);
                System.out.println("Produto final adicionado com sucesso!");
                Repositorio.serialize(repositorio, "info.repo");
            } else {
                System.out.println("Erro: Produto final com o ID " + idProdutoFinal + " já existe no repositório.");
            }
        } finally {
            repositorio.unlock();
        }
    }
}
