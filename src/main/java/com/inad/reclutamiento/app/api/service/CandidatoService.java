/**
 * 
 */
package com.inad.reclutamiento.app.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inad.reclutamiento.app.models.candidato.Candidato;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
public interface CandidatoService {

	public List<Candidato> findAll();
	
	public Page<Candidato> findAll(Pageable pageable);
	
	public Candidato findCandidatoById(long id);
	
	public void saveCandidato(Candidato candidato);
	
	public void deleteCandidatoById(long id);
	
	public void deleteCandidato(Candidato candidato);
}
