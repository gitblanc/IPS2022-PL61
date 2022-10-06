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
public class DeleteAdminAction implements Action {

	@Override
	public void execute() {
		AdministradorBLDto admin = new AdministradorBLDto();
		admin.id = Console.readString("Introduce el id del administrador");
		AdministracionService sm = BusinessFactory.forAdministracionService();
		sm.deleteAdministrador(admin.id);
		Console.println("¡Administrador eliminado!");
	}

}
