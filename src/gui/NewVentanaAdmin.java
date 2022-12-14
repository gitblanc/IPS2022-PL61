package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import logic.Actividad;
import logic.Administrador;
import logic.Alquiler;

public class NewVentanaAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Administrador admin = new Administrador();

	private int year = LocalDateTime.now().getYear();
	private DayOfWeek diaSemana = LocalDateTime.now().getDayOfWeek();
	private int day = LocalDateTime.now().getDayOfMonth();
	private Month month = LocalDateTime.now().getMonth();
	private boolean cambioDeMes = false;

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private JPanel panelCalendario;
	private JPanel panelAcciones;
	private JPanel panelBotones;
	private JPanel panelCrearTipoActividad;
	private JButton btnCrearTipoActividad;
	private JPanel panelPlanificarActividad;
	private JButton btnPlanificarActividad;
	private JPanel panelAlquilarASocio;
	private JButton btnAlquilarInstalacion;
	private JPanel panelCancelarAlquiler;
	private JButton btnCancelarAlquiler;
	private JPanel panelCrearActividad;
	private JPanel panelTipo;
	private JPanel panelRecursos;
	private JPanel panelIntensidad;
	private JLabel lblTipo;
	private JTextField textFieldTipo;
	private JLabel lblRecursos;
	private JPanel panelInstalacion;
	private JLabel lblInstalacion;
	private JComboBox<String> comboBoxInstalaciones;
	private JLabel lblIntensidad;
	private JComboBox<String> comboBoxIntensidad;
	private JPanel panelAcceso;
	private JScrollPane scrollPaneRecursosDisponibles;
	private JList<String> listRecursosDisponibles;
	private JScrollPane scrollPaneRecursosSeleccionados;
	private JList<String> listRecursosSeleccionados;
	private JPanel panelMoverRecursos;

	DefaultListModel<String> listDisponibles = new DefaultListModel<String>();
	DefaultListModel<String> listSeleccionados = new DefaultListModel<String>();
	private JPanel paneBotonSeleccionado;
	private JButton btnMoverASeleccionado;
	private JPanel panelBotonDisponible;
	private JButton btnMoverADisponible;
	private JPanel panelBotonesCrearYAtrasTipo;
	private JButton btnAtrasTipo;
	private JButton btnCrearTipo;
	private JPanel panelSeleccionAcceso;
	private JLabel lblAcceso;
	private JComboBox<String> comboBoxAcceso;
	private JSpinner spinner;
	private JLabel lblParametrosCorrectosTipoA;
	private JPanel panelPlanificacionActividad;
	private JPanel panelTipoActividad;
	private JPanel panelFecha;
	private JLabel lblTipoActividad;
	private JComboBox<String> comboBoxTiposActividad;
	private JPanel panelSeleccionFecha;
	private JPanel panelBotonesAtrasPlanificar;
	private JButton btnAtrasPlanificarTipo;
	private JButton btnPlanificarTipo;

	private JDateChooser jDateChooser;
	private JLabel lblFechaPlanificar;
	private JTextField textFieldFechaPlanificacion;
	private JLabel lblPlanificaci??nCorrecta;
	private JPanel panelPanelDiasSemana;
	private JLabel lblLunes;
	private JLabel lblMartes;
	private JLabel lblMiercoles;
	private JLabel lblJueves;
	private JLabel lblViernes;
	private JLabel lblSabado;
	private JLabel lblDomingo;
	private JPanel panelHoras;
	private JLabel lblHoras;
	private JLabel lblHora9;
	private JLabel lblHora10;
	private JLabel lblHora11;
	private JLabel lblHora12;
	private JLabel lblHora13;
	private JLabel lblHora14;
	private JLabel lblHora15;
	private JLabel lblHora16;
	private JLabel lblHora17;
	private JLabel lblHora18;
	private JLabel lblHora19;
	private JLabel lblHora20;
	private JLabel lblHora21;
	private JLabel lblHora22;
	private JLabel lblHora23;
	private JPanel panelCeldasCalendario;
	private JPanel panelSemana;
	private JLabel lblSemanaFechaCalendario;
	private JButton btnSemanaAnterior;
	private JButton btnSemanaSiguiente;
	private JComboBox<String> comboBoxIntalacionesCalendario;

	/**
	 * Create the frame.
	 */
	public NewVentanaAdmin() {
		setTitle("Aministrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 698);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelPrincipal(), "panelPrincipal");
	}

	private void listarRecursosDisponibles(String instalacion) {
		for (String v : admin.getRecursosPorInstalacion(instalacion)) {
			listDisponibles.addElement(v);
		}
	}

	private JPanel getPanelPrincipal() {
		if (panelPrincipal == null) {
			panelPrincipal = new JPanel();
			panelPrincipal.setLayout(new BorderLayout(0, 0));
			panelPrincipal.add(getPanelCalendario(), BorderLayout.CENTER);
			panelPrincipal.add(getPanelAcciones(), BorderLayout.EAST);
		}
		return panelPrincipal;
	}

	protected void mostrarPanelAcciones(String panel) {
		((CardLayout) getPanelAcciones().getLayout()).show(getPanelAcciones(), panel);
		vaciarCampos();
	}

	private void vaciarCampos() {
		listSeleccionados.removeAllElements();
		listDisponibles.removeAllElements();
		getTextFieldTipo().setText("");
		getComboBoxAcceso().setSelectedIndex(0);
		getComboBoxIntensidad().setSelectedIndex(0);
		textFieldTipo.setBorder(LineBorder.createGrayLineBorder());
		getLblParametrosCorrectosTipoA().setVisible(false);
		int max = admin.getPlazasPorInstalacion(
				getComboBoxInstalaciones().getSelectedItem().toString().split("@")[0].toLowerCase());
		spinner.setModel(new SpinnerNumberModel(max, 1, max, 1));
		getTextFieldFechaPlanificacion().setText("");
		getLblPlanificaci??nCorrecta().setText("");
	}

	private JPanel getPanelCalendario() {
		if (panelCalendario == null) {
			panelCalendario = new JPanel();
			panelCalendario.setBackground(SystemColor.activeCaption);
			panelCalendario.setLayout(new BorderLayout(0, 0));
			panelCalendario.add(getPanelPanelDiasSemana(), BorderLayout.NORTH);
			panelCalendario.add(getPanelHoras(), BorderLayout.WEST);
			panelCalendario.add(getPanelCeldasCalendario(), BorderLayout.CENTER);
			panelCalendario.add(getPanelSemana(), BorderLayout.SOUTH);
		}
		return panelCalendario;
	}

	private JPanel getPanelAcciones() {
		if (panelAcciones == null) {
			panelAcciones = new JPanel();
			panelAcciones.setBackground(Color.WHITE);
			panelAcciones.setLayout(new CardLayout(0, 0));
			panelAcciones.add(getPanelBotones(), "panelBotones");
			panelAcciones.add(getPanelCrearActividad(), "panelCrearActividad");
			panelAcciones.add(getPanelPlanificacionActividad(), "panelPlanificacionActividad");
		}
		return panelAcciones;
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setBackground(new Color(255, 255, 255));
			panelBotones.setLayout(new GridLayout(4, 0, 0, 0));
			panelBotones.add(getPanelCrearTipoActividad());
			panelBotones.add(getPanelPlanificarActividad());
			panelBotones.add(getPanelAlquilarASocio());
			panelBotones.add(getPanelCancelarAlquiler());
		}
		return panelBotones;
	}

	private JPanel getPanelCrearTipoActividad() {
		if (panelCrearTipoActividad == null) {
			panelCrearTipoActividad = new JPanel();
			panelCrearTipoActividad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			FlowLayout fl_panelCrearTipoActividad = (FlowLayout) panelCrearTipoActividad.getLayout();
			fl_panelCrearTipoActividad.setVgap(60);
			panelCrearTipoActividad.setBackground(Color.WHITE);
			panelCrearTipoActividad.add(getBtnCrearTipoActividad());
		}
		return panelCrearTipoActividad;
	}

	private JButton getBtnCrearTipoActividad() {
		if (btnCrearTipoActividad == null) {
			btnCrearTipoActividad = new JButton("Crear tipo actividad");
			btnCrearTipoActividad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// getPanelCalendario().setVisible(false);
					mostrarPanelAcciones("panelCrearActividad");
					String instalacion = getComboBoxInstalaciones().getSelectedItem().toString().split("@")[0]
							.toLowerCase();
					listarRecursosDisponibles(instalacion);
				}
			});
			btnCrearTipoActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnCrearTipoActividad;
	}

	private JPanel getPanelPlanificarActividad() {
		if (panelPlanificarActividad == null) {
			panelPlanificarActividad = new JPanel();
			panelPlanificarActividad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			FlowLayout fl_panelPlanificarActividad = (FlowLayout) panelPlanificarActividad.getLayout();
			fl_panelPlanificarActividad.setVgap(60);
			panelPlanificarActividad.setBackground(Color.WHITE);
			panelPlanificarActividad.add(getBtnPlanificarActividad());
		}
		return panelPlanificarActividad;
	}

	private JButton getBtnPlanificarActividad() {
		if (btnPlanificarActividad == null) {
			btnPlanificarActividad = new JButton("Planificar actividad");
			btnPlanificarActividad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelAcciones("panelPlanificacionActividad");
				}
			});
			btnPlanificarActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnPlanificarActividad;
	}

	private JPanel getPanelAlquilarASocio() {
		if (panelAlquilarASocio == null) {
			panelAlquilarASocio = new JPanel();
			panelAlquilarASocio.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			FlowLayout fl_panelAlquilarASocio = (FlowLayout) panelAlquilarASocio.getLayout();
			fl_panelAlquilarASocio.setVgap(60);
			panelAlquilarASocio.setBackground(Color.WHITE);
			panelAlquilarASocio.add(getBtnAlquilarInstalacion());
		}
		return panelAlquilarASocio;
	}

	private JButton getBtnAlquilarInstalacion() {
		if (btnAlquilarInstalacion == null) {
			btnAlquilarInstalacion = new JButton("Alquilar instalaci??n");
			btnAlquilarInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnAlquilarInstalacion;
	}

	private JPanel getPanelCancelarAlquiler() {
		if (panelCancelarAlquiler == null) {
			panelCancelarAlquiler = new JPanel();
			panelCancelarAlquiler.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			FlowLayout fl_panelCancelarAlquiler = (FlowLayout) panelCancelarAlquiler.getLayout();
			fl_panelCancelarAlquiler.setVgap(60);
			panelCancelarAlquiler.setBackground(Color.WHITE);
			panelCancelarAlquiler.add(getBtnCancelarAlquiler());
		}
		return panelCancelarAlquiler;
	}

	private JButton getBtnCancelarAlquiler() {
		if (btnCancelarAlquiler == null) {
			btnCancelarAlquiler = new JButton("Cancelar alquiler");
			btnCancelarAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnCancelarAlquiler;
	}

	private JPanel getPanelCrearActividad() {
		if (panelCrearActividad == null) {
			panelCrearActividad = new JPanel();
			panelCrearActividad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelCrearActividad.setBackground(Color.WHITE);
			panelCrearActividad.setLayout(new GridLayout(5, 0, 0, 0));
			panelCrearActividad.add(getPanelTipo());
			panelCrearActividad.add(getPanelInstalacion());
			panelCrearActividad.add(getPanelRecursos());
			panelCrearActividad.add(getPanelIntensidad());
			panelCrearActividad.add(getPanelAcceso());
		}
		return panelCrearActividad;
	}

	private JPanel getPanelTipo() {
		if (panelTipo == null) {
			panelTipo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelTipo.getLayout();
			flowLayout.setVgap(60);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelTipo.setBackground(Color.WHITE);
			panelTipo.add(getLblTipo());
			panelTipo.add(getTextFieldTipo());
		}
		return panelTipo;
	}

	private JPanel getPanelRecursos() {
		if (panelRecursos == null) {
			panelRecursos = new JPanel();
			panelRecursos.setBackground(Color.WHITE);
			panelRecursos.setLayout(new GridLayout(0, 4, 0, 0));
			panelRecursos.add(getLblRecursos());
			panelRecursos.add(getScrollPane_1());
			panelRecursos.add(getPanelMoverRecursos());
			panelRecursos.add(getScrollPaneRecursosSeleccionados());
		}
		return panelRecursos;
	}

	private JPanel getPanelIntensidad() {
		if (panelIntensidad == null) {
			panelIntensidad = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelIntensidad.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setVgap(60);
			panelIntensidad.setBackground(Color.WHITE);
			panelIntensidad.add(getLblIntensidad());
			panelIntensidad.add(getComboBoxIntensidad());
		}
		return panelIntensidad;
	}

	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTipo;
	}

	private JTextField getTextFieldTipo() {
		if (textFieldTipo == null) {
			textFieldTipo = new JTextField();
			textFieldTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldTipo.setColumns(10);
		}
		return textFieldTipo;
	}

	private JLabel getLblRecursos() {
		if (lblRecursos == null) {
			lblRecursos = new JLabel("Recursos:");
			lblRecursos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblRecursos;
	}

	private JPanel getPanelInstalacion() {
		if (panelInstalacion == null) {
			panelInstalacion = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelInstalacion.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setVgap(60);
			panelInstalacion.setBackground(Color.WHITE);
			panelInstalacion.add(getLblInstalacion());
			panelInstalacion.add(getComboBoxInstalaciones());
		}
		return panelInstalacion;
	}

	private JLabel getLblInstalacion() {
		if (lblInstalacion == null) {
			lblInstalacion = new JLabel("Instalaci??n:");
			lblInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblInstalacion;
	}

	private JComboBox<String> getComboBoxInstalaciones() {
		if (comboBoxInstalaciones == null) {
			comboBoxInstalaciones = new JComboBox<String>();
			comboBoxInstalaciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listDisponibles.removeAllElements();
					listSeleccionados.removeAllElements();
					listarRecursosDisponibles(
							getComboBoxInstalaciones().getSelectedItem().toString().split("@")[0].toLowerCase());
					int max = admin.getPlazasPorInstalacion(
							getComboBoxInstalaciones().getSelectedItem().toString().split("@")[0].toLowerCase());
					spinner.setModel(new SpinnerNumberModel(max, 1, max, 1));
				}
			});
			comboBoxInstalaciones.setModel(new DefaultComboBoxModel<String>(admin.getInstalaciones()));
			comboBoxInstalaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxInstalaciones;
	}

	private JLabel getLblIntensidad() {
		if (lblIntensidad == null) {
			lblIntensidad = new JLabel("Intensidad:");
			lblIntensidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblIntensidad;
	}

	private JComboBox<String> getComboBoxIntensidad() {
		if (comboBoxIntensidad == null) {
			comboBoxIntensidad = new JComboBox<String>();
			comboBoxIntensidad.setModel(new DefaultComboBoxModel<String>(new String[] { "Alta", "Moderada", "Baja" }));
			comboBoxIntensidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxIntensidad;
	}

	private JPanel getPanelAcceso() {
		if (panelAcceso == null) {
			panelAcceso = new JPanel();
			panelAcceso.setBackground(Color.WHITE);
			panelAcceso.setLayout(new GridLayout(2, 1, 0, 0));
			panelAcceso.add(getPanelSeleccionAcceso());
			panelAcceso.add(getPanelBotonesCrearYAtrasTipo());
		}
		return panelAcceso;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPaneRecursosDisponibles == null) {
			scrollPaneRecursosDisponibles = new JScrollPane();
			scrollPaneRecursosDisponibles.setViewportView(getListRecursosDisponibles());
		}
		return scrollPaneRecursosDisponibles;
	}

	private JList<String> getListRecursosDisponibles() {
		if (listRecursosDisponibles == null) {
			listRecursosDisponibles = new JList<String>();
			listRecursosDisponibles.setLayoutOrientation(JList.VERTICAL_WRAP);
			listRecursosDisponibles.setModel(listDisponibles);
			listRecursosDisponibles.setVisibleRowCount(7);
			listRecursosDisponibles.setValueIsAdjusting(true);
			listRecursosDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return listRecursosDisponibles;
	}

	private JScrollPane getScrollPaneRecursosSeleccionados() {
		if (scrollPaneRecursosSeleccionados == null) {
			scrollPaneRecursosSeleccionados = new JScrollPane();
			scrollPaneRecursosSeleccionados.setViewportView(getListRecursosSeleccionados());
		}
		return scrollPaneRecursosSeleccionados;
	}

	private JList<String> getListRecursosSeleccionados() {
		if (listRecursosSeleccionados == null) {
			listRecursosSeleccionados = new JList<String>();
			listRecursosSeleccionados.setModel(listSeleccionados);
			listRecursosSeleccionados.setLayoutOrientation(JList.VERTICAL_WRAP);
			listRecursosSeleccionados.setVisibleRowCount(7);
			listRecursosSeleccionados.setValueIsAdjusting(true);
			listRecursosSeleccionados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return listRecursosSeleccionados;
	}

	private JPanel getPanelMoverRecursos() {
		if (panelMoverRecursos == null) {
			panelMoverRecursos = new JPanel();
			panelMoverRecursos.setBackground(Color.WHITE);
			panelMoverRecursos.setLayout(new GridLayout(2, 1, 0, 0));
			panelMoverRecursos.add(getPaneBotonSeleccionado());
			panelMoverRecursos.add(getPanelBotonDisponible());
		}
		return panelMoverRecursos;
	}

	private JPanel getPaneBotonSeleccionado() {
		if (paneBotonSeleccionado == null) {
			paneBotonSeleccionado = new JPanel();
			FlowLayout flowLayout = (FlowLayout) paneBotonSeleccionado.getLayout();
			flowLayout.setVgap(40);
			paneBotonSeleccionado.setBackground(Color.WHITE);
			paneBotonSeleccionado.add(getBtnMoverASeleccionado_1());
		}
		return paneBotonSeleccionado;
	}

	private JButton getBtnMoverASeleccionado_1() {
		if (btnMoverASeleccionado == null) {
			btnMoverASeleccionado = new JButton("-->");
			btnMoverASeleccionado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					moverASeleccionados();
				}
			});
			btnMoverASeleccionado.setFont(new Font("Tahoma", Font.PLAIN, 7));
		}
		return btnMoverASeleccionado;
	}

	protected void moverASeleccionados() {
		getListRecursosDisponibles().getSelectedValuesList().stream().forEach((data) -> {
			listSeleccionados.addElement(data);
			listDisponibles.removeElement(data);
		});
		validate();
	}

	private JPanel getPanelBotonDisponible() {
		if (panelBotonDisponible == null) {
			panelBotonDisponible = new JPanel();
			panelBotonDisponible.setBackground(Color.WHITE);
			panelBotonDisponible.add(getBtnMoverADisponible());
		}
		return panelBotonDisponible;
	}

	private JButton getBtnMoverADisponible() {
		if (btnMoverADisponible == null) {
			btnMoverADisponible = new JButton("<--");
			btnMoverADisponible.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					moverADisponible();
				}
			});
			btnMoverADisponible.setFont(new Font("Tahoma", Font.PLAIN, 7));
		}
		return btnMoverADisponible;
	}

	protected void moverADisponible() {
		getListRecursosSeleccionados().getSelectedValuesList().stream().forEach((data) -> {
			listSeleccionados.removeElement(data);
			listDisponibles.addElement(data);
		});
		validate();
	}

	private JPanel getPanelBotonesCrearYAtrasTipo() {
		if (panelBotonesCrearYAtrasTipo == null) {
			panelBotonesCrearYAtrasTipo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelBotonesCrearYAtrasTipo.getLayout();
			flowLayout.setHgap(15);
			flowLayout.setVgap(30);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelBotonesCrearYAtrasTipo.setBackground(Color.WHITE);
			panelBotonesCrearYAtrasTipo.add(getLblParametrosCorrectosTipoA());
			panelBotonesCrearYAtrasTipo.add(getBtnAtrasTipo_1());
			panelBotonesCrearYAtrasTipo.add(getBtnCrearTipo_1());
		}
		return panelBotonesCrearYAtrasTipo;
	}

	private JButton getBtnAtrasTipo_1() {
		if (btnAtrasTipo == null) {
			btnAtrasTipo = new JButton("Atr??s");
			btnAtrasTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getPanelCalendario().setVisible(true);
					mostrarPanelAcciones("panelBotones");
				}
			});
			btnAtrasTipo.setVerticalAlignment(SwingConstants.BOTTOM);
			btnAtrasTipo.setHorizontalAlignment(SwingConstants.RIGHT);
			btnAtrasTipo.setForeground(Color.WHITE);
			btnAtrasTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAtrasTipo.setBackground(new Color(165, 42, 42));
		}
		return btnAtrasTipo;
	}

	private JButton getBtnCrearTipo_1() {
		if (btnCrearTipo == null) {
			btnCrearTipo = new JButton("Crear");
			btnCrearTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comprobacionesPreviasCreacion())
						crearActividad();
				}
			});
			btnCrearTipo.setVerticalAlignment(SwingConstants.BOTTOM);
			btnCrearTipo.setHorizontalAlignment(SwingConstants.RIGHT);
			btnCrearTipo.setForeground(Color.WHITE);
			btnCrearTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCrearTipo.setBackground(new Color(0, 250, 154));
		}
		return btnCrearTipo;
	}

	protected boolean comprobacionesPreviasCreacion() {
		if (getTextFieldTipo().getText() == null || getTextFieldTipo().getText().isEmpty()) {
			getLblParametrosCorrectosTipoA().setVisible(false);
			textFieldTipo.setBorder(new LineBorder(Color.RED));
			return false;
		}
		textFieldTipo.setBorder(LineBorder.createGrayLineBorder());
		return true;
	}

	protected void crearActividad() {
		String id = UUID.randomUUID().toString();
		String tipo = getTextFieldTipo().getText();
		String intensidad = getComboBoxIntensidad().getSelectedItem().toString().split("@")[0].toLowerCase();
		List<String> recursos = getRecursosSeleccionados();
		String acceso = getComboBoxAcceso().getSelectedItem().toString().split("@")[0].toLowerCase();
		String instalacion = getComboBoxInstalaciones().getSelectedItem().toString().split("@")[0].toLowerCase();
		if (acceso.equals("reserva")) {
			int plazas = Integer.parseInt(getSpinner().getValue().toString());
			admin.crearActividad(id, tipo, intensidad, instalacion, recursos, acceso, plazas);
		} else {
			admin.crearActividad(id, tipo, intensidad, instalacion, recursos, acceso, -1);// el -1 es pq conlleva plazas
																							// ilimitadas
		}
		getLblParametrosCorrectosTipoA().setVisible(true);
		getComboBoxTiposActividad().setModel(new DefaultComboBoxModel<String>(admin.getAllTiposActividad()));
	}

	private List<String> getRecursosSeleccionados() {
		List<String> recursos = new ArrayList<>();
		for (int i = 0; i < listSeleccionados.getSize(); i++) {
			recursos.add(listSeleccionados.elementAt(i));
		}
		return recursos;
	}

	private JPanel getPanelSeleccionAcceso() {
		if (panelSeleccionAcceso == null) {
			panelSeleccionAcceso = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelSeleccionAcceso.getLayout();
			flowLayout.setVgap(20);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelSeleccionAcceso.setBackground(Color.WHITE);
			panelSeleccionAcceso.add(getLblAcceso());
			panelSeleccionAcceso.add(getComboBoxAcceso());
			panelSeleccionAcceso.add(getSpinner());
		}
		return panelSeleccionAcceso;
	}

	private JLabel getLblAcceso() {
		if (lblAcceso == null) {
			lblAcceso = new JLabel("Acceso:");
			lblAcceso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblAcceso;
	}

	private JComboBox<String> getComboBoxAcceso() {
		if (comboBoxAcceso == null) {
			comboBoxAcceso = new JComboBox<String>();
			comboBoxAcceso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getComboBoxAcceso().getSelectedItem().toString().split("@")[0].toLowerCase()
							.equals("reserva")) {
						getSpinner().setEnabled(true);
					} else {
						getSpinner().setEnabled(false);
					}
				}
			});
			comboBoxAcceso.setModel(new DefaultComboBoxModel<String>(new String[] { "libre", "reserva" }));
			comboBoxAcceso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxAcceso;
	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setEnabled(false);
			int max = admin.getPlazasPorInstalacion(
					getComboBoxInstalaciones().getSelectedItem().toString().split("@")[0].toLowerCase());
			spinner.setModel(new SpinnerNumberModel(max, 1, max, 1));
		}
		return spinner;
	}

	private JLabel getLblParametrosCorrectosTipoA() {
		if (lblParametrosCorrectosTipoA == null) {
			lblParametrosCorrectosTipoA = new JLabel("??Tipo creado!");
			lblParametrosCorrectosTipoA.setVisible(false);
			lblParametrosCorrectosTipoA.setForeground(new Color(50, 205, 50));
			lblParametrosCorrectosTipoA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblParametrosCorrectosTipoA;
	}

	private JPanel getPanelPlanificacionActividad() {
		if (panelPlanificacionActividad == null) {
			panelPlanificacionActividad = new JPanel();
			panelPlanificacionActividad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelPlanificacionActividad.setBackground(Color.WHITE);
			panelPlanificacionActividad.setLayout(new GridLayout(2, 1, 0, 0));
			panelPlanificacionActividad.add(getPanelTipoActividad());
			panelPlanificacionActividad.add(getPanelFecha());
		}
		return panelPlanificacionActividad;
	}

	private JPanel getPanelTipoActividad() {
		if (panelTipoActividad == null) {
			panelTipoActividad = new JPanel();
			panelTipoActividad.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) panelTipoActividad.getLayout();
			flowLayout.setVgap(130);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelTipoActividad.add(getLblTipoActividad());
			panelTipoActividad.add(getComboBoxTiposActividad());
		}
		return panelTipoActividad;
	}

	private JPanel getPanelFecha() {
		if (panelFecha == null) {
			panelFecha = new JPanel();
			panelFecha.setBackground(Color.WHITE);
			panelFecha.setLayout(new GridLayout(2, 0, 0, 0));
			panelFecha.add(getPanelSeleccionFecha());
			panelFecha.add(getPanelBotonesAtrasPlanificar());
		}
		return panelFecha;
	}

	private JLabel getLblTipoActividad() {
		if (lblTipoActividad == null) {
			lblTipoActividad = new JLabel("Tipo: ");
			lblTipoActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTipoActividad.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblTipoActividad;
	}

	private JComboBox<String> getComboBoxTiposActividad() {
		if (comboBoxTiposActividad == null) {
			comboBoxTiposActividad = new JComboBox<String>();
			comboBoxTiposActividad.setModel(new DefaultComboBoxModel<String>(admin.getAllTiposActividad()));
			comboBoxTiposActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxTiposActividad;
	}

	private JPanel getPanelSeleccionFecha() {
		if (panelSeleccionFecha == null) {
			panelSeleccionFecha = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelSeleccionFecha.getLayout();
			flowLayout.setVgap(60);
			flowLayout.setAlignment(FlowLayout.LEFT);
			getJdateChooser();
			panelSeleccionFecha.setBackground(Color.WHITE);
			panelSeleccionFecha.add(getLblFechaPlanificar());
			panelSeleccionFecha.add(getTextFieldFechaPlanificacion());
		}
		return panelSeleccionFecha;
	}

	private JPanel getPanelBotonesAtrasPlanificar() {
		if (panelBotonesAtrasPlanificar == null) {
			panelBotonesAtrasPlanificar = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelBotonesAtrasPlanificar.getLayout();
			flowLayout.setVgap(120);
			flowLayout.setHgap(15);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelBotonesAtrasPlanificar.setBackground(Color.WHITE);
			panelBotonesAtrasPlanificar.add(getLblPlanificaci??nCorrecta());
			panelBotonesAtrasPlanificar.add(getBtnAtrasTipo_1_1());
			panelBotonesAtrasPlanificar.add(getBtnCrearTipo_1_1());
		}
		return panelBotonesAtrasPlanificar;
	}

	private JButton getBtnAtrasTipo_1_1() {
		if (btnAtrasPlanificarTipo == null) {
			btnAtrasPlanificarTipo = new JButton("Atr??s");
			btnAtrasPlanificarTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelAcciones("panelBotones");
				}
			});
			btnAtrasPlanificarTipo.setVerticalAlignment(SwingConstants.BOTTOM);
			btnAtrasPlanificarTipo.setHorizontalAlignment(SwingConstants.RIGHT);
			btnAtrasPlanificarTipo.setForeground(Color.WHITE);
			btnAtrasPlanificarTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAtrasPlanificarTipo.setBackground(new Color(165, 42, 42));
		}
		return btnAtrasPlanificarTipo;
	}

	private JButton getBtnCrearTipo_1_1() {
		if (btnPlanificarTipo == null) {
			btnPlanificarTipo = new JButton("Planificar");
			btnPlanificarTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					planificarActividad();
					pintarPanelesCalendario(
							getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0]);
				}
			});
			btnPlanificarTipo.setVerticalAlignment(SwingConstants.BOTTOM);
			btnPlanificarTipo.setHorizontalAlignment(SwingConstants.RIGHT);
			btnPlanificarTipo.setForeground(Color.WHITE);
			btnPlanificarTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnPlanificarTipo.setBackground(new Color(0, 250, 154));
		}
		return btnPlanificarTipo;
	}

	protected void planificarActividad() {
		String tipo = getComboBoxTiposActividad().getSelectedItem().toString().split("@")[0].toLowerCase();
		String fecha = getTextFieldFechaPlanificacion().getText();
		if (fecha != null && !fecha.isEmpty()) {
			admin.planificarActividad(tipo, fecha);
			getLblPlanificaci??nCorrecta().setForeground(Color.GREEN);
			getLblPlanificaci??nCorrecta().setText("??Hecho!");
			getTextFieldFechaPlanificacion().setBorder(LineBorder.createGrayLineBorder());
		} else {
			getTextFieldFechaPlanificacion().setBorder(new LineBorder(Color.RED));
		}

	}

	private JDateChooser getJdateChooser() {
		if (jDateChooser == null) {
			jDateChooser = new JDateChooser();
		}
		return jDateChooser;
	}

	private JLabel getLblFechaPlanificar() {
		if (lblFechaPlanificar == null) {
			lblFechaPlanificar = new JLabel("Fecha:");
			lblFechaPlanificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblFechaPlanificar;
	}

	private JTextField getTextFieldFechaPlanificacion() {
		if (textFieldFechaPlanificacion == null) {
			textFieldFechaPlanificacion = new JTextField();
			textFieldFechaPlanificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldFechaPlanificacion.setColumns(10);
		}
		return textFieldFechaPlanificacion;
	}

	private JLabel getLblPlanificaci??nCorrecta() {
		if (lblPlanificaci??nCorrecta == null) {
			lblPlanificaci??nCorrecta = new JLabel("");
			lblPlanificaci??nCorrecta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblPlanificaci??nCorrecta;
	}

	private JPanel getPanelPanelDiasSemana() {
		if (panelPanelDiasSemana == null) {
			panelPanelDiasSemana = new JPanel();
			panelPanelDiasSemana.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelPanelDiasSemana.setBackground(new Color(255, 255, 255));
			panelPanelDiasSemana.setLayout(new GridLayout(0, 8, 0, 10));
			panelPanelDiasSemana.add(getLblHoras());
			panelPanelDiasSemana.add(getLblLunes());
			panelPanelDiasSemana.add(getLblMartes());
			panelPanelDiasSemana.add(getLblMiercoles());
			panelPanelDiasSemana.add(getLblJueves());
			panelPanelDiasSemana.add(getLblViernes());
			panelPanelDiasSemana.add(getLblSabado());
			panelPanelDiasSemana.add(getLblDomingo());
		}
		return panelPanelDiasSemana;
	}

	private JLabel getLblLunes() {
		if (lblLunes == null) {
			lblLunes = new JLabel("LUNES");
			lblLunes.setBackground(new Color(32, 178, 170));
			lblLunes.setHorizontalAlignment(SwingConstants.CENTER);
			lblLunes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblLunes;
	}

	private JLabel getLblMartes() {
		if (lblMartes == null) {
			lblMartes = new JLabel("MARTES");
			lblMartes.setHorizontalAlignment(SwingConstants.CENTER);
			lblMartes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblMartes;
	}

	private JLabel getLblMiercoles() {
		if (lblMiercoles == null) {
			lblMiercoles = new JLabel("MI??RCOLES");
			lblMiercoles.setHorizontalAlignment(SwingConstants.CENTER);
			lblMiercoles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblMiercoles;
	}

	private JLabel getLblJueves() {
		if (lblJueves == null) {
			lblJueves = new JLabel("JUEVES");
			lblJueves.setHorizontalAlignment(SwingConstants.CENTER);
			lblJueves.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblJueves;
	}

	private JLabel getLblViernes() {
		if (lblViernes == null) {
			lblViernes = new JLabel("VIERNES");
			lblViernes.setHorizontalAlignment(SwingConstants.CENTER);
			lblViernes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblViernes;
	}

	private JLabel getLblSabado() {
		if (lblSabado == null) {
			lblSabado = new JLabel("S??BADO");
			lblSabado.setForeground(new Color(30, 144, 255));
			lblSabado.setHorizontalAlignment(SwingConstants.CENTER);
			lblSabado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblSabado;
	}

	private JLabel getLblDomingo() {
		if (lblDomingo == null) {
			lblDomingo = new JLabel("DOMINGO");
			lblDomingo.setForeground(new Color(30, 144, 255));
			lblDomingo.setHorizontalAlignment(SwingConstants.CENTER);
			lblDomingo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblDomingo;
	}

	private JPanel getPanelHoras() {
		if (panelHoras == null) {
			panelHoras = new JPanel();
			panelHoras.setBackground(Color.WHITE);
			panelHoras.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelHoras.setLayout(new GridLayout(15, 2, 0, 0));
			panelHoras.add(getLblHora9());
			panelHoras.add(getLblHora10());
			panelHoras.add(getLblHora11());
			panelHoras.add(getLblHora12());
			panelHoras.add(getLblHora13());
			panelHoras.add(getLblHora14());
			panelHoras.add(getLblHora15());
			panelHoras.add(getLblHora16());
			panelHoras.add(getLblHora17());
			panelHoras.add(getLblHora18());
			panelHoras.add(getLblHora19());
			panelHoras.add(getLblHora20());
			panelHoras.add(getLblHora21());
			panelHoras.add(getLblHora22());
			panelHoras.add(getLblHora23());
		}
		return panelHoras;
	}

	private JLabel getLblHoras() {
		if (lblHoras == null) {
			lblHoras = new JLabel("HORAS");
			lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
			lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblHoras;
	}

	private JLabel getLblHora9() {
		if (lblHora9 == null) {
			lblHora9 = new JLabel("       9:00         ");
			lblHora9.setBackground(Color.WHITE);
			lblHora9.setHorizontalAlignment(SwingConstants.CENTER);
			lblHora9.setFont(new Font("Dialog", Font.PLAIN, 14));
		}
		return lblHora9;
	}

	private JLabel getLblHora10() {
		if (lblHora10 == null) {
			lblHora10 = new JLabel("10:00");
			lblHora10.setBackground(Color.WHITE);
			lblHora10.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora10.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora10;
	}

	private JLabel getLblHora11() {
		if (lblHora11 == null) {
			lblHora11 = new JLabel("11:00");
			lblHora11.setBackground(Color.WHITE);
			lblHora11.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora11.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora11;
	}

	private JLabel getLblHora12() {
		if (lblHora12 == null) {
			lblHora12 = new JLabel("12:00");
			lblHora12.setBackground(Color.WHITE);
			lblHora12.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora12.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora12;
	}

	private JLabel getLblHora13() {
		if (lblHora13 == null) {
			lblHora13 = new JLabel("13:00");
			lblHora13.setBackground(Color.WHITE);
			lblHora13.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora13.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora13;
	}

	private JLabel getLblHora14() {
		if (lblHora14 == null) {
			lblHora14 = new JLabel("14:00");
			lblHora14.setBackground(Color.WHITE);
			lblHora14.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora14.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora14;
	}

	private JLabel getLblHora15() {
		if (lblHora15 == null) {
			lblHora15 = new JLabel("15:00");
			lblHora15.setBackground(Color.WHITE);
			lblHora15.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora15.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora15;
	}

	private JLabel getLblHora16() {
		if (lblHora16 == null) {
			lblHora16 = new JLabel("16:00");
			lblHora16.setBackground(Color.WHITE);
			lblHora16.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora16.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora16;
	}

	private JLabel getLblHora17() {
		if (lblHora17 == null) {
			lblHora17 = new JLabel("17:00");
			lblHora17.setBackground(Color.WHITE);
			lblHora17.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora17.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora17;
	}

	private JLabel getLblHora18() {
		if (lblHora18 == null) {
			lblHora18 = new JLabel("18:00");
			lblHora18.setBackground(Color.WHITE);
			lblHora18.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora18.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora18;
	}

	private JLabel getLblHora19() {
		if (lblHora19 == null) {
			lblHora19 = new JLabel("19:00");
			lblHora19.setBackground(Color.WHITE);
			lblHora19.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora19.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora19;
	}

	private JLabel getLblHora20() {
		if (lblHora20 == null) {
			lblHora20 = new JLabel("20:00");
			lblHora20.setBackground(Color.WHITE);
			lblHora20.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora20.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora20;
	}

	private JLabel getLblHora21() {
		if (lblHora21 == null) {
			lblHora21 = new JLabel("21:00");
			lblHora21.setBackground(Color.WHITE);
			lblHora21.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora21.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora21;
	}

	private JLabel getLblHora22() {
		if (lblHora22 == null) {
			lblHora22 = new JLabel("22:00");
			lblHora22.setBackground(Color.WHITE);
			lblHora22.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora22.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora22;
	}

	private JLabel getLblHora23() {
		if (lblHora23 == null) {
			lblHora23 = new JLabel("23:00");
			lblHora23.setBackground(Color.WHITE);
			lblHora23.setFont(new Font("Dialog", Font.PLAIN, 14));
			lblHora23.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblHora23;
	}

	private JPanel getPanelCeldasCalendario() {
		if (panelCeldasCalendario == null) {
			panelCeldasCalendario = new JPanel();
			panelCeldasCalendario.setBackground(Color.WHITE);
			panelCeldasCalendario.setLayout(new GridLayout(15, 7, 0, 0));
		}
		return panelCeldasCalendario;
	}

	private JPanel getPanelSemana() {
		if (panelSemana == null) {
			panelSemana = new JPanel();
			panelSemana.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelSemana.setBackground(SystemColor.inactiveCaption);
			panelSemana.add(getBtnSemanaAnterior());
			panelSemana.add(getLblSemanaFechaCalendario());
			panelSemana.add(getBtnSemanaSiguiente());
			panelSemana.add(getComboBoxIntalacionesCalendario_1());
			pintarPanelesCalendario(getComboBoxIntalacionesCalendario_1().getItemAt(0));
		}
		return panelSemana;
	}

	private void pintarPanelesCalendario(String instalacion) {
		List<Actividad> actividades = admin.listarActividadesPorInstalacion(instalacion);
		List<Alquiler> alquileres = admin.listarAlquileres(instalacion);
		JButton bot;
		getPanelCeldasCalendario().removeAll();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 7; j++) {
				bot = new JButton();
				bot.setBackground(new Color(152, 251, 152));
				asignarTexto(bot, i, j, actividades, alquileres);
				getPanelCeldasCalendario().add(bot);
			}
		}
		validate();
	}

	private void asignarTexto(JButton p, int i, int j, List<Actividad> actividades, List<Alquiler> alquileres) {
		int lunes = Integer.parseInt(getLblLunes().getText().split(" - ")[1]);
		int martes = Integer.parseInt(getLblMartes().getText().split(" - ")[1]);
		int miercoles = Integer.parseInt(getLblMiercoles().getText().split(" - ")[1]);
		int jueves = Integer.parseInt(getLblJueves().getText().split(" - ")[1]);
		int viernes = Integer.parseInt(getLblViernes().getText().split(" - ")[1]);
		int sabado = Integer.parseInt(getLblSabado().getText().split(" - ")[1]);
		int domingo = Integer.parseInt(getLblDomingo().getText().split(" - ")[1]);

		for (Actividad a : actividades) {
			String fecha = a.getFecha();
			if (fecha != null) {
				int dia = Integer.parseInt(fecha.split("/")[0]);
				int month = Integer.parseInt(fecha.split("/")[1]);
				String horainicio = a.getHoraInicio();
				String horafin = a.getHoraFin();
				if (horainicio != null && horafin != null) {
					if (month == this.month.getValue()) {
						if (dia == lunes) {
							if (j == 0) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == martes) {
							if (j == 1) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == miercoles) {
							if (j == 2) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == jueves) {
							if (j == 3) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == viernes) {
							if (j == 4) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == sabado) {
							if (j == 5) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == domingo) {
							if (j == 6) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						}
					}
				}
			}
		}
		for (Alquiler a : alquileres) {
			String fecha = a.getFecha();
			if (fecha != null) {
				int dia = Integer.parseInt(fecha.split("/")[0]);
				int month = Integer.parseInt(fecha.split("/")[1]);
				String horainicio = a.getHora_inicio();
				String horafin = a.getHora_fin();
				if (horainicio != null && horafin != null) {
					if (month == this.month.getValue()) {
						if (dia == lunes) {
							if (j == 0) {
								pintarAlquiler(i, horainicio, horafin, p, a);
							}
						} else if (dia == martes) {
							if (j == 1) {
								pintarAlquiler(i, horainicio, horafin, p, a);
							}
						} else if (dia == miercoles) {
							if (j == 2) {
								pintarAlquiler(i, horainicio, horafin, p, a);
							}
						} else if (dia == jueves) {
							if (j == 3) {
								pintarAlquiler(i, horainicio, horafin, p, a);
							}
						} else if (dia == viernes) {
							if (j == 4) {
								pintarAlquiler(i, horainicio, horafin, p, a);
							}
						} else if (dia == sabado) {
							if (j == 5) {
								pintarAlquiler(i, horainicio, horafin, p, a);
							}
						} else if (dia == domingo) {
							if (j == 6) {
								pintarAlquiler(i, horainicio, horafin, p, a);
							}
						}
					}
				}
			}
		}
	}

	private void pintarAlquiler(int i, String horainicio, String horafin, JButton bot, Alquiler a) {
		int fin = Integer.parseInt(horafin.split(":")[0]);
		int inicio = Integer.parseInt(horainicio.split(":")[0]);
		int diferencia = fin - inicio;
		switch (i) {
		// 9:00
		case 0:
			if (horainicio.equals("9:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("9:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 9 && 9 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 10:00
		case 1:
			if (horainicio.equals("10:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio == 10) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("10:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 10 && 10 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 11:00
		case 2:
			if (horainicio.equals("11:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio == 11) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("11:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 11 && 11 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 12:00
		case 3:
			if (horainicio.equals("12:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("12:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 12 && 12 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 13:00
		case 4:
			if (horainicio.equals("13:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("13:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 13 && 13 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 14:00
		case 5:
			if (horainicio.equals("14:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("14:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 14 && 14 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 15:00
		case 6:
			if (horainicio.equals("15:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("15:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 15 && 15 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 16:00
		case 7:
			if (horainicio.equals("16:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("16:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 16 && 16 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 17:00
		case 8:
			if (horainicio.equals("17:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("17:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 17 && 17 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 18:00
		case 9:
			if (horainicio.equals("18:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("18:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 18 && 18 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 19:00
		case 10:
			if (horainicio.equals("19:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("19:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 19 && 19 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 20:00
		case 11:
			if (horainicio.equals("20:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("20:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 20 && 20 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 21:00
		case 12:
			if (horainicio.equals("21:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("21:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 21 && 21 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 22:00
		case 13:
			if (horainicio.equals("22:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("22:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (diferencia > 1 && inicio < 22 && 22 < fin) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		// 23:00
		default:
			if (horainicio.equals("23:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			if (horafin.equals("23:00")) {
				bot.setText(a.getId_socio());
				bot.setBackground(new Color(100, 149, 237));
			}
			break;
		}

	}

	private void pintarActividad(int i, String horainicio, String horafin, JButton bot, Actividad a) {
		int fin = Integer.parseInt(horafin.split(":")[0]);
		int inicio = Integer.parseInt(horainicio.split(":")[0]);
		int diferencia = fin - inicio;
		switch (i) {
		// 9:00
		case 0:
			if (horainicio.equals("9:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("9:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 9 && 9 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 10:00
		case 1:
			if (horainicio.equals("10:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio == 10) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("10:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 10 && 10 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 11:00
		case 2:
			if (horainicio.equals("11:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio == 11) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("11:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 11 && 11 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 12:00
		case 3:
			if (horainicio.equals("12:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("12:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 12 && 12 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 13:00
		case 4:
			if (horainicio.equals("13:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("13:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 13 && 13 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 14:00
		case 5:
			if (horainicio.equals("14:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("14:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 14 && 14 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 15:00
		case 6:
			if (horainicio.equals("15:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("15:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 15 && 15 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 16:00
		case 7:
			if (horainicio.equals("16:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("16:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 16 && 16 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 17:00
		case 8:
			if (horainicio.equals("17:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("17:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 17 && 17 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 18:00
		case 9:
			if (horainicio.equals("18:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("18:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 18 && 18 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 19:00
		case 10:
			if (horainicio.equals("19:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("19:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 19 && 19 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 20:00
		case 11:
			if (horainicio.equals("20:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("20:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 20 && 20 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 21:00
		case 12:
			if (horainicio.equals("21:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("21:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 21 && 21 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 22:00
		case 13:
			if (horainicio.equals("22:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("22:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (diferencia > 1 && inicio < 22 && 22 < fin) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		// 23:00
		default:
			if (horainicio.equals("23:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			if (horafin.equals("23:00")) {
				bot.setText(a.getTipo());
				bot.setBackground(Color.ORANGE);
			}
			break;
		}
	}

	private JLabel getLblSemanaFechaCalendario() {
		if (lblSemanaFechaCalendario == null) {
			lblSemanaFechaCalendario = new JLabel("");
			lblSemanaFechaCalendario.setFont(new Font("Tahoma", Font.PLAIN, 14));
			if (day > 0 && day < 7) {
				asignarNuevoMes(month.getValue() - 1);
			}
			lblSemanaFechaCalendario.setText(month.getValue() + "/" + year);
			asignarDias(diaSemana, day, month, year);
		}
		return lblSemanaFechaCalendario;
	}

	private void asignarDias(DayOfWeek diaSemana, int dia, Month month, int year) {
		boolean meses31dias = month == Month.JANUARY || month == Month.MARCH || month == Month.MAY
				|| month == Month.JULY || month == Month.AUGUST || month == Month.OCTOBER || month == Month.DECEMBER;
		boolean meses30dias = month == Month.APRIL || month == Month.JUNE || month == Month.SEPTEMBER
				|| month == Month.NOVEMBER;
		boolean bisiesto = (year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0);
		switch (diaSemana) {
		case MONDAY:
			asignarValoresEtiquetas(dia, dia + 1, dia + 2, dia + 3, dia + 4, dia + 5, dia + 6);
			break;
		case TUESDAY:
			if (dia == 1) {
				// meses de 31 d??as
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblLunes().setText("Lun - " + (30));
				} else {
					if (bisiesto) {
						getLblLunes().setText("Lun - " + (29));
					} else {
						getLblLunes().setText("Lun - " + (28));
					}
				}
			} else {
				getLblLunes().setText("Lun - " + (dia - 1));
			}
			getLblMiercoles().setText("Mier - " + (dia + 1));
			getLblJueves().setText("Jue - " + (dia + 2));
			getLblViernes().setText("Vier - " + (dia + 3));
			getLblSabado().setText("Sab - " + (dia + 4));
			getLblDomingo().setText("Dom - " + (dia + 5));
			getLblMartes().setText("Mar - " + (dia));
			break;
		case WEDNESDAY:
			if (dia == 1) {
				// meses de 31 d??as
				if (meses31dias) {
					getLblMartes().setText("Mar - " + (31));
					getLblLunes().setText("Lun - " + (30));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} else {
					if (bisiesto) {
						getLblMartes().setText("Mar - " + (29));
						getLblLunes().setText("Lun - " + (28));
					} else {
						getLblMartes().setText("Mar - " + (28));
						getLblLunes().setText("Lun - " + (27));
					}
				}
			} else if (dia == 2) {
				getLblMartes().setText("Mar - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblLunes().setText("Lun - " + (30));
				} else {
					if (bisiesto) {
						getLblLunes().setText("Lun - " + (29));
					} else {
						getLblLunes().setText("Lun - " + (28));
					}
				}
			} else {
				getLblLunes().setText("Lun - " + (dia - 2));
				getLblMartes().setText("Mar - " + (dia - 1));
			}
			getLblJueves().setText("Jue - " + (dia + 1));
			getLblViernes().setText("Vier - " + (dia + 2));
			getLblSabado().setText("Sab - " + (dia + 3));
			getLblDomingo().setText("Dom - " + (dia + 4));
			getLblMiercoles().setText("Mier - " + (dia));
			break;
		case THURSDAY:
			if (dia == 1) {
				// meses de 31 d??as
				if (meses31dias) {
					getLblMiercoles().setText("Mier - " + (31));
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblMiercoles().setText("Mier - " + (30));
					getLblMartes().setText("Mar - " + (29));
					getLblLunes().setText("Lun - " + (28));
				} else {
					if (bisiesto) {
						getLblMiercoles().setText("Mier - " + (29));
						getLblMartes().setText("Mar - " + (28));
						getLblLunes().setText("Lun - " + (27));
					} else {
						getLblMiercoles().setText("Mier - " + (28));
						getLblMartes().setText("Mar - " + (27));
						getLblLunes().setText("Lun - " + (26));
					}
				}
			} else if (dia == 2) {
				getLblMiercoles().setText("Mier - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblMartes().setText("Mar - " + (31));
					getLblLunes().setText("Lun - " + (30));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} else {
					if (bisiesto) {
						getLblMartes().setText("Mar - " + (29));
						getLblLunes().setText("Lun - " + (28));
					} else {
						getLblMartes().setText("Mar - " + (28));
						getLblLunes().setText("Lun - " + (27));
					}
				}
			} else if (dia == 3) {
				getLblMiercoles().setText("Mier - " + (2));
				getLblMartes().setText("Mar - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblLunes().setText("Lun - " + (30));
				} else {
					if (bisiesto) {
						getLblLunes().setText("Lun - " + (29));
					} else {
						getLblLunes().setText("Lun - " + (28));
					}
				}
			} else {
				getLblLunes().setText("Lun - " + (dia - 3));
				getLblMartes().setText("Mar - " + (dia - 2));
				getLblMiercoles().setText("Mier - " + (dia - 1));
			}
			getLblViernes().setText("Vier - " + (dia + 1));
			getLblSabado().setText("Sab - " + (dia + 2));
			getLblDomingo().setText("Dom - " + (dia + 3));
			getLblJueves().setText("Jue - " + (dia));
			break;
		case FRIDAY:
			if (dia == 1) {
				// meses de 31 d??as
				if (meses31dias) {
					getLblJueves().setText("Jue - " + (31));
					getLblMiercoles().setText("Mier - " + (30));
					getLblMartes().setText("Mar - " + (29));
					getLblLunes().setText("Lun - " + (28));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblJueves().setText("Jue - " + (30));
					getLblMiercoles().setText("Mier - " + (29));
					getLblMartes().setText("Mar - " + (28));
					getLblLunes().setText("Lun - " + (27));
				} else {
					if (bisiesto) {
						getLblJueves().setText("Jue - " + (29));
						getLblMiercoles().setText("Mier - " + (28));
						getLblMartes().setText("Mar - " + (27));
						getLblLunes().setText("Lun - " + (26));
					} else {
						getLblJueves().setText("Jue - " + (28));
						getLblMiercoles().setText("Mier - " + (27));
						getLblMartes().setText("Mar - " + (26));
						getLblLunes().setText("Lun - " + (25));
					}
				}
			} else if (dia == 2) {
				getLblJueves().setText("Jue - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblMiercoles().setText("Mier - " + (31));
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblMiercoles().setText("Mier - " + (30));
					getLblMartes().setText("Mar - " + (29));
					getLblLunes().setText("Lun - " + (28));
				} else {
					if (bisiesto) {
						getLblMiercoles().setText("Mier - " + (29));
						getLblMartes().setText("Mar - " + (28));
						getLblLunes().setText("Lun - " + (27));
					} else {
						getLblMiercoles().setText("Mier - " + (28));
						getLblMartes().setText("Mar - " + (27));
						getLblLunes().setText("Lun - " + (26));
					}
				}
			} else if (dia == 3) {
				getLblJueves().setText("Jue - " + (2));
				getLblMiercoles().setText("Mier - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblMartes().setText("Mar - " + (31));
					getLblLunes().setText("Lun - " + (30));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} else {
					if (bisiesto) {
						getLblMartes().setText("Mar - " + (29));
						getLblLunes().setText("Lun - " + (28));
					} else {
						getLblMartes().setText("Mar - " + (28));
						getLblLunes().setText("Lun - " + (27));
					}
				}
			} else if (dia == 4) {
				getLblJueves().setText("Jue - " + (3));
				getLblMiercoles().setText("Mier - " + (2));
				getLblMartes().setText("Mar - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblLunes().setText("Lun - " + (30));
				} else {
					if (bisiesto) {
						getLblLunes().setText("Lun - " + (29));
					} else {
						getLblLunes().setText("Lun - " + (28));
					}
				}
			} else {
				getLblLunes().setText("Lun - " + (dia - 4));
				getLblMartes().setText("Mar - " + (dia - 3));
				getLblMiercoles().setText("Mier - " + (dia - 2));
				getLblJueves().setText("Jue - " + (dia - 1));
			}
			getLblViernes().setText("Vier - " + (dia));
			getLblSabado().setText("Sab - " + (dia + 1));
			getLblDomingo().setText("Dom - " + (dia + 2));
			break;
		case SATURDAY:
			if (dia == 1) {
				// meses de 31 d??as
				if (meses31dias) {
					getLblViernes().setText("Vier - " + (31));
					getLblJueves().setText("Jue - " + (30));
					getLblMiercoles().setText("Mier - " + (29));
					getLblMartes().setText("Mar - " + (28));
					getLblLunes().setText("Lun - " + (27));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblViernes().setText("Vier - " + (30));
					getLblJueves().setText("Jue - " + (29));
					getLblMiercoles().setText("Mier - " + (28));
					getLblMartes().setText("Mar - " + (27));
					getLblLunes().setText("Lun - " + (26));
				} else {
					if (bisiesto) {
						getLblViernes().setText("Vier - " + (29));
						getLblJueves().setText("Jue - " + (28));
						getLblMiercoles().setText("Mier - " + (27));
						getLblMartes().setText("Mar - " + (26));
						getLblLunes().setText("Lun - " + (25));
					} else {
						getLblViernes().setText("Vier - " + (28));
						getLblJueves().setText("Jue - " + (27));
						getLblMiercoles().setText("Mier - " + (26));
						getLblMartes().setText("Mar - " + (25));
						getLblLunes().setText("Lun - " + (24));
					}
				}
			} else if (dia == 2) {
				getLblViernes().setText("Vier - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblJueves().setText("Jue - " + (31));
					getLblMiercoles().setText("Mier - " + (30));
					getLblMartes().setText("Mar - " + (29));
					getLblLunes().setText("Lun - " + (28));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblJueves().setText("Jue - " + (30));
					getLblMiercoles().setText("Mier - " + (29));
					getLblMartes().setText("Mar - " + (28));
					getLblLunes().setText("Lun - " + (27));
				} else {
					if (bisiesto) {
						getLblJueves().setText("Jue - " + (29));
						getLblMiercoles().setText("Mier - " + (28));
						getLblMartes().setText("Mar - " + (27));
						getLblLunes().setText("Lun - " + (26));
					} else {
						getLblJueves().setText("Jue - " + (28));
						getLblMiercoles().setText("Mier - " + (27));
						getLblMartes().setText("Mar - " + (26));
						getLblLunes().setText("Lun - " + (25));
					}
				}
			} else if (dia == 3) {
				getLblViernes().setText("Vier - " + (2));
				getLblJueves().setText("Jue - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblMiercoles().setText("Mier - " + (31));
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblMiercoles().setText("Mier - " + (30));
					getLblMartes().setText("Mar - " + (29));
					getLblLunes().setText("Lun - " + (28));
				} else {
					if (bisiesto) {
						getLblMiercoles().setText("Mier - " + (29));
						getLblMartes().setText("Mar - " + (28));
						getLblLunes().setText("Lun - " + (27));
					} else {
						getLblMiercoles().setText("Mier - " + (28));
						getLblMartes().setText("Mar - " + (27));
						getLblLunes().setText("Lun - " + (26));
					}
				}
			} else if (dia == 4) {
				getLblViernes().setText("Vier - " + (3));
				getLblJueves().setText("Jue - " + (2));
				getLblMiercoles().setText("Mier - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblMartes().setText("Mar - " + (31));
					getLblLunes().setText("Lun - " + (30));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} else {
					if (bisiesto) {
						getLblMartes().setText("Mar - " + (29));
						getLblLunes().setText("Lun - " + (28));
					} else {
						getLblMartes().setText("Mar - " + (28));
						getLblLunes().setText("Lun - " + (27));
					}
				}
			} else if (dia == 5) {
				getLblViernes().setText("Vier - " + (4));
				getLblJueves().setText("Jue - " + (3));
				getLblMiercoles().setText("Mier - " + (2));
				getLblMartes().setText("Mar - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblLunes().setText("Lun - " + (30));
				} else {
					if (bisiesto) {
						getLblLunes().setText("Lun - " + (29));
					} else {
						getLblLunes().setText("Lun - " + (28));
					}
				}
			} else {
				getLblLunes().setText("Lun - " + (dia - 5));
				getLblMartes().setText("Mar - " + (dia - 4));
				getLblMiercoles().setText("Mier - " + (dia - 3));
				getLblJueves().setText("Jue - " + (dia - 2));
				getLblViernes().setText("Vier - " + (dia - 1));
			}
			getLblSabado().setText("Sab - " + (dia));
			getLblDomingo().setText("Dom - " + (dia + 1));
			break;
		default:// domingo
			if (dia == 1) {
				// meses de 31 d??as
				if (meses31dias) {
					getLblSabado().setText("Sab - " + (31));
					getLblViernes().setText("Vier - " + (30));
					getLblJueves().setText("Jue - " + (29));
					getLblMiercoles().setText("Mier - " + (28));
					getLblMartes().setText("Mar - " + (27));
					getLblLunes().setText("Lun - " + (26));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblSabado().setText("Sab - " + (30));
					getLblViernes().setText("Vier - " + (29));
					getLblJueves().setText("Jue - " + (28));
					getLblMiercoles().setText("Mier - " + (27));
					getLblMartes().setText("Mar - " + (26));
					getLblLunes().setText("Lun - " + (25));
				} else {
					if (bisiesto) {
						getLblSabado().setText("Sab - " + (29));
						getLblViernes().setText("Vier - " + (28));
						getLblJueves().setText("Jue - " + (27));
						getLblMiercoles().setText("Mier - " + (26));
						getLblMartes().setText("Mar - " + (25));
						getLblLunes().setText("Lun - " + (24));
					} else {
						getLblSabado().setText("Sab - " + (28));
						getLblViernes().setText("Vier - " + (27));
						getLblJueves().setText("Jue - " + (26));
						getLblMiercoles().setText("Mier - " + (25));
						getLblMartes().setText("Mar - " + (24));
						getLblLunes().setText("Lun - " + (23));
					}
				}
			} else if (dia == 2) {
				getLblSabado().setText("Sab - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblViernes().setText("Vier - " + (31));
					getLblJueves().setText("Jue - " + (30));
					getLblMiercoles().setText("Mier - " + (29));
					getLblMartes().setText("Mar - " + (28));
					getLblLunes().setText("Lun - " + (27));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblViernes().setText("Vier - " + (30));
					getLblJueves().setText("Jue - " + (29));
					getLblMiercoles().setText("Mier - " + (28));
					getLblMartes().setText("Mar - " + (27));
					getLblLunes().setText("Lun - " + (26));
				} else {
					if (bisiesto) {
						getLblViernes().setText("Vier - " + (29));
						getLblJueves().setText("Jue - " + (28));
						getLblMiercoles().setText("Mier - " + (27));
						getLblMartes().setText("Mar - " + (26));
						getLblLunes().setText("Lun - " + (25));
					} else {
						getLblViernes().setText("Vier - " + (28));
						getLblJueves().setText("Jue - " + (27));
						getLblMiercoles().setText("Mier - " + (26));
						getLblMartes().setText("Mar - " + (25));
						getLblLunes().setText("Lun - " + (24));
					}
				}
			} else if (dia == 3) {
				getLblSabado().setText("Sab - " + (2));
				getLblViernes().setText("Vier - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblJueves().setText("Jue - " + (31));
					getLblMiercoles().setText("Mier - " + (30));
					getLblMartes().setText("Mar - " + (29));
					getLblLunes().setText("Lun - " + (28));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblJueves().setText("Jue - " + (30));
					getLblMiercoles().setText("Mier - " + (29));
					getLblMartes().setText("Mar - " + (28));
					getLblLunes().setText("Lun - " + (27));
				} else {
					if (bisiesto) {
						getLblJueves().setText("Jue - " + (29));
						getLblMiercoles().setText("Mier - " + (28));
						getLblMartes().setText("Mar - " + (27));
						getLblLunes().setText("Lun - " + (26));
					} else {
						getLblJueves().setText("Jue - " + (28));
						getLblMiercoles().setText("Mier - " + (27));
						getLblMartes().setText("Mar - " + (26));
						getLblLunes().setText("Lun - " + (25));
					}
				}
			} else if (dia == 4) {
				getLblSabado().setText("Sab - " + (3));
				getLblViernes().setText("Vier - " + (2));
				getLblJueves().setText("Jue - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblMiercoles().setText("Mier - " + (31));
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblMiercoles().setText("Mier - " + (30));
					getLblMartes().setText("Mar - " + (29));
					getLblLunes().setText("Lun - " + (28));
				} else {
					if (bisiesto) {
						getLblMiercoles().setText("Mier - " + (29));
						getLblMartes().setText("Mar - " + (28));
						getLblLunes().setText("Lun - " + (27));
					} else {
						getLblMiercoles().setText("Mier - " + (28));
						getLblMartes().setText("Mar - " + (27));
						getLblLunes().setText("Lun - " + (26));
					}
				}
			} else if (dia == 5) {
				getLblSabado().setText("Sab - " + (4));
				getLblViernes().setText("Vier - " + (3));
				getLblJueves().setText("Jue - " + (2));
				getLblMiercoles().setText("Mier - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblMartes().setText("Mar - " + (31));
					getLblLunes().setText("Lun - " + (30));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} else {
					if (bisiesto) {
						getLblMartes().setText("Mar - " + (29));
						getLblLunes().setText("Lun - " + (28));
					} else {
						getLblMartes().setText("Mar - " + (28));
						getLblLunes().setText("Lun - " + (27));
					}
				}
			} else if (dia == 6) {
				getLblSabado().setText("Sab - " + (5));
				getLblViernes().setText("Vier - " + (4));
				getLblJueves().setText("Jue - " + (3));
				getLblMiercoles().setText("Mier - " + (2));
				getLblMartes().setText("Mar - " + (1));
				// meses de 31 d??as
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 d??as
				else if (meses30dias) {
					getLblLunes().setText("Lun - " + (30));
				} else {
					if (bisiesto) {
						getLblLunes().setText("Lun - " + (29));
					} else {
						getLblLunes().setText("Lun - " + (28));
					}
				}
			} else {
				getLblLunes().setText("Lun - " + (dia - 6));
				getLblMartes().setText("Mar - " + (dia - 5));
				getLblMiercoles().setText("Mier - " + (dia - 4));
				getLblJueves().setText("Jue - " + (dia - 3));
				getLblViernes().setText("Vier - " + (dia - 2));
				getLblSabado().setText("Sab - " + (dia - 1));
			}
			getLblDomingo().setText("Dom - " + (dia));
			break;
		}
	}

	private JButton getBtnSemanaAnterior() {
		if (btnSemanaAnterior == null) {
			btnSemanaAnterior = new JButton("<--");
			btnSemanaAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarSemanaAnterior();
					getLblSemanaFechaCalendario().setText(month.getValue() + "/" + year);
					pintarPanelesCalendario(
							getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0]);
				}
			});
			btnSemanaAnterior.setForeground(SystemColor.text);
			btnSemanaAnterior.setBackground(SystemColor.textInactiveText);
			btnSemanaAnterior.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnSemanaAnterior;
	}

	protected void mostrarSemanaAnterior() {
		int previousMonth = month.getValue() - 1;

		boolean meses31dias = previousMonth == 1 || previousMonth == 3 || previousMonth == 5 || previousMonth == 7
				|| previousMonth == 8 || previousMonth == 10 || previousMonth == 12;
		boolean meses30dias = previousMonth == 4 || previousMonth == 6 || previousMonth == 9 || previousMonth == 11;
		boolean bisiesto = (year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0);

		int lastDay = Integer.parseInt(getLblLunes().getText().split(" - ")[1].toString());

		if (lastDay == 1) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				this.year--;
			} else
				asignarNuevoMes(previousMonth);
			if (meses31dias) {
				asignarValoresEtiquetas(25, 26, 27, 28, 29, 30, 31);
			} else if (meses30dias) {
				asignarValoresEtiquetas(24, 25, 26, 27, 28, 29, 30);
			} else {
				if (bisiesto) {
					asignarValoresEtiquetas(23, 24, 25, 26, 27, 28, 29);
					asignarNuevoMes(previousMonth);
				} else {
					asignarValoresEtiquetas(22, 23, 24, 25, 26, 27, 28);
				}
			}
		} else if (lastDay == 2) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				this.year--;
			} else
				asignarNuevoMes(previousMonth);
			if (meses31dias) {
				asignarValoresEtiquetas(26, 27, 28, 29, 30, 31, 1);
			} else if (meses30dias) {
				asignarValoresEtiquetas(25, 26, 27, 28, 29, 30, 1);
			} else {
				if (bisiesto) {
					asignarValoresEtiquetas(24, 25, 26, 27, 28, 29, 1);
				} else {
					asignarValoresEtiquetas(23, 24, 25, 26, 27, 28, 29);
				}
			}
		} else if (lastDay == 3) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				this.year--;
			} else
				asignarNuevoMes(previousMonth);
			if (meses31dias) {
				asignarValoresEtiquetas(27, 28, 29, 30, 31, 1, 2);
			} else if (meses30dias) {
				asignarValoresEtiquetas(26, 27, 28, 29, 30, 1, 2);
			} else {
				if (bisiesto) {
					asignarValoresEtiquetas(25, 26, 27, 28, 29, 1, 2);
				} else {
					asignarValoresEtiquetas(24, 25, 26, 27, 28, 1, 2);
				}
			}
		} else if (lastDay == 4) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				this.year--;
			} else
				asignarNuevoMes(previousMonth);
			if (meses31dias) {
				asignarValoresEtiquetas(28, 29, 30, 31, 1, 2, 3);
			} else if (meses30dias) {
				asignarValoresEtiquetas(27, 28, 29, 30, 1, 2, 3);
			} else {
				if (bisiesto) {
					asignarValoresEtiquetas(26, 27, 28, 29, 1, 2, 3);
				} else {
					asignarValoresEtiquetas(25, 26, 27, 28, 1, 2, 3);
				}
			}
		} else if (lastDay == 5) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				this.year--;
			} else
				asignarNuevoMes(previousMonth);
			if (meses31dias) {
				asignarValoresEtiquetas(29, 30, 31, 1, 2, 3, 4);
			} else if (meses30dias) {
				asignarValoresEtiquetas(28, 29, 30, 1, 2, 3, 4);
			} else {
				if (bisiesto) {
					asignarValoresEtiquetas(27, 28, 29, 1, 2, 3, 4);
				} else {
					asignarValoresEtiquetas(26, 27, 28, 1, 2, 3, 4);
				}
			}
		} else if (lastDay == 6) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				this.year--;
			} else
				asignarNuevoMes(previousMonth);
			if (meses31dias) {
				asignarValoresEtiquetas(30, 31, 1, 2, 3, 4, 5);
			} else if (meses30dias) {
				asignarValoresEtiquetas(29, 30, 1, 2, 3, 4, 5);
			} else {
				if (bisiesto) {
					asignarValoresEtiquetas(28, 29, 1, 2, 3, 4, 5);
				} else {
					asignarValoresEtiquetas(27, 28, 1, 2, 3, 4, 5);
				}
			}
		} else if (lastDay == 7) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				this.year--;
			} else
				asignarNuevoMes(previousMonth);
			if (meses31dias) {
				asignarValoresEtiquetas(31, 1, 2, 3, 4, 5, 6);
			} else if (meses30dias) {
				asignarValoresEtiquetas(30, 1, 2, 3, 4, 5, 6);
			} else {
				if (bisiesto) {
					asignarValoresEtiquetas(29, 1, 2, 3, 4, 5, 6);
				} else {
					asignarValoresEtiquetas(28, 1, 2, 3, 4, 5, 6);
				}
			}
		} else {
			asignarValoresEtiquetas(lastDay - 7, lastDay - 6, lastDay - 5, lastDay - 4, lastDay - 3, lastDay - 2,
					lastDay - 1);
			cambioDeMes = false;
		}
	}

	private void asignarNuevoMes(int month) {
		switch (month) {
		case 1:
			this.month = Month.JANUARY;
			break;
		case 2:
			this.month = Month.FEBRUARY;
			break;
		case 3:
			this.month = Month.MARCH;
			break;
		case 4:
			this.month = Month.APRIL;
			break;
		case 5:
			this.month = Month.MAY;
			break;
		case 6:
			this.month = Month.JUNE;
			break;
		case 7:
			this.month = Month.JULY;
			break;
		case 8:
			this.month = Month.AUGUST;
			break;
		case 9:
			this.month = Month.SEPTEMBER;
			break;
		case 10:
			this.month = Month.OCTOBER;
			break;
		case 11:
			this.month = Month.NOVEMBER;
			break;
		default:
			this.month = Month.DECEMBER;
			break;
		}
		cambioDeMes = true;
	}

	private JButton getBtnSemanaSiguiente() {
		if (btnSemanaSiguiente == null) {
			btnSemanaSiguiente = new JButton("-->");
			btnSemanaSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarSemanaSiguiente();
					getLblSemanaFechaCalendario().setText(month.getValue() + "/" + year);
					pintarPanelesCalendario(
							getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0]);
				}
			});
			btnSemanaSiguiente.setForeground(SystemColor.text);
			btnSemanaSiguiente.setBackground(SystemColor.textInactiveText);
			btnSemanaSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnSemanaSiguiente;
	}

	protected void mostrarSemanaSiguiente() {
		int actualMonth = month.getValue();
		int nextMonth = actualMonth + 1;
		int actualYear = Integer.parseInt(getLblSemanaFechaCalendario().getText().split("/")[1].toString());
		boolean actualMes31dias = actualMonth == 1 || actualMonth == 3 || actualMonth == 5 || actualMonth == 7
				|| actualMonth == 8 || actualMonth == 10 || actualMonth == 12;
		boolean actualMes30dias = actualMonth == 4 || actualMonth == 6 || actualMonth == 9 || actualMonth == 11;

		boolean bisiesto = (actualYear % 4 == 0 && actualYear % 100 != 0)
				|| (actualYear % 100 == 0 && actualYear % 400 == 0);

		int lastDay = Integer.parseInt(getLblDomingo().getText().split(" - ")[1].toString());

		if (lastDay < Integer.parseInt(getLblLunes().getText().split(" - ")[1].toString())) {
			if (actualMonth == 12) {
				asignarNuevoMes(1);
				this.year += 1;
			} else
				asignarNuevoMes(nextMonth);
		}

		// Si el mes tiene 31 dias
		if (actualMes31dias) {
			if (lastDay == 31) {
				asignarValoresEtiquetas(1, 2, 3, 4, 5, 6, 7);
			} else if (lastDay == 30) {
				asignarValoresEtiquetas(31, 1, 2, 3, 4, 5, 6);
			} else if (lastDay == 29) {
				asignarValoresEtiquetas(30, 31, 1, 2, 3, 4, 5);
			} else if (lastDay == 28) {
				asignarValoresEtiquetas(29, 30, 31, 1, 2, 3, 4);
			} else if (lastDay == 27) {
				asignarValoresEtiquetas(28, 29, 30, 31, 1, 2, 3);
			} else if (lastDay == 26) {
				asignarValoresEtiquetas(27, 28, 29, 30, 31, 1, 2);
			} else if (lastDay == 25) {
				asignarValoresEtiquetas(26, 27, 28, 29, 30, 31, 1);
			} else {
				asignarValoresEtiquetas(lastDay + 1, lastDay + 2, lastDay + 3, lastDay + 4, lastDay + 5, lastDay + 6,
						lastDay + 7);
				cambioDeMes = false;
			}
		}
		// Si el mes tiene 30 dias
		else if (actualMes30dias) {
			if (lastDay == 30) {
				asignarValoresEtiquetas(1, 2, 3, 4, 5, 6, 7);
			} else if (lastDay == 29) {
				asignarValoresEtiquetas(30, 1, 2, 3, 4, 5, 6);
			} else if (lastDay == 28) {
				asignarValoresEtiquetas(29, 30, 1, 2, 3, 4, 5);
			} else if (lastDay == 27) {
				asignarValoresEtiquetas(28, 29, 30, 1, 2, 3, 4);
			} else if (lastDay == 26) {
				asignarValoresEtiquetas(27, 28, 29, 30, 1, 2, 3);
			} else if (lastDay == 25) {
				asignarValoresEtiquetas(26, 27, 28, 29, 30, 1, 2);
			} else if (lastDay == 24) {
				asignarValoresEtiquetas(25, 26, 27, 28, 29, 30, 1);
			} else {
				asignarValoresEtiquetas(lastDay + 1, lastDay + 2, lastDay + 3, lastDay + 4, lastDay + 5, lastDay + 6,
						lastDay + 7);
				cambioDeMes = false;
			}
		}
		// Si es febrero
		else if (month.getValue() == 2) {
			// si es un a??o bisiesto
			if (bisiesto) {
				if (lastDay == 29) {
					asignarValoresEtiquetas(1, 2, 3, 4, 5, 6, 7);
				} else if (lastDay == 28) {
					asignarValoresEtiquetas(29, 1, 2, 3, 4, 5, 6);
				} else if (lastDay == 27) {
					asignarValoresEtiquetas(28, 29, 1, 2, 3, 4, 5);
				} else if (lastDay == 26) {
					asignarValoresEtiquetas(27, 28, 29, 1, 2, 3, 4);
				} else if (lastDay == 25) {
					asignarValoresEtiquetas(26, 27, 28, 29, 1, 2, 3);
				} else if (lastDay == 24) {
					asignarValoresEtiquetas(25, 26, 27, 28, 29, 1, 2);
				} else if (lastDay == 23) {
					asignarValoresEtiquetas(24, 25, 26, 27, 28, 29, 1);
				} else {
					asignarValoresEtiquetas(lastDay + 1, lastDay + 2, lastDay + 3, lastDay + 4, lastDay + 5,
							lastDay + 6, lastDay + 7);
					cambioDeMes = false;
				}
			} else {
				if (lastDay == 28) {
					asignarValoresEtiquetas(1, 2, 3, 4, 5, 6, 7);
				} else if (lastDay == 27) {
					asignarValoresEtiquetas(28, 1, 2, 3, 4, 5, 6);
				} else if (lastDay == 26) {
					asignarValoresEtiquetas(27, 28, 1, 2, 3, 4, 5);
				} else if (lastDay == 25) {
					asignarValoresEtiquetas(26, 27, 28, 1, 2, 3, 4);
				} else if (lastDay == 24) {
					asignarValoresEtiquetas(25, 26, 27, 28, 1, 2, 3);
				} else if (lastDay == 23) {
					asignarValoresEtiquetas(24, 25, 26, 27, 28, 1, 2);
				} else if (lastDay == 22) {
					asignarValoresEtiquetas(23, 24, 25, 26, 27, 28, 1);
				} else {
					asignarValoresEtiquetas(lastDay + 1, lastDay + 2, lastDay + 3, lastDay + 4, lastDay + 5,
							lastDay + 6, lastDay + 7);
					cambioDeMes = false;
				}
			}
			getLblSemanaFechaCalendario().setText(actualMonth + "/" + actualYear);
		}

	}

	private void asignarValoresEtiquetas(int lunes, int martes, int miercoles, int jueves, int viernes, int sabado,
			int domingo) {
		getLblLunes().setText("Lun - " + (lunes));
		getLblMartes().setText("Mar - " + (martes));
		getLblMiercoles().setText("Mier - " + (miercoles));
		getLblJueves().setText("Jue - " + (jueves));
		getLblViernes().setText("Vier - " + (viernes));
		getLblSabado().setText("Sab - " + (sabado));
		getLblDomingo().setText("Dom - " + (domingo));
		cambioDeMes = true;
	}

	private JComboBox<String> getComboBoxIntalacionesCalendario_1() {
		if (comboBoxIntalacionesCalendario == null) {
			comboBoxIntalacionesCalendario = new JComboBox<String>();
			comboBoxIntalacionesCalendario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pintarPanelesCalendario(comboBoxIntalacionesCalendario.getSelectedItem().toString().split("@")[0]);
				}
			});
			comboBoxIntalacionesCalendario.setModel(new DefaultComboBoxModel<String>(admin.getInstalaciones()));
			comboBoxIntalacionesCalendario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxIntalacionesCalendario;
	}

	public boolean getCambioDeMes() {
		return cambioDeMes;
	}
}
