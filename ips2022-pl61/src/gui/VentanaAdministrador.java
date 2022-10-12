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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	private JButton btnMostrarCrearActividad;
	private JPanel panelCrearActividad;
	private JLabel lblAdministrador2;
	private JPanel panelTextoActividad;
	private JPanel panelId;
	private JLabel lblIdActividad;
	private JTextField textFieldId;
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
	private JButton btnMostrarPlanificarActividad;
	private JPanel panelPlanificarActividad;
	private JComboBox<String> comboBoxHorarioInicio;
	// private JPanel panelCeldasCalendario;
	private JPanel panelHorarioActividad;
	private JLabel lblHorario;
	private JPanel panelIntroducirIdActividad;
	private JLabel lblIntroduceId;
	private JPanel panelPlanificacionId;
	private JTextField textFieldIdPlanificacion;
	private JPanel panelBotonesAtrasYAceptar;
	private JButton btnAceptarPlanificacion;
	private JButton btnAtrasPlanificacion;
	private JLabel lblA;
	private JComboBox<String> comboBoxHorarioFin;
	private JPanel panelInstalacion;
	private JLabel lblInstalacion;
	private JComboBox<String> comboBox;
	private JPanel panelNumeroDePlazas;
	private JLabel lblNumeroDePlazas;
	private JTextField textFieldNumeroDePlazas;
	private JLabel lblSinLimite;
	private JLabel lblSinRecursos;
	private JLabel lblDia;
	private JTextField textFieldDia;

	public VentanaAdministrador() {
		setMinimumSize(new Dimension(870, 670));
		getContentPane().setLayout(new CardLayout(0, 0));
		this.setTitle("Administrador");
		getContentPane().add(getPanelSelectorAccion(), "panelSelectorAction");
		getContentPane().add(getPanelCrearActividad(), "panelCrearActividad");
		getContentPane().add(getPanelPlanificarActividad(), "panelPlanificarActividad");
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
			panelSelectorAccion.setLayout(null);
			panelSelectorAccion.add(getLblAdministrador());
			panelSelectorAccion.add(getBtnMostrarCrearActividad());
			panelSelectorAccion.add(getBtnMostrarPlanificarActividad());
		}
		return panelSelectorAccion;
	}

	private JLabel getLblAdministrador() {
		if (lblAdministrador == null) {
			lblAdministrador = new JLabel("Administrador");
			lblAdministrador.setForeground(Color.BLUE);
			lblAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAdministrador.setBounds(10, 11, 150, 30);
		}
		return lblAdministrador;
	}

	private JButton getBtnMostrarCrearActividad() {
		if (btnMostrarCrearActividad == null) {
			btnMostrarCrearActividad = new JButton("Crear una actividad");
			btnMostrarCrearActividad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanel("panelCrearActividad");
				}
			});
			btnMostrarCrearActividad.setForeground(Color.WHITE);
			btnMostrarCrearActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnMostrarCrearActividad.setBackground(new Color(34, 139, 34));
			btnMostrarCrearActividad.setBounds(164, 122, 530, 62);
		}
		return btnMostrarCrearActividad;
	}

	protected void mostrarPanel(String panel) {
		((CardLayout) getContentPane().getLayout()).show(getContentPane(), panel);
		vaciarCampos();
	}

	private JPanel getPanelCrearActividad() {
		if (panelCrearActividad == null) {
			panelCrearActividad = new JPanel();
			panelCrearActividad.setLayout(new BorderLayout(0, 0));
			panelCrearActividad.add(getLblAdministrador2(), BorderLayout.NORTH);
			panelCrearActividad.add(getPanelTextoActividad(), BorderLayout.CENTER);
		}
		return panelCrearActividad;
	}

	private JLabel getLblAdministrador2() {
		if (lblAdministrador2 == null) {
			lblAdministrador2 = new JLabel("Administrador");
			lblAdministrador2.setForeground(Color.BLUE);
			lblAdministrador2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblAdministrador2;
	}

	private JPanel getPanelTextoActividad() {
		if (panelTextoActividad == null) {
			panelTextoActividad = new JPanel();
			panelTextoActividad.setLayout(new GridLayout(9, 1, 0, 0));
			panelTextoActividad.add(getPanelId());
			panelTextoActividad.add(getPanelNombreActividad());
			panelTextoActividad.add(getPanelIntensidadActividad());
			panelTextoActividad.add(getPanelRecursosActividad());
			panelTextoActividad.add(getPanelAccesoActividad());
			panelTextoActividad.add(getPanelHorarioActividad());
			panelTextoActividad.add(getPanel_1_1());
			panelTextoActividad.add(getPanel_1_2());
			panelTextoActividad.add(getPanelBotonCrear());
		}
		return panelTextoActividad;
	}

	private JPanel getPanelId() {
		if (panelId == null) {
			panelId = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelId.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setVgap(30);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelId.add(getLblIdActividad());
			panelId.add(getTextFieldId());
		}
		return panelId;
	}

	private JLabel getLblIdActividad() {
		if (lblIdActividad == null) {
			lblIdActividad = new JLabel("Id de la actividad:");
			lblIdActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblIdActividad;
	}

	private JTextField getTextFieldId() {
		if (textFieldId == null) {
			textFieldId = new JTextField();
			textFieldId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldId.setColumns(30);
		}
		return textFieldId;
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
			lblNombreActividad = new JLabel("Nombre de la actividad:");
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
			panelRecursosActividad.add(getTextFieldRecurso());
			panelRecursosActividad.add(getLblSinRecursos());
		}
		return panelRecursosActividad;
	}

	private JLabel getLblRecursosActividad_1() {
		if (lblRecursosActividad_1 == null) {
			lblRecursosActividad_1 = new JLabel("Recursos de la actividad:");
			lblRecursosActividad_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblRecursosActividad_1;
	}

	private JTextField getTextFieldRecurso() {
		if (textFieldRecurso == null) {
			textFieldRecurso = new JTextField();
			textFieldRecurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldRecurso.setColumns(30);
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
		String id = getTextFieldId().getText();
		String nombre = getTextFieldNombre().getText();
		String intensidad = getComboBoxIntensidad().getSelectedItem().toString().split("@")[0].toLowerCase();
		String[] recurso = getTextFieldRecurso().getText().split(",");
		String acceso = getComboBoxAcceso().getSelectedItem().toString().split("@")[0].toLowerCase();
		String horario = getComboBoxHorarioInicio().getSelectedItem().toString().split("@")[0].toLowerCase();
		if (!admin.crearActividad(id, nombre, intensidad, recurso, acceso, horario)) {
			getLblValidacionCampos().setEnabled(true);
			getLblValidacionCampos().setForeground(Color.RED);
			getLblValidacionCampos().setText("¡Los valores no son correctos, introdúcelos de nuevo!");
		} else {
			getLblValidacionCampos().setEnabled(true);
			getLblValidacionCampos().setForeground(Color.GREEN);
			getLblValidacionCampos().setText("¡Actividad creada!");
			vaciarCampos();
		}
	}

	private void vaciarCampos() {
		getTextFieldId().setText("");
		getTextFieldNombre().setText("");
		getTextFieldRecurso().setText("");
		getComboBoxIntensidad().setSelectedIndex(0);
		getComboBoxAcceso().setSelectedIndex(0);
		getComboBoxHorarioInicio().setSelectedIndex(0);
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

	private JButton getBtnMostrarPlanificarActividad() {
		if (btnMostrarPlanificarActividad == null) {
			btnMostrarPlanificarActividad = new JButton("Planificar una actividad");
			btnMostrarPlanificarActividad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanel("panelPlanificarActividad");
				}
			});
			btnMostrarPlanificarActividad.setForeground(Color.WHITE);
			btnMostrarPlanificarActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnMostrarPlanificarActividad.setBackground(new Color(205, 133, 63));
			btnMostrarPlanificarActividad.setBounds(164, 237, 530, 62);
		}
		return btnMostrarPlanificarActividad;
	}

	private JPanel getPanelPlanificarActividad() {
		if (panelPlanificarActividad == null) {
			panelPlanificarActividad = new JPanel();
			panelPlanificarActividad.setBackground(Color.WHITE);
			panelPlanificarActividad.setLayout(new GridLayout(0, 1, 0, 0));
			panelPlanificarActividad.add(getPanelIntroducirIdActividad());
		}
		return panelPlanificarActividad;
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
			comboBoxHorarioInicio.setModel(new DefaultComboBoxModel(new String[] {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
		}
		return comboBoxHorarioInicio;
	}
	private JPanel getPanelIntroducirIdActividad() {
		if (panelIntroducirIdActividad == null) {
			panelIntroducirIdActividad = new JPanel();
			panelIntroducirIdActividad.setBackground(Color.WHITE);
			panelIntroducirIdActividad.setLayout(new GridLayout(3, 1, 0, 0));
			panelIntroducirIdActividad.add(getLblIntroduceId());
			panelIntroducirIdActividad.add(getPanelPlanificacionId());
			panelIntroducirIdActividad.add(getPanelBotonesAtrasYAceptar());
		}
		return panelIntroducirIdActividad;
	}
	private JLabel getLblIntroduceId() {
		if (lblIntroduceId == null) {
			lblIntroduceId = new JLabel("Introduce el id de la actividad:");
			lblIntroduceId.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblIntroduceId.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblIntroduceId;
	}
	private JPanel getPanelPlanificacionId() {
		if (panelPlanificacionId == null) {
			panelPlanificacionId = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelPlanificacionId.getLayout();
			flowLayout.setVgap(20);
			panelPlanificacionId.setBackground(new Color(95, 158, 160));
			panelPlanificacionId.add(getTextFieldIdPlanificacion());
		}
		return panelPlanificacionId;
	}
	private JTextField getTextFieldIdPlanificacion() {
		if (textFieldIdPlanificacion == null) {
			textFieldIdPlanificacion = new JTextField();
			textFieldIdPlanificacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
			textFieldIdPlanificacion.setColumns(20);
		}
		return textFieldIdPlanificacion;
	}
	private JPanel getPanelBotonesAtrasYAceptar() {
		if (panelBotonesAtrasYAceptar == null) {
			panelBotonesAtrasYAceptar = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelBotonesAtrasYAceptar.getLayout();
			flowLayout.setHgap(20);
			flowLayout.setVgap(170);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelBotonesAtrasYAceptar.setBackground(new Color(95, 158, 160));
			panelBotonesAtrasYAceptar.add(getBtnAtrasPlanificacion());
			panelBotonesAtrasYAceptar.add(getBtnAceptarPlanificacion());
		}
		return panelBotonesAtrasYAceptar;
	}
	private JButton getBtnAceptarPlanificacion() {
		if (btnAceptarPlanificacion == null) {
			btnAceptarPlanificacion = new JButton("Aceptar");
			btnAceptarPlanificacion.setBackground(new Color(124, 252, 0));
			btnAceptarPlanificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnAceptarPlanificacion;
	}
	private JButton getBtnAtrasPlanificacion() {
		if (btnAtrasPlanificacion == null) {
			btnAtrasPlanificacion = new JButton("Atrás");
			btnAtrasPlanificacion.setBackground(new Color(135, 206, 235));
			btnAtrasPlanificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnAtrasPlanificacion;
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
			comboBoxHorarioFin.setModel(new DefaultComboBoxModel(new String[] {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}));
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
			panelInstalacion.add(getComboBox());
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
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"a"}));
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBox;
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
		}
		return lblSinLimite;
	}
	private JLabel getLblSinRecursos() {
		if (lblSinRecursos == null) {
			lblSinRecursos = new JLabel("Nota: Dejar en blanco si no se requieren recursos");
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
}
