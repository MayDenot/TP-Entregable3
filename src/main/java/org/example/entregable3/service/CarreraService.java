package org.example.entregable3.service;

import org.example.entregable3.entities.Carrera;
import org.example.entregable3.repository.CarreraRepository;
import org.example.entregable3.service.DTO.Request.CarreraRequestDTO;
import org.springframework.stereotype.Service;
@Service
public class CarreraService {
    private CarreraRepository carreraRepository;

    public void insertarCarrera(CarreraRequestDTO carrera){
        carreraRepository.save(carrera);
    }
}
