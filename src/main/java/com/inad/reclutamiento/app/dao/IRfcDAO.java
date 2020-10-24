/**
 * 
 */
package com.inad.reclutamiento.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inad.reclutamiento.app.models.candidato.Rfc;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@Repository( value = "rfcDAO" )
public interface IRfcDAO extends JpaRepository<Rfc, Long> {

}
