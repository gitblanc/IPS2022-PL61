/**
 * 
 */
package database.business.administracion.crud;

import java.util.List;
import java.util.Optional;

import database.business.administracion.AdministracionService;

/**
 * @author UO285176
 *
 */
public class AdministracionServiceImpl implements AdministracionService {

	@Override
	public AdministradorBLDto addAdministracion(AdministradorBLDto admin) {
		return new AddAdmin(admin).execute();
	}

	@Override
	public void deleteAdministrador(String idAdministrador) {
		DeleteAdmin da = new DeleteAdmin(idAdministrador);
		da.execute();
	}

	@Override
	public void updateAdministrador(AdministradorBLDto admin) {
		UpdateAdmin ua = new UpdateAdmin(admin);
		ua.execute();
	}

	@Override
	public Optional<AdministradorBLDto> findMonitorById(String idAdministrador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdministradorBLDto> findAllAdministracion() {
		return new FindAllAdmin().execute();
	}

}
