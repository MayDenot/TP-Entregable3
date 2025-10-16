package org.example.entregable3.service.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteResponseDTO {
    private String carrera;
    private Long cantidadInscriptos, cantidadGradudados;
    private int anio;
}
