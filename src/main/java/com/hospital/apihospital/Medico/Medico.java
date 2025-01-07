package com.hospital.apihospital.Medico;

import com.hospital.apihospital.Direccion.Direccion;
import com.hospital.apihospital.Genero.Genero;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String nombre;
    private String email;
    private String telefono;
    private int edad;

    @Enumerated(value = EnumType.STRING)
    private Genero genero;

    @Setter
    @Enumerated(value = EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    @Setter
    private Direccion direccion;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.telefono = datosRegistroMedico.telefono();
        this.edad = Integer.parseInt(datosRegistroMedico.edad());
        this.genero = Genero.ofString(datosRegistroMedico.genero());
        this.especialidad = Especialidad.ofString(datosRegistroMedico.especialidad());
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }
}
