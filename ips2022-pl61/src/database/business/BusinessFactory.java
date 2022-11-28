/**
 * 
 */
package database.business;

import database.business.actividad.ActividadService;
import database.business.actividad.crud.ActividadServiceImpl;
import database.business.actividadSocio.ActividadSocioService;
import database.business.actividadSocio.crud.ActividadSocioServiceImpl;
import database.business.administracion.AdministracionService;
import database.business.administracion.crud.AdministracionServiceImpl;
import database.business.alquiler.AlquilerService;
import database.business.alquiler.crud.AlquilerServiceImpl;
import database.business.instalacion.InstalacionService;
import database.business.instalacion.crud.InstalacionServiceImpl;
import database.business.monitor.MonitorService;
import database.business.monitor.crud.MonitorServiceImpl;
import database.business.recurso.RecursoService;
import database.business.recurso.crud.RecursoServiceImpl;
import database.business.recursosALlevarSocio.RecursosALlevarSocioService;
import database.business.recursosALlevarSocio.crud.RecursosALlevarSocioServiceImpl;
import database.business.recursosActividad.RecursosActividadService;
import database.business.recursosActividad.crud.RecursosActividadServiceImpl;
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

	public static ActividadService forActividadService() {
		return new ActividadServiceImpl();
	}

	public static RecursoService forRecursoService() {
		return new RecursoServiceImpl();
	}

	public static RecursosActividadService forRecursosActividadService() {
		return new RecursosActividadServiceImpl();
	}

	public static InstalacionService forInstalacionService() {
		return new InstalacionServiceImpl();
	}
	
	public static ActividadSocioService forActividadSocioService() {
		return new ActividadSocioServiceImpl();
	}
	
	public static AlquilerService forAlquilerService() {
		return new AlquilerServiceImpl();
	}
	
	public static RecursosALlevarSocioService forRecursosALlevarSocioService() {
		return new RecursosALlevarSocioServiceImpl();
	}
	
}
