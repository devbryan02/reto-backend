package com.reto.bff.dto;

import lombok.Data;

@Data
public class ProductoFinancieroDto {

    private String tipoDocumento;
    private String nombre;
    private Double saldo;

}
