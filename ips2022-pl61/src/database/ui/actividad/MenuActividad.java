/**
 * 
 */
package database.ui.actividad;

import console.Console;
import database.ui.actividad.action.AddActividadAction;
import database.ui.actividad.action.DeleteActividadAction;
import database.ui.actividad.action.FindAllActividadesAction;
import database.ui.actividad.action.UpdateActividadAction;

/**
 * @author UO285176
 *
 */
public class MenuActividad {
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
			new AddActividadAction().execute();
			break;
		case 2:
			new DeleteActividadAction().execute();
			break;
		case 3:
			new UpdateActividadAction().execute();
			break;
		case 4:	
			new FindAllActividadesAction().execute();
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
		Console.println("1. Añadir una actividad");
		Console.println("2. Eliminar una actividad");
		Console.println("3. Actualizar una actividad");
		Console.println("4. Listar actividades");
		Console.println("0. Salir");
		Console.println("");
	}
}
