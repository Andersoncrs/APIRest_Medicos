package com.hospital.apihospital.Medico;

import com.hospital.apihospital.Direccion.Direccion;
import com.hospital.apihospital.Genero.Genero;

public record ListarMedico(
        String nombre,
        String email,
        Genero genero,
        Especialidad especialidad,
        Direccion direccion
){
    public ListarMedico(Medico medico) {
        this(
                medico.getNombre(),
                medico.getEmail(),
                medico.getGenero(),
                medico.getEspecialidad(),
                medico.getDireccion()
                );
    }
}
