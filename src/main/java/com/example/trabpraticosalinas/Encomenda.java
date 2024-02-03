package com.example.trabpraticosalinas;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Encomenda implements Serializable {
    private int idEncomenda;
    private LocalDate encomendaData;
    private Cliente cliente;
    private List<produtoFinal> lotesProdutoFinal;
    private EncomendaEstado estado;

    public Encomenda(int idEncomenda, LocalDate encomendaData, Cliente cliente, List<produtoFinal> lotesProdutoFinal, EncomendaEstado estado) {
        this.idEncomenda = idEncomenda;
        this.encomendaData = encomendaData;
        this.cliente = cliente;
        this.lotesProdutoFinal = lotesProdutoFinal;
        this.estado = estado;
        if (cliente.getEncomendas() == null) {
            cliente.setEncomendas(new ArrayList<>());
        }
        cliente.getEncomendas().add(this);
    }

    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public ChronoLocalDate getEncomendaData() {
        return encomendaData;
    }

    public void setEncomendaData(LocalDate encomendaData) {
        this.encomendaData = encomendaData;
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

    public EncomendaEstado getEstado() {
        return estado;
    }

    public void setEstado(EncomendaEstado estado) {
        this.estado = estado;
    }
}
