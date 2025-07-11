package com.reto.bff.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    private final ServiceUrlsConfig serviceUrlsConfig;

    @Bean(name = "clienteWebClient")
    public WebClient clienteWebClient() {
        return WebClient.builder()
                .baseUrl(serviceUrlsConfig.getClient().getBaseUrl())
                .build();
    }

    @Bean(name = "productoWebClient")
    public WebClient productoWebClient() {
        return WebClient.builder()
                .baseUrl(serviceUrlsConfig.getProduct().getBaseUrl())
                .build();
    }

}
