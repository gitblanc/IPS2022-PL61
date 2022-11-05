/**
 * 
 */
package database.business.recursosActividad.crud;

import java.util.List;

import database.business.recursosActividad.RecursosActividadService;

/**
 * @author UO285176
 *
 */
public class RecursosActividadServiceImpl implements RecursosActividadService {

	@Override
	public RecursosActividadBLDto addRecursosActividad(RecursosActividadBLDto recursoActividad) {
		return new AddRecursoActividad(recursoActividad).execute();
	}

	@Override
	public List<RecursosActividadBLDto> findAllRecursosActividades() {
		return new FindAllRecursosActividad().execute();
	}

}
