package com.desafio.itau.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class Estatistica {
    
    public Estatistica(List<Transacao> transacaoList){
            this.count = transacaoList.size();
            this.sum = transacaoList.stream()
                    .map(Transacao::valor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            this.avg = this.count > 0 ? this.sum.divide(BigDecimal.valueOf(this.count), BigDecimal.ROUND_HALF_UP) : BigDecimal.ZERO;
            this.min = transacaoList.stream()
                    .map(Transacao::valor)
                    .min(BigDecimal::compareTo)
                    .orElse(BigDecimal.ZERO);
            this.max = transacaoList.stream()
                    .map(Transacao::valor)
                    .max(BigDecimal::compareTo)
                    .orElse(BigDecimal.ZERO);
    }

    private Integer count;

    private BigDecimal sum;

    private BigDecimal avg;

    private BigDecimal min;

    private BigDecimal max;


}
