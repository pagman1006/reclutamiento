/**
 * 
 */
package com.inad.reclutamiento.app.models.candidato;

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
@Table(name = "correos")
public class CorreoElectronico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_correo")
	private Long id;
	
	@Column(name = "id_candidato")
	private Long idCandidato;
	
	@Column(name = "tipo_correo")
	private Integer tipoCorreo;
	
	@Column
	private String correo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Integer getTipoCorreo() {
		return tipoCorreo;
	}

	public void setTipoCorreo(Integer tipoCorreo) {
		this.tipoCorreo = tipoCorreo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CorreoElectronico [id=");
		builder.append(id);
		builder.append(", idCandidato=");
		builder.append(idCandidato);
		builder.append(", tipoCorreo=");
		builder.append(tipoCorreo);
		builder.append(", correo=");
		builder.append(correo);
		builder.append("]");
		return builder.toString();
	}
}
