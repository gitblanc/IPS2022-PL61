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
		actividad.tipo = Console.readString("Tipo");
		actividad.intensidad = Console.readString("Intensidad");
		actividad.acceso = Console.readString("Acceso por");
		actividad.hora_inicio = Console.readString("Hora de inicio");
		actividad.hora_fin = Console.readString("Hora de finalización");
		actividad.instalacion = Console.readString("Instalación");
		actividad.fecha = Console.readString("Día");
		actividad.plazas = Console.readInt("Plazas");

		ActividadService as = BusinessFactory.forActividadService();
		as.updateActividad(actividad);
		Console.println("¡Actividad actualizada!");
		Console.println("");
	}

}
