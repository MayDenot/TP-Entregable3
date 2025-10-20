package org.example.entregable3.service.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteRequestDTO {
    @JsonProperty("DNI")
    private Integer DNI;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("edad")
    private Integer edad;

    @JsonProperty("genero")
    private String genero;

    @JsonProperty("ciudad")
    private String ciudad;

    @JsonProperty("LU")
    private Integer LU;
    //private List<Estudiante_CarreraRequestDTO> inscripciones;
}
