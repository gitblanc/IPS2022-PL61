package logic;

import java.util.ArrayList;
import java.util.List;

import database.business.BusinessFactory;
import database.business.socio.SocioService;
import database.business.socio.SocioService.SocioBLDto;

public class Socio {
	
	private static SocioService ss = BusinessFactory.forSocioService();
	
	//Cada socio tiene una lista de actividades a la que está inscrito
	private List<Actividad> actividadesApuntadas = new ArrayList<Actividad>();
	
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
	 * Mçetodo que añade una actividad al sociio
	 * @param actividad de tipo Actividad
	 */
	public void addActividad(Actividad actividad) {
		actividadesApuntadas.add(actividad);
	}

	/**
	 * Método que devuelve todas las actividades apuntadas por el socio
	 * @return
	 */
	public  List<Actividad> listarActividadesApuntadas() {
		return actividadesApuntadas;
	}
	
	
	
	
	
}
