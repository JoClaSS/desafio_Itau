package com.desafio.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class transacaoController {


    public ResponseEntity<String> deleteAllTransacao() {
        // Lógica para deletar a transação
        return ResponseEntity.ok("Transações deletadas com sucesso");
    }
}
