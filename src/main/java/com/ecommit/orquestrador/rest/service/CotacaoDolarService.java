package com.ecommit.orquestrador.rest.service;

import com.ecommit.orquestrador.rest.CotacaoDolarRequestHandler;
import com.ecommit.orquestrador.rest.entity.CotacaoDolarEntity;
import com.ecommit.orquestrador.rest.repository.CotacaoDolarRepository;
import com.ecommit.orquestrador.rest.utils.JsonResponseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CotacaoDolarService {

    private final CotacaoDolarRequestHandler cotacaoDolarRequestHandler;

    private final CotacaoDolarRepository cotacaoDolarRepository;

    public CotacaoDolarService(CotacaoDolarRequestHandler cotacaoDolarRequestHandler, CotacaoDolarRepository cotacaoDolarRepository) {
        this.cotacaoDolarRequestHandler = cotacaoDolarRequestHandler;
        this.cotacaoDolarRepository = cotacaoDolarRepository;
    }

    public String getCurrentPrice(String coinKey) throws JsonProcessingException {
        return fetchApiResponseCurrentCoinPrice(coinKey);
    }

    public void saveCurrentPrice(Long jobId, String price, String quotation){
        CotacaoDolarEntity entity = new CotacaoDolarEntity(jobId, price, quotation);
        cotacaoDolarRepository.save(entity);
    }

    private String fetchApiResponseCurrentCoinPrice(String coinKey) throws JsonProcessingException {
        ResponseEntity<String> response;
        switch (coinKey){
            case "USDBRL":
                response = cotacaoDolarRequestHandler.getUSDBRL();
                break;
            case "USDEUR":
                response = cotacaoDolarRequestHandler.getUSDEUR();
                break;
            default:
                throw new RuntimeException("Cotacao não mapeada");
        }
        final Map<?, ?> coinMap = JsonResponseUtils.toMap(response, coinKey);
        String currentPrice = "null";

        if (coinMap != null) {
            currentPrice = (String) coinMap.get("bid");
        }
        return currentPrice;
    }
}
