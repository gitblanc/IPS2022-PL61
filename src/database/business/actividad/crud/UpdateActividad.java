/**
 * 
 */
package database.business.actividad.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.actividad.ActividadService.ActividadBLDto;

/**
 * @author UO285176
 *
 */
public class UpdateActividad {
	private static String SQL = "update Actividad set nombre_a = ?, intensidad = ?, acceso = ?, hora_inicio = ?, hora_fin = ?, nombre_i = ? where id_a = ?";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private ActividadBLDto actividad = null;

	public UpdateActividad(ActividadBLDto actividad) {
		Argument.isNotNull(actividad);
		this.actividad = actividad;
	}

	public void execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);
			pst = c.prepareStatement(SQL);
			pst.setString(1, actividad.tipo);
			pst.setString(2, actividad.intensidad);
			pst.setString(3, actividad.id);
			pst.setString(4, actividad.acceso);
			pst.setString(5, actividad.hora_inicio);
			pst.setString(6, actividad.hora_fin);
			pst.setString(7, actividad.instalacion);
			pst.setString(8, actividad.fecha);
			pst.setInt(9, actividad.plazas);

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
