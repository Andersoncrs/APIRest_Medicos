package com.hospital.apihospital.Medico;

import com.hospital.apihospital.Direccion.DatosActualizarDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosActualizarMedico(
        @NotNull
        Long id,

        @Pattern(regexp = "^[a-zA-Z]{3,}\\s[a-zA-Z]{1,}$")
        String nombre,

        @Pattern(regexp = "Ortopedia|Pediatria|Cardiologia", flags = Pattern.Flag.CASE_INSENSITIVE)
        String especialidad,

        @Valid
        DatosActualizarDireccion direccion
) {
}
