package org.example.entregable3.controller;

import org.example.entregable3.entities.Estudiante;
import org.example.entregable3.service.DTO.Request.EstudianteRequestDTO;
import org.example.entregable3.service.DTO.Response.EstudianteResponseDTO;
import org.example.entregable3.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/estudiantes")
@RestController
public class EstudianteController {
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    // POST: Insertar nuevo estudiante
    @PostMapping
    public ResponseEntity<?> insertarEstudiante(@RequestBody EstudianteRequestDTO estudianteDTO) {
        try {
//            // Validar que los campos requeridos no sean null
//            if (estudianteDTO.getDNI() == null || estudianteDTO.getLU() == null ||
//                estudianteDTO.getEdad() == null) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Error: DNI, LU y edad son campos obligatorios");
//            }

            Estudiante estudiante = new Estudiante(
                    estudianteDTO.getDNI(),
                    estudianteDTO.getNombre(),
                    estudianteDTO.getApellido(),
                    estudianteDTO.getEdad(),
                    estudianteDTO.getGenero(),
                    estudianteDTO.getCiudad(),
                    estudianteDTO.getLU(),
                    null
            );
            estudianteService.insertarEstudiante(estudiante);
            return ResponseEntity.status(HttpStatus.CREATED).body("Estudiante creado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear estudiante: " + e.getMessage());
        }
    }

    // GET: Buscar estudiantes con filtros opcionales (ordenados por apellido)
    @GetMapping
    public ResponseEntity<List<EstudianteResponseDTO>> search(
            @RequestParam(required = false) Integer dni,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) Integer edad,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String ciudad,
            @RequestParam(required = false) Integer LU) {
        List<EstudianteResponseDTO> estudiantes = estudianteService.search(dni, nombre, apellido, edad, genero, ciudad, LU);
        return ResponseEntity.ok(estudiantes);
    }

    // GET: Obtener estudiante por número de libreta universitaria
    @GetMapping("/{LU}")
    public ResponseEntity<?> getEstudianteByLibreta(@PathVariable int LU) {
        try {
            EstudianteResponseDTO estudiante = estudianteService.getEstudianteByLibreta(LU);
            return ResponseEntity.ok(estudiante);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
    }

    // GET: Obtener estudiantes filtrados por género
    @GetMapping("/{genero}")
    public ResponseEntity<?> getEstudiantesByGenero(@PathVariable String genero) {
        try {
            List<EstudianteResponseDTO> estudiantes = estudianteService.getEstudianteByGenero(genero);
            return ResponseEntity.ok(estudiantes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    // GET: Obtener estudiantes por carrera y ciudad
    @GetMapping("/carrera/{idCarrera}/ciudad/{ciudad}")
    public ResponseEntity<List<EstudianteResponseDTO>> getEstudiantesByCarreraYCiudad(
            @PathVariable int idCarrera,
            @PathVariable String ciudad) {
        List<EstudianteResponseDTO> estudiantes = estudianteService.getEstudiantesByCarreraYCiudad(idCarrera, ciudad);
        return ResponseEntity.ok(estudiantes);
    }
}
