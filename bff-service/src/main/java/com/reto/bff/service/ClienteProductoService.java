package com.reto.bff.service;

import com.reto.bff.constants.ApiPaths;
import com.reto.bff.dto.ClienteResponseDto;
import com.reto.bff.dto.ProductoFinancieroDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ClienteProductoService {

    private final WebClient clienteWebClient;
    private final WebClient productoWebClient;

    public ClienteProductoService(
            @Qualifier("clienteWebClient") WebClient clienteWebClient,
            @Qualifier("productoWebClient") WebClient productoWebClient ) {
        this.clienteWebClient = clienteWebClient;
        this.productoWebClient = productoWebClient;
    }

    public Mono<ClienteResponseDto> getInfoClientAndProducts(String codigoUnico){

        Mono<ClienteResponseDto> clientMono = clienteWebClient.get()
                .uri(ApiPaths.GET_CLIENT_BY_CODIGO_UNICO, codigoUnico)
                .retrieve()
                .bodyToMono(ClienteResponseDto.class);

        Mono<List<ProductoFinancieroDto>> productsMono = productoWebClient.get()
                .uri(ApiPaths.GET_PRODUCTS_BY_CLIENT, codigoUnico)
                .retrieve()
                .bodyToFlux(ProductoFinancieroDto.class)
                .collectList();

        return Mono.zip(clientMono, productsMono)
                .map(tuple ->{
                    ClienteResponseDto cliente = tuple.getT1();
                    cliente.setProductos(tuple.getT2());
                    return cliente;
                });
    }
}
