package com.hospital.apihospital.Direccion;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class Direccion {
    private String ciudad;
    private int calle;
    private int carrera;
    private Integer complemento;
    private String letraComplemento;


    public Direccion(DatosDireccion datosDireccion) {
        this.ciudad =  datosDireccion.ciudad();
        this.calle = Integer.parseInt(datosDireccion.calle());
        this.carrera = Integer.parseInt(datosDireccion.carrera());
        this.complemento = (datosDireccion.complemento() != null) ? Integer.parseInt(datosDireccion.complemento()) : null;
        this.letraComplemento = datosDireccion.letraComplemento();
    }
}
