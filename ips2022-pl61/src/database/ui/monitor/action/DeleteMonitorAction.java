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
public class DeleteMonitorAction implements Action {

	@Override
	public void execute() {
		MonitorBLDto monitor = new MonitorBLDto();
		monitor.id = Console.readString("Introduce el id del monitor");
		MonitorService sm = BusinessFactory.forMonitorService();
		sm.deleteMonitor(monitor.id);
		Console.println("¡Monitor eliminado!");
	}

}
