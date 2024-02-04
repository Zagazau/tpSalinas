package com.example.trabpraticosalinas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class
produtoFinal implements Serializable {
    private UUID idProdutoFinal;
    public Date dataCricao;



    public produtoFinal(UUID idProdutoFinal, Date dataCricao) {
        this.idProdutoFinal = idProdutoFinal;
        this.dataCricao = dataCricao;


    }

    public produtoFinal() {

    }

    public UUID getIdProdutoFinal() {
        return idProdutoFinal;
    }

    public void setIdProdutoFinal(UUID idProdutoFinal) {
        this.idProdutoFinal = idProdutoFinal;
    }

    public Date getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(Date dataCricao) {
        this.dataCricao = dataCricao;
    }

}
