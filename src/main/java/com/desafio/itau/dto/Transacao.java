package com.desafio.itau.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record Transacao(
    @NotNull(message = "Valor não pode ser nulo")
    @DecimalMin(value = "0.01", inclusive = true, message = "Valor deve ser maior que zero")
    BigDecimal valor,
    
    @NotNull(message = "Data e hora não podem ser nulas")
    @PastOrPresent(message = "Data não pode ser no futuro")
    OffsetDateTime dataHora
) {}
