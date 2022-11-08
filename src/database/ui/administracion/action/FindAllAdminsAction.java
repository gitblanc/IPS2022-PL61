/**
 * 
 */
package database.ui.administracion.action;

import console.Console;
import database.business.BusinessFactory;
import database.business.administracion.AdministracionService;
import database.business.administracion.AdministracionService.AdministradorBLDto;
import database.ui.Action;

/**
 * @author UO285176
 *
 */
public class FindAllAdminsAction implements Action{

	@Override
	public void execute() {
		Console.println("--- Lista de administradores ---");
		AdministracionService sm = BusinessFactory.forAdministracionService();
		for (AdministradorBLDto s : sm.findAllAdministracion())
			Console.println(s.id + " - " + s.nombre + " - " + s.apellidos + " - " + s.correo);
	}

}
