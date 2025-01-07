package com.hospital.apihospital.Medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public ResponseEntity<String> registrarMedico(DatosRegistroMedico datosRegistroMedico){
        Medico medico = new Medico(datosRegistroMedico);
        medicoRepository.save(medico);
        return  ResponseEntity.status(200).body("Registro creado con Exito");
    }
}
