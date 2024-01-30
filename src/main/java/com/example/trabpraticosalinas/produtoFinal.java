package com.example.trabpraticosalinas;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class produtoFinal implements Serializable {
    public Date dataCricao;
    List<loteFabrico> lotes;

    public produtoFinal(Date dataCricao, List<loteFabrico> lotes) {
        this.dataCricao = dataCricao;
        this.lotes = lotes;
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
