package com.example.trabpraticosalinas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EncomendaBll {

    private static int proximoIdEncomenda = 1;
    public EncomendaBll() {
    }

    public static List<Encomenda> obterTodasEncomendas() {
        List<Encomenda> todasEncomendas = new ArrayList<>();

        Map<String, List<Encomenda>> encomendasMap = Repositorio.getRepositorio().getEncomendasMap();

        for (List<Encomenda> encomendas : encomendasMap.values()) {
            todasEncomendas.addAll(encomendas);
        }

        return todasEncomendas;
    }

    public static Encomenda criarEncomenda(Encomenda encomenda, Cliente cliente) {
        if (encomenda != null && cliente != null) {

            System.out.println("Criando encomenda para cliente: " + cliente.getNome());
            System.out.println("Detalhes da encomenda: " + encomenda.toString());

            encomenda.setEstado(EncomendaEstado.PROCESSADA);
            encomenda.setCliente(cliente);


            encomenda.setIdEncomenda(proximoIdEncomenda++);


            if (Repositorio.getRepositorio().getClientesMap().containsKey(cliente.getNIF())) {
                if (!Repositorio.getRepositorio().getClientesMap().get(cliente.getNIF()).getEncomendas().contains(encomenda)) {
                    Repositorio.getRepositorio().getClientesMap().get(cliente.getNIF()).getEncomendas().add(encomenda);
                } else {
                    System.out.println("A encomenda já existe na lista do cliente. Não foi duplicada.");
                }
            } else {
                System.out.println("Cliente não encontrado no repositório. A encomenda não foi adicionada ao cliente.");
            }


            Repositorio.getRepositorio().getEncomendasMap()
                    .computeIfAbsent(cliente.getNIF(), k -> new ArrayList<>())
                    .add(encomenda);

            System.out.println("Encomenda criada com sucesso!");
            Repositorio.getRepositorio().serialize(Repositorio.getRepositorio(), "info.repo");


            return encomenda;
        } else {
            System.out.println("Encomenda ou cliente inválido(s). A encomenda não foi criada.");
            return null;
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

