/**
 * 
 */
package database.business.alquiler.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author UO285176
 *
 */
public class CreateAlquiler {

	private static String SQL = "INSERT INTO ALQUILERES ( ID_A, NOMBRE_I, ID_SOCIO, FECHA, HORA_INICIO, HORA_FIN ) VALUES ( ?, ?, ?, ?, ?, ?)";

	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	String socio, instalacion, fecha, inicio, fin = null;

	public CreateAlquiler(String id_socio, String instalacion, String hora_inicio, String hora_fin, String fecha) {
		this.socio = id_socio;
		this.instalacion = instalacion;
		this.fecha = fecha;
		this.inicio = hora_inicio;
		this.fin = hora_fin;
	}

	public void execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, UUID.randomUUID().toString());
			pst.setString(2, this.instalacion);
			pst.setString(3, this.socio);
			pst.setString(4, this.fecha);
			pst.setString(5, this.inicio);
			pst.setString(6, this.fin);

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
