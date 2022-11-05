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
public class AddRecursosActividadAction implements Action{

	@Override
	public void execute() {
		RecursosActividadBLDto recursosActividad = new RecursosActividadBLDto();
		recursosActividad.actividad = Console.readString("Id actividad");
		recursosActividad.recurso = Console.readString("Nombre recurso");
		RecursosActividadService ras = BusinessFactory.forRecursosActividadService();
		ras.addRecursosActividad(recursosActividad);
		Console.print("¡Recurso añadido a actividad!");
		Console.println("");
	}

}
