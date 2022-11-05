/**
 * 
 */
package database.ui.socio;

import console.Console;
import database.ui.socio.action.AddSocioAction;
import database.ui.socio.action.DeleteSocioAction;
import database.ui.socio.action.FindAllAction;
import database.ui.socio.action.UpdateSocioAction;

/**
 * @author UO285176
 *
 */
public class MenuSocio {
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
			new AddSocioAction().execute();
			break;
		case 2:
			new DeleteSocioAction().execute();
			break;
		case 3:
			new UpdateSocioAction().execute();
			break;
		case 4:
			new FindAllAction().execute();
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
		Console.println("Selecciona una opci�n: ");
		Console.println("1. Añadir un socio");
		Console.println("2. Eliminar un socio");
		Console.println("3. Actualizar un socio");
		Console.println("4. Listar socios");
		Console.println("0. Salir");
		Console.println("");
	}

}
