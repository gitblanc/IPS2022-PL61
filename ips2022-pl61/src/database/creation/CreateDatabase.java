/**
 * 
 */
package database.creation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author UO285176
 *
 */

//Execute this class only once to set up the database
public class CreateDatabase {

	private static List<String> createQueries = new ArrayList<>();
	private static List<String> dropTables = new ArrayList<>();

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:1521/", "SA", "");
			stmt = con.createStatement();

			createQueries();

			// Eliminamos las tablas
			for (String query : dropTables) {
				stmt.executeQuery(query);
			}

			// Creamos las tablas
			for (String query : createQueries) {
				stmt.executeQuery(query);
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static void createQueries() {
		String crearSocios = "create table socio(id_s varchar(10) primary key, nombre_s varchar(20) not null"
				+ ", apellidos_s varchar(50) not null, correo_s varchar(50) not null)";
		String crearMonitor = "create table monitor(id_m varchar(10) primary key, nombre_m varchar(20) not null"
				+ ", apellidos_m varchar(50) not null, correo_m varchar(50) not null)";
		String crearNoSocio = "create table no_socio(id_ns varchar(10) primary key, nombre_ns varchar(20) not null"
				+ ", apellidos_ns varchar(50) not null, correo_ns varchar(50) not null)";
		String crearRecurso = "create table recurso(nombre_r varchar(20) not null, cantidad_r int not null)";
		String crearInstalacion = "create table instalacion(nombre_i varchar(20) not null, plazas int not null)";
		String crearActividad = "create table actividad(id_a varchar(10) primary key, nombre_a varchar(20) not null"
				+ ")";
		String crearCursillo = "create table cursillo(id_c varchar(10) primary key, nombre_c varchar(20) not null, "
				+ "duracion varchar(20) not null, horario date not null)";
		String crearListaEspera = "create table lista_espera(id_lista varchar(10) primary key, cantidad int not null)";
//

		String dropSocios = "drop table socio";
		String dropMonitor = "drop table monitor";
		String dropNoSocio = "drop table no_socio";
		String dropInstalacion = "drop table instalacion";
		String dropRecurso = "drop table recurso";
		String dropActividad = "drop table actividad";
		String dropCursillo = "drop table cursillo";
		String dropListaEspera = "drop table lista_espera";

		createQueries.add(crearSocios);
		createQueries.add(crearMonitor);
		createQueries.add(crearNoSocio);
		createQueries.add(crearInstalacion);
		createQueries.add(crearRecurso);
		createQueries.add(crearActividad);
		createQueries.add(crearCursillo);
		createQueries.add(crearListaEspera);

		dropTables.add(dropSocios);
		dropTables.add(dropMonitor);
		dropTables.add(dropNoSocio);
		dropTables.add(dropInstalacion);
		dropTables.add(dropRecurso);
		dropTables.add(dropActividad);
		dropTables.add(dropCursillo);
		dropTables.add(dropListaEspera);
	}
}
