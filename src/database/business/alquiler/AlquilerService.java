/**
 * 
 */
package database.business.alquiler;

import java.util.List;

/**
 * @author UO285176
 *
 */
public interface AlquilerService {
	
	void updateAlquiler(AlquilerBLDto alquiler);

	public class AlquilerBLDto{
		public String id;
		public String instalacion;
		public String fecha;
		public String hora_inicio;
		public String hora_fin;
		public String id_socio;
	}

	List<AlquilerBLDto> findAll();
}
