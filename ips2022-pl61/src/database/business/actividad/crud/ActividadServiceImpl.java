/**
 * 
 */
package database.business.actividad.crud;

import java.util.List;

import database.business.actividad.ActividadService;

/**
 * @author UO285176
 *
 */
public class ActividadServiceImpl implements ActividadService {

	@Override
	public ActividadBLDto addActividad(ActividadBLDto actividad) {
		return new AddActividad(actividad).execute();
	}

	@Override
	public void deleteActividad(String idActividad) {
		DeleteActividad da = new DeleteActividad(idActividad);
		da.execute();
	}

	@Override
	public void updateActividad(ActividadBLDto actividad) {
		UpdateActividad ua = new UpdateActividad(actividad);
		ua.execute();
	}

	@Override
	public ActividadBLDto findActividadById(String idActividad) {
		return new FindById(idActividad).execute();
	}

	@Override
	public List<ActividadBLDto> findAllActividades() {
		return new FindAllActividades().execute();
	}

	@Override
	public void planificarActividad(String tipo, String fecha, String hora_inicio, String hora_fin, String id) {
		new PlanificarActividad(tipo,fecha, hora_inicio, hora_fin, id).execute();
	}

	@Override
	public ActividadBLDto findByTipo(String tipo) {
		return new FindByTipo(tipo).execute();
	}

}
