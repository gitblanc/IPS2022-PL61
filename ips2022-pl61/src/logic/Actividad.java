/**
 * 
 */
package logic;

import java.util.ArrayList;
import java.util.List;

import database.business.BusinessFactory;
import database.business.actividad.ActividadService;
import database.business.actividad.ActividadService.ActividadBLDto;
import database.business.instalacion.InstalacionService;
import database.business.instalacion.InstalacionService.InstalacionBLDto;
import database.business.recursosActividad.RecursosActividadService;
import database.business.recursosActividad.RecursosActividadService.RecursosActividadBLDto;

/**
 * @author UO285176 UO276967
 *
 */
public class Actividad {

	// factoría de actividades

	private ActividadService as = BusinessFactory.forActividadService();
	// factoría de recursos por actividad
	private RecursosActividadService ras = BusinessFactory.forRecursosActividadService();

	// factoría de instalaciones
	private static InstalacionService is = BusinessFactory.forInstalacionService();

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
	 * @param instalacion
	 * @param hora_fin
	 */
	protected boolean crearActividad(String id, String nombre, String intensidad, String[] recurso, String acceso,
			String hora_inicio, String hora_fin, String instalacion) {
		if (!validarParametros(id, nombre, intensidad, recurso))
			return false;
		if (acceso == "libre acceso")
			acceso = "libre";
		acceso = "reserva";
		ActividadBLDto actividad = new ActividadBLDto();
		actividad.id = id;
		actividad.nombre = nombre;
		actividad.intensidad = intensidad;
		actividad.acceso = acceso;
		actividad.hora_inicio = hora_inicio;
		actividad.hora_fin = hora_fin;
		actividad.instalacion = instalacion;
		as.addActividad(actividad);
		addRecursosActividad(id, recurso);
		return true;
	}

	private void addRecursosActividad(String id, String[] recurso) {
		RecursosActividadBLDto ra = new RecursosActividadBLDto();
		ra.actividad = id;
		// Una actividad sin recursos
		if (recurso[0].isBlank()) {
			ra.recurso = "sin recursos";
			ras.addRecursosActividad(ra);
		} // Una actividad con recursos
		else {
			for (int i = 0; i < recurso.length; i++) {
				ra.recurso = recurso[i];
				ras.addRecursosActividad(ra);
			}
		}
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
	private boolean validarParametros(String id, String nombre, String intensidad, String[] recurso) {
		if (id == null || nombre == null || intensidad == null || id.isBlank() || nombre.isBlank()
				|| intensidad.isBlank())

			return false;
		return true;
	}

	/**
	 * Método que devuelve la lista de las actividades con reserva
	 * 
	 * @return
	 */
	public List<ActividadBLDto> actividadesReserva() {
		List<ActividadBLDto> listaReserva = new ArrayList<ActividadBLDto>();
		for (ActividadBLDto a : listarActividades()) {
			if (a.acceso.equals("reserva") || a.acceso.equals("RESERVA") || a.acceso.equals("Reserva")) {
				listaReserva.add(a);
			}
		}
		return listaReserva;
	}

	/**
	 * Método que devuelve la lista de las actividades que no necesitan reserva
	 * 
	 * @return
	 */
	public List<ActividadBLDto> actividadesLibre() {
		List<ActividadBLDto> listaLibre = new ArrayList<ActividadBLDto>();
		for (ActividadBLDto a : listarActividades()) {
			if (a.acceso.equals("libre") || a.acceso.equals("LIBRE") || a.acceso.equals("Libre")) {
				listaLibre.add(a);
			}
		}
		return listaLibre;

	}

	/**
	 * Método que devuelve las instalaciones existentes
	 * 
	 * @return
	 */
	public static String[] listarInstalaciones() {
		List<InstalacionBLDto> instalaciones = is.findAllInstalaciones();
		String[] result = new String[instalaciones.size()];
		for (int i = 0; i < instalaciones.size(); i++) {
			result[i] = instalaciones.get(i).nombre;
		}
		return result;
	}

}
