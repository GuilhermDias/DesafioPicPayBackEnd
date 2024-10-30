package com.desafio.picpay.service;

import com.desafio.picpay.domain.transacao.Transacao;
import com.desafio.picpay.domain.transacao.TransacaoDTO;
import com.desafio.picpay.domain.usuario.Usuario;
import com.desafio.picpay.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private UsuarioService usuarioService;

    private ApiAutorizacaoService apiAutorizacaoService;

    public void criaTransacao(TransacaoDTO transacao) throws Exception {
        Usuario remetente = this.usuarioService.findUsuarioById(transacao.remetenteId());
        Usuario receptor = this.usuarioService.findUsuarioById(transacao.receptorId());

        usuarioService.validaTransacao(remetente, transacao.valor());


        apiAutorizacaoService.HttpAutorizacao();

        Transacao newTransacao = new Transacao();
        newTransacao.setRemetente(remetente);
        newTransacao.setReceptor(receptor);
        newTransacao.setValor(transacao.valor());
        newTransacao.setDataHoraDaTransacao(LocalDateTime.now());

        remetente.setSaldo(remetente.getSaldo().subtract(transacao.valor()));
        receptor.setSaldo(receptor.getSaldo().add(transacao.valor()));

        this.transacaoRepository.save(newTransacao);
        this.usuarioService.salvaUsuario(remetente);
        this.usuarioService.salvaUsuario(receptor);
    }

}