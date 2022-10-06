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
public class AddAdminAction implements Action {

	@Override
	public void execute() {
		AdministradorBLDto admin = new AdministradorBLDto();
		// Get info
		admin.id = Console.readString("Id");
		admin.nombre = Console.readString("Nombre");
		admin.apellidos = Console.readString("Apellidos");
		admin.correo = Console.readString("Correo");

		AdministracionService ms = BusinessFactory.forAdministracionService();
		ms.addAdministracion(admin);
		// Print result
		Console.println("¡Administrador añadido!");
		Console.println("");

	}

}
