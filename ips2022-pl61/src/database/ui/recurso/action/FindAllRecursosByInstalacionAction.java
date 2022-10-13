/**
 * 
 */
package database.ui.recurso.action;

import console.Console;
import database.business.BusinessFactory;
import database.business.recurso.RecursoService;
import database.business.recurso.RecursoService.RecursoBLDto;
import database.ui.Action;

/**
 * @author UO285176
 *
 */
public class FindAllRecursosByInstalacionAction implements Action{

	@Override
	public void execute() {
		String instalacion = Console.readString("Nombre de la instalacion");
		Console.println("--- Lista de recursos de " + instalacion + "---");
		RecursoService rs = BusinessFactory.forRecursoService();
		for (RecursoBLDto r : rs.findRecursoByInstalacion(instalacion))
			Console.println(r.nombre + " - " + r.cantidad + " - " + r.instalacion);
	}

}
