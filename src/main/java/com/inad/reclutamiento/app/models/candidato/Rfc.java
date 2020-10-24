/**
 * 
 */
package com.inad.reclutamiento.app.models.candidato;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@Entity
@Table( name = "rfc" )
public class Rfc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rfc" )
	private Long id;
	
	@NotEmpty
	@Column( name = "rfc" )
	private String clave;
	
	@Column( name = "homoclave" )
	private String homoclave;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_rfc")
	private List<Candidato> candidatos = new ArrayList<Candidato>();
	
	public Rfc() {
		super();
	}
	
	public Rfc(@NotEmpty String clave, String homoclave) {
		super();
		this.clave = clave;
		this.homoclave = homoclave;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the rfc
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param rfc the rfc to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the homoclave
	 */
	public String getHomoclave() {
		return homoclave;
	}

	/**
	 * @param homoclave the homoclave to set
	 */
	public void setHomoclave(String homoclave) {
		this.homoclave = homoclave;
	}

	/**
	 * @return the candidatos
	 */
	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	/**
	 * @param candidatos the candidatos to set
	 */
	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

}
