package database.business.recursosALlevarSocio;

import java.util.List;

public interface RecursosALlevarSocioService {

	public class RecursosALlevarSocioBLDto {
		public String nombre_recurso_a_llevar;
		public String nombre_instalacion;
	}
	
	// Listado de recursos por instalacion
		List<RecursosALlevarSocioBLDto> findRecursoByInstalacion(String instalacion);
}
