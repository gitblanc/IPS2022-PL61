package database.business.recursosALlevarSocio.crud;

import java.util.List;

import database.business.recursosALlevarSocio.RecursosALlevarSocioService;

public class RecursosALlevarSocioServiceImpl implements RecursosALlevarSocioService {

	@Override
	public List<RecursosALlevarSocioBLDto> findRecursoByInstalacion(String instalacion) {
		return new FindRecursoByInstalacion(instalacion).execute();
	}

}
