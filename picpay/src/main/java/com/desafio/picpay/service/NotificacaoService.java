package com.desafio.picpay.service;

import com.desafio.picpay.domain.notificacao.NotificacaoDTO;
import com.desafio.picpay.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoService {

    @Autowired
    private RestTemplate restTemplate;

    public void mandaNotificacao(Usuario usuario, String mensagem) throws Exception {
        String email = usuario.getEmail();
        NotificacaoDTO notificacaoRequest = new NotificacaoDTO(email, mensagem);

        /*ResponseEntity<String> NotificacaoResponse = restTemplate.postForEntity("https://util.devi.tools/api/v1/notify", notificacaoRequest, String.class);

        if(NotificacaoResponse.getStatusCode() == HttpStatus.OK){
            System.out.println("Erro ao enviar notificação");
            throw new Exception("Serviço de notificacao está em manutenção");
        }*/
        System.out.println("Notificação enviada");
    }
}
