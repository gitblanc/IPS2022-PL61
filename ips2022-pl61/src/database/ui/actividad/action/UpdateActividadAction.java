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
public class UpdateActividadAction implements Action {

	@Override
	public void execute() {
		ActividadBLDto actividad = new ActividadBLDto();
		Console.println("Escribe los nuevos datos de la actividad que quieras:");
		actividad.id = Console.readString("Id");
		actividad.nombre = Console.readString("Nombre");
		actividad.intensidad = Console.readString("Intensidad");
		actividad.acceso = Console.readString("Acceso por");
		actividad.horario = Console.readString("Horario");
		ActividadService as = BusinessFactory.forActividadService();
		as.updateActividad(actividad);
		Console.println("¡Actividad actualizada!");
		Console.println("");
	}

}
