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
public class DeleteActividadAction implements Action {

	@Override
	public void execute() {
		ActividadBLDto actividad = new ActividadBLDto();
		actividad.id = Console.readString("Introduce el id de la actividad");
		ActividadService as = BusinessFactory.forActividadService();
		as.deleteActividad(actividad.id);
		Console.println("¡Actividad eliminada!");
	}

}
