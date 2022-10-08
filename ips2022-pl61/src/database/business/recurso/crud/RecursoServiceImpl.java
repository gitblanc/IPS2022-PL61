/**
 * 
 */
package database.business.recurso.crud;

import java.util.List;
import java.util.Optional;

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
	public Optional<RecursoBLDto> findRecursoByName(String nombreRecurso) {
		// TODO Auto-generated method stub
				return null;
	}

	@Override
	public List<RecursoBLDto> findAllRecursos() {
		return new FindAllRecursos().execute();
	}

	
}
