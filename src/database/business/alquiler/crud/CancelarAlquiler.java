/**
 * 
 */
package database.business.alquiler.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author UO285176
 *
 */
public class CancelarAlquiler {

	private static String SQL = "delete from alquileres where id_socio = ? and nombre_i = ? and fecha = ? and hora_inicio = ? and hora_fin = ?";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	String socio = null;
	String instalacion = null;
	String fecha = null;
	String hora_inicio = null;
	String hora_fin = null;

	public CancelarAlquiler(String socio, String instalacion, String fecha, String hora_inicio, String hora_fin) {
		this.socio = socio;
		this.instalacion = instalacion;
		this.fecha = fecha;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}

	public Void execute() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, this.socio);
			pst.setString(2, this.instalacion);
			pst.setString(3, this.fecha);
			pst.setString(4, this.hora_inicio);
			pst.setString(5, this.hora_fin);

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
		return null;
	}

}
