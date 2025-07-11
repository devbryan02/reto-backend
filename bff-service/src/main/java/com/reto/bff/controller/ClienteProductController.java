package com.reto.bff.controller;

import com.reto.bff.dto.ClienteResponseDto;
import com.reto.bff.service.ClienteProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ClienteProductController {

    private final ClienteProductoService clienteProductoService;

    @GetMapping("/clientes/{codigoUnico}")
    public Mono<ClienteResponseDto> getFullInfo(@PathVariable("codigoUnico") String codigoUnico) {
        return clienteProductoService.getInfoClientAndProducts(codigoUnico);
    }

}
