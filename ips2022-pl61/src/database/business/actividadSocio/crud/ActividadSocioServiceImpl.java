package database.business.actividadSocio.crud;

import java.util.List;

import database.business.actividadSocio.ActividadSocioService;

public class ActividadSocioServiceImpl implements ActividadSocioService {

	@Override
	public ActividadSocioBLDto addActividadSocio(ActividadSocioBLDto actividadSocio) {
		return new AddActividadSocio(actividadSocio).execute();
	}

	@Override
	public List<ActividadSocioBLDto> findAllActividadSocio() {
		return new FindAllActividadSocio().execute();
	}

	@Override
	public void deleteActividadSocio(String id, String correo) {
		new DeleteActividadSocio(id, correo).execute();
	}
}
