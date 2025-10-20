package org.example.entregable3.service.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante_CarreraRequestDTO {
    @JsonProperty("anioInscripcion")
    private Integer anioInscripcion;

    @JsonProperty("antiguedad")
    private Integer antiguedad;

    @JsonProperty("anioGraduacion")
    private Integer anioGraduacion;

    @JsonProperty("estudiante")
    private EstudianteRequestDTO estudiante;

    @JsonProperty("carrera")
    private CarreraRequestDTO carrera;
}
