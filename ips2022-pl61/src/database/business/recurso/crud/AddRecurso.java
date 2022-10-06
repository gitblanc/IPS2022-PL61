package database.business.recurso.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import assertion.Argument;
import database.business.recurso.RecursoService.RecursoBLDto;

/**
 * 
 * @author uo276967
 *
 */
public class AddRecurso {

	//Conexiones
	private static String SQL = "insert into Recurso(nombre_r, cantidad_r) values (?, ?)";
	private static final String URL = "jdbc:hsqldb:hsql://localhost:1521/";
	private static final String USER = "sa";
	private static final String PASSWORD = "";
	
	private RecursoBLDto recurso = null;
	
	/**
	 * Constructor de la clase 
	 * @param recurso de tipo RecursoBLDto
	 */
	public AddRecurso(RecursoBLDto recurso) {
		Argument.isNotNull(recurso);
		this.recurso = recurso;
	}
	
	/**
	 * Método que ejecuta la transacción
	 * @return un RecursoBLDto
	 */
	public RecursoBLDto execute() {
		// Process
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);

			pst = c.prepareStatement(SQL);
			pst.setString(1, recurso.nombre);
			pst.setInt(2, recurso.cantidad);

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
		return recurso;
	}
	
	
	
}
