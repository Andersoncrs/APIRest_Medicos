package com.hospital.apihospital.Direccion;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DatosDireccion(

        @NotBlank
        String ciudad,

        @NotBlank
        @Positive
        String calle,

        @NotBlank
        @Positive
        String carrera,

        @Positive
        String complemento,

        @Pattern(regexp = "^[a-z]$", flags = Pattern.Flag.CASE_INSENSITIVE)
        String letraComplemento
) {
}
