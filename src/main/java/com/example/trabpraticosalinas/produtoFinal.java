package com.example.trabpraticosalinas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class
produtoFinal implements Serializable {
    private UUID idProdutoFinal;
    public Date dataCricao;
    List<loteFabrico> lotes;

    public produtoFinal(UUID idProdutoFinal, Date dataCricao, List<loteFabrico> lotes) {
        this.idProdutoFinal = idProdutoFinal;
        this.dataCricao = dataCricao;
        this.lotes = lotes;
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

    public List<loteFabrico> getLotes() {
        return lotes;
    }

    public void setLotes(List<loteFabrico> lotes) {
        this.lotes = lotes;
    }
}
