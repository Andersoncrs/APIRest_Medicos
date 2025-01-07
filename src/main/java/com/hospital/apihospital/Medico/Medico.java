package com.hospital.apihospital.Medico;

import com.hospital.apihospital.Direccion.Direccion;
import com.hospital.apihospital.Genero.Genero;
import jakarta.persistence.*;

@Entity
@Table(name = "medicos")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String telefono;
    private int edad;
    Genero genero;
    Especialidad especialidad;
    @Embedded
    Direccion direccion;


}
