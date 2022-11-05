/**
 * 
 */
package database.business.administracion.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.business.administracion.AdministracionService.AdministradorBLDto;

/**
 * @author UO285176
 *
 */
public class FindAllAdmin {
	private static final String SQL = "select * from Administracion";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	public List<AdministradorBLDto> execute() {
		List<AdministradorBLDto> admins = new ArrayList<>();

		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();
			while (rs.next()) {
				AdministradorBLDto admin = new AdministradorBLDto();
				admin.id = rs.getString("id_a");
				admin.nombre = rs.getString("nombre_a");
				admin.apellidos = rs.getString("apellidos_a");
				admin.correo = rs.getString("correo_a");
				admins.add(admin);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					/* ignore */ }
			if (pst != null)
				try {
					pst.close();
				} catch (SQLException e) {
					/* ignore */ }
			if (c != null)
				try {
					c.close();
				} catch (SQLException e) {
					/* ignore */ }
		}
		return admins;
	}
}
