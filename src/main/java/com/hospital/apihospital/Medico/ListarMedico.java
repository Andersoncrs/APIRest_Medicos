package com.hospital.apihospital.Medico;

import com.hospital.apihospital.Direccion.Direccion;

public record ListarMedico(
        String nombre,
        String email,
        String genero,
        Especialidad especialidad,
        Direccion direccion
){
}
