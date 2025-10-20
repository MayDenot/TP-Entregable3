package org.example.entregable3.service.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante_CarreraRequestDTO {
    private Integer anioInscripcion;

    private Integer antiguedad;

    private Integer anioGraduacion;

    private EstudianteRequestDTO estudiante;

    private CarreraRequestDTO carrera;
}
