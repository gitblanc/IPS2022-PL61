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
public class DeleteSocioAction implements Action {

	@Override
	public void execute() {
		SocioBLDto socio = new SocioBLDto();
		socio.id = Console.readString("Introduce el id del socio");
		SocioService ss = BusinessFactory.forSocioService();
		ss.deleteSocio(socio.id);
		Console.println("¡Socio eliminado!");
	}

}
