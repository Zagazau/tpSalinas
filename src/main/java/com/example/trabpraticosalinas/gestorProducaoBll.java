package com.example.trabpraticosalinas;

import java.util.Map;

public class gestorProducaoBll {
    public static void registargestorProducao(gestorProducao gp) {
        Repositorio.getRepositorio().getGestoresProducaoMap().put(gp.getNIF(), gp);

        System.out.println("Admin criado com sucesso.");
        Repositorio.getRepositorio().serialize(Repositorio.getRepositorio(), "info.repo");
    }
}

