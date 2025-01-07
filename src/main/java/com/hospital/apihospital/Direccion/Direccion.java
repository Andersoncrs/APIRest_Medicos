package com.hospital.apihospital.Direccion;

import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion {
    private String ciudad;
    private int calle;
    private int carrera;
    private String complemento;
    private String letraComplemeneto;
}
