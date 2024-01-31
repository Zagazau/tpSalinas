package com.example.trabpraticosalinas;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class loteFabricoBll {
    private Repositorio repositorio;

    public loteFabricoBll(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void criarNovoLoteFabrico(String tipo, double peso, tipoTanque crist, Date diaTrabalho, List<Marnoto> marnotos) {
        UUID idLoteFabrico = UUID.randomUUID(); // Gerar um ID único para o loteFabrico
        loteFabrico novoLoteFabrico = new loteFabrico(idLoteFabrico, tipo, peso, crist, diaTrabalho, marnotos);
        repositorio.lock();

        try {
            repositorio.getLotesFabricoMap().put(idLoteFabrico.toString(), novoLoteFabrico);
            System.out.println("Lote de Fabrico adicionado com sucesso!");
            repositorio.serialize("info.repo");
        } finally {
            repositorio.unlock();
        }
    }
}
