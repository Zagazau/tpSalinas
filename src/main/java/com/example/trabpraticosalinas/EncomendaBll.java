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

        // Percorra o mapa de clientes e obtenha todas as encomendas
        Map<String, List<Encomenda>> encomendasMap = Repositorio.getRepositorio().getEncomendasMap();

        for (List<Encomenda> encomendas : encomendasMap.values()) {
            todasEncomendas.addAll(encomendas);
        }

        return todasEncomendas;
    }

    public static Encomenda criarEncomenda(Encomenda encomenda, Cliente cliente) {
        if (encomenda != null && cliente != null) {
            // Adicione logs para depuração
            System.out.println("Criando encomenda para cliente: " + cliente.getNome());
            System.out.println("Detalhes da encomenda: " + encomenda.toString());

            encomenda.setEstado(EncomendaEstado.PROCESSADA);
            encomenda.setCliente(cliente);

            // Atribui o próximo ID disponível
            encomenda.setIdEncomenda(proximoIdEncomenda++);

            // Certifica-se de que o cliente está no repositório antes de adicionar a encomenda
            if (Repositorio.getRepositorio().getClientesMap().containsKey(cliente.getNIF())) {
                // Verifica se a encomenda já existe na lista de encomendas do cliente
                if (!Repositorio.getRepositorio().getClientesMap().get(cliente.getNIF()).getEncomendas().contains(encomenda)) {
                    // Adiciona a encomenda à lista do cliente
                    Repositorio.getRepositorio().getClientesMap().get(cliente.getNIF()).getEncomendas().add(encomenda);
                } else {
                    System.out.println("A encomenda já existe na lista do cliente. Não foi duplicada.");
                }
            } else {
                System.out.println("Cliente não encontrado no repositório. A encomenda não foi adicionada ao cliente.");
            }

            // Adiciona a encomenda ao mapa de encomendas
            Repositorio.getRepositorio().getEncomendasMap()
                    .computeIfAbsent(cliente.getNIF(), k -> new ArrayList<>())
                    .add(encomenda);

            System.out.println("Encomenda criada com sucesso!");
            Repositorio.getRepositorio().serialize(Repositorio.getRepositorio(), "info.repo");

            // Retorna a instância da encomenda criada
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

