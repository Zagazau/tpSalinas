package com.example.trabpraticosalinas;

public class gestorVendasBll {
    public static void registargestorVendas(gestorVendas gv) {
        Repositorio.getRepositorio().getGestoresVendasMap().put(gv.getNIF(), gv);

        System.out.println("Admin criado com sucesso.");
        Repositorio.getRepositorio().serialize(Repositorio.getRepositorio(), "info.repo");
    }
}

