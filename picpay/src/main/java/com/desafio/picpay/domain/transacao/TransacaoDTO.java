package com.desafio.picpay.domain.transacao;

import com.desafio.picpay.domain.usuario.Usuario;

import java.math.BigDecimal;

public record TransacaoDTO(Long remetenteId, Long receptorId, BigDecimal valor) {
}
