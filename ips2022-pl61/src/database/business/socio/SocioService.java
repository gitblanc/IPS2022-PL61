/**
 * 
 */
package database.business.socio;

import java.util.List;
import java.util.Optional;

/**
 * @author UO285176
 *
 */
public interface SocioService {
	// Le pasamos el socio a a�adir
	SocioBLDto addSocio(SocioBLDto socio);

	// Le pasamos el identificador del socio a eliminar
	void deleteSocio(String idSocio);

	// Le pasamos el socio a actualizar
	void updateSocio(SocioBLDto socio);

	// Le pasamos el id del socio que queremos buscar
	Optional<SocioBLDto> findSocioById(String idSocio);

	// Devuelve una lista con todos los socios
	List<SocioBLDto> findAllSocios();
	

	public class SocioBLDto {

		public String id;
		public String nombre;
		public String apellidos;
		public String correo;
		public String contraseña;

	}
}
