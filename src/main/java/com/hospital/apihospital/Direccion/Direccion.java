package com.hospital.apihospital.Direccion;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
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
