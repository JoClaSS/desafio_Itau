package com.desafio.itau.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.itau.dto.*;
import com.desafio.itau.service.transacaoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    List<Transacao> transacaoList = new ArrayList<>();

    @DeleteMapping
    public ResponseEntity<String> deleteAllTransacao() {
        // Lógica para deletar a transação
        return ResponseEntity.ok("Transações deletadas com sucesso");
    }

    @PostMapping
    public ResponseEntity<String> CriarTransacao(@Valid @RequestBody Transacao transacao) {
        transacaoList.add(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Transação criada com sucesso");
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
