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
public class FindAllActividadesAction implements Action {

	@Override
	public void execute() {
		Console.println("--- Lista de actividades ---");
		ActividadService sm = BusinessFactory.forActividadService();
		for (ActividadBLDto s : sm.findAllActividades())
			Console.println(s.id + " - " + s.nombre + " - " + s.intensidad);
	}

}
