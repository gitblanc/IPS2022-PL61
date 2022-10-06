/**
 * 
 */
package database.business.administracion.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.administracion.AdministracionService.AdministradorBLDto;

/**
 * @author UO285176
 *
 */
public class UpdateAdmin {
	private static String SQL = "update Administracion set nombre_a = ?, apellidos_a = ?, correo_a = ? where id_a = ?";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private AdministradorBLDto admin = null;

	public UpdateAdmin(AdministradorBLDto admin) {
		Argument.isNotNull(admin);
		this.admin = admin;
	}

	public void execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);
			pst = c.prepareStatement(SQL);
			pst.setString(1, admin.nombre);
			pst.setString(2, admin.apellidos);
			pst.setString(3, admin.correo);
			pst.setString(4, admin.id);

			pst.executeUpdate();

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

	}
}
