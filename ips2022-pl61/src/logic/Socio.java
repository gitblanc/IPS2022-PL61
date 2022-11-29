package logic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import database.business.BusinessFactory;
import database.business.actividad.ActividadService;
import database.business.actividad.ActividadService.ActividadBLDto;
import database.business.actividadSocio.ActividadSocioService;
import database.business.actividadSocio.ActividadSocioService.ActividadSocioBLDto;
import database.business.alquiler.AlquilerService;
import database.business.alquiler.AlquilerService.AlquilerBLDto;
import database.business.recurso.RecursoService;
import database.business.recurso.RecursoService.RecursoBLDto;
import database.business.recursosALlevarSocio.RecursosALlevarSocioService;
import database.business.recursosALlevarSocio.RecursosALlevarSocioService.RecursosALlevarSocioBLDto;
import database.business.socio.SocioService;
import database.business.socio.SocioService.SocioBLDto;

public class Socio {

	private String id, nombre, apellidos, correo, passwd;

	private static SocioService ss = BusinessFactory.forSocioService();
	private static ActividadSocioService ass = BusinessFactory.forActividadSocioService();
	private static ActividadService aser = BusinessFactory.forActividadService();
	private static AlquilerService als = BusinessFactory.forAlquilerService();
	private static RecursoService rs = BusinessFactory.forRecursoService();
	private static RecursosALlevarSocioService ralss = BusinessFactory.forRecursosALlevarSocioService();

	public Socio(String id, String nombre, String apellidos, String pass) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.passwd = pass;
	}

	public Socio() {
	}

	public String socioCorrecto(String correo, String contraseña) {
		String correcto = null;
		if (!validarParametros(correo, contraseña))
			correcto = null;
		List<SocioBLDto> lista = ss.findAllSocios();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).correo.equals(correo)) {
				if (lista.get(i).contraseña.equals(contraseña)) {
					correcto = lista.get(i).nombre;
				} else {
					correcto = null;
				}
			} else {
				correcto = null;
			}
		}
		return correcto;
	}

	public String devolverCorreo(String correo) {
		return correo;
	}

	private boolean validarParametros(String correo, String contraseña) {
		if (correo == null || contraseña == null) {
			return false;
		}
		return true;
	}

	public static List<ActividadSocioBLDto> listarActividadSocio() {
		return ass.findAllActividadSocio();
	}

	public static List<ActividadBLDto> listarTodasLAsActividades() {
		return aser.findAllActividades();
	}

	public static List<AlquilerBLDto> listarTodosAlquileres() {
		return als.findAll();
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public String getPasswd() {
		return passwd;
	}

	// ------------------------------------------------------------

//	/**
//	 * Método que encuentra las actividades de cada socio
//	 */
//	public List<String> findActivitiesBySocio(String correo) {
//		List<ActividadSocioBLDto> actividadesApuntadas = listarActividadSocio();
//		List<ActividadBLDto> actividades = listarTodasLAsActividades();
//		List<String> lista = new ArrayList<String>();
//		for (int i = 0; i < actividadesApuntadas.size(); i++) {
//			if (actividadesApuntadas.get(i).correo_socio.equals(correo)) {
//				for (int j = 0; j < actividades.size(); j++) {
//					if (actividadesApuntadas.get(i).id_actividad != null
//							&& actividadesApuntadas.get(i).id_actividad.equals(actividades.get(j).id)) {
//						if (fechaMasProxima(LocalDate.now(), actividades.get(j).fecha)) {
//							String a = actividades.get(j).id + " ------ " + actividades.get(j).tipo + " ------ "
//									+ actividades.get(j).fecha + " ------ " + actividades.get(j).hora_inicio + " - "
//									+ actividades.get(j).hora_fin + " ------ " + actividades.get(j).instalacion;
//							lista.add(a);
//						}
//
//					}
//				}
//			}
//		}
//
//		return lista;
//	}

	public List<String> findActivitiesBySocio(String correo) {
		List<ActividadBLDto> actividades = listarActividadSocioOrdenadas(correo);
		List<String> lista = new ArrayList<String>();
		for (int j = 0; j < actividades.size(); j++) {
			String a = actividades.get(j).id + " ------ " + actividades.get(j).tipo + " ------ "
					+ actividades.get(j).fecha + " ------ " + actividades.get(j).hora_inicio + " - "
					+ actividades.get(j).hora_fin + " ------ " + actividades.get(j).instalacion;
			lista.add(a);

		}
		return lista;
	}

	public List<ActividadBLDto> findActividadesDelSocio(String correo) {
		List<ActividadSocioBLDto> actividadesApuntadas = listarActividadSocio();
		List<ActividadBLDto> actividades = listarTodasLAsActividades();
		List<ActividadBLDto> resultado = new ArrayList<ActividadBLDto>();
		for (int i = 0; i < actividadesApuntadas.size(); i++) {
			if (actividadesApuntadas.get(i).correo_socio.equals(correo)) {
				for (int j = 0; j < actividades.size(); j++) {
					if (actividadesApuntadas.get(i).id_actividad != null
							&& actividadesApuntadas.get(i).id_actividad.equals(actividades.get(j).id)) {
						if (fechaMasProxima(LocalDate.now(), actividades.get(j).fecha)) {
							resultado.add(actividades.get(j));
						}
					}
				}
			}
		}
		return resultado;
	}

	private List<ActividadBLDto> listarActividadSocioOrdenadas(String correo) {
		List<ActividadBLDto> actividades = new ArrayList<ActividadBLDto>(findActividadesDelSocio(correo));
		actividades.sort(new OrderActividades());
		return actividades;
	}

	/**
	 * Método que encuentra las instalaciones de cada socio
	 */
	public List<String> findAlquilersBySocio(String correo) {
		List<AlquilerBLDto> alquileres = devolverAlquileresDelSocioOrdenadoPorDias(correo);
		List<String> lista = new ArrayList<String>();
		for (int i = 0; i < alquileres.size(); i++) {
			if (alquileres.get(i).cancelado == 0) {
				String a = alquileres.get(i).id + " ------ " + alquileres.get(i).instalacion + " ------ "
						+ alquileres.get(i).fecha + " ------ " + alquileres.get(i).hora_inicio + " - "
						+ alquileres.get(i).hora_fin;
				lista.add(a);
			}
		}

		return lista;
	}

	public List<AlquilerBLDto> devolverAlquileresDelSocio(String correo) {
		List<AlquilerBLDto> todosLosAlquileres = listarTodosAlquileres();
		List<AlquilerBLDto> result = new ArrayList<AlquilerBLDto>();
		SocioBLDto socio = ss.findByCorreo(correo);
		String id = socio.id;
		for (int i = 0; i < todosLosAlquileres.size(); i++) {
			if (todosLosAlquileres.get(i).id_socio.equals(id)) {
				if (todosLosAlquileres.get(i).cancelado == 0) {
					result.add(todosLosAlquileres.get(i));
				}
			}
		}
		return result;
	}

	public List<AlquilerBLDto> devolverAlquileresDelSocioOrdenadoPorDias(String correo) {
		List<AlquilerBLDto> lista = new ArrayList<AlquilerBLDto>(devolverAlquileresDelSocio(correo));
		lista.sort(new OrderAlquileres());
		return lista;
	}

	public List<AlquilerBLDto> devolverAlquileresDelSocioOrdenadorPorHoras(String correo) {
		List<AlquilerBLDto> lista = new ArrayList<AlquilerBLDto>(devolverAlquileresDelSocioOrdenadoPorDias(correo));
		lista.sort(new OrderAlquileresPorHoras());
		return lista;
	}

	class OrderAlquileres implements Comparator<AlquilerBLDto> {

		@Override
		public int compare(AlquilerBLDto o1, AlquilerBLDto o2) {
			String[] date = o1.fecha.split("/");
			int day = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]);
			int year = Integer.parseInt(date[2]);
			LocalDate ac1 = LocalDate.of(year, month, day);

			String[] date2 = o2.fecha.split("/");
			int day2 = Integer.parseInt(date2[0]);
			int month2 = Integer.parseInt(date2[1]);
			int year2 = Integer.parseInt(date2[2]);
			LocalDate ac2 = LocalDate.of(year2, month2, day2);

			return ac1.compareTo(ac2);

		}

	}

	class OrderAlquileresPorHoras implements Comparator<AlquilerBLDto> {

		@Override
		public int compare(AlquilerBLDto o1, AlquilerBLDto o2) {
			String[] hora1 = o1.hora_inicio.split(":");
			Integer hora_inicio_1 = Integer.parseInt(hora1[0]);
			String[] hora2 = o2.hora_inicio.split(":");
			Integer hora_inicio_2 = Integer.parseInt(hora2[0]);

			return hora_inicio_1.compareTo(hora_inicio_2);
		}

	}

	class OrderActividades implements Comparator<ActividadBLDto> {

		@Override
		public int compare(ActividadBLDto o1, ActividadBLDto o2) {
			String[] date = o1.fecha.split("/");
			int day = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]);
			int year = Integer.parseInt(date[2]);
			LocalDate ac1 = LocalDate.of(year, month, day);

			String[] date2 = o2.fecha.split("/");
			int day2 = Integer.parseInt(date2[0]);
			int month2 = Integer.parseInt(date2[1]);
			int year2 = Integer.parseInt(date2[2]);
			LocalDate ac2 = LocalDate.of(year2, month2, day2);

			return ac1.compareTo(ac2);
		}

	}

	private boolean fechaMasProxima(LocalDate l, String fechaActividad) {
		String[] date = fechaActividad.split("/");
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);
		LocalDate ac = LocalDate.of(year, month, day);

		l = LocalDate.now();

		return l.isBefore(ac) || l.isEqual(ac);

	}

	public static String[] listarSociosPorCorreo() {
		List<SocioBLDto> socios = ss.findAllSocios();
		String[] todosLosSocios = new String[socios.size()];
		for (int i = 0; i < socios.size(); i++) {
			todosLosSocios[i] = socios.get(i).correo;
		}
		return todosLosSocios;

	}

	public static boolean añadirActividadASocio(String correo, String id_actividad) {
		ActividadSocioBLDto as = new ActividadSocioBLDto();
		ActividadBLDto a = aser.findActividadById(id_actividad);
		LocalDate hoy = LocalDate.now();
		LocalTime hora = LocalTime.now();
		String fecha_A = a.fecha;
		String[] date = fecha_A.split("/");
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);
		LocalDate ac = LocalDate.of(year, month, day);

		String hora_a = a.hora_inicio;
		String[] valores = hora_a.split(":");
		int v = Integer.parseInt(valores[0]);
		int hora_ahora = hora.getHour();
		boolean result = false;

		if (!a.acceso.toUpperCase().equals("LIBRE")) {
			if (hoy.isBefore(ac) || (hoy.isEqual(ac) && Math.abs(hora_ahora - v) >= 1)) {
					List<ActividadSocioBLDto> actividadesDelSocio = ass.findAllActividadSocio();
					for (ActividadSocioBLDto acsocio : actividadesDelSocio) {
						if (acsocio.correo_socio.equals(correo) && acsocio.id_actividad.equals(id_actividad)) {
							result = false;
						} else {
							result = true;
						
					}
				}

			}
		}
		if (result == true) {
			as.correo_socio = correo;
			as.id_actividad = id_actividad;
			ass.addActividadSocio(as);
		}
		return result;

	}

	public static void eliminarActividadSocio(String correo, String id_actividad) {
		ass.deleteActividadSocio(id_actividad, correo);
	}

	public String[] listarSocios() {
		List<SocioBLDto> socios = ss.findAllSocios();
		String[] todosLosSocios = new String[socios.size()];
		for (int i = 0; i < socios.size(); i++) {
			todosLosSocios[i] = socios.get(i).id;
		}
		return todosLosSocios;
	}

	public static String getIdSocio(String correo) {
		SocioBLDto socio = ss.findByCorreo(correo);
		return socio.id;
	}


	public static boolean comprobarNotieneActividades(String id_socio, String fecha, String inicio, String fin) {
		SocioBLDto socio = ss.findSocioById(id_socio);
		String correoObtenido = socio.correo;
		List<ActividadSocioBLDto> actividadSocio = ass.findByCorreoSocio(correoObtenido);
		List<ActividadBLDto> listaActividad = new ArrayList<>();
		boolean result = true;
		for(ActividadSocioBLDto as: actividadSocio) {
			listaActividad.add(aser.findActividadById(as.id_actividad));
		}
		
		for(ActividadBLDto actividad: listaActividad) {
			if(actividad.fecha.equals(fecha) && actividad.hora_inicio.equals(inicio) ||
					actividad.fecha.equals(fecha) && comprobarHoras(actividad.hora_inicio, inicio, fin)) {
				result = false;
			}
		}
		return result;
	}
	
	private static boolean comprobarHoras(String horaRan, String inicio, String fin) {
		String[] i = inicio.split(":");
		int hora_inicio = Integer.parseInt(i[0]);

		String[] j = fin.split(":");
		int hora_fin = Integer.parseInt(j[0]);

		String[] r = horaRan.split(":");
		int hora1 = Integer.parseInt(r[0]);

		if (hora1 > hora_inicio && hora1 < hora_fin) {
			return false;
		}
		return true;
	}

	public static void eliminarAlquiler(String correo, String id_alquiler) {
		String socioId = ss.findByCorreo(correo).id;
		List<AlquilerBLDto> alquileres = als.findByIdSocio(socioId);
		AlquilerBLDto alquiler = null;
		for (AlquilerBLDto a : alquileres) {
			if (a.id.equals(id_alquiler)) {
				alquiler = a;
				alquiler.cancelado = 1;
			}
		}
		als.updateAlquiler(alquiler);

	}

	public List<String> findAlquilersBySocioCancelados(String correo) {
		String socioId = ss.findByCorreo(correo).id;
		List<AlquilerBLDto> alquileres = als.findByIdSocio(socioId);
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < alquileres.size(); i++) {
			if (alquileres.get(i).cancelado == 1) {
				String r = alquileres.get(i).id + " ------ " + alquileres.get(i).instalacion + " ------ "
						+ alquileres.get(i).fecha + " ------ " + alquileres.get(i).hora_inicio + " - "
						+ alquileres.get(i).hora_fin + " ----CANCELADO----";
				result.add(r);
			}
		}
		return result;
	}

	public static Socio buscarSocio(String id_socio) {
		SocioBLDto s = ss.findSocioById(id_socio);
		return new Socio(s.id, s.nombre, s.apellidos, s.contraseña);
	}
	
	public List<String> findRecursosByInstalacion(String instalacion) {
		List<RecursoBLDto> lista = rs.findRecursoByInstalacion(instalacion);
		List<String> result = new ArrayList<>();
		for(int i = 0; i < lista.size(); i++) {
			String a = lista.get(i).nombre + "\n";
			result.add(a);
		}
		return result;
	}

	public List<String> findRecursosByInstalacionNecesarios(String instalacion) {
		List<RecursosALlevarSocioBLDto> lista = ralss.findRecursoByInstalacion(instalacion);
		List<String> result = new ArrayList<>();
		for(int i = 0; i < lista.size(); i++) {
			String a = lista.get(i).nombre_recurso_a_llevar + "\n";
			result.add(a);
		}
		return result;
	}


}
