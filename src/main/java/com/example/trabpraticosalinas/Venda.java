package com.example.trabpraticosalinas;

import java.io.Serializable;

public class Venda implements Serializable {
    private gestorVendas gv;
    private Cliente cliente;
    private Encomenda encomenda;

    public Venda(gestorVendas gv, Cliente cliente, Encomenda encomenda) {
        this.gv = gv;
        this.cliente = cliente;
        this.encomenda = encomenda;
    }

    public gestorVendas getGv() {
        return gv;
    }

    public void setGv(gestorVendas gv) {
        this.gv = gv;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }
}
