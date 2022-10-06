/**
 * 
 */
package database.business.socio.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.socio.SocioService.SocioBLDto;

/**
 * @author UO285176
 *
 */
public class DeleteSocio {
	private static String SQL = "delete from Socio where id_s = ?";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private SocioBLDto socio = new SocioBLDto();

	public DeleteSocio(String idSocio) {
		Argument.isNotNull(idSocio);
		this.socio.id = idSocio;
	}

	public void execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, socio.id);

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
