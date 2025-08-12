package com.desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/transacoes")
public class transacaoController {

    @DeleteMapping
    public ResponseEntity<String> deleteAllTransacao() {
        // Lógica para deletar a transação
        return ResponseEntity.ok("Transações deletadas com sucesso");
    }
}
