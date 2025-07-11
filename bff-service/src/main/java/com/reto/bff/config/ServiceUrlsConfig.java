package com.reto.bff.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "services")
public class ServiceUrlsConfig {

    private Cliente client;
    private Producto product;

    @Data
    public static class Cliente{
        private String name;
        private String baseUrl;
    }

    @Data
    public static class Producto{
        private String name;
        private String baseUrl;
    }

}
