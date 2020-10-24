package com.inad.reclutamiento.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inad.reclutamiento.app.models.candidato.Candidato;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@Repository(value = "clienteDAO")
public interface ICandidatoDAO extends JpaRepository<Candidato, Long> {

}
