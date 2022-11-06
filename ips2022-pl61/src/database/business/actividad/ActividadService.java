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
	// Le pasamos la actividad a añadir
	ActividadBLDto addActividad(ActividadBLDto actividad);

	// Le pasamos el identificador de la actividad a eliminar
	void deleteActividad(String idActividad);

	// Le pasamos la actividad a actualizar
	void updateActividad(ActividadBLDto actividad);

	// Le pasamos el id de la actividad que queremos buscar
	ActividadBLDto findActividadById(String idActividad);

	// Devuelve una lista con todos las actividades
	List<ActividadBLDto> findAllActividades();

	public class ActividadBLDto {

		public String id;
		public String tipo;
		public String intensidad;
		public String acceso;
		public String monitor;
		public String hora_inicio;
		public String hora_fin;
		public String instalacion;
		public String fecha;
		public int plazas;


	}

	void planificarActividad(String tipo, String fecha, String hora_inicio, String hora_fin);
}
