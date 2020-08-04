/**
 * 
 */
package com.inad.reclutamiento.app.catalogo;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
public enum Idioma {
	
	ESPANOL(1, "Español", true),

	INGLES(2, "Ingles", true),

	CHINO(3, "Chino", true),
	
	ALEMAN(3, "Aleman", true),
	
	FRANCES(3, "Frances", true);

	private int id;

	private String nombre;

	private boolean activo;

	private Idioma(int id, String nombre, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
	}

	public static Idioma valueOf() throws Exception {
		for (Idioma nivel : values()) {
			if (nivel.isActivo()) {
				return nivel;
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
