package org.example.entregable3.service;

import org.example.entregable3.entities.Estudiante;
import org.example.entregable3.service.DTO.Response.EstudianteResponseDTO;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.example.entregable3.entities.Carrera;
import org.example.entregable3.repository.CarreraRepository;
import org.example.entregable3.service.DTO.Request.CarreraRequestDTO;
import org.example.entregable3.service.DTO.Response.CarreraResponseDTO;
import org.example.entregable3.service.DTO.Response.ReporteResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarreraService {
    private final CarreraRepository carreraRepository;

    @Transactional
    public void insertarCarrera(Carrera carrera){
        carreraRepository.save(carrera);
    }
    @Transactional(readOnly = true)
    public List<ReporteResponseDTO> getReporte(){
        return carreraRepository.getReporte();
    }
    @Transactional(readOnly = true)
    public CarreraResponseDTO getCarreraById(int id){
        return carreraRepository.findById(id)
                .map(c -> new CarreraResponseDTO(
                        c.getCarrera(),
                        c.getDuracion()
                ))
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));
    }
    @Transactional(readOnly = true)
    public List<CarreraResponseDTO> getCarreraxCantidadInscriptos(){
        return carreraRepository.getCarrerasXCantidadInscriptos();
    }
}
