package database.business.actividadSocio.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.actividadSocio.ActividadSocioService.ActividadSocioBLDto;

public class DeleteActividadSocio {

		private static final String SQL = "delete from ActividadSocio where id_a = ? and correo_s = ?";
		private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
		private static final String USER = "sa";
		private static final String PASSWORD = "";

		private ActividadSocioBLDto actividad = new ActividadSocioBLDto();

		public DeleteActividadSocio(String idActividad, String correo) {
			Argument.isNotNull(idActividad);
			Argument.isNotNull(correo);
			this.actividad.id_actividad = idActividad;
			this.actividad.correo_socio = correo;
		}

		public void execute() {
			Connection c = null;
			PreparedStatement pst = null;
			ResultSet rs = null;

			try {
				c = DriverManager.getConnection(URL, USER, PASSWORD);

				pst = c.prepareStatement(SQL);
				pst.setString(1, actividad.id_actividad);
				pst.setString(2, actividad.correo_socio);

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
