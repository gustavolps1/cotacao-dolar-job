package com.ecommit.orquestrador.rest.constants;

public final class URI {

    public static final String GET_COTACAO_USDBRL;

    public static final String GET_COTACAO_USDEUR;

    static {
                GET_COTACAO_USDBRL = "https://economia.awesomeapi.com.br/json/last/USD-BRL";
                GET_COTACAO_USDEUR = "https://economia.awesomeapi.com.br/json/last/USD-EUR";
    }
}
