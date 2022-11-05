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

}
