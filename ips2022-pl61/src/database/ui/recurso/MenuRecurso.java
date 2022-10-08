/**
 * 
 */
package database.ui.recurso;

import console.Console;
import database.ui.recurso.action.AddRecursoAction;
import database.ui.recurso.action.DeleteRecursoAction;
import database.ui.recurso.action.FindAllRecursosAction;
import database.ui.recurso.action.UpdateRecursoAction;

/**
 * @author uo276969
 *
 */
public class MenuRecurso {

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
			new AddRecursoAction().execute();
			break;
		case 2:
			new DeleteRecursoAction().execute();
			break;
		case 3:
			new UpdateRecursoAction().execute();
			break;
		case 4:
			new FindAllRecursosAction().execute();
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
		Console.println("1. Añadir un recurso");
		Console.println("2. Eliminar un recurso");
		Console.println("3. Actualizar un recurso");
		Console.println("4. Listar recursos");
		Console.println("0. Salir");
		Console.println("");
	}
}
