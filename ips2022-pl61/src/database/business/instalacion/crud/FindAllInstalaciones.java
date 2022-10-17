/**
 * 
 */
package database.business.instalacion.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.business.instalacion.InstalacionService.InstalacionBLDto;

/**
 * @author UO285176
 *
 */
public class FindAllInstalaciones {

	private static final String SQL = "select * from Instalacion";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	public List<InstalacionBLDto> execute() {
		List<InstalacionBLDto> instalaciones = new ArrayList<>();

		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();
			while (rs.next()) {
				InstalacionBLDto instalacion = new InstalacionBLDto();
				instalacion.nombre = rs.getString("nombre_i");
				instalacion.plazas = rs.getInt("plazas");
				instalaciones.add(instalacion);
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
		return instalaciones;
	}

}
