/**
 * 
 */
package database.business.instalacion.crud;

import java.util.List;

import database.business.instalacion.InstalacionService;

/**
 * @author UO285176
 *
 */
public class InstalacionServiceImpl implements InstalacionService {

	@Override
	public List<InstalacionBLDto> findAllInstalaciones() {
		return new FindAllInstalaciones().execute();
	}

}
