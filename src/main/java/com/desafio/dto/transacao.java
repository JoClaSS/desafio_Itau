package com.desafio.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record transacao(BigDecimal valor, OffsetDateTime dataHora) {

}
