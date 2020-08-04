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
@Table(name = "telefonos")
public class Telefono {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefono")
	private Long id;
	
	@Column(name = "id_candidato")
	private Long idCandidato;
	
	@Column(name = "tipo_telefono")
	private Integer tipoTelefono;
	
	@Column
	private Long numero;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_candidato")
//	private Candidato candidato;

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

	public Integer getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(Integer tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

//	public Candidato getCandidato() {
//		return candidato;
//	}
//
//	public void setCandidato(Candidato candidato) {
//		this.candidato = candidato;
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Telefono [id=");
		builder.append(id);
		builder.append(", idCandidato=");
		builder.append(idCandidato);
		builder.append(", tipoTelefono=");
		builder.append(tipoTelefono);
		builder.append(", numero=");
		builder.append(numero);
		builder.append("]");
		return builder.toString();
	}
}
