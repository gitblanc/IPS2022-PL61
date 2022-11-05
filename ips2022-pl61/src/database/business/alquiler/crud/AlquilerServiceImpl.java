/**
 * 
 */
package database.business.alquiler.crud;

import java.util.List;

import database.business.alquiler.AlquilerService;

/**
 * @author UO285176
 *
 */
public class AlquilerServiceImpl implements AlquilerService {

	@Override
	public void updateAlquiler(AlquilerBLDto alquiler) {
		new UpdateAlquiler(alquiler).execute();
	}

	@Override
	public List<AlquilerBLDto> findAll() {
		return new FindAllAlquileres().execute();
	}

	@Override
	public void cancelarAlquiler(String socio, String instalacion, String fecha, String hora_inicio, String hora_fin) {
		new CancelarAlquiler(socio, instalacion, fecha, hora_inicio, hora_fin).execute();
	}

}
