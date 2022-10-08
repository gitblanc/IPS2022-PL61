/**
 * 
 */
package logic;

import java.util.List;

import assertion.Argument;
import database.business.BusinessFactory;
import database.business.actividad.ActividadService;
import database.business.actividad.ActividadService.ActividadBLDto;

/**
 * @author UO285176
 *
 */
public class Actividad {
	// factoría de actividades
	private ActividadService as = BusinessFactory.forActividadService();

	/**
	 * Método que lista todas las actividades existentes
	 * @return
	 */
	protected List<ActividadBLDto> listarActividades() {
		return as.findAllActividades();
	}
	
	/**
	 * Método que crea una actividad
	 * @param id
	 * @param nombre
	 * @param intensidad
	 * @param recurso
	 */
	protected void crearActividad(String id, String nombre, String intensidad, String recurso) {
		Argument.isNotNull(id);
		Argument.isNotNull(nombre);
		Argument.isNotNull(intensidad);
		Argument.isNotNull(recurso);
		ActividadBLDto actividad = new ActividadBLDto();
		actividad.id = id;
		actividad.nombre = nombre;
		actividad.intensidad = intensidad;
		actividad.recurso = recurso;
		as.addActividad(actividad);
	}
}
