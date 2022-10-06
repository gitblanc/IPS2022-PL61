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
public class AddSocio {
	private static String SQL = "insert into Socio(id_s, nombre_s, apellidos_s, correo_s) values (?, ?, ?, ?)";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private SocioBLDto socio = null;

	public AddSocio(SocioBLDto nuevoSocio) {
		Argument.isNotNull(nuevoSocio);
		this.socio = nuevoSocio;
	}

	public SocioBLDto execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, socio.id);
			pst.setString(2, socio.nombre);
			pst.setString(3, socio.apellidos);
			pst.setString(4, socio.correo);

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
		return socio;
	}
}
