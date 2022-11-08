package database.ui.actividadSocio;

import console.Console;
import database.ui.actividadSocio.action.AddActividadSocioAction;
import database.ui.actividadSocio.action.FindAllActividadSocioAction;

public class menuActividadSocio {
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
			new AddActividadSocioAction().execute();
			break;
		case 2:
			new FindAllActividadSocioAction().execute();
			break;
		}

	}

	private static int getMenuOption() {
		Integer opt;

		do {
			Console.print("Opci�n:");
			opt = Console.readInt();

		} while (opt == null || opt < EXIT);

		return opt;
	}

	private static void showMenu() {
		Console.println("");
		Console.println("Selecciona una opci�n: ");
		Console.println("1. Añadir un a un socio una actividad");
		Console.println("2. Listar las actividades con los socios");
		Console.println("0. Salir");
		Console.println("");
	}
}
