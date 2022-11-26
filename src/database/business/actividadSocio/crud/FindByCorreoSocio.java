package database.business.actividadSocio.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assertion.Argument;
import database.business.actividadSocio.ActividadSocioService.ActividadSocioBLDto;

public class FindByCorreoSocio {

	private static String SQL = "select * from ActividadSocio where correo_s = ?";

	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private String correo;

	public FindByCorreoSocio(String correoSocio) {
		Argument.isNotNull(correoSocio);
		this.correo = correoSocio;
	}

	public List<ActividadSocioBLDto> execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<ActividadSocioBLDto> acs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, this.correo);


			rs = pst.executeQuery();
			acs = getResult(rs);

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
		return acs;
	}
	
	private List<ActividadSocioBLDto> getResult(ResultSet r) throws SQLException {
		List<ActividadSocioBLDto> res = new ArrayList<>();
		while (r.next()) {
			res.add(resultSet(r));
		}
		return res;
	}

	private ActividadSocioBLDto resultSet(ResultSet r) throws SQLException {
		ActividadSocioBLDto a = new ActividadSocioBLDto();
		a.correo_socio = r.getString("Correo_s");
		a.id_actividad = r.getString("id_a");

		return a;
	}
		
	

}
