/**
 * 
 */
package database.ui.socio.action;

import console.Console;
import database.business.BusinessFactory;
import database.business.socio.SocioService;
import database.business.socio.SocioService.SocioBLDto;
import database.ui.Action;

/**
 * @author UO285176
 *
 */
public class FindAllAction implements Action {

	@Override
	public void execute() {
		Console.println("--- Lista de socios ---");
		SocioService ss = BusinessFactory.forSocioService();
		for (SocioBLDto s : ss.findAllSocios())
			Console.println(s.id + " - " + s.nombre + " - " + s.apellidos + " - " + s.correo + " - " + s.contraseña);
	}

}
