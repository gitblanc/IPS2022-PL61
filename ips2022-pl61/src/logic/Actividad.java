/**
 * 
 */
package logic;

import java.time.LocalDate;
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
	private String id;
	private String tipo;
	private String intensidad;
	private String acceso;
	private String monitor;
	private String horaInicio;
	private String horaFin;
	private String instalacion;
	private String fecha;
	private int plazas;

	// factoría de actividades
	public Actividad() {
	}

	public String getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getIntensidad() {
		return intensidad;
	}

	public String getAcceso() {
		return acceso;
	}

	public String getMonitor() {
		return monitor;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public String getInstalacion() {
		return instalacion;
	}

	public String getFecha() {
		return fecha;
	}

	public int getPlazas() {
		return plazas;
	}

	public static ActividadService getAs() {
		return as;
	}

	public RecursosActividadService getRas() {
		return ras;
	}

	public static InstalacionService getIs() {
		return is;
	}

	private static ActividadService as = BusinessFactory.forActividadService();
	// factoría de recursos por actividad
	private RecursosActividadService ras = BusinessFactory.forRecursosActividadService();

	// factoría de instalaciones
	private static InstalacionService is = BusinessFactory.forInstalacionService();

	/**
	 * Método que lista todas las actividades existentes
	 * 
	 * @return
	 */
	public static List<ActividadBLDto> listarActividadesBLDto() {
		return as.findAllActividades();
	}

	public Actividad(String id, String tipo, String intensidad, String acceso, String monitor, String hora_inicio,
			String hora_fin, String instalacion, String fecha, int plazas) {
		this.id = id;
		this.tipo = tipo;
		this.intensidad = intensidad;
		this.acceso = acceso;
		this.monitor = monitor;
		this.horaInicio = hora_inicio;
		this.horaFin = hora_fin;
		this.instalacion = instalacion;
		this.fecha = fecha;
		this.plazas = plazas;
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
	 * @param plazas
	 * @param dia
	 */
//	protected boolean crearActividad(String id, String nombre, String intensidad, String[] recurso, String acceso,
//			String hora_inicio, String hora_fin, String instalacion, String fecha, int plazas) {
//		if (!validarParametros(id, nombre, intensidad, recurso, fecha, plazas, hora_inicio, hora_fin, instalacion))
//			return false;
//		if (acceso == "libre acceso")
//			acceso = "libre";
//		acceso = "reserva";
//		ActividadBLDto actividad = new ActividadBLDto();
//		actividad.id = id;
//		actividad.tipo = nombre;
//		actividad.intensidad = intensidad;
//		actividad.acceso = acceso;
//		actividad.hora_inicio = hora_inicio;
//		actividad.hora_fin = hora_fin;
//		actividad.instalacion = instalacion;
//		actividad.fecha = fecha;
//		actividad.plazas = plazas;
//		as.addActividad(actividad);
//		addRecursosActividad(id, recurso);
//		return true;
//	}

	private void addRecursosActividad(String id, List<String> recursos) {
		RecursosActividadBLDto ra = new RecursosActividadBLDto();
		ra.actividad = id;
		// Una actividad sin recursos
		if (recursos.isEmpty()) {
			ra.recurso = "sin recursos";
			ras.addRecursosActividad(ra);
		} // Una actividad con recursos
		else {
			for (String r : recursos) {
				ra.recurso = r;
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
	 * @param plazas
	 * @param dia
	 * @param hora_fin
	 * @param hora_inicio
	 * @param instalacion
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean validarParametros(String id, String nombre, String intensidad, String[] recursos, String dia,
			int plazas, String hora_inicio, String hora_fin, String instalacion) {
		if (id == null || nombre == null || intensidad == null || id.isBlank() || nombre.isBlank()
				|| intensidad.isBlank())
			return false;
		if (plazas < -1 || plazas == 0)
			return false;
		if (Integer.parseInt(hora_inicio.split(":")[0].toString().split("@")[0]) >= Integer
				.parseInt(hora_fin.split(":")[0].toString().split("@")[0]))
			return false;
		if (!existeRecursoEnInstalacion(recursos, instalacion))
			return false;
		return true;
	}

	private boolean existeRecursoEnInstalacion(String[] recursos, String instalacion) {
		if (recursos[0].isBlank())
			return true;
		for (int i = 0; i < recursos.length; i++) {
			if (!buscarRecurso(recursos[i], instalacion))
				return false;
		}
		return true;
	}

	private boolean buscarRecurso(String recurso, String instalacion) {
		String[] recursosInstalacion = Recurso.listarRecursosPorInstalacion(instalacion);
		for (int i = 0; i < recursosInstalacion.length; i++) {
			if (recursosInstalacion[i].equals(recurso))
				return true;
		}
		return false;
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

//	public static List<String> listarActividades(String dia) {
//		List<ActividadBLDto> actividades = listarActividadesBLDto();
//		List<String> result = new ArrayList<String>();
//		for (int i = 0; i < actividades.size(); i++) {
//			if (actividades.get(i).fecha.equals(dia)) {
//				String a = actividades.get(i).tipo + " ------ " + actividades.get(i).hora_inicio + " - "
//						+ actividades.get(i).hora_fin + " ------  Acceso por: "
//						+ actividades.get(i).acceso.toUpperCase();
//				result.add(a);
//			}
//		}
//		return result;
//	}
//
//	public static List<String> listarActividades() {
//		List<ActividadBLDto> actividades = listarActividadesBLDto();
//		List<String> result = new ArrayList<String>();
//		for (int i = 0; i < actividades.size(); i++) {
//			String a = actividades.get(i).tipo + " ------ " + actividades.get(i).fecha + " ------ "
//					+ actividades.get(i).hora_inicio + " - " + actividades.get(i).hora_fin + " ------ "
//					+ "Instalación: " + actividades.get(i).instalacion + " ------ Acceso por: "
//					+ actividades.get(i).acceso.toUpperCase();
//			result.add(a);
//		}
//
//		return result;
//	}
//
//	
//	/**
//	 * M�todo que devuelve una lista de los id y nombres de todas las actividades existentes
//	 */
//	public List<String> listarActividades() {
//		List<ActividadBLDto> actividadesBLDto = listarActividadesBLDto();
//		List<String> actividades = new ArrayList<String>();
//		for(int i=0; i<actividadesBLDto.size(); i++) {
//			String s = actividadesBLDto.get(i).id+"---" +actividadesBLDto.get(i).nombre;
//			actividades.add(s);
//		}
//		return actividades;
//	}
//	

	public void crearActividad(String id, String tipo, String intensidad, String instalacion, List<String> recursos,
			String acceso, int plazas) {
		ActividadBLDto actividad = new ActividadBLDto();
		actividad.id = id;
		actividad.tipo = tipo;
		actividad.intensidad = intensidad;
		actividad.instalacion = instalacion;
		actividad.acceso = acceso;
		actividad.plazas = plazas;
		as.addActividad(actividad);
		addRecursosActividad(id, recursos);
	}

	public int getPlazasInstalacion(String instalacion) {
		List<InstalacionBLDto> instalaciones = is.findAllInstalaciones();
		for (InstalacionBLDto i : instalaciones) {
			if (i.nombre.equals(instalacion))
				return i.plazas;
		}
		return -1;
	}

	public String[] findAllTiposActividad() {
		List<ActividadBLDto> actividades = as.findAllActividades();
		String[] res = new String[actividades.size()];
		int i = 0;
		for (ActividadBLDto a : actividades) {
			res[i] = a.tipo;
			i++;
		}
		return res;
	}

	public void planificarActividad(String tipo, String fecha, String hora_inicio, String hora_fin, String id) {
		as.planificarActividad(tipo, fecha, hora_inicio, hora_fin, id);
	}

	public List<Actividad> listarActividadesPorInstalacion(String instalacion) {
		List<Actividad> actividades = new ArrayList<>();
		for (ActividadBLDto a : as.findAllActividades()) {
			if (a.instalacion.equals(instalacion)) {
				actividades.add(new Actividad(a.id, a.tipo, a.intensidad, a.acceso, a.monitor, a.hora_inicio,
						a.hora_fin, a.instalacion, a.fecha, a.plazas));
			}
		}
		return actividades;
	}

	public static List<String> listarActividades(String dia) {
		List<ActividadBLDto> actividades = listarActividadesBLDto();
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < actividades.size(); i++) {
			if (actividades.get(i).fecha.equals(dia)) {
				String a = actividades.get(i).id + " ------ " + actividades.get(i).tipo + " ------ "
						+ actividades.get(i).hora_inicio + " - " + actividades.get(i).hora_fin + " ------  Acceso por: "
						+ actividades.get(i).acceso.toUpperCase();
				result.add(a);
			}
		}
		return result;
	}

	public static List<String> listarActividades() {
		List<ActividadBLDto> actividades = listarActividadesBLDto();
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < actividades.size(); i++) {
			if (!actividades.get(i).acceso.toUpperCase().equals("LIBRE")
					&& fechaMasProxima(LocalDate.now(), actividades.get(i).fecha)) {
				String a = actividades.get(i).tipo + " ------ " + actividades.get(i).fecha + " ------ "
						+ actividades.get(i).hora_inicio + " - " + actividades.get(i).hora_fin + " ------ "
						+ "Instalación: " + actividades.get(i).instalacion;
				result.add(a);
			}

		}

		return result;
	}

	public static String[] rellenarArrayConIds() {
		List<ActividadBLDto> actividades = listarActividadesBLDto();
		String[] ids = new String[actividades.size()];
		for (int i = 0; i < actividades.size(); i++) {
			if (!actividades.get(i).acceso.toUpperCase().equals("LIBRE")
					&& fechaMasProxima(LocalDate.now(), actividades.get(i).fecha)) {
				ids[i] = actividades.get(i).id;
			}
		}
		return ids;
	}

	private static boolean fechaMasProxima(LocalDate l, String fechaActividad) {
		String[] date = fechaActividad.split("/");
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);
		LocalDate ac = LocalDate.of(year, month, day);

		l = LocalDate.now();

		return l.isBefore(ac);

	}
//
//	
//	/**
//	 * M todo que devuelve una lista de los id y nombres de todas las actividades existentes
//	 */
//	public List<String> listarActividades() {
//		List<ActividadBLDto> actividadesBLDto = listarActividadesBLDto();
//		List<String> actividades = new ArrayList<String>();
//		for(int i=0; i<actividadesBLDto.size(); i++) {
//			String s = actividadesBLDto.get(i).id+"---" +actividadesBLDto.get(i).nombre;
//			actividades.add(s);
//		}
//		return actividades;
//	}
//	

	public Actividad buscarActividad(String tipo, String fecha, String hora_inicio, String hora_fin) {
		ActividadBLDto a = as.findByTipo(tipo);
		return new Actividad(a.id, a.tipo, a.intensidad, a.acceso, a.monitor, a.hora_inicio, a.hora_fin, a.instalacion,
				a.fecha, a.plazas);
	}

	public List<String> getAllRecursos(String idA) {
		List<String> res = new ArrayList<>();
		List<RecursosActividadBLDto> recursosActividad = getRas().findAllRecursosActividades();
		for (RecursosActividadBLDto r : recursosActividad) {
			if (r.actividad.equals(idA))
				res.add(r.recurso);
		}
		return res;
	}

}
