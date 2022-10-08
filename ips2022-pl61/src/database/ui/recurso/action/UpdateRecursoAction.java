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
 * @author uo276967
 *
 */
public class UpdateRecursoAction implements Action {

	@Override
	public void execute() {
		RecursoBLDto recurso = new RecursoBLDto();
		Console.println("Escribe los nuevos datos del recurso que quieras:");
		recurso.nombre = Console.readString("Nombre");
		recurso.cantidad = Console.readInt("Cantidad");
		RecursoService rs = BusinessFactory.forRecursoService();
		rs.updateRecurso(recurso);
		Console.println("¡Recurso actualizado!");
		Console.println("");
	}

}
