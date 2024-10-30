package com.desafio.picpay.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "usuarios")
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String documento;
    @Column(unique = true)
    private String email;
    private String senha;
    private BigDecimal saldo;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public Usuario(UsuarioDTO usuario) {
        this.nome = usuario.nome();
        this.sobrenome = usuario.sobrenome();
        this.documento = usuario.documento();
        this.email = usuario.email();
        this.senha = usuario.senha();
        this.saldo = usuario.saldo();
        this.tipoUsuario = usuario.tipoUsuario();
    }
}
