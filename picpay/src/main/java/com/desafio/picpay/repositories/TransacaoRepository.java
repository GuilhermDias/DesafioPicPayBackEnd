package com.desafio.picpay.repositories;

import com.desafio.picpay.domain.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    Optional<Transacao> findByDataHoraDaTransacao(LocalDateTime localDateTime);
}
