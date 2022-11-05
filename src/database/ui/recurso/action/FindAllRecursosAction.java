package database.ui.recurso.action;

import console.Console;
import database.business.BusinessFactory;
import database.business.recurso.RecursoService;
import database.business.recurso.RecursoService.RecursoBLDto;
import database.ui.Action;

/**
 * 
 * @author uo276967
 *
 */
public class FindAllRecursosAction implements Action {

	@Override
	public void execute() {
		Console.println("--- Lista de recursos ---");
		RecursoService rs = BusinessFactory.forRecursoService();
		for (RecursoBLDto r : rs.findAllRecursos())
			Console.println(r.nombre + " - " + r.cantidad + " - " + r.instalacion);
	}

}
