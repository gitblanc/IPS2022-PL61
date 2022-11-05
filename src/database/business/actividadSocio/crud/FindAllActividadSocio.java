package database.business.actividadSocio.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.business.actividadSocio.ActividadSocioService.ActividadSocioBLDto;

public class FindAllActividadSocio {

	private static final String SQL = "select * from ActividadSocio";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	public List<ActividadSocioBLDto> execute() {
		List<ActividadSocioBLDto> actividadesSocio = new ArrayList<>();

		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();
			while (rs.next()) {
				ActividadSocioBLDto actividadSocio = new ActividadSocioBLDto();
				actividadSocio.correo_socio = rs.getString("correo_s");
				actividadSocio.id_actividad = rs.getString("id_a");
				actividadesSocio.add(actividadSocio);
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
		return actividadesSocio;
	}
}
