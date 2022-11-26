/**
 * 
 */
package database.business.instalacion.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author UO285176
 *
 */
public class CerrarInstalacion {

	private static String SQL = "UPDATE INSTALACION SET CERRADA_PARA_ALQUILERES = ? where nombre_i = ?";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private String instalacion;
	private String fechaCierre;

	public CerrarInstalacion(String instalacion, String fechaCierre) {
		this.instalacion = instalacion;
		this.fechaCierre = fechaCierre;
	}

	public void execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, fechaCierre);
			pst.setString(2, instalacion);

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
