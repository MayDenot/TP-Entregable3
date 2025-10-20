package org.example.entregable3.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.entregable3.entities.Carrera;
import org.example.entregable3.service.CarreraService;
import org.example.entregable3.service.DTO.Request.CarreraRequestDTO;
import org.example.entregable3.service.DTO.Response.CarreraResponseDTO;
import org.example.entregable3.service.DTO.Response.ReporteResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/carreras")
@RestController
@RequiredArgsConstructor  // Cambia AllArgsConstructor por este
public class CarreraController {

    private final CarreraService carreraService;

    // POST - Crear carrera
    @PostMapping
    public ResponseEntity<String> insertar(@Valid @RequestBody Carrera carrera) {
        carreraService.insertarCarrera(carrera);
        return ResponseEntity.status(HttpStatus.CREATED).body("Carrera creada exitosamente");
    }

    // GET - Obtener reportes
    @GetMapping("/reportes")
    public ResponseEntity<List<ReporteResponseDTO>> getReportes() {
        return ResponseEntity.ok(carreraService.getReporte());
    }

    // GET - Obtener carrera por ID
    @GetMapping("/{id}")
    public ResponseEntity<CarreraResponseDTO> getCarreraById(
            @PathVariable @Positive(message = "El ID debe ser positivo") int id) {
        return ResponseEntity.ok(carreraService.getCarreraById(id));
    }

    // GET - Obtener carreras por cantidad de inscriptos
    @GetMapping("/inscriptos")
    public ResponseEntity<List<CarreraResponseDTO>> getCarrerasXCantidadInscriptos() {
        return ResponseEntity.ok(carreraService.getCarreraxCantidadInscriptos());
    }
}

