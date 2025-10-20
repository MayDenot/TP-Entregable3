package org.example.entregable3.service.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class EstudianteRequestDTO {

    @NotNull(message = "El DNI es obligatorio")
    @Positive(message = "El DNI debe ser un número positivo")
    private Integer DNI;

    @NotNull(message = "El nombre es obligatorio")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotNull(message = "El apellido es obligatorio")
    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;

    @NotNull(message = "La edad es obligatoria")
    @Positive(message = "La edad debe ser un número positivo")
    @Min(value = 1, message = "La edad debe ser al menos 1")
    @Max(value = 120, message = "La edad debe ser menor a 120")
    private Integer edad;

    @NotNull(message = "El género es obligatorio")
    @NotBlank(message = "El género no puede estar vacío")
    @Pattern(regexp = "^[MF]$", message = "El género debe ser 'M' o 'F'")
    private String genero;

    @NotNull(message = "La ciudad es obligatoria")
    @NotBlank(message = "La ciudad no puede estar vacía")
    private String ciudad;

    @NotNull(message = "El LU (Libreta Universitaria) es obligatorio")
    @Positive(message = "El LU debe ser un número positivo")
    private Integer LU;

    //private List<Estudiante_CarreraRequestDTO> inscripciones;
}
