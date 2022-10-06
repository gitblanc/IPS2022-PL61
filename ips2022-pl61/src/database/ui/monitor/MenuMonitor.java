package database.ui.monitor;

import console.Console;
import database.ui.monitor.action.AddMonitorAction;
import database.ui.monitor.action.DeleteMonitorAction;
import database.ui.monitor.action.FindAllMonitoresAction;
import database.ui.monitor.action.UpdateMonitorAction;

public class MenuMonitor {
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
			new AddMonitorAction().execute();
			break;
		case 2:
			new DeleteMonitorAction().execute();
			break;
		case 3:
			new UpdateMonitorAction().execute();
			break;
		case 4:
			new FindAllMonitoresAction().execute();
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
		Console.println("1. Añadir un monitor");
		Console.println("2. Eliminar un monitor");
		Console.println("3. Actualizar un monitor");
		Console.println("4. Listar monitores");
		Console.println("0. Salir");
		Console.println("");
	}
}
