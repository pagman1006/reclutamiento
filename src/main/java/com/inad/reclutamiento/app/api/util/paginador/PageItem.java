/**
 * 
 */
package com.inad.reclutamiento.app.api.util.paginador;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
public class PageItem {

	private int numero;
	private boolean actual;

	public PageItem(int numero, boolean actual) {
		this.numero = numero;
		this.actual = actual;
	}

	public int getNumero() {
		return numero;
	}

	public boolean isActual() {
		return actual;
	}

}
