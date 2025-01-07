package com.hospital.apihospital.Direccion;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class Direccion {
    private String ciudad;
    private int calle;
    private int carrera;
    private int complemento;
    private String letraComplemento;


    public Direccion(DatosDireccion datosDireccion) {
        this.ciudad =  datosDireccion.ciudad();
        this.calle = Integer.parseInt(datosDireccion.calle());
        this.carrera = Integer.parseInt(datosDireccion.carrera());
        this.complemento = Integer.parseInt(datosDireccion.complemento());
        this.letraComplemento = datosDireccion.letraComplemento();
    }
}
