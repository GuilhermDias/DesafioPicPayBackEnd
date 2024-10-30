package com.desafio.picpay.domain.usuario;

import java.math.BigDecimal;

public record UsuarioDTO(String nome, String sobrenome, String documento, String email, String senha, BigDecimal saldo, TipoUsuario tipoUsuario) {
}
