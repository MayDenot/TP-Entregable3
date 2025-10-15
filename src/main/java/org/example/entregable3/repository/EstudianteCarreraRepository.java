package org.example.entregable3.repository;

import org.example.entregable3.entities.Estudiante_Carrera;
import org.example.entregable3.entities.Estudiante_Carrera_PK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteCarreraRepository extends JpaRepository<Estudiante_Carrera, Estudiante_Carrera_PK> {
  // insertEstudianteACarrera(Estudiante_Carrera ec)
}
