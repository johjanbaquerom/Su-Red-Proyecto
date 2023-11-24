package com.prueba.suRed.repository;

import com.prueba.suRed.entity.PerfilDeUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilDeUsurioRepository extends JpaRepository<PerfilDeUsuario, Long> {
}
