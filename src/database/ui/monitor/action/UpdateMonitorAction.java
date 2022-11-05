/**
 * 
 */
package database.ui.monitor.action;

import console.Console;
import database.business.BusinessFactory;
import database.business.monitor.MonitorService;
import database.business.monitor.MonitorService.MonitorBLDto;
import database.ui.Action;

/**
 * @author UO285176
 *
 */
public class UpdateMonitorAction implements Action {

	@Override
	public void execute() {
		MonitorBLDto monitor = new MonitorBLDto();
		Console.println("Escribe los nuevos datos del monitor que quieras:");
		monitor.id = Console.readString("Id");
		monitor.nombre = Console.readString("Nombre");
		monitor.apellidos = Console.readString("Apellidos");
		monitor.correo = Console.readString("Correo");
		MonitorService sm = BusinessFactory.forMonitorService();
		sm.updateMonitor(monitor);
		Console.println("¡Monitor actualizado!");
		Console.println("");
	}

}
