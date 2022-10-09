/**
 * 
 */
package database.business.actividad;

import java.util.List;
import java.util.Optional;

/**
 * @author UO285176
 *
 */
public interface ActividadService {
	// Le pasamos la actividad a a�adir
	ActividadBLDto addActividad(ActividadBLDto actividad);

	// Le pasamos el identificador de la actividad a eliminar
	void deleteActividad(String idActividad);

	// Le pasamos la actividad a actualizar
	void updateActividad(ActividadBLDto actividad);

	// Le pasamos el id de la actividad que queremos buscar
	Optional<ActividadBLDto> findActividadById(String idActividad);

	// Devuelve una lista con todos las actividades
	List<ActividadBLDto> findAllActividades();

	public class ActividadBLDto {

		public String id;
		public String nombre;
		public String intensidad;
		public String acceso;
		public String horario;
		public String monitor;


	}
}
