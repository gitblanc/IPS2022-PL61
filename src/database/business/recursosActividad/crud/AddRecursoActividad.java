/**
 * 
 */
package database.business.recursosActividad.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.recursosActividad.RecursosActividadService.RecursosActividadBLDto;

/**
 * @author UO285176
 *
 */
public class AddRecursoActividad {

	private static String SQL = "insert into RecursosActividad(id_a, nombre_r) values (?, ?)";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private RecursosActividadBLDto recursoActividad;

	public AddRecursoActividad(RecursosActividadBLDto recursoActividad) {
		Argument.isNotNull(recursoActividad);
		this.recursoActividad = recursoActividad;
	}

	public RecursosActividadBLDto execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, recursoActividad.actividad);
			pst.setString(2, recursoActividad.recurso);

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
		return recursoActividad;
	}

}
