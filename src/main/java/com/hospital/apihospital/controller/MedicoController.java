package com.hospital.apihospital.controller;

import com.hospital.apihospital.Medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoController {


    @Autowired
    MedicoService service;

    @GetMapping
    public PagedModel<EntityModel<ListarMedico>> listarMedicos(Pageable pageable){
        return service.ListarMedico(pageable);
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
