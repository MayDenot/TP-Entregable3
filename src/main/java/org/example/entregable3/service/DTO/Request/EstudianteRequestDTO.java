package org.example.entregable3.service.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteRequestDTO {
    private int DNI;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudad;
    private int LU;
    //private List<Estudiante_CarreraRequestDTO> inscripciones;
}
