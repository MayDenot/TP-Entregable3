package org.example.entregable3.repository;

import org.example.entregable3.entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
  // insertar(Estudiante estudiante)
  // List<Estudiante> getEstudiantesOrderedByApellido()
  // Estudiante getEstudianteByLibreta(int libreta)
  // List<Estudiante> getEstudiantesByGenero(String genero)
  // List<Estudiante> getEstudiantesByCarreraYCiudad(int id_carrera, String ciudad)
}
