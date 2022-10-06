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
public class FindAllMonitoresAction implements Action {

	@Override
	public void execute() {
		Console.println("--- Lista de monitorwas ---");
		MonitorService sm = BusinessFactory.forMonitorService();
		for (MonitorBLDto s : sm.findAllMonitor())
			Console.println(s.id + " - " + s.nombre + " - " + s.apellidos + " - " + s.correo);
	}

}
