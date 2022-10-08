/**
 * 
 */
package database.ui.recursosActividad;

import console.Console;

/**
 * @author UO285176
 *
 */
public class MenuRecursosActividad {
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
			new AddRecursosActividadAction().execute();
			break;
		case 2:
			new FindAllRecursosActividadesAction().execute();
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
		Console.println("1. Añadir un recurso a una actividad");
		Console.println("2. Listar actividades");
		Console.println("0. Salir");
		Console.println("");
	}
}
