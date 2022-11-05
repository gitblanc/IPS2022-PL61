/**
 * 
 */
package database.business.alquiler.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.alquiler.AlquilerService.AlquilerBLDto;

/**
 * @author UO285176
 *
 */
public class UpdateAlquiler {
	private static String SQL = "update Alquileres set nombre_i = ?, id_socio = ?, fecha = ?, hora_inicio = ?, hora_fin = ? where id_a = ?";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	AlquilerBLDto alquiler = null;

	public UpdateAlquiler(AlquilerBLDto al) {
		Argument.isNotNull(al, "The id can't be null");
		this.alquiler = al;
	}

	public void execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);
			pst = c.prepareStatement(SQL);
			pst.setString(1, alquiler.instalacion);
			pst.setString(2, alquiler.id_socio);
			pst.setString(3, alquiler.fecha);
			pst.setString(4, alquiler.hora_inicio);
			pst.setString(5, alquiler.hora_fin);
			pst.setString(6, alquiler.id);

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
