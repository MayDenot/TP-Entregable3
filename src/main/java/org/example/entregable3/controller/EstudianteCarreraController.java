package org.example.entregable3.controller;

import lombok.AllArgsConstructor;
import org.example.entregable3.entities.Carrera;
import org.example.entregable3.entities.Estudiante;
import org.example.entregable3.entities.Estudiante_Carrera;
import org.example.entregable3.entities.Estudiante_Carrera_PK;
import org.example.entregable3.repository.CarreraRepository;
import org.example.entregable3.repository.EstudianteRepository;
import org.example.entregable3.service.DTO.Request.Estudiante_CarreraRequestDTO;
import org.example.entregable3.service.EstudianteCarreraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/estudianteCarrera")
@RestController
@AllArgsConstructor
public class EstudianteCarreraController {
    private final EstudianteCarreraService estudianteCarreraService;
    private final EstudianteRepository estudianteRepository;
    private final CarreraRepository carreraRepository;

    // POST: Matricular estudiante en una carrera
    @PostMapping
    public ResponseEntity<?> insertarEstudianteCarrera(@RequestBody Estudiante_CarreraRequestDTO dto) {
        try {
            // Buscar el estudiante existente por DNI
            Estudiante estudiante = estudianteRepository.findById(dto.getEstudiante().getDNI())
                    .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con DNI: " + dto.getEstudiante().getDNI()));

            // Buscar la carrera existente por ID
            Carrera carrera = carreraRepository.findById(dto.getCarrera().getId())
                    .orElseThrow(() -> new RuntimeException("Carrera no encontrada con ID: " + dto.getCarrera().getId()));

            // Crear la clave primaria compuesta
            Estudiante_Carrera_PK pk = new Estudiante_Carrera_PK(estudiante.getDNI(), carrera.getIdCarrera());

            // Crear la relación Estudiante_Carrera
            Estudiante_Carrera estudianteCarrera = new Estudiante_Carrera(
                    pk,
                    dto.getAnioInscripcion(),
                    dto.getAntiguedad(),
                    dto.getAnioGraduacion(),
                    estudiante,
                    carrera
            );

            // Guardar la matriculación
            estudianteCarreraService.insertarEstudianteCarrera(estudianteCarrera);

            return ResponseEntity.status(HttpStatus.CREATED).body("Estudiante matriculado exitosamente en la carrera");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al matricular estudiante: " + e.getMessage());
        }
    }
}
