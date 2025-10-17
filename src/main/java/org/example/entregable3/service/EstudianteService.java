package org.example.entregable3.service;

import lombok.AllArgsConstructor;
import org.example.entregable3.entities.Carrera;
import org.example.entregable3.entities.Estudiante;
import org.example.entregable3.repository.EstudianteRepository;
import org.example.entregable3.service.DTO.Response.CarreraResponseDTO;
import org.example.entregable3.service.DTO.Response.EstudianteResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EstudianteService {
    private final  EstudianteRepository estudianteRepository;

    @Transactional
    public void insertarEstudiante(Estudiante estudiante) throws Exception{
        try{
            estudianteRepository.save(estudiante);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional(readOnly = true)
    public List<EstudianteResponseDTO> getEstudianteByGenero(String genero) throws Exception {
        List<Estudiante> estudiantes = estudianteRepository.getEstudiantesByGenero(genero);
        try{
            return estudiantes.stream()
                    .map(e -> new EstudianteResponseDTO( e.getDNI(), e.getNombre(), e.getApellido(), e.getEdad(), e.getGenero(), e.getCiudad(), e.getLU()))
                    .toList();
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional(readOnly = true)
    public EstudianteResponseDTO getEstudianteByLibreta(int LU) throws Exception{
        try{
            return estudianteRepository.getEstudianteByLU(LU)
                    .map(e -> new EstudianteResponseDTO(
                            e.getDNI(),
                            e.getNombre(),
                            e.getApellido(),
                            e.getEdad(),
                            e.getGenero(),
                            e.getCiudad(),
                            e.getLU()
                    ))
                    .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con LU: " + LU));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Transactional(readOnly = true)
    public List<EstudianteResponseDTO> getEstudiantesByCarreraYCiudad(int idCarrera, String ciudad){
        List<Estudiante> estudiantes = estudianteRepository.getEstudiantesByCarreraYCiudad(idCarrera, ciudad);
        return estudiantes.stream()
                .map(e -> new EstudianteResponseDTO(
                        e.getDNI(),
                        e.getNombre(),
                        e.getApellido(),
                        e.getEdad(),
                        e.getGenero(),
                        e.getCiudad(),
                        e.getLU()
                ))
                .toList();
    }
    @Transactional(readOnly = true)
    public List<EstudianteResponseDTO> search(Integer dni, String nombre, String apellido, Integer edad, String genero, String ciudad, Integer LU){
        List<Estudiante> estudiantes = estudianteRepository.search(dni, nombre, apellido, edad, genero, ciudad, LU);
        return estudiantes.stream()
                .map(e -> new EstudianteResponseDTO(
                        e.getDNI(),
                        e.getNombre(),
                        e.getApellido(),
                        e.getEdad(),
                        e.getGenero(),
                        e.getCiudad(),
                        e.getLU()
                ))
                .toList();
    }
}
