/**
 * 
 */
package database.business.recurso.crud;

import java.util.List;

import database.business.recurso.RecursoService;

/**
 * @author uo276967
 *
 */
public class RecursoServiceImpl implements RecursoService{

	@Override
	public RecursoBLDto addRecurso(RecursoBLDto recurso) {
		return new AddRecurso(recurso).execute();
	}

	@Override
	public void deleteRecurso(String nombreRecurso) {
		DeleteRecurso dr = new DeleteRecurso(nombreRecurso);
		dr.execute();
		
	}

	@Override
	public void updateRecurso(RecursoBLDto recurso) {
		UpdateRecurso ur = new UpdateRecurso(recurso);
		ur.execute();
		
	}

	@Override
	public List<RecursoBLDto> findAllRecursos() {
		return new FindAllRecursos().execute();
	}

	@Override
	public List<RecursoBLDto> findRecursoByInstalacion(String instalacion) {
		FindAllRecursosByInstalacion fi = new FindAllRecursosByInstalacion(instalacion);
		return fi.execute();
	}

	
}
