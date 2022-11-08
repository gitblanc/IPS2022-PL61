package database.ui.actividadSocio.action;

import console.Console;
import database.business.BusinessFactory;
import database.business.actividadSocio.ActividadSocioService;
import database.business.actividadSocio.ActividadSocioService.ActividadSocioBLDto;
import database.ui.Action;

public class AddActividadSocioAction implements Action{

	@Override
	public void execute() {
		ActividadSocioBLDto actividadSocio = new ActividadSocioBLDto();
		actividadSocio.correo_socio = Console.readString("Correo del socio");
		actividadSocio.id_actividad = Console.readString("Id de la actividad");
		ActividadSocioService ass = BusinessFactory.forActividadSocioService();
		ass.addActividadSocio(actividadSocio);
		Console.print("Actividad añadida a socio determinado");
		Console.println("");
		
	}

}
