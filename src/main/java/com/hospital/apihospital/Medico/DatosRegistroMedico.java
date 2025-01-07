package com.hospital.apihospital.Medico;

import com.hospital.apihospital.Direccion.DatosDireccion;

public record DatosRegistroMedico(
        String nombre,
        String email,
        String telefono,
        int edad,
        String genero,
        String especialidad,
        DatosDireccion direccion
) {
}
