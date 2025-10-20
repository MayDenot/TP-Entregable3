package org.example.entregable3.service.DTO.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@Getter
public class EstudianteResponseDTO {
    private int dni;

    private String nombre;

    private String apellido;

    private int edad;

    private String genero;

    private String ciudad;

    private int LU;
    //private List<Estudiante_CarreraResponseDTO> inscripciones;
}
