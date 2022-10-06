/**
 * 
 */
package database.business;

import database.business.socio.SocioService;
import database.business.socio.crud.SocioServiceImpl;

/**
 * @author UO285176
 *
 */
public class BusinessFactory {
	public static SocioService forSocioService() {
		return new SocioServiceImpl();
	}
}
