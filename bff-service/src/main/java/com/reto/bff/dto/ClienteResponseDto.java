package com.reto.bff.dto;

import lombok.Data;
import java.util.List;

@Data
public class ClienteResponseDto {

    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String numeroDocumento;
    private List<ProductoFinancieroDto> productos;

}
