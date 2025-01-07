package com.hospital.apihospital.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {

    @GetMapping
    public void listarMedicos(){
    }

    @PostMapping
    public void registrarMedico(){
    }

    @PatchMapping
    public void actalizarMedico(){
    }

    @DeleteMapping
    public void eliminarMedico(){
    }



}
