 package database.business.actividadSocio.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;

public class DeleteActividadSocio {

		private static final String SQL = "delete from ActividadSocio where id_a = ? and correo_s = ?";
		private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
		private static final String USER = "sa";
		private static final String PASSWORD = "";

		private String id;
		private String correo;

		public DeleteActividadSocio(String idActividad, String correo) {
			Argument.isNotNull(idActividad);
			Argument.isNotNull(correo);
			this.id = idActividad;
			this.correo = correo;
		}

		public void execute() {
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			try {
				c = DriverManager.getConnection(URL, USER, PASSWORD);

				pst = c.prepareStatement(SQL);
				pst.setString(1, this.id);
				pst.setString(2, this.correo);

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
