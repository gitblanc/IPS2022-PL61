/**
 * 
 */
package logic;

import java.util.List;

import database.business.BusinessFactory;
import database.business.actividad.ActividadService;
import database.business.actividad.ActividadService.ActividadBLDto;

/**
 * @author UO285176
 *
 */
public class Actividad {
	// factor�a de actividades
	private ActividadService as = BusinessFactory.forActividadService();

	/**
	 * M�todo que lista todas las actividades existentes
	 * 
	 * @return
	 */
	protected List<ActividadBLDto> listarActividades() {
		return as.findAllActividades();
	}

	/**
	 * M�todo que crea una actividad
	 * 
	 * @param id
	 * @param nombre
	 * @param intensidad
	 * @param recurso
	 */
	protected boolean crearActividad(String id, String nombre, String intensidad, String recurso) {
		if (!validarParametros(id, nombre, intensidad, recurso))
			return false;
		ActividadBLDto actividad = new ActividadBLDto();
		actividad.id = id;
		actividad.nombre = nombre;
		actividad.intensidad = intensidad;
		as.addActividad(actividad);
		return true;
	}

	/**
	 * M�todo que comprueba que no pasemos null, espacios en blanco o nada a la base
	 * de datos
	 * 
	 * @param id
	 * @param nombre
	 * @param intensidad
	 * @param recurso
	 * @return
	 */
	private boolean validarParametros(String id, String nombre, String intensidad, String recurso) {
		if (id == null || nombre == null || intensidad == null || recurso == null || id.isBlank() || nombre.isBlank()
				|| intensidad.isBlank() || recurso.isBlank())
			return false;
		return true;
	}
}
