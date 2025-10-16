package org.example.entregable3.service.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante_CarreraResponseDTO {
    private int anioInscripcion;
    private int antiguedad;
    private int anioGraduacion;
    private EstudianteResponseDTO estudiante;
    private CarreraResponseDTO carrera;
}
