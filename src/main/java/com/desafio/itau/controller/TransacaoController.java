package com.desafio.itau.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.desafio.itau.dto.*;

import java.util.List;
import java.util.ArrayList;


@Controller
public class TransacaoController {

    List<Transacao> transacaoList = new ArrayList<>();

    @DeleteMapping("/transacao")
    public ResponseEntity<String> deleteAllTransacao() {
        // Lógica para deletar a transação
        return ResponseEntity.ok("Transações deletadas com sucesso");
    }

    @PostMapping("/transacao")
    public ResponseEntity<String> CriarTransacao(@RequestBody Transacao transacao) {
        transacaoList.add(transacao);
        return ResponseEntity.ok("Transação criada com sucesso");
    }

    @GetMapping("/estatistica")
    public ResponseEntity<Estatistica> getEstatistica() {
        // Filtra as transações para manter apenas as que não são antigas
        transacaoList.removeIf(t -> t.dataHora().isBefore(
            java.time.Instant.now()
                .minusSeconds(60)
                .atOffset(t.dataHora().getOffset())
        ));

         Estatistica estatistica = new Estatistica(transacaoList);

        return ResponseEntity.ok(estatistica);
    }
}
