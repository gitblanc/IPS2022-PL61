package database.business.recursosALlevarSocio.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import assertion.Argument;
import database.business.recursosALlevarSocio.RecursosALlevarSocioService.RecursosALlevarSocioBLDto;

public class FindRecursoByInstalacion {

	
	private static final String SQL = "select * from recursosALlevarSocio where nombre_i = ?";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	
	private String instalacion;
	
	public FindRecursoByInstalacion(String instalacion) {
		Argument.isNotEmpty(instalacion);
		Argument.isNotNull(instalacion);
		this.instalacion = instalacion;
	}

	public List<RecursosALlevarSocioBLDto> execute() {
		List<RecursosALlevarSocioBLDto> recursos = new ArrayList<>();

		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);
			pst = c.prepareStatement(SQL);
			pst.setString(1, instalacion);
			rs = pst.executeQuery();
			while (rs.next()) {
				RecursosALlevarSocioBLDto recurso = new RecursosALlevarSocioBLDto();
				recurso.nombre_recurso_a_llevar = rs.getString("nombre_recurso_a_llevar");
				recurso.nombre_instalacion= rs.getString("nombre_i");
				recursos.add(recurso);
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
		return recursos;
	}
}
