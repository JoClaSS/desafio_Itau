package com.desafio.itau.service;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafio.itau.dto.Transacao;

@Service
public class transacaoService {

     public ResponseEntity<String> isValidTransacao(Transacao transacao) {

        if(transacao == null) {
            return ResponseEntity.unprocessableEntity().body("A transação não pode ser nula");
        }
         if(transacao.valor() == null ) {
             return ResponseEntity.unprocessableEntity().body("O valor, não pode ser nulo");
         }
         if(transacao.valor().compareTo(BigDecimal.ZERO) <= 0) {
             return ResponseEntity.unprocessableEntity().body("O valor, não pode ser nulo ou igual a zero");
         }  
         if(transacao.dataHora().isAfter(java.time.OffsetDateTime.now(transacao.dataHora().getOffset()))) {
             return ResponseEntity.unprocessableEntity().body("A data e hora não pode ser futura");
         }
         else{
         } return ResponseEntity.ok("Transação válida");

    }
}
