/**
 * 
 */
package com.inad.reclutamiento.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.inad.reclutamiento.app.models.user.Usuario;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
	
}
