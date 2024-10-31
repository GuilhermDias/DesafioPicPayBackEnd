package com.desafio.picpay.controller;

import com.desafio.picpay.domain.transacao.Transacao;
import com.desafio.picpay.domain.transacao.TransacaoDTO;
import com.desafio.picpay.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Transacao> criaTransacao(@RequestBody @Validated TransacaoDTO transacao) throws Exception {
        Transacao newTransacao = this.transacaoService.criaTransacao(transacao);
        return new ResponseEntity<>(newTransacao, HttpStatus.OK);
    }
}
