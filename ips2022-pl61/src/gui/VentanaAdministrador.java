/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logic.Administrador;

/**
 * @author UO285176
 *
 */
public class VentanaAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;

	private Administrador admin = new Administrador();

	private JPanel panelSelectorAccion;
	private JLabel lblAdministrador;
	private JPanel panelCrearActividad;
	private JLabel lblAdministrador2;
	private JPanel panelTextoActividad;
	private JPanel panelNombreActividad;
	private JLabel lblNombreActividad;
	private JTextField textFieldNombre;
	private JPanel panelIntensidadActividad;
	private JLabel lblIntensidadActividad;
	private JComboBox<String> comboBoxIntensidad;
	private JPanel panelRecursosActividad;
	private JLabel lblRecursosActividad_1;
	private JTextField textFieldRecurso;
	private JPanel panelBotonCrear;
	private JButton btnCrearActividad;
	private JLabel lblValidacionCampos;
	private JButton btnVolverSeleccionAccion;
	private JPanel panelAccesoActividad;
	private JLabel lblNivelDeAcceso;
	private JComboBox<String> comboBoxAcceso;
	private JLabel lblSpace;
	private JComboBox<String> comboBoxHorarioInicio;
	// private JPanel panelCeldasCalendario;
	private JPanel panelHorarioActividad;
	private JLabel lblHorario;
	private JLabel lblA;
	private JComboBox<String> comboBoxHorarioFin;
	private JPanel panelInstalacion;
	private JLabel lblInstalacion;
	private JComboBox<String> comboBoxInstalacion;
	private JPanel panelNumeroDePlazas;
	private JLabel lblNumeroDePlazas;
	private JTextField textFieldNumeroDePlazas;
	private JLabel lblSinLimite;
	private JLabel lblSinRecursos;
	private JLabel lblDia;
	private JTextField textFieldDia;
	private JPanel panelLblAdmin;
	private JPanel panelBtnCrearActividad;
	private JButton btnCrearYPlanificar;
	private JComboBox<String> comboBoxRecursosInstalacion;

	public VentanaAdministrador() {
		setMinimumSize(new Dimension(870, 670));
		getContentPane().setLayout(new CardLayout(0, 0));
		this.setTitle("Administrador");
		getContentPane().add(getPanelSelectorAccion(), "panelSelectorAction");
		getContentPane().add(getPanelCrearActividad(), "panelCrearActividad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	// POSIBLE IMPLEMENTACION
//	private void generarCeldasCalendario() {
//		Celda celda;
//		for (int i = 0; i < 16; i++) {
//			for (int j = 0; j < 8; j++) {
//				celda = new Celda(i, j);
//				getPanelCeldasCalendario().add(celda);
//			}
//		}
//		validate();
//	}

	private JPanel getPanelSelectorAccion() {
		if (panelSelectorAccion == null) {
			panelSelectorAccion = new JPanel();
			panelSelectorAccion.setLayout(new BorderLayout(0, 0));
			panelSelectorAccion.add(getPanelLblAdmin(), BorderLayout.NORTH);
			panelSelectorAccion.add(getPanelBtnCrearActividad(), BorderLayout.CENTER);
		}
		return panelSelectorAccion;
	}

	private JLabel getLblAdministrador() {
		if (lblAdministrador == null) {
			lblAdministrador = new JLabel("Administrador");
			lblAdministrador.setForeground(Color.BLUE);
			lblAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblAdministrador;
	}

	protected void mostrarPanel(String panel) {
		((CardLayout) getContentPane().getLayout()).show(getContentPane(), panel);
		vaciarCampos();
	}

	private JPanel getPanelCrearActividad() {
		if (panelCrearActividad == null) {
			panelCrearActividad = new JPanel();
			panelCrearActividad.setBackground(Color.WHITE);
			panelCrearActividad.setLayout(new BorderLayout(0, 0));
			panelCrearActividad.add(getLblAdministrador2(), BorderLayout.NORTH);
			panelCrearActividad.add(getPanelTextoActividad(), BorderLayout.CENTER);
		}
		return panelCrearActividad;
	}

	private JLabel getLblAdministrador2() {
		if (lblAdministrador2 == null) {
			lblAdministrador2 = new JLabel("   Administrador");
			lblAdministrador2.setBackground(Color.WHITE);
			lblAdministrador2.setForeground(Color.BLUE);
			lblAdministrador2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblAdministrador2;
	}

	private JPanel getPanelTextoActividad() {
		if (panelTextoActividad == null) {
			panelTextoActividad = new JPanel();
			panelTextoActividad.setLayout(new GridLayout(8, 1, 0, 0));
			panelTextoActividad.add(getPanelNombreActividad());
			panelTextoActividad.add(getPanelIntensidadActividad());
			panelTextoActividad.add(getPanelAccesoActividad());
			panelTextoActividad.add(getPanelHorarioActividad());
			panelTextoActividad.add(getPanel_1_1());
			panelTextoActividad.add(getPanelRecursosActividad());
			panelTextoActividad.add(getPanel_1_2());
			panelTextoActividad.add(getPanelBotonCrear());
		}
		return panelTextoActividad;
	}

	private JPanel getPanelNombreActividad() {
		if (panelNombreActividad == null) {
			panelNombreActividad = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelNombreActividad.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setHgap(10);
			flowLayout.setVgap(30);
			panelNombreActividad.add(getLblNombreActividad());
			panelNombreActividad.add(getTextFieldNombre());
		}
		return panelNombreActividad;
	}

	private JLabel getLblNombreActividad() {
		if (lblNombreActividad == null) {
			lblNombreActividad = new JLabel("Tipo de la actividad:");
			lblNombreActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblNombreActividad;
	}

	private JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldNombre.setColumns(30);
		}
		return textFieldNombre;
	}

	private JPanel getPanelIntensidadActividad() {
		if (panelIntensidadActividad == null) {
			panelIntensidadActividad = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelIntensidadActividad.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setHgap(10);
			flowLayout.setVgap(30);
			panelIntensidadActividad.add(getLblIntensidadActividad());
			panelIntensidadActividad.add(getComboBoxIntensidad());
		}
		return panelIntensidadActividad;
	}

	private JLabel getLblIntensidadActividad() {
		if (lblIntensidadActividad == null) {
			lblIntensidadActividad = new JLabel("Intensidad de la actividad:");
			lblIntensidadActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblIntensidadActividad;
	}

	private JComboBox<String> getComboBoxIntensidad() {
		if (comboBoxIntensidad == null) {
			comboBoxIntensidad = new JComboBox<String>();
			comboBoxIntensidad.setModel(new DefaultComboBoxModel<String>(new String[] { "Alta", "Moderada", "Baja" }));
			comboBoxIntensidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxIntensidad;
	}

	private JPanel getPanelRecursosActividad() {
		if (panelRecursosActividad == null) {
			panelRecursosActividad = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelRecursosActividad.getLayout();
			flowLayout.setVgap(30);
			flowLayout.setHgap(10);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelRecursosActividad.add(getLblRecursosActividad_1());
			panelRecursosActividad.add(getComboBoxRecursosInstalacion());
			panelRecursosActividad.add(getTextFieldRecurso());
			panelRecursosActividad.add(getLblSinRecursos());
		}
		return panelRecursosActividad;
	}

	private JLabel getLblRecursosActividad_1() {
		if (lblRecursosActividad_1 == null) {
			lblRecursosActividad_1 = new JLabel("Recursos disponibles:");
			lblRecursosActividad_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblRecursosActividad_1;
	}

	private JTextField getTextFieldRecurso() {
		if (textFieldRecurso == null) {
			textFieldRecurso = new JTextField();
			textFieldRecurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldRecurso.setColumns(15);
		}
		return textFieldRecurso;
	}

	private JPanel getPanelBotonCrear() {
		if (panelBotonCrear == null) {
			panelBotonCrear = new JPanel();
			FlowLayout fl_panelBotonCrear = new FlowLayout(FlowLayout.RIGHT, 15, 30);
			panelBotonCrear.setLayout(fl_panelBotonCrear);
			panelBotonCrear.add(getLblValidacionCampos());
			panelBotonCrear.add(getBtnVolverSeleccionAccion());
			panelBotonCrear.add(getBtnCrearActividad());
			panelBotonCrear.add(getLblSpace());
		}
		return panelBotonCrear;
	}

	private JButton getBtnCrearActividad() {
		if (btnCrearActividad == null) {
			btnCrearActividad = new JButton("Crear");
			btnCrearActividad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearActividad();
				}
			});
			btnCrearActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCrearActividad.setForeground(Color.WHITE);
			btnCrearActividad.setBackground(new Color(34, 139, 34));
		}
		return btnCrearActividad;
	}

	protected void crearActividad() {
		String id = UUID.randomUUID().toString();
		String nombre = getTextFieldNombre().getText();
		String intensidad = getComboBoxIntensidad().getSelectedItem().toString().split("@")[0].toLowerCase();
		String[] recurso = getTextFieldRecurso().getText().split(",");
		String acceso = getComboBoxAcceso().getSelectedItem().toString().split("@")[0].toLowerCase();
		String hora_inicio = getComboBoxHorarioInicio().getSelectedItem().toString().split("@")[0].toLowerCase();
		String hora_fin = getComboBoxHorarioFin().getSelectedItem().toString().split("@")[0].toLowerCase();
		String instalacion = getComboBoxInstalacion().getSelectedItem().toString().split("@")[0].toLowerCase();
		String fecha = getTextFieldDia().getText();
		if (getTextFieldDia().getText().isBlank()) {
			getLblValidacionCampos().setEnabled(true);
			getLblValidacionCampos().setForeground(Color.GREEN);
			getLblValidacionCampos().setText("¡Actividad creada!");
		} else {
			fecha = getTextFieldDia().getText();
		}
		int plazas;
		if (getTextFieldNumeroDePlazas().getText().isBlank()) {
			plazas = -1;
		} else {
			plazas = Integer.parseInt(getTextFieldNumeroDePlazas().getText());
		}
		if (!admin.crearActividad(id, nombre, intensidad, recurso, acceso, hora_inicio, hora_fin, instalacion, fecha,
				plazas)) {
			getLblValidacionCampos().setEnabled(true);
			getLblValidacionCampos().setForeground(Color.RED);
			getLblValidacionCampos().setText("¡Los valores no son correctos, introdúcelos de nuevo!");
		} else {
			getLblValidacionCampos().setEnabled(true);
			getLblValidacionCampos().setForeground(Color.GREEN);
			getLblValidacionCampos().setText("¡Actividad creada!");
			vaciarCampos();
		}
		getLblValidacionCampos().setVisible(true);
	}

	private void vaciarCampos() {
		getTextFieldNombre().setText("");
		getTextFieldRecurso().setText("");
		getComboBoxIntensidad().setSelectedIndex(0);
		getComboBoxAcceso().setSelectedIndex(0);
		getComboBoxHorarioInicio().setSelectedIndex(0);
		getComboBoxHorarioFin().setSelectedIndex(0);
		getComboBoxInstalacion().setSelectedIndex(0);
		getTextFieldDia().setText("");
		getTextFieldNumeroDePlazas().setText("");
	}

	private JLabel getLblValidacionCampos() {
		if (lblValidacionCampos == null) {
			lblValidacionCampos = new JLabel("");
			lblValidacionCampos.setEnabled(false);
			lblValidacionCampos.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return lblValidacionCampos;
	}

	private JButton getBtnVolverSeleccionAccion() {
		if (btnVolverSeleccionAccion == null) {
			btnVolverSeleccionAccion = new JButton("Atr\u00E1s");
			btnVolverSeleccionAccion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanel("panelSelectorAction");
					getLblValidacionCampos().setVisible(false);
				}
			});
			btnVolverSeleccionAccion.setForeground(new Color(255, 255, 255));
			btnVolverSeleccionAccion.setBackground(new Color(100, 149, 237));
			btnVolverSeleccionAccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnVolverSeleccionAccion;
	}

	private JPanel getPanelAccesoActividad() {
		if (panelAccesoActividad == null) {
			panelAccesoActividad = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelAccesoActividad.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setVgap(30);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelAccesoActividad.add(getLblNivelDeAcceso());
			panelAccesoActividad.add(getComboBoxAcceso());
		}
		return panelAccesoActividad;
	}

	private JLabel getLblNivelDeAcceso() {
		if (lblNivelDeAcceso == null) {
			lblNivelDeAcceso = new JLabel("Tipo de acceso:");
			lblNivelDeAcceso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblNivelDeAcceso;
	}

	private JComboBox<String> getComboBoxAcceso() {
		if (comboBoxAcceso == null) {
			comboBoxAcceso = new JComboBox<String>();
			comboBoxAcceso.setModel(new DefaultComboBoxModel<String>(new String[] { "Libre acceso", "Con reserva" }));
			comboBoxAcceso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxAcceso;
	}

	private JLabel getLblSpace() {
		if (lblSpace == null) {
			lblSpace = new JLabel("");
		}
		return lblSpace;
	}

	private JPanel getPanelHorarioActividad() {
		if (panelHorarioActividad == null) {
			panelHorarioActividad = new JPanel();
			FlowLayout fl_panelHorarioActividad = (FlowLayout) panelHorarioActividad.getLayout();
			fl_panelHorarioActividad.setVgap(30);
			fl_panelHorarioActividad.setHgap(10);
			fl_panelHorarioActividad.setAlignment(FlowLayout.LEFT);
			panelHorarioActividad.add(getLblHorario());
			panelHorarioActividad.add(getComboBoxHorarioInicio());
			panelHorarioActividad.add(getLblA());
			panelHorarioActividad.add(getComboBoxHorarioFin());
			panelHorarioActividad.add(getLblDia());
			panelHorarioActividad.add(getTextFieldDia());
		}
		return panelHorarioActividad;
	}

	private JLabel getLblHorario() {
		if (lblHorario == null) {
			lblHorario = new JLabel("Horario:   de");
			lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblHorario;
	}

	private JComboBox<String> getComboBoxHorarioInicio() {
		if (comboBoxHorarioInicio == null) {
			comboBoxHorarioInicio = new JComboBox<String>();
			comboBoxHorarioInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxHorarioInicio.setModel(new DefaultComboBoxModel<String>(
					new String[] { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00",
							"18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
		}
		return comboBoxHorarioInicio;
	}

	private JLabel getLblA() {
		if (lblA == null) {
			lblA = new JLabel("a");
			lblA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblA;
	}

	private JComboBox<String> getComboBoxHorarioFin() {
		if (comboBoxHorarioFin == null) {
			comboBoxHorarioFin = new JComboBox<String>();
			comboBoxHorarioFin.setModel(
					new DefaultComboBoxModel<String>(new String[] { "10:00", "11:00", "12:00", "13:00", "14:00",
							"15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
			comboBoxHorarioFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxHorarioFin;
	}

	private JPanel getPanel_1_1() {
		if (panelInstalacion == null) {
			panelInstalacion = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelInstalacion.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setVgap(30);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelInstalacion.add(getLblInstalacion());
			panelInstalacion.add(getComboBoxInstalacion());
		}
		return panelInstalacion;
	}

	private JLabel getLblInstalacion() {
		if (lblInstalacion == null) {
			lblInstalacion = new JLabel("Instalación:");
			lblInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblInstalacion;
	}

	private JComboBox<String> getComboBoxInstalacion() {
		if (comboBoxInstalacion == null) {
			comboBoxInstalacion = new JComboBox<String>();
			comboBoxInstalacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getComboBoxRecursosInstalacion()
							.setModel(new DefaultComboBoxModel<String>(admin.getRecursosPorInstalacion(
									getComboBoxInstalacion().getSelectedItem().toString().split("@")[0]
											.toLowerCase())));
				}
			});
			comboBoxInstalacion.setModel(new DefaultComboBoxModel<String>(admin.getInstalaciones()));
			comboBoxInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxInstalacion;
	}

	private JPanel getPanel_1_2() {
		if (panelNumeroDePlazas == null) {
			panelNumeroDePlazas = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelNumeroDePlazas.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setVgap(30);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelNumeroDePlazas.add(getLblNumeroDePlazas());
			panelNumeroDePlazas.add(getTextFieldNumeroDePlazas());
			panelNumeroDePlazas.add(getLblSinLimite());
		}
		return panelNumeroDePlazas;
	}

	private JLabel getLblNumeroDePlazas() {
		if (lblNumeroDePlazas == null) {
			lblNumeroDePlazas = new JLabel("Número de plazas:");
			lblNumeroDePlazas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblNumeroDePlazas;
	}

	private JTextField getTextFieldNumeroDePlazas() {
		if (textFieldNumeroDePlazas == null) {
			textFieldNumeroDePlazas = new JTextField();
			textFieldNumeroDePlazas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldNumeroDePlazas.setColumns(10);
		}
		return textFieldNumeroDePlazas;
	}

	private JLabel getLblSinLimite() {
		if (lblSinLimite == null) {
			lblSinLimite = new JLabel("Nota: Dejar en blanco si no hay límite de plazas");
			lblSinLimite.setForeground(new Color(128, 0, 0));
		}
		return lblSinLimite;
	}

	private JLabel getLblSinRecursos() {
		if (lblSinRecursos == null) {
			lblSinRecursos = new JLabel("Nota: Dejar en blanco si no se requieren recursos y separar por comas");
			lblSinRecursos.setForeground(new Color(128, 0, 0));
		}
		return lblSinRecursos;
	}

	private JLabel getLblDia() {
		if (lblDia == null) {
			lblDia = new JLabel("el día: ");
			lblDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblDia;
	}

	private JTextField getTextFieldDia() {
		if (textFieldDia == null) {
			textFieldDia = new JTextField();
			textFieldDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldDia.setColumns(3);
		}
		return textFieldDia;
	}

	private JPanel getPanelLblAdmin() {
		if (panelLblAdmin == null) {
			panelLblAdmin = new JPanel();
			panelLblAdmin.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) panelLblAdmin.getLayout();
			flowLayout.setHgap(15);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelLblAdmin.add(getLblAdministrador());
		}
		return panelLblAdmin;
	}

	private JPanel getPanelBtnCrearActividad() {
		if (panelBtnCrearActividad == null) {
			panelBtnCrearActividad = new JPanel();
			panelBtnCrearActividad.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 250));
			panelBtnCrearActividad.add(getBtnMostrarCrearActividad_1());
		}
		return panelBtnCrearActividad;
	}

	private JButton getBtnMostrarCrearActividad_1() {
		if (btnCrearYPlanificar == null) {
			btnCrearYPlanificar = new JButton("Crear y planificar una actividad");
			btnCrearYPlanificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanel("panelCrearActividad");
				}
			});
			btnCrearYPlanificar.setForeground(Color.WHITE);
			btnCrearYPlanificar.setFont(new Font("Tahoma", Font.PLAIN, 40));
			btnCrearYPlanificar.setBackground(new Color(34, 139, 34));
		}
		return btnCrearYPlanificar;
	}

	private JComboBox<String> getComboBoxRecursosInstalacion() {
		if (comboBoxRecursosInstalacion == null) {
			comboBoxRecursosInstalacion = new JComboBox<String>();
			comboBoxRecursosInstalacion.setModel(new DefaultComboBoxModel<String>(admin.getRecursosPorInstalacion(
					getComboBoxInstalacion().getSelectedItem().toString().split("@")[0].toLowerCase())));
			comboBoxRecursosInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxRecursosInstalacion;
	}
}
