package com.example.trabpraticosalinas;

import java.io.Serializable;
import java.util.List;

public class Encomenda implements Serializable {
    private Cliente cliente;
    private List<produtoFinal> lotesProdutoFinal;
    private String estado;

    public Encomenda(Cliente cliente, List<produtoFinal> lotesProdutoFinal, String estado) {
        this.cliente = cliente;
        this.lotesProdutoFinal = lotesProdutoFinal;
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<produtoFinal> getLotesProdutoFinal() {
        return lotesProdutoFinal;
    }

    public void setLotesProdutoFinal(List<produtoFinal> lotesProdutoFinal) {
        this.lotesProdutoFinal = lotesProdutoFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
