package org.example.entregable3.service.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraRequestDTO {
    @NotBlank(message = "Una carrera no puede ser nula")
    private int id;
    private String carrera;
    private Long duracion;
    //private List<Estudiante_CarreraRequestDTO> estudiantes;


}
