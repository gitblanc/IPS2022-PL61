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
 * @author chenx
 *
 */
public class DeleteRecursoAction implements Action {

	@Override
	public void execute() {
		RecursoBLDto recurso = new RecursoBLDto();
		recurso.nombre = Console.readString("Introduce el nombre del recurso");
		RecursoService rs = BusinessFactory.forRecursoService();
		rs.deleteRecurso(recurso.nombre);
		Console.println("¡Recurso eliminado!");
	}

}
