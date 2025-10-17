package org.example.entregable3.service;

import lombok.AllArgsConstructor;
import org.example.entregable3.entities.Estudiante_Carrera;
import org.example.entregable3.repository.EstudianteCarreraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class EstudianteCarreraService {
    private final EstudianteCarreraRepository estudianteCarreraRepository;

    @Transactional
    public void insertarEstudianteCarrera(Estudiante_Carrera ec) {
        //No estamos seguros si se hace la corroboracion de la carrera que existe.(creo)
        estudianteCarreraRepository.save(ec);
    }
}
