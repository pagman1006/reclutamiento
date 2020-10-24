/**
 * 
 */
package com.inad.reclutamiento.app.catalogo;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
public enum TipoCorreo {

	PERSONAL(1, "Correo Personal", true),

	CORPORATIVO(2, "Correo Corporativo", true),

	OTRO(3, "Otro", true);

	private int id;

	private String nombre;

	private boolean activo;

	private TipoCorreo(int id, String nombre, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
	}

	public static TipoCorreo valueOf() throws Exception {
		for (TipoCorreo tipo : values()) {
			if (tipo.isActivo()) {
				return tipo;
			}
		}
		return null;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
