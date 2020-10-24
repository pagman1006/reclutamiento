/**
 * 
 */
package com.inad.reclutamiento.app.models.requerimiento;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@Entity
@Table(name = "requerimientos")
public class Requerimiento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_requerimiento")
	private Long id;
	
	@Column
	private String region;
	
	@Column
	private String centro;
	
	@Column(name = "id_cliente")
	private Long idCliente;
	
	@Column
	private String cliente;

}
