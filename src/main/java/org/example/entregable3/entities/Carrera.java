package org.example.entregable3.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Carrera {
  @Id
  private int idCarrera;
  @Column
  private String carrera;
  @Column
  private int duracion;
  @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
  private List<Estudiante_Carrera> inscripciones;
}
