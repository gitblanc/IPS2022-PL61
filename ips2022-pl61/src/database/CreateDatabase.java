/**
 * 
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author UO285176
 *
 */

//Execute this class only once to set up the database
public class CreateDatabase {

	public static void main(String[] args) {

		String crearSocios = "create table socio(datos_personales varchar(50)"
				+ " not null, cc_socio varchar(20), importe_cuota double, periodicidad_cuota int"
				+ "mes_ref_cuota int)";
		String crearRecibos = "create table recibo(fecha_recibo date, cc_recibo varchar(20) not null"
				+ ", importe double, concepto varchar(20), fecha_valor date)";
		String crearLotes = "create table lote(fecha_emision date)";

		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1521/", "SA", "");
			stmt = con.createStatement();

			stmt.executeQuery(crearSocios);
			stmt.executeQuery(crearRecibos);
			stmt.executeQuery(crearLotes);

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
