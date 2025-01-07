package com.hospital.apihospital.Direccion;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record DatosActualizarDireccion(
        String ciudad,

        @Positive
        String calle,

        @Positive
        String carrera,

        @Positive
        String complemento,

        @Pattern(regexp = "^[a-z]$", flags = Pattern.Flag.CASE_INSENSITIVE)
        String letraComplemento
) {
}
