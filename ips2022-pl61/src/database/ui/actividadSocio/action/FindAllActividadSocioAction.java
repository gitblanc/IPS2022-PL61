package database.ui.actividadSocio.action;

import console.Console;
import database.business.BusinessFactory;
import database.business.actividadSocio.ActividadSocioService;
import database.business.actividadSocio.ActividadSocioService.ActividadSocioBLDto;
import database.ui.Action;

public class FindAllActividadSocioAction implements Action{

	@Override
	public void execute() {
		Console.println("--- Lista de socios con actividades ---");
		ActividadSocioService ass = BusinessFactory.forActividadSocioService();
		for (ActividadSocioBLDto as : ass.findAllActividadSocio())
			Console.println(as.correo_socio + " - " + as.id_actividad);
		
	}

}
