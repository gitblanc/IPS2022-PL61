package database.business.monitor;

import java.util.List;
import java.util.Optional;

//UO285176
public interface MonitorService {
	// Le pasamos el monitor a añadir
	MonitorBLDto addMonitor(MonitorBLDto monitor);

	// Le pasamos el identificador del monitor a eliminar
	void deleteMonitor(String idMonitor);

	// Le pasamos el monitor a actualizar
	void updateMonitor(MonitorBLDto monitor);

	// Le pasamos el id del monitor que queremos buscar
	Optional<MonitorBLDto> findMonitorById(String idMonitor);

	// Devuelve una lista con todos los monitores
	List<MonitorBLDto> findAllMonitor();

	public class MonitorBLDto {

		public String id;
		public String nombre;
		public String apellidos;
		public String correo;

	}
}
