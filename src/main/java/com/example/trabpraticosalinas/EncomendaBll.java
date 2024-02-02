package com.example.trabpraticosalinas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EncomendaBll {

    public EncomendaBll() {
    }

    public static void criarEncomenda(Encomenda encomenda, Cliente cliente) {
        if (encomenda != null && cliente != null) {
            encomenda.setEstado(EncomendaEstado.PROCESSADA);
            encomenda.setCliente(cliente);
            encomenda.setIdEncomenda(Repositorio.getRepositorio().getEncomendasMap().size() + 1);

            Map<String, List<Encomenda>> encomendasMap = Repositorio.getRepositorio().getEncomendasMap();

            List<Encomenda> encomendas = encomendasMap.computeIfAbsent(cliente.getNIF(), k -> new ArrayList<>());
            encomendas.add(encomenda);

            // Certifica-se de que o cliente está no repositório antes de adicionar a encomenda
            if (Repositorio.getRepositorio().getClientesMap().containsKey(cliente.getNIF())) {
                Repositorio.getRepositorio().getClientesMap().get(cliente.getNIF()).getEncomendas().add(encomenda);
            } else {
                System.out.println("Cliente não encontrado no repositório. A encomenda não foi adicionada ao cliente.");
            }

            System.out.println("Encomenda criada com sucesso!");
            Repositorio.getRepositorio().serialize(Repositorio.getRepositorio(), "info.repo");
        } else {
            System.out.println("Encomenda ou cliente inválido(s). A encomenda não foi criada.");
        }
    }

    public static void atualizarEncomenda() {
        Map<String, List<Encomenda>> encomendasMap = Repositorio.getRepositorio().getEncomendasMap();

        for (List<Encomenda> encomendas : encomendasMap.values()) {
            for (Encomenda encomenda : encomendas) {
                if (encomenda.getEstado() == EncomendaEstado.PROCESSADA && LocalDate.now().isAfter(encomenda.getEncomendaData())) {
                    encomenda.setEstado(EncomendaEstado.REALIZADA);
                    System.out.println("Encomenda ID " + encomenda.getIdEncomenda() + " foi REALIZADA.");
                }
                if (encomenda.getEstado() == EncomendaEstado.PROCESSADA && LocalDate.now().isEqual(encomenda.getEncomendaData())) {
                    encomenda.setEstado(EncomendaEstado.REALIZADA);
                    System.out.println("Encomenda ID " + encomenda.getIdEncomenda() + " foi NAO_REALIZADA.");
                }
            }
        }

        Repositorio.getRepositorio().serialize(Repositorio.getRepositorio(), "info.repo");
    }
}

