package database.business.actividadSocio.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.actividadSocio.ActividadSocioService.ActividadSocioBLDto;

public class AddActividadSocio {

	private static String SQL = "insert into ActividadSocio(correo_s, id_a) values (?, ?)";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private ActividadSocioBLDto actividadSocio;

	public AddActividadSocio(ActividadSocioBLDto actividadSocio) {
		Argument.isNotNull(actividadSocio);
		this.actividadSocio = actividadSocio;
	}

	public ActividadSocioBLDto execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, actividadSocio.correo_socio);
			pst.setString(2, actividadSocio.id_actividad);

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
		return actividadSocio;
	}
}
