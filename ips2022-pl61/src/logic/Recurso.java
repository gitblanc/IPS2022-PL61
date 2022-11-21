/**
 * 
 */
package logic;

import java.util.List;

import database.business.BusinessFactory;
import database.business.recurso.RecursoService;
import database.business.recurso.RecursoService.RecursoBLDto;

/**
 * @author UO285176
 *
 */
public class Recurso {

	private static RecursoService rs = BusinessFactory.forRecursoService();

	public static String[] listarRecursosPorInstalacion(String instalacion) {
		List<RecursoBLDto> recursos = rs.findRecursoByInstalacion(instalacion);
		String[] recursosInstalacion = new String[recursos.size()];
		for (int i = 0; i < recursos.size(); i++) {
			recursosInstalacion[i] = recursos.get(i).nombre;
		}
		return recursosInstalacion;
	}

	public static String[] listarTodosLosRecursos() {
		List<RecursoBLDto> recursos = rs.findAllRecursos();
		String[] recursosInstalacion = new String[recursos.size()];
		for (int i = 0; i < recursos.size(); i++) {
			recursosInstalacion[i] = recursos.get(i).nombre;
		}
		return recursosInstalacion;
	}

}
