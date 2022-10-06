/**
 * 
 */
package database.business.administracion;

import java.util.List;
import java.util.Optional;

/**
 * @author UO285176
 *
 */
public interface AdministracionService {
	// Le pasamos el admin a añadir
	AdministradorBLDto addAdministracion(AdministradorBLDto admin);

	// Le pasamos el identificador del admin a eliminar
	void deleteAdministrador(String idAdministrador);

	// Le pasamos el monitor a actualizar
	void updateAdministrador(AdministradorBLDto admin);

	// Le pasamos el id del admin que queremos buscar
	Optional<AdministradorBLDto> findMonitorById(String idAdministrador);

	// Devuelve una lista con todos los administradores
	List<AdministradorBLDto> findAllAdministracion();

	public class AdministradorBLDto {

		public String id;
		public String nombre;
		public String apellidos;
		public String correo;

	}
}
