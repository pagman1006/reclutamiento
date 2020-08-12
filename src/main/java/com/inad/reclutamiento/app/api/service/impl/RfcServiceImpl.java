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

import com.inad.reclutamiento.app.api.service.RfcService;
import com.inad.reclutamiento.app.dao.IRfcDAO;
import com.inad.reclutamiento.app.models.candidato.Rfc;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@Service("rfcService")
@Transactional(readOnly = true)
public class RfcServiceImpl implements RfcService {

	@Autowired
	private IRfcDAO rfcDAO;
	
	@Override
	public List<Rfc> findAll() {
		return rfcDAO.findAll();
	}

	@Override
	public Page<Rfc> findAll(Pageable pageable) {
		return rfcDAO.findAll(pageable);
	}

	@Override
	public Rfc findRfcById(long id) {
		return rfcDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void saveRfc(Rfc rfc) {
		rfcDAO.save(rfc);
	}

	@Override
	@Transactional
	public void deleteRfcById(long id) {
		rfcDAO.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteRfc(Rfc rfc) {
		rfcDAO.delete(rfc);
	}

}
