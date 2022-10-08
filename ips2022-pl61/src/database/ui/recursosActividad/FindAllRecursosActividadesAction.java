/**
 * 
 */
package database.ui.recursosActividad;

import console.Console;
import database.business.BusinessFactory;
import database.business.recursosActividad.RecursosActividadService;
import database.business.recursosActividad.RecursosActividadService.RecursosActividadBLDto;
import database.ui.Action;

/**
 * @author UO285176
 *
 */
public class FindAllRecursosActividadesAction implements Action {

	@Override
	public void execute() {
		Console.println("--- Lista de recursos por actividad ---");
		RecursosActividadService sm = BusinessFactory.forRecursosActividadService();
		for (RecursosActividadBLDto s : sm.findAllRecursosActividades())
			Console.println(s.actividad + " - " + s.recurso);
	}

}
