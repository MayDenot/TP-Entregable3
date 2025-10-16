package org.example.entregable3.repository;

import org.example.entregable3.service.DTO.Request.CarreraRequestDTO;
import org.example.entregable3.service.DTO.Response.CarreraResponseDTO;
import org.example.entregable3.service.DTO.Response.ReporteResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<CarreraRequestDTO, Integer> {
    //void insertar(CarreraRequestDTO carrera);
    @Query("SELECT new org.example.entregable3.service.DTO.Request.CarreraRequestDTO(c.carrera, COUNT(ec.estudiante)) " +
            "FROM Estudiante_Carrera ec " +
            "JOIN ec.carrera c " +
            "GROUP BY c.carrera " +
            "ORDER BY COUNT(ec.estudiante) DESC")
    List<CarreraResponseDTO> getCarrerasXCantidadInscriptos();
    // CarreraResponseDTO getCarreraById(int id) devuelve un optional, usar el orElseGet o algo asi
    @Query("SELECT new org.example.entregable3.service.DTO.Response.ReporteResponseDTO(" +
            "c.carrera, " +
            "COUNT(ec), " +
            "SUM(CASE WHEN ec.anioGraduacion > 0 THEN 1 ELSE 0 END), " +
            "ec.anioInscripcion" +
            ") " +
            "FROM Estudiante_Carrera ec JOIN ec.carrera c " +
            "GROUP BY c.carrera, ec.anioInscripcion " +
            "ORDER BY c.carrera ASC, ec.anioInscripcion ASC")
    List<ReporteResponseDTO> getReporte();
}
