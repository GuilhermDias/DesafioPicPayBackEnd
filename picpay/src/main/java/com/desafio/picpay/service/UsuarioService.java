package com.desafio.picpay.service;

import com.desafio.picpay.domain.usuario.TipoUsuario;
import com.desafio.picpay.domain.usuario.Usuario;
import com.desafio.picpay.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validaTransacao(Usuario remetente, BigDecimal valor) throws Exception {
        if(remetente.getTipoUsuario() == TipoUsuario.LOGISTAS) throw new Exception("Função não disponivel para este usuario");
        if(remetente.getSaldo().compareTo(valor) < 0) throw new Exception("Saldo insuficiente na conta");
    }

    public Usuario findUsuarioById(Long id) throws Exception {
        return this.usuarioRepository.findUsuarioById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public void salvaUsuario(Usuario usuario){
        this.usuarioRepository.save(usuario);
    }

}
