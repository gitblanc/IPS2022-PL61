/**
 * 
 */
package logic;

/**
 * @author UO281576
 *
 */
public class Administrador {

	/**
	 * M�todo que permite que el administrador cree una actividad llamando al m�todo
	 * de la clase Actividad
	 * 
	 * @param id
	 * @param nombre
	 * @param intensidad
	 * @param recurso
	 */
	public boolean crearActividad(String id, String nombre, String intensidad, String recurso) {
		Actividad actividad = new Actividad();
		return actividad.crearActividad(id, nombre, intensidad, recurso);
	}
}
