package com.ecommit.orquestrador.rest.api;

import com.ecommit.orquestrador.rest.constants.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CotacaoDolarRequestHandler {
    private final RestTemplate restTemplate;

    public CotacaoDolarRequestHandler(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> getUSDBRL(){
        return restTemplate.getForEntity(URI.GET_COTACAO_USDBRL, String.class);
    }

    public ResponseEntity<String> getUSDEUR(){
        return restTemplate.getForEntity(URI.GET_COTACAO_USDEUR, String.class);
    }
}
