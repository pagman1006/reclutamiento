/**
 * 
 */
package com.inad.reclutamiento.app.catalogo;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
public enum NivelIdioma {
	
	EPL1(1, "Epl 1", true),

	EPL2(2, "Epl 2", true),

	EPL3(3, "Epl 3", true),
	
	EPL4(3, "Epl 4", true),
	
	EPL5(3, "Epl 5", true);

	private int id;

	private String nombre;

	private boolean activo;

	private NivelIdioma(int id, String nombre, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
	}

	public static NivelIdioma valueOf() throws Exception {
		for (NivelIdioma nivel : values()) {
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
