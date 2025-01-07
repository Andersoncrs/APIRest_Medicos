package com.hospital.apihospital.controller;

import com.hospital.apihospital.Medico.DatosRegistroMedico;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {

    @GetMapping
    public void listarMedicos(){
    }

    @PostMapping
    public void registrarMedico(@Valid @RequestBody DatosRegistroMedico datosRegistroMedico){
        System.out.println(datosRegistroMedico);
    }

    @PatchMapping
    public void actalizarMedico(){
    }

    @DeleteMapping
    public void eliminarMedico(){
    }



}
