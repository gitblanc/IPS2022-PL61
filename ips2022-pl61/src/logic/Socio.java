package logic;

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
	
	//Cada socio tiene una lista de actividades a la que está inscrito
	private List<ActividadSocioBLDto> actividadesApuntadas = ass.findAllActividadSocio();
	private List<ActividadBLDto> actividades = as.findAllActividades();
	
	public String socioCorrecto(String correo, String contraseña) {
		String correcto = null;
		if (!validarParametros(correo, contraseña))
			correcto = null;
		List<SocioBLDto> lista = ss.findAllSocios();
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).correo.equals(correo)) {
				if(lista.get(i).contraseña.equals(contraseña)) {
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

	private boolean validarParametros(String correo, String contraseña) {
		if(correo == null || contraseña == null ) {
			return false;
		}
		return true;
	}
	
	
	//------------------------------------------------------------
	
	/**
	 * Método que encuentra las actividades de cada socio
	 */
	public List<String> findActivitiesBySocio(String correo) {
		List<String> lista = new ArrayList<String>();
		for(int i = 0; i < actividadesApuntadas.size(); i++) {
			if(actividadesApuntadas.get(i).correo_socio.equals(correo)) {
				 for(int j = 0; j < actividades.size(); j++) {
					 if(actividadesApuntadas.get(i).id_actividad.equals(actividades.get(j).id)) {
						 String a = "Actividad: " + actividades.get(j).nombre + " ----- Fecha: " +
								 actividades.get(j).fecha + " ----- Hora: " + actividades.get(j).hora_inicio + " - " +
								 actividades.get(j).hora_fin + " ----- Instalación: " + actividades.get(j).instalacion;
						 lista.add(a);
					 }
				 }
			}
		}
		
		return lista;
	}
	
	
	
	
}
