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
public class UpdateAdminAction implements Action {

	@Override
	public void execute() {
		AdministradorBLDto admin = new AdministradorBLDto();
		Console.println("Escribe los nuevos datos del admin que quieras:");
		admin.id = Console.readString("Id");
		admin.nombre = Console.readString("Nombre");
		admin.apellidos = Console.readString("Apellidos");
		admin.correo = Console.readString("Correo");
		AdministracionService sm = BusinessFactory.forAdministracionService();
		sm.updateAdministrador(admin);
		Console.println("¡Administrador actualizado!");
		Console.println("");
	}

}
