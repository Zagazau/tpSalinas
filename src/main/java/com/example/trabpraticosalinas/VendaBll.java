package com.example.trabpraticosalinas;

import java.util.Map;

public class VendaBll {
    private Repositorio repositorio;

    public VendaBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void realizarVenda(String usernameGestorVendas, String usernameCliente, String idEncomenda) {
        repositorio.lock();

        try {
            gestorVendas gv = repositorio.getGestoresVendasMap().get(usernameGestorVendas);
            Cliente cliente = repositorio.getClientesMap().get(usernameCliente);
            Encomenda encomenda = repositorio.getEncomendasMap().get(idEncomenda);

            if (gv != null && cliente != null && encomenda != null) {
                Venda novaVenda = new Venda(gv, cliente, encomenda);
                repositorio.getVendasMap().put(idEncomenda, novaVenda);

                System.out.println("Venda realizada com sucesso!");
                Repositorio.serialize(repositorio, "info.repo");            } else {
                System.out.println("Erro: Gestor de Vendas, Cliente ou Encomenda não encontrados.");
            }
        } finally {
            repositorio.unlock();
        }
    }
}
