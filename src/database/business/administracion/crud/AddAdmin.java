package database.business.administracion.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.administracion.AdministracionService.AdministradorBLDto;

//UO285176
public class AddAdmin {
	private static String SQL = "insert into Administracion(id_a, nombre_a, apellidos_a, correo_a) values (?, ?, ?, ?)";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private AdministradorBLDto admin = null;

	public AddAdmin(AdministradorBLDto admin) {
		Argument.isNotNull(admin);
		this.admin = admin;
	}

	public AdministradorBLDto execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, admin.id);
			pst.setString(2, admin.nombre);
			pst.setString(3, admin.apellidos);
			pst.setString(4, admin.correo);

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
		return admin;
	}
}
