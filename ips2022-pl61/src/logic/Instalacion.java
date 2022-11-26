/**
 * 
 */
package logic;

import database.business.BusinessFactory;
import database.business.instalacion.InstalacionService;

/**
 * @author UO285176
 *
 */
public class Instalacion {
	
	private static InstalacionService is = BusinessFactory.forInstalacionService();
	
	public void cerrarInstalacion(String instalacion, String fechaCierre) {
		is.cerrarInstalacion(instalacion, fechaCierre);
	}
}
