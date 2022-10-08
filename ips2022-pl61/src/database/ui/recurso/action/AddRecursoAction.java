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
public class AddRecursoAction implements Action {

	@Override
	public void execute() {
		RecursoBLDto recurso = new RecursoBLDto();
		//Get info
		recurso.nombre = Console.readString("Nombre");
		recurso.cantidad = Console.readInt("Cantidad");
		
		RecursoService rs = BusinessFactory.forRecursoService();
		recurso = rs.addRecurso(recurso);
		//Print result
		Console.println("¡Recurso añadido!");
		Console.println("");
	}
}
