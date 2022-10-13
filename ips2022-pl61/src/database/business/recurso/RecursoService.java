package database.business.recurso;

import java.util.List;


/**
 * 
 * @author uo276967
 *
 */
public interface RecursoService {

	// Le pasamos el recurso a a�adir
	RecursoBLDto addRecurso(RecursoBLDto recurso);

	// Le pasamos el nombre del recurso a eliminar a eliminar
	void deleteRecurso(String nombreRecurso);

	// Le pasamos el recurso a actualizar
	void updateRecurso(RecursoBLDto recurso);

	// Listado de recursos por instalacion
	List<RecursoBLDto> findRecursoByInstalacion(String instalacion);

	// Devuelve una lista con todos los recursos
	List<RecursoBLDto> findAllRecursos();
	
	
	public class RecursoBLDto {
		public String nombre;
		public int cantidad;
		public String instalacion;
	}
	
	
}
