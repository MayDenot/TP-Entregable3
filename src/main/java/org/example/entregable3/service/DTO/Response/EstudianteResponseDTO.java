package org.example.entregable3.service.DTO.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteResponseDTO {
    @JsonProperty("DNI")
    private int DNI;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("edad")
    private int edad;

    @JsonProperty("genero")
    private String genero;

    @JsonProperty("ciudad")
    private String ciudad;

    @JsonProperty("LU")
    private int LU;
    //private List<Estudiante_CarreraResponseDTO> inscripciones;
}
