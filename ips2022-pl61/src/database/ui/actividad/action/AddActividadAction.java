/**
 * 
 */
package database.ui.actividad.action;

import console.Console;
import database.business.BusinessFactory;
import database.business.actividad.ActividadService;
import database.business.actividad.ActividadService.ActividadBLDto;
import database.ui.Action;

/**
 * @author UO285176
 *
 */
public class AddActividadAction implements Action{

	@Override
	public void execute() {
		ActividadBLDto actividad = new ActividadBLDto();
		//Get info
		actividad.id = Console.readString("Id");
		actividad.nombre = Console.readString("Nombre");
		
		ActividadService as = BusinessFactory.forActividadService();
		as.addActividad(actividad);
		//Print result
		Console.print("�Actividad a�adida!");
		Console.println("");
	}

}