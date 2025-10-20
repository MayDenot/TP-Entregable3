package org.example.entregable3.repository;

import org.example.entregable3.entities.Estudiante;
import org.example.entregable3.service.DTO.Response.EstudianteResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    @Query("""
    SELECT e
    FROM Estudiante e
    WHERE (:dni IS NULL OR e.DNI = :dni)
      AND (:nombre IS NULL OR e.nombre LIKE CONCAT('%', :nombre, '%'))
      AND (:apellido IS NULL OR e.apellido LIKE CONCAT('%', :apellido, '%'))
      AND (:edad IS NULL OR e.edad = :edad)
      AND (:genero IS NULL OR e.genero = :genero)
      AND (:ciudad IS NULL OR e.ciudad LIKE CONCAT('%', :ciudad, '%'))
      AND (:LU IS NULL OR e.LU = :LU)
    ORDER BY e.apellido ASC
""")
    //en caso de no filtrar por nada ordena por apellido por default
    List<Estudiante> search(Integer dni, String nombre, String apellido, Integer edad, String genero, String ciudad, Integer LU);

    @Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
    List<Estudiante> getEstudiantesByGenero(String genero);

    @Query("SELECT e FROM Estudiante e WHERE e.LU = :lu")
    Optional<Estudiante> getEstudianteByLU(int lu);

    @Query("SELECT ec.estudiante FROM Estudiante_Carrera ec WHERE ec.carrera.idCarrera = :idCarrera AND ec.estudiante.ciudad = :ciudad")
    List<Estudiante> getEstudiantesByCarreraYCiudad(int idCarrera, String ciudad);
}
