package com.desafio.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record Transacao(BigDecimal valor, OffsetDateTime dataHora) {

}
