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
	 * Método que permite que el administrador cree una actividad llamando al m�todo
	 * de la clase Actividad
	 * 
	 * @param id
	 * @param nombre
	 * @param intensidad
	 * @param recurso
	 * @param acceso
	 * @param instalacion
	 * @param hora_fin
	 * @param plazas
	 * @param dia
	 */
	public boolean crearActividad(String id, String nombre, String intensidad, String[] recurso, String acceso,
			String hora_inicio, String hora_fin, String instalacion, String fecha, int plazas) {
		Actividad actividad = new Actividad();
		return actividad.crearActividad(id, nombre, intensidad, recurso, acceso, hora_inicio, hora_fin, instalacion,
				fecha, plazas);

	}
	

	public String[] getInstalaciones() {
		return Actividad.listarInstalaciones();
	}

	public String[] getRecursosPorInstalacion(String instalacion) {
		return Recurso.listarRecursosPorInstalacion(instalacion);
	}
	

}
