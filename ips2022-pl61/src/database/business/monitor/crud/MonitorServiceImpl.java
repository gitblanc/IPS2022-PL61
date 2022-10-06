/**
 * 
 */
package database.business.monitor.crud;

import java.util.List;
import java.util.Optional;

import database.business.monitor.MonitorService;

/**
 * @author UO285176
 *
 */
public class MonitorServiceImpl implements MonitorService {

	@Override
	public MonitorBLDto addMonitor(MonitorBLDto monitor) {
		return new AddMonitor(monitor).execute();
	}

	@Override
	public void deleteMonitor(String idMonitor) {
		DeleteMonitor dm = new DeleteMonitor(idMonitor);
		dm.execute();
	}

	@Override
	public void updateMonitor(MonitorBLDto monitor) {
		UpdateMonitor um = new UpdateMonitor(monitor);
		um.execute();
	}

	@Override
	public Optional<MonitorBLDto> findMonitorById(String idMonitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MonitorBLDto> findAllMonitor() {
		return new FindAllMonitors().execute();
	}

}
