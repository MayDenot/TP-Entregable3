package org.example.entregable3.service.DTO.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entregable3.service.DTO.Request.Estudiante_CarreraRequestDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraResponseDTO {
    @NotBlank(message = "Una carrera no puede ser nula")
    private int idCarrera;
    private String carrera;
    private int duracion;
    private List<Estudiante_CarreraResponseDTO> inscriptos;
}
