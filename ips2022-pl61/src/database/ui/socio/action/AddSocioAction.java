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
public class AddSocioAction implements Action{

	@Override
	public void execute() {
		SocioBLDto socio = new SocioBLDto();
		//Get info
		socio.id = Console.readString("Id");
		socio.nombre = Console.readString("Nombre");
		socio.apellidos = Console.readString("Apellidos");
		socio.correo = Console.readString("Correo");
		
		SocioService ss = BusinessFactory.forSocioService();
		socio = ss.addSocio(socio);
		//Print result
		Console.println("¡Socio añadido!");
		Console.println("");
	}

}
