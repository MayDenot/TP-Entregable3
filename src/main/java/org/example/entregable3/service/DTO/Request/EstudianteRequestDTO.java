package org.example.entregable3.service.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteRequestDTO {
    private Integer DNI;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String genero;
    private String ciudad;
    private Integer LU;
    //private List<Estudiante_CarreraRequestDTO> inscripciones;
}
