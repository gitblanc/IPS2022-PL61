package logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import database.business.BusinessFactory;
import database.business.actividad.ActividadService;
import database.business.actividad.ActividadService.ActividadBLDto;
import database.business.actividadSocio.ActividadSocioService;
import database.business.actividadSocio.ActividadSocioService.ActividadSocioBLDto;
import database.business.socio.SocioService;
import database.business.socio.SocioService.SocioBLDto;

public class Socio {

	private static SocioService ss = BusinessFactory.forSocioService();
	private static ActividadSocioService ass = BusinessFactory.forActividadSocioService();
	private static ActividadService as = BusinessFactory.forActividadService();

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
		return as.findAllActividades();
	}

	// ------------------------------------------------------------

	/**
	 * Método que encuentra las actividades de cada socio
	 */
	public List<String> findActivitiesBySocio(String correo) {
		List<ActividadSocioBLDto> actividadesApuntadas = listarActividadSocio();
		List<ActividadBLDto> actividades = listarTodasLAsActividades();
		List<String> lista = new ArrayList<String>();
		for (int i = 0; i < actividadesApuntadas.size(); i++) {
			if (actividadesApuntadas.get(i).correo_socio.equals(correo)) {
				for (int j = 0; j < actividades.size(); j++) {
					if (actividadesApuntadas.get(i).id_actividad.equals(actividades.get(j).id)) {
						//solo se muestran mis actividades más proximaas
						if(fechaMasProxima(LocalDate.now(), actividades.get(j).fecha)) {
							String a = "Actividad: " + actividades.get(j).tipo + " ----- Fecha: " + actividades.get(j).fecha
									+ " ----- Hora: " + actividades.get(j).hora_inicio + " - " + actividades.get(j).hora_fin
									+ " ----- Instalación: " + actividades.get(j).instalacion;
							lista.add(a);
						}
						
					}
				}
			}
		}

		return lista;
	}
	
	private boolean fechaMasProxima(LocalDate l, String fechaActividad) { 
		String[] date = fechaActividad.split("/");
		int day = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);
		LocalDate ac = LocalDate.of(year, month, day);
		
		l = LocalDate.now();
		
		return l.isBefore(ac);
		
		
	}
	
	public static String[] listarSociosPorCorreo(){
		List<SocioBLDto> socios = ss.findAllSocios();
		String[] todosLosSocios = new String[socios.size()];
		todosLosSocios[0] = "Seleccione uno";
		for(int i = 1; i < socios.size(); i++) {
			todosLosSocios[i] = socios.get(i).correo;
		}
		return todosLosSocios;
		
	}
	

}