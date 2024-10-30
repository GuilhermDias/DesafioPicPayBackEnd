package com.desafio.picpay.controller;

import com.desafio.picpay.domain.usuario.Usuario;
import com.desafio.picpay.domain.usuario.UsuarioDTO;
import com.desafio.picpay.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criaUsuario(UsuarioDTO usuario){
        Usuario newUsuario = usuarioService.criaUsuario(usuario);
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> mostraTodosUsusarios(){
        List<Usuario> usuarios = this.usuarioService.exibeTodosUsuario();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
