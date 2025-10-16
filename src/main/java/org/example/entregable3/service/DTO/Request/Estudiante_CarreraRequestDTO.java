package org.example.entregable3.service.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante_CarreraRequestDTO {
    private int anioInscripcion;
    private int antiguedad;
    private int anioGraduacion;
    private EstudianteRequestDTO estudiante;
    private CarreraRequestDTO carrera;
}
