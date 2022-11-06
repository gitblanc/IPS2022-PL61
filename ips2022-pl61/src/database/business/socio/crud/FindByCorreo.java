package database.business.socio.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.socio.SocioService.SocioBLDto;

public class FindByCorreo {

	private static String SQL = "select * from Socio where correo_s = ?";

	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private String correo;

	public FindByCorreo(String correo) {
		Argument.isNotNull(correo);
		this.correo = correo;
	}

	public SocioBLDto execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		SocioBLDto socio = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, this.correo);


			rs = pst.executeQuery();
			socio = getResult(rs);

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
		return socio;
	}
	
	private SocioBLDto getResult(ResultSet r) throws SQLException {
		SocioBLDto s = new SocioBLDto();
		if(r.next()) {
			s.id = r.getString("Id_s");
			s.nombre = r.getString("Nombre_s");
			s.apellidos = r.getString("Apellidos_s");
			s.correo = r.getString("Correo_s");
			s.contraseña = r.getString("Contraseña_s");
		}
		
		return s;
		
		
	}
	
}
