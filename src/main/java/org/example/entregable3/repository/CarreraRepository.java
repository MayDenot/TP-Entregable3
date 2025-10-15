package org.example.entregable3.repository;

import org.example.entregable3.entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
  // insertar(Carrera carrera)
  // List<CarreraDTO> getCarrerasXCantidadInscriptos()
  // Carrera getCarreraById(int id) devuelve un optional, usar el orElseGet o algo asi
  // List<ReporteDTO> getReporte()
}
