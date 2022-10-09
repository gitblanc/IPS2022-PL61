/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import database.business.BusinessFactory;
import database.business.actividad.ActividadService;
import database.business.actividad.ActividadService.ActividadBLDto;

/**
 * @author UO285176
 *
 */
public class Actividad {
	
	// lista de socios apuntados a una actividad
	private List<Socio> sociosApuntados = new ArrayList<>();
	
	// factoría de actividades
	private ActividadService as = BusinessFactory.forActividadService();

	/**
	 * Método que lista todas las actividades existentes
	 * 
	 * @return
	 */
	public List<ActividadBLDto> listarActividades() {
		return as.findAllActividades();
	}

	/**
	 * Método que crea una actividad
	 * 
	 * @param id
	 * @param nombre
	 * @param intensidad
	 * @param recurso
	 * @param monitor
	 */
	protected boolean crearActividad(String id, String nombre, String intensidad, String recurso, String id_m) {
		if (!validarParámetros(id, nombre, intensidad, recurso, id_m))
			return false;
		ActividadBLDto actividad = new ActividadBLDto();
		actividad.id = id;
		actividad.nombre = nombre;
		actividad.intensidad = intensidad;
		actividad.monitor = id_m;
		as.addActividad(actividad);
		return true;
	}

	/**
	 * Método que comprueba que no pasemos null, espacios en blanco o nada a la base
	 * de datos
	 * 
	 * @param id
	 * @param nombre
	 * @param intensidad
	 * @param recurso
	 * @return
	 */
	private boolean validarParámetros(String id, String nombre, String intensidad, String recurso, String id_m) {
		if (id == null || nombre == null || intensidad == null || recurso == null || id_m == null|| id.isBlank() || nombre.isBlank()
				|| intensidad.isBlank() || recurso.isBlank()|| id_m.isBlank())
			return false;
		return true;
	}

	public List<Socio> getSociosApuntados() {
	
		return sociosApuntados;
	}

	public ActividadService getAs() {
		return as;
	}

	public boolean comprobarMonitorActividad(String monitor, String id) {
		List<ActividadBLDto> actividades = listarActividades();
		for (int i=0; i<actividades.size(); i++ ) {
			if(actividades.get(i).monitor == monitor) {
				if (actividades.get(i).id == id) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String[] actividadesId() {
		List<ActividadBLDto> actividades = listarActividades();
		String[] act = new String[actividades.size()];
		for (int i=0; i<actividades.size(); i++) {
			String id = actividades.get(i).id;
			act[i] = id;
		}
		return act;
	}
	
	
	
	
}
