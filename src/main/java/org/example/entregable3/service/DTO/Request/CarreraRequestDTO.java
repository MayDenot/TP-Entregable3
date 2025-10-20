package org.example.entregable3.service.DTO.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraRequestDTO {
    @NotNull(message = "El ID de la carrera no puede ser nulo")
    @Positive(message = "El ID debe ser un número positivo")
    private Integer id;
    private String carrera;
    private Integer duracion;
    //private List<Estudiante_CarreraRequestDTO> estudiantes;


}
