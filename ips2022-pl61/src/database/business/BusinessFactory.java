/**
 * 
 */
package database.business;

import database.business.administracion.AdministracionService;
import database.business.administracion.crud.AdministracionServiceImpl;
import database.business.monitor.MonitorService;
import database.business.monitor.crud.MonitorServiceImpl;
import database.business.socio.SocioService;
import database.business.socio.crud.SocioServiceImpl;

/**
 * @author UO285176
 *
 */
public class BusinessFactory {
	public static SocioService forSocioService() {
		return new SocioServiceImpl();
	}
	
	public static MonitorService forMonitorService() {
		return new MonitorServiceImpl();
	}
	
	public static AdministracionService forAdministracionService() {
		return new AdministracionServiceImpl();
	}
}
