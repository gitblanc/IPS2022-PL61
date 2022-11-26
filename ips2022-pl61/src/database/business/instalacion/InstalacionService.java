/**
 * 
 */
package database.business.instalacion;

import java.util.List;

/**
 * @author UO285176
 *
 */
public interface InstalacionService {
	public List<InstalacionBLDto> findAllInstalaciones();
	
	public class InstalacionBLDto{
		public String nombre;
		public int plazas;
	}

	public void cerrarInstalacion(String instalacion, String fechaCierre);
}
