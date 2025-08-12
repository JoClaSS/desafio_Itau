package com.desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.ArrayList;

import com.desafio.dto.transacao;


@Controller
@RequestMapping("/transacoes")
public class transacaoController {

    @DeleteMapping
    public ResponseEntity<String> deleteAllTransacao() {
        // Lógica para deletar a transação
        return ResponseEntity.ok("Transações deletadas com sucesso");
    }

    @PostMapping
    public ResponseEntity<String> CriarTransacao(@RequestBody transacao transacao) {
        List<transacao> transacaoList = new ArrayList<>();
        transacaoList.add(transacao);
        return ResponseEntity.ok("Transação criada com sucesso");
    }
}
