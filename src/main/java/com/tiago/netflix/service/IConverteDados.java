package com.tiago.netflix.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T>classe);
}
