package com.hospital.apihospital.Medico;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hospital.apihospital.Direccion.Direccion;
import com.hospital.apihospital.Genero.Genero;


public record ListarMedico(
        Long id,
        String nombre,
        String email,
        Genero genero,
        Especialidad especialidad,
        Direccion direccion
){
    public ListarMedico(Medico medico) {
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getGenero(),
                medico.getEspecialidad(),
                medico.getDireccion()
                );
    }
}
