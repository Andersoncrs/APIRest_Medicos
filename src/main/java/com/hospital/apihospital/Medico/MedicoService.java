package com.hospital.apihospital.Medico;

import com.hospital.apihospital.Direccion.Direccion;
import jakarta.transaction.Transactional;
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

import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PagedResourcesAssembler<ListarMedico> pagedResourcesAssembler;

    public ResponseEntity<String> registrarMedico(DatosRegistroMedico datosRegistroMedico){
        Medico medico = new Medico(datosRegistroMedico);
        medicoRepository.save(medico);
        return  ResponseEntity.status(200).body("Registro creado con Exito");
    }

    public PagedModel<EntityModel<ListarMedico>> ListarMedico(Pageable pageable){
        Pageable pageableConf = PageRequest.of(pageable.getPageNumber(), 2, Sort.by("nombre").ascending());
        Page<ListarMedico> listarMedicoPage =  medicoRepository.listarMedicos(pageableConf).map(ListarMedico::new);
        return pagedResourcesAssembler.toModel(listarMedicoPage);
    }

    @Transactional
    public ResponseEntity<Object> ActualizarDatosMedico(DatosActualizarMedico datosActualizarMedico) {
        Optional<Medico> medicoOptional = medicoRepository.findById(datosActualizarMedico.id());
        if(medicoOptional.isPresent()){
            Medico medico = medicoOptional.get();
            if(datosActualizarMedico.nombre() != null){
                medico.setNombre(datosActualizarMedico.nombre());
            }
            if(datosActualizarMedico.especialidad() != null){
                medico.setEspecialidad(Especialidad.ofString(datosActualizarMedico.especialidad()));
            }
            if(datosActualizarMedico.direccion() != null){
                Direccion direccion = new Direccion();
                if(datosActualizarMedico.direccion().ciudad() != null){
                    direccion.setCiudad(datosActualizarMedico.direccion().ciudad());
                } else {direccion.setCiudad(medico.getDireccion().getCiudad());}
                if(datosActualizarMedico.direccion().calle() != null){
                    direccion.setCalle(Integer.parseInt(datosActualizarMedico.direccion().calle()));
                } else {direccion.setCalle(medico.getDireccion().getCalle());}
                if(datosActualizarMedico.direccion().carrera() != null){
                    direccion.setCarrera(Integer.parseInt(datosActualizarMedico.direccion().carrera()));
                } else{direccion.setCarrera(medico.getDireccion().getCarrera());}
                if(datosActualizarMedico.direccion().complemento() != null){
                    direccion.setComplemento(Integer.parseInt(datosActualizarMedico.direccion().complemento()));
                }else{direccion.setComplemento(medico.getDireccion().getComplemento());}
                if(datosActualizarMedico.direccion().letraComplemento() != null){
                    direccion.setLetraComplemento(datosActualizarMedico.direccion().letraComplemento());
                }else{direccion.setLetraComplemento(medico.getDireccion().getLetraComplemento());}
                medico.setDireccion(direccion);
            }
            ListarMedico listarMedico = new ListarMedico(medico);
            return ResponseEntity.accepted().body(listarMedico);
        }
        return ResponseEntity.badRequest().body("No se encuentra el Registro");
    }

    @Transactional
    public ResponseEntity<String> eliminarRegistroMedico(Long id) {
        Optional<Medico> medicoOptional = medicoRepository.findById(id);
        if(medicoOptional.isPresent()){
            Medico medico = medicoOptional.get();
            medico.setActivo(0);
            return ResponseEntity.ok("Registro Eliminado Con Exito");
        }
        return ResponseEntity.status(404).body("No se ha encontrado el Registro");
    }
}
