package com.desafio.picpay.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiAutorizacaoService {

    private ObjectMapper objectMapper;

    public boolean HttpAutorizacao() throws IOException, InterruptedException {
        URI url = URI.create("https://util.devi.tools/api/v2/authorize");

        HttpRequest request = HttpRequest.newBuilder().uri(url).build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == HttpStatus.OK.value()){
            JsonNode jsonNode = objectMapper.readTree(response.body());
            return jsonNode.path("data").path("authorization").asBoolean();
        } else {
            throw new RuntimeException("Autenticacao não autorizada");
        }
    }
}
