package com.hospital.apihospital.controller;

import com.hospital.apihospital.Medico.DatosRegistroMedico;
import com.hospital.apihospital.Medico.Medico;
import com.hospital.apihospital.Medico.MedicoRepository;
import com.hospital.apihospital.Medico.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {


    @Autowired
    MedicoService service;

    @GetMapping
    public void listarMedicos(){
    }

    @PostMapping
    public ResponseEntity<String> registrarMedico(@Valid @RequestBody DatosRegistroMedico datosRegistroMedico){
        System.out.println(datosRegistroMedico);
        return service.registrarMedico(datosRegistroMedico);
    }

    @PatchMapping
    public void actalizarMedico(){
    }

    @DeleteMapping
    public void eliminarMedico(){
    }



}
