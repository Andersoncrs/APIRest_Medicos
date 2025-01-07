package com.hospital.apihospital.Medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    @Query(value = "SELECT m FROM Medico AS m WHERE activo = 1")
    Page<Medico> listarMedicos(Pageable pageable);
}
