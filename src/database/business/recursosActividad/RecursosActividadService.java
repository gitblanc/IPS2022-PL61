/**
 * 
 */
package database.business.recursosActividad;

import java.util.List;

/**
 * @author UO285176
 *
 */
public interface RecursosActividadService {

	RecursosActividadBLDto addRecursosActividad(RecursosActividadBLDto recursoActividad);
	
	List<RecursosActividadBLDto> findAllRecursosActividades();
	public class RecursosActividadBLDto {

		public String actividad;
		public String recurso;

	}
}
