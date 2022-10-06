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
public class UpdateSocioAction implements Action{

	@Override
	public void execute() {
		SocioBLDto socio = new SocioBLDto();
		Console.println("Escribe los nuevos datos del socio que quieras:");
		socio.id = Console.readString("Id");
		socio.nombre = Console.readString("Nombre");
		socio.apellidos = Console.readString("Apellidos");
		socio.correo = Console.readString("Correo");
		SocioService ss = BusinessFactory.forSocioService();
		ss.updateSocio(socio);
		Console.println("¡Socio actualizado!");
		Console.println("");
	}

}
