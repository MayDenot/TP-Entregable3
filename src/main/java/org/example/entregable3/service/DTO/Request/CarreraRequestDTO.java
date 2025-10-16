package org.example.entregable3.service.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraRequestDTO {
    private String carrera;
    private Long duracion;
    //private List<Estudiante_CarreraRequestDTO> estudiantes;


}
