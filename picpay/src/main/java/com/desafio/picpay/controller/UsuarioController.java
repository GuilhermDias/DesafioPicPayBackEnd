package com.desafio.picpay.controller;

import com.desafio.picpay.domain.usuario.Usuario;
import com.desafio.picpay.domain.usuario.UsuarioDTO;
import com.desafio.picpay.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criaUsuario(@RequestBody @Validated UsuarioDTO usuario){
        Usuario newUsuario = usuarioService.criaUsuario(usuario);
        return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> mostraTodosUsusarios(){
        List<Usuario> usuarios = this.usuarioService.exibeTodosUsuario();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
