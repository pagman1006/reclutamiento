/**
 * 
 */
package com.inad.reclutamiento.app.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inad.reclutamiento.app.models.candidato.Rfc;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
public interface RfcService {

public List<Rfc> findAll();
	
	public Page<Rfc> findAll(Pageable pageable);
	
	public Rfc findRfcById(long id);
	
	public void saveRfc(Rfc rfc);
	
	public void deleteRfcById(long id);
	
	public void deleteRfc(Rfc rfc);
}
