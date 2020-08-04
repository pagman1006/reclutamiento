/**
 * 
 */
package com.inad.reclutamiento.app.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inad.reclutamiento.app.api.service.CandidatoService;
import com.inad.reclutamiento.app.dao.ICandidatoDAO;
import com.inad.reclutamiento.app.models.candidato.Candidato;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@Service("candidatoService")
@Transactional(readOnly = true)
public class CandidatoServiceImpl implements CandidatoService {

	@Autowired
	private ICandidatoDAO candidatoDAO;
	
	/* (non-Javadoc)
	 * @see com.inad.reclutamiento.app.api.service.CandidatoService#findAll()
	 */
	@Override
	public List<Candidato> findAll() {
		return candidatoDAO.findAll();
	}

	@Override
	public Page<Candidato> findAll(Pageable pageable) {
		return candidatoDAO.findAll(pageable);
	}

	@Override
	@Transactional
	public void saveCandidato(Candidato candidato) {
		candidatoDAO.save(candidato);
	}

	@Override
	@Transactional
	public void deleteCandidatoById(long id) {
		candidatoDAO.deleteById(id);
	}

	@Override
	public Candidato findCandidatoById(long id) {
		return candidatoDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteCandidato(Candidato candidato) {
		candidatoDAO.delete(candidato);
	}

}
