package com.myapi.example.service;

import com.myapi.example.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCEPClient {

    private final RestTemplate restTemplate;

    public Endereco getCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return restTemplate.getForObject(url, Endereco.class);
    }

    public ViaCEPClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
