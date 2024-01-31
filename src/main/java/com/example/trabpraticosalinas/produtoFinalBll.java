package com.example.trabpraticosalinas;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class produtoFinalBll {
    private Repositorio repositorio;

    public produtoFinalBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criarNovoProdutoFinal(UUID idProdutoFinal, Date dataCriacao, List<loteFabrico> lotes) {
        produtoFinal novoProdutoFinal = new produtoFinal(idProdutoFinal, dataCriacao, lotes);
        repositorio.lock();

        try {
            if (!repositorio.getProdutosFinaisMap().containsKey(idProdutoFinal)) {
                repositorio.getProdutosFinaisMap().put(idProdutoFinal, novoProdutoFinal);
                System.out.println("Produto final adicionado com sucesso!");
                repositorio.serialize("info.repo");
            } else {
                System.out.println("Erro: Produto final com o ID " + idProdutoFinal + " já existe no repositório.");
            }
        } finally {
            repositorio.unlock();
        }
    }
}
