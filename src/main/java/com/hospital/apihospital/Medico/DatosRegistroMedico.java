package com.hospital.apihospital.Medico;

import com.hospital.apihospital.Direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DatosRegistroMedico(
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z]{3,}\\s[a-zA-Z]{1,}$")
        String nombre,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "^\\d{10}$")
        String telefono,

        @NotBlank
        @Positive
        @Max(100)
        @Pattern(regexp = "^\\d+$")
        String edad,

        @NotBlank
        @Pattern(regexp = "Femenino|Masculino", flags = Pattern.Flag.CASE_INSENSITIVE)
        String genero,

        @NotBlank
        @Pattern(regexp = "Ortopedia|Pediatria|Cardiologia", flags = Pattern.Flag.CASE_INSENSITIVE)
        String especialidad,

        @NotNull
        @Valid
        DatosDireccion direccion
) {
}
