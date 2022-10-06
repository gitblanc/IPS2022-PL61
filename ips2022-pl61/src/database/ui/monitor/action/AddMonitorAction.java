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
public class AddMonitorAction implements Action{

	@Override
	public void execute() {
		MonitorBLDto monitor = new MonitorBLDto();
		//Get info
		monitor.id = Console.readString("Id");
		monitor.nombre = Console.readString("Nombre");
		monitor.apellidos = Console.readString("Apellidos");
		monitor.correo = Console.readString("Correo");
		
		MonitorService ms = BusinessFactory.forMonitorService();
		monitor = ms.addMonitor(monitor);
		//Print result
		Console.println("¡Monitor añadido!");
		Console.println("");
	}

}
