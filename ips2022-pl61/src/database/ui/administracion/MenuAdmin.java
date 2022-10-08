/**
 * 
 */
package database.ui.administracion;

import console.Console;
import database.ui.administracion.action.AddAdminAction;
import database.ui.administracion.action.DeleteAdminAction;
import database.ui.administracion.action.FindAllAdminsAction;
import database.ui.administracion.action.UpdateAdminAction;

/**
 * @author UO285176
 *
 */
public class MenuAdmin {
	private static final int EXIT = 0;

	public static void main(String[] args) {
		execute();
	}

	private static void execute() {
		int opt;

		do {
			showMenu();
			opt = getMenuOption();
			try {
				processOption(opt);

			} catch (RuntimeException rte) {
				System.out.println(rte);
				return;

			} catch (Exception be) {
				System.out.println(be);
			}
		} while (opt != EXIT);
	}

	private static void processOption(int option) {
		switch (option) {
		case EXIT:
			return;
		case 1:
			new AddAdminAction().execute();
			break;
		case 2:
			new DeleteAdminAction().execute();
			break;
		case 3:
			new UpdateAdminAction().execute();
			break;
		case 4:
			new FindAllAdminsAction().execute();
			break;
		}

	}

	private static int getMenuOption() {
		Integer opt;

		do {
			Console.print("Opción:");
			opt = Console.readInt();

		} while (opt == null || opt < EXIT);

		return opt;
	}

	private static void showMenu() {
		Console.println("");
		Console.println("Selecciona una opción: ");
		Console.println("1. Añadir un administrador");
		Console.println("2. Eliminar un administrador");
		Console.println("3. Actualizar un administrador");
		Console.println("4. Listar administrador");
		Console.println("0. Salir");
		Console.println("");
	}
}
