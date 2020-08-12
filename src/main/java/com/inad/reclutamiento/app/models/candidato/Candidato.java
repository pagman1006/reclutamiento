/**
 * 
 */
package com.inad.reclutamiento.app.models.candidato;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@Entity
@Table(name = "candidatos", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_rfc", "id_candidato"})} )
public class Candidato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_candidato")
	private Long id;
	
	@NotEmpty
	@Column(name = "primer_nombre")
	private String primerNombre;
	
	@Column(name = "segundo_nombre")
	private String segundoNombre;
	
	@NotEmpty
	@Column(name = "apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name = "apellido_materno")
	private String apellidoMaterno;
	
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	@Column
	private Integer estadoId;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_candidato")
	private List<Telefono> telefonos = new ArrayList<Telefono>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_candidato")
	private List<CorreoElectronico> correosElectronicos = new ArrayList<CorreoElectronico>();
	
	@Transient
	private Long numeroCasa;
	
	@Transient
	private Long numeroCelular;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public List<CorreoElectronico> getCorreosElectronicos() {
		return correosElectronicos;
	}

	public void setCorreosElectronicos(List<CorreoElectronico> correosElectronicos) {
		this.correosElectronicos = correosElectronicos;
	}

	public Long getNumeroCasa() {
		for (Telefono tel : telefonos){
			if (tel.getTipoTelefono() == 1) {
				setNumeroCasa(tel.getNumero());
			}
		}
		return numeroCasa;
	}

	public void setNumeroCasa(Long numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public Long getNumeroCelular() {
		for (Telefono tel : telefonos){
			if (tel.getTipoTelefono() == 2) {
				setNumeroCelular(tel.getNumero());
			}
		}
		return numeroCelular;
	}

	public void setNumeroCelular(Long numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Candidato [id=");
		builder.append(id);
		builder.append(", primerNombre=");
		builder.append(primerNombre);
		builder.append(", segundoNombre=");
		builder.append(segundoNombre);
		builder.append(", apellidoPaterno=");
		builder.append(apellidoPaterno);
		builder.append(", apellidoMaterno=");
		builder.append(apellidoMaterno);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", estadoId=");
		builder.append(estadoId);
		builder.append(", telefonos=");
		builder.append(telefonos);
		builder.append("]");
		return builder.toString();
	}
}
