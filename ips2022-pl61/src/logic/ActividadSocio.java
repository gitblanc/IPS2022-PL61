package logic;

import database.business.BusinessFactory;
import database.business.actividadSocio.ActividadSocioService;
import database.business.actividadSocio.ActividadSocioService.ActividadSocioBLDto;

public class ActividadSocio {

	private String id_actividad;
	private String correo_socio;
	
	public ActividadSocio(String id, String correo ) {
		this.id_actividad = id;
		this.correo_socio = correo;
	}
	
	private static ActividadSocioService ass = BusinessFactory.forActividadSocioService();
	
	public boolean addActividadSocio(String correo, String id_a) {
		ActividadSocioBLDto acSocio = new ActividadSocioBLDto();
//		//if(correo.isBlank() || correo.isEmpty() || correo == null || id_a.isBlank() || id_a.isEmpty() ||
//				id_a == null) {
//			return false;
//		}
		acSocio.correo_socio = correo;
		acSocio.id_actividad = id_a;
		ass.addActividadSocio(acSocio);
		return true;
	}

	public String getId_actividad() {
		return id_actividad;
	}

	public void setId_actividad(String id_actividad) {
		this.id_actividad = id_actividad;
	}

	public String getCorreo_socio() {
		return correo_socio;
	}

	public void setCorreo_socio(String correo_socio) {
		this.correo_socio = correo_socio;
	}
	
	public boolean deleteActividadSocio(String correo, String id_a) {
		ActividadSocioBLDto acSocio = new ActividadSocioBLDto();
		acSocio.correo_socio = correo;
		acSocio.id_actividad = id_a;
		ass.deleteActividadSocio(acSocio);
		return true;
	}
	
}
