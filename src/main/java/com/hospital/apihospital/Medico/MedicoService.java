package com.hospital.apihospital.Medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    private PagedResourcesAssembler<ListarMedico> pagedResourcesAssembler;

    public ResponseEntity<String> registrarMedico(DatosRegistroMedico datosRegistroMedico){
        Medico medico = new Medico(datosRegistroMedico);
        medicoRepository.save(medico);
        return  ResponseEntity.status(200).body("Registro creado con Exito");
    }

    public PagedModel<EntityModel<ListarMedico>> ListarMedico(Pageable pageable){
        Pageable pageableConf = PageRequest.of(pageable.getPageNumber(), 2, Sort.by("nombre").ascending());
        Page<ListarMedico> listarMedicoPage =  medicoRepository.findAll(pageableConf).map(ListarMedico::new);
        return pagedResourcesAssembler.toModel(listarMedicoPage);
    }
}
