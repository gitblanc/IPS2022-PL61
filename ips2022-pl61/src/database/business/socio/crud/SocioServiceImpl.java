/**
 * 
 */
package database.business.socio.crud;

import java.util.List;
import java.util.Optional;

import database.business.socio.SocioService;

/**
 * @author UO285176
 *
 */
public class SocioServiceImpl implements SocioService {

	@Override
	public SocioBLDto addSocio(SocioBLDto socio) {
		return new AddSocio(socio).execute();
	}

	@Override
	public void deleteSocio(String idSocio) {
		DeleteSocio ds = new DeleteSocio(idSocio);
		ds.execute();
	}

	@Override
	public void updateSocio(SocioBLDto socio) {
		UpdateSocio us = new UpdateSocio(socio);
		us.execute();
	}

	@Override
	public Optional<SocioBLDto> findSocioById(String idSocio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SocioBLDto> findAllSocios() {
		return new FindAllSocios().execute();
	}


}
