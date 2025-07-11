package com.reto.bff.constants;

public class ApiPaths {

    public final static String GET_CLIENT_BY_CODIGO_UNICO = "/api/clientes/{codigoUnico}";
    public final static String GET_PRODUCTS_BY_CLIENT = "/api/productos/cliente/{codigoUnico}";

    private ApiPaths() {
    }

}
