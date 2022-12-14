package database.business.actividadSocio;

import java.util.List;

public interface ActividadSocioService {

	ActividadSocioBLDto addActividadSocio(ActividadSocioBLDto actividadSocio);
	
	List<ActividadSocioBLDto> findAllActividadSocio();
	
	public class ActividadSocioBLDto {

		public String id_actividad;
		public String correo_socio;

	}

	void deleteActividadSocio(String id, String correo);

	List<ActividadSocioBLDto> findByCorreoSocio(String correo);
}
