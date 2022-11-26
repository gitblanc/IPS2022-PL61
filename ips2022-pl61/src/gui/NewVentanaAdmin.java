package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
	private int[] diasRestantes;
	private List<Integer> mesesRestantes = new ArrayList<>();

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
	private JLabel lblPlanificaciónCorrecta;
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
	private JPanel panelCeldasCalendario;
	private JPanel panelSemana;
	private JLabel lblSemanaFechaCalendario;
	private JButton btnSemanaAnterior;
	private JButton btnSemanaSiguiente;
	private JComboBox<String> comboBoxIntalacionesCalendario;
	private JPanel panelCancelacionAlquiler;
	private JPanel panelSociosParaCancelar;
	private JPanel panelAlquiler;
	private JPanel panelAtrasCancelar;
	private JLabel lblIdSocio;
	private JComboBox<String> comboBoxSocios;
	private JLabel lblAlquiler;
	private JComboBox<String> comboBoxAlquileresDeSocio;
	private JButton btnAtrasCancelarAlq;
	private JButton btnCancelacionAlquiler;
	private JPanel panelTipoActividadSelector;
	private JLabel lblspace;
	private JPanel panelHorario;
	private JLabel lblHorario;
	private JComboBox<String> comboBoxHoraInicio;
	private JComboBox<String> comboBoxHoraFin;
	private JPanel panelAlquilarInstalacionASocio;
	private JPanel panelIdSocioAlquilarInstalacion;
	private JLabel lblIdSocioAlquilarInst;
	private JComboBox<String> comboBoxIdSociosAlquilarInst;
	private JPanel panelInstalacionAlquInst;
	private JLabel lblInstalacionAlqInst;
	private JPanel panelHoraInicioHoraFin;
	private JLabel lblHorario_1;
	private JComboBox<String> comboBoxHoraInicioAlqInst;
	private JComboBox<String> comboBoxHoraFinAlqInst;
	private JPanel panelFechaAlqInst;
	private JLabel lblFechaAlqInst;
	private JTextField textFieldFechaAlqInst;
	private JPanel paneBtnAtrasAlquilar;
	private JLabel lblAlquilerCorrecto;
	private JButton btnAtrasAlquilar;
	private JButton btnAlquilar;
	private JLabel lblspace_1;
	private JLabel lblHorarioOcupado;
	private JLabel lblHorarioOcupado1;
	private JPanel panel9;
	private JPanel panel10;
	private JPanel panel11;
	private JPanel panel12;
	private JPanel panel13;
	private JPanel panel14;
	private JPanel panel15;
	private JPanel panel16;
	private JPanel panel17;
	private JPanel panel18;
	private JPanel panel19;
	private JPanel panel20;
	private JPanel panel21;
	private JPanel panel22;
	private JPanel panel23;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	private JLabel lbl15;
	private JLabel lbl16;
	private JLabel lbl17;
	private JLabel lbl18;
	private JLabel lbl19;
	private JLabel lbl20;
	private JLabel lbl21;
	private JLabel lbl22;
	private JLabel lbl23;
	private JRadioButton rdbtnRepetirActividadCadaDia;
	private JPanel panelFechaPlPrincipal;
	private JLabel lblFechaPlanificar;
	private JTextField textFieldFechaPlanificacion;
	private JPanel panelRepetirVariosDias;
	private JScrollPane scrollPaneDiasRepetir;

	private JList<String> listDiasDisponibles;
	DefaultListModel<String> listDiasDisponiblesModel = new DefaultListModel<String>();

	ButtonGroup Button_Group = new ButtonGroup(); // Creates new button group
	private JRadioButton rdbtnRepetirVariosDias;
	private JRadioButton rdbtnNoRepetir;

	private boolean lunesMixed;
	private boolean martesMixed;
	private boolean miercolesMixed;
	private boolean juevesMixed;
	private boolean viernesMixed;
	private boolean sabadoMixed;
	private boolean domingoMixed;
	private JPanel panelCerrarInstalacion;
	private JButton btnNewButton;
	private JPanel panelCerrarInstalacionAlquileres;
	private JPanel panelInstalacionesCerrar;
	private JPanel panelDiaCerrarInstalaciones;
	private JPanel panelAtrasCerrarInstalacion;
	private JComboBox<String> comboBoxInstalacionesACerrar;
	private JLabel lblInstalacionACerrar;
	private JLabel lblFechaInstalacionCerrada;
	private JTextField textFieldFechaCierre;
	private JLabel lblRecordatorioAlquileres;
	private JPanel panelBotonesAtrasYCancelar;
	private JButton btnAtrasCerrar;
	private JButton btnCrearCerrar;
	private JLabel lblNewLabel;
	private JLabel lblTodoCorrectoCerrar;

	/**
	 * Create the frame.
	 */
	public NewVentanaAdmin() {
		setMinimumSize(new Dimension(1096, 701));
		setTitle("Aministrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelPrincipal(), "panelPrincipal");

		Button_Group.add(getRdbtnRepetirActividadCadaDia_1());
		Button_Group.add(getRdbtnRepetirVariosDias());
		Button_Group.add(getRdbtnNoRepetir());
	}

	private void listarRecursosDisponibles(String instalacion) {
		for (String v : admin.getAllRecursos()) {
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
				getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0].toLowerCase());
		spinner.setModel(new SpinnerNumberModel(max, 1, max, 1));
		getTextFieldFechaPlanificacion().setText("");
		getLblPlanificaciónCorrecta().setText("");
		getLblAlquilerCorrecto().setText("");
		getTextFieldFechaAlqInst().setText("");
		getLblHorarioOcupado().setVisible(false);
		getLblHorarioOcupado1().setVisible(false);
		getTextFieldFechaCierre().setText("");
		this.mesesRestantes = new ArrayList<>();
		this.diasRestantes = null;
		getLblTodoCorrectoCerrar().setVisible(false);
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
			panelAcciones.add(getPanelCancelacionAlquiler(), "panelCancelacionAlquiler");
			panelAcciones.add(getPanelAlquilarInstalacionASocio(), "panelAlquilarASocio");
			panelAcciones.add(getPanelCerrarInstalacionAlquileres(), "panelCerrarInstalacion");
		}
		return panelAcciones;
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setBackground(new Color(255, 255, 255));
			panelBotones.setLayout(new GridLayout(5, 0, 0, 0));
			panelBotones.add(getPanelCrearTipoActividad());
			panelBotones.add(getPanelPlanificarActividad());
			panelBotones.add(getPanelAlquilarASocio());
			panelBotones.add(getPanelCancelarAlquiler());
			panelBotones.add(getPanelCerrarInstalacion());
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
					String instalacion = getComboBoxIntalacionesCalendario_1().getSelectedItem().toString()
							.split("@")[0].toLowerCase();
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
			btnAlquilarInstalacion = new JButton("Alquilar instalación");
			btnAlquilarInstalacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelAcciones("panelAlquilarASocio");
				}
			});
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
			btnCancelarAlquiler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelAcciones("panelCancelacionAlquiler");
				}
			});
			btnCancelarAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnCancelarAlquiler;
	}

	private JPanel getPanelCrearActividad() {
		if (panelCrearActividad == null) {
			panelCrearActividad = new JPanel();
			panelCrearActividad.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelCrearActividad.setBackground(Color.WHITE);
			panelCrearActividad.setLayout(new GridLayout(4, 0, 0, 0));
			panelCrearActividad.add(getPanelTipo());
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
			listRecursosDisponibles.setVisibleRowCount(Integer.MAX_VALUE);
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
			listRecursosSeleccionados.setVisibleRowCount(Integer.MAX_VALUE);
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
			btnAtrasTipo = new JButton("Atrás");
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
						crearActividad(null, null, null, null);
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

	protected void crearActividad(Actividad actividad, String date, String inicio, String fin) {
		if (actividad == null) {
			String id = UUID.randomUUID().toString();
			String tipo = getTextFieldTipo().getText();
			String intensidad = getComboBoxIntensidad().getSelectedItem().toString().split("@")[0].toLowerCase();
			List<String> recursos = getRecursosSeleccionados();
			String acceso = getComboBoxAcceso().getSelectedItem().toString().split("@")[0].toLowerCase();
			String instalacion = getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0]
					.toLowerCase();
			if (acceso.equals("reserva")) {
				int plazas = Integer.parseInt(getSpinner().getValue().toString());
				admin.crearActividad(id, tipo, intensidad, instalacion, recursos, acceso, plazas);
			} else {
				admin.crearActividad(id, tipo, intensidad, instalacion, recursos, acceso, -1);// el -1 es pq conlleva
																								// plazas
																								// ilimitadas
			}
			getLblParametrosCorrectosTipoA().setVisible(true);
			getComboBoxTiposActividad().setModel(new DefaultComboBoxModel<String>(admin.getAllTiposActividad()));
		} else {
			String id = UUID.randomUUID().toString();
			admin.crearActividad(id, actividad.getTipo(), actividad.getIntensidad(), actividad.getInstalacion(),
					actividad.getAllRecursos(actividad.getId()), actividad.getAcceso(), actividad.getPlazas());
			admin.planificarActividad(actividad.getTipo(), date, inicio, fin, id);
		}
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
			spinner.setModel(new SpinnerNumberModel(10, 1, 10, 1));
		}
		return spinner;
	}

	private JLabel getLblParametrosCorrectosTipoA() {
		if (lblParametrosCorrectosTipoA == null) {
			lblParametrosCorrectosTipoA = new JLabel("¡Tipo creado!");
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
			panelTipoActividad.setLayout(new GridLayout(2, 1, 0, 0));
			panelTipoActividad.add(getPanelTipoActividadSelector());
			panelTipoActividad.add(getPanelHorario());
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
			getJdateChooser();
			panelSeleccionFecha.setBackground(Color.WHITE);
			panelSeleccionFecha.setLayout(new GridLayout(4, 1, 0, 0));
			panelSeleccionFecha.add(getPanelFechaPlPrincipal());
			panelSeleccionFecha.add(getRdbtnRepetirActividadCadaDia_1());
			panelSeleccionFecha.add(getPanelRepetirVariosDias());
			panelSeleccionFecha.add(getRdbtnNoRepetir());
		}
		return panelSeleccionFecha;
	}

	private JPanel getPanelBotonesAtrasPlanificar() {
		if (panelBotonesAtrasPlanificar == null) {
			panelBotonesAtrasPlanificar = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelBotonesAtrasPlanificar.getLayout();
			flowLayout.setVgap(120);
			flowLayout.setHgap(10);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelBotonesAtrasPlanificar.setBackground(Color.WHITE);
			panelBotonesAtrasPlanificar.add(getLblPlanificaciónCorrecta());
			panelBotonesAtrasPlanificar.add(getLblHorarioOcupado());
			panelBotonesAtrasPlanificar.add(getBtnAtrasTipo_1_1());
			panelBotonesAtrasPlanificar.add(getBtnCrearTipo_1_1());
			panelBotonesAtrasPlanificar.add(getLblspace());
		}
		return panelBotonesAtrasPlanificar;
	}

	private JButton getBtnAtrasTipo_1_1() {
		if (btnAtrasPlanificarTipo == null) {
			btnAtrasPlanificarTipo = new JButton("Atrás");
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
					String fecha = getTextFieldFechaPlanificacion().getText();
					String inicio = getComboBoxHoraInicio().getSelectedItem().toString().split("@")[0];
					String fin = getComboBoxHoraFin().getSelectedItem().toString().split("@")[0];
					String instalacion = getComboBoxIntalacionesCalendario_1().getSelectedItem().toString()
							.split("@")[0];
					if (getRdbtnRepetirActividadCadaDia_1().isSelected()) {
						if (!existsActividad(fecha, inicio, fin) && !existsAlquiler(fecha, inicio, fin, instalacion)
								&& !existsActividadOrAlquilerInAFutureDay(fecha, inicio, fin, instalacion)) {
							planificarActividad(null);
							for (int i = 0; i < diasRestantes.length; i++) {
								String date = diasRestantes[i] + "/" + mesesRestantes.get(i) + "/"
										+ fecha.split("/")[2];
								crearActividad(admin.buscarActividad(
										getComboBoxTiposActividad().getSelectedItem().toString().split("@")[0], date,
										inicio, fin), date, inicio, fin);
							}
							pintarPanelesCalendario(
									getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0],
									null);
						} else {
							getLblPlanificaciónCorrecta().setText("");
							getLblHorarioOcupado().setVisible(true);
						}
					} else if (getRdbtnRepetirVariosDias().isSelected()) {
						if (!existsActividad(fecha, inicio, fin) && !existsAlquiler(fecha, inicio, fin, instalacion)) {
							List<String> diasSeleccionados = getListDiasDisponibles().getSelectedValuesList();
							int nextDay = 0;
							for (String day : diasSeleccionados) {
								nextDay = obtenerProximoDiaSemana(day);
								String newFecha = nextDay + "/" + fecha.split("/")[1] + "/" + fecha.split("/")[2];
								if (!existsActividadOrAlquilerInAFutureDay(newFecha, inicio, fin, instalacion)) {

									for (int i = 0; i < diasRestantes.length; i++) {
										String date = diasRestantes[i] + "/" + mesesRestantes.get(i) + "/"
												+ fecha.split("/")[2];
										crearActividad(
												admin.buscarActividad(getComboBoxTiposActividad().getSelectedItem()
														.toString().split("@")[0], date, inicio, fin),
												date, inicio, fin);
									}
								} else {
									getLblPlanificaciónCorrecta().setText("");
									getLblHorarioOcupado().setVisible(true);
									break;
								}
							}
							getLblPlanificaciónCorrecta().setText("¡Hecho!");
							pintarPanelesCalendario(
									getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0],
									null);
						} else {
							getLblPlanificaciónCorrecta().setText("");
							getLblHorarioOcupado().setVisible(true);
						}
					} else if (getRdbtnNoRepetir().isSelected()) {// si no se seleccionó ningún radioboton o
																	// se
																	// selecciono no repetir
						String[] fechaSeparada = getTextFieldFechaPlanificacion().getText().split("/");
						if (lunesMixed || martesMixed || miercolesMixed || juevesMixed || viernesMixed || sabadoMixed
								|| domingoMixed) {// si hay un día que empieze otro mes intercalado con el finm de otro
													// mes
							fechaSeparada[1] = (Integer.parseInt(fechaSeparada[1]) + 1) + "";
							fecha = fechaSeparada[0] + "/" + fechaSeparada[1] + "/" + fechaSeparada[2];
						}
						if (!existsActividad(fecha, inicio, fin) && !existsAlquiler(fecha, inicio, fin, instalacion)) {
							getLblHorarioOcupado().setVisible(false);
							planificarActividad(null);
							pintarPanelesCalendario(
									getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0],
									null);
						} else {
							getLblPlanificaciónCorrecta().setText("");
							getLblHorarioOcupado().setVisible(true);
						}
					}
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

	protected boolean existsActividadOrAlquilerInAFutureDay(String fecha, String inicio, String fin,
			String instalacion) {
		List<Actividad> actividades = admin.listarActividadesPorInstalacion(instalacion);
		String newDay = fecha.split("/")[0];
		String newMonth = fecha.split("/")[1];
		String dayOfTheWeek = getRdbtnRepetirActividadCadaDia_1().getText().split(" ")[2];// Lunes martes ...
		diasRestantes = obtenerDiasRestantes(Integer.parseInt(newDay), Integer.parseInt(newMonth), dayOfTheWeek);
		for (Actividad a : actividades) {
			String acMonth = a.getFecha().split("/")[1];
			if (a.getInstalacion().equals(instalacion)) {// si la actividad tiene la misma instalacion en la que se
															// esta
															// planificando
				if (Integer.parseInt(acMonth) >= Integer.parseInt(newMonth)) {// si la actividad es posterior al día
																				// que
																				// seleccionamos
					String acDay = a.getFecha().split("/")[0];// dia actividad
					if (findDay(diasRestantes, Integer.parseInt(acDay))) {// si ese día está ocupado
						int dif = Integer.parseInt(a.getHoraFin().split(":")[0])
								- Integer.parseInt(a.getHoraInicio().split(":")[0]);
						if (a.getHoraInicio().equals(inicio))
							return true;// devuelve true pq está ocupado el horario
						else if (dif > 1)
							if (Integer.parseInt(inicio.split(":")[0]) == obtenerHoraIntermedia(a.getHoraInicio(),
									a.getHoraFin()))
								return true;// si se coloca una actividad cuando hay una que estaría en curso
											// devuelve
											// true
					}
				}
			}
		}
		List<Alquiler> alquileres = admin.listarAlquileres(instalacion);
		for (Alquiler al : alquileres) {
			if (al.getInstalacion().equals(instalacion)) {
				int alMonth = Integer.parseInt(al.getFecha().split("/")[1]);
				if (alMonth >= Integer.parseInt(newMonth)) { // si el alquiler es posterior al dia que seleccionamos
					int alDay = Integer.parseInt(al.getFecha().split("/")[0]);
					if (alDay == Integer.parseInt(newDay)) {
						if (findDay(diasRestantes, alDay)) {// si en ese dia existe un alquiler
							int dif = Integer.parseInt(al.getHora_fin().split(":")[0])
									- Integer.parseInt(al.getHora_inicio().split(":")[0]);
							if (al.getHora_inicio().equals(inicio)) {
								return true;// ya está ocupado el horario
							} else if (dif > 1) {
								if (Integer.parseInt(inicio.split(":")[0]) == obtenerHoraIntermedia(al.getHora_inicio(),
										al.getHora_fin())) {
									return true; // si se coloca una actividad cuando hay un alquiler que estaría en
													// curso
													// devuelve true
								}
							}
						}
					}
				}
			}
		}
		return false;

	}

	private int obtenerProximoDiaSemana(String dia) {
		int proxDia;
		if (dia == "Lunes") {
			proxDia = Integer.parseInt(getLblLunes().getText().split(" - ")[1]);
		} else if (dia == "Martes") {
			proxDia = Integer.parseInt(getLblMartes().getText().split(" - ")[1]);
		} else if (dia == "Miércoles") {
			proxDia = Integer.parseInt(getLblMiercoles().getText().split(" - ")[1]);
		} else if (dia == "Jueves") {
			proxDia = Integer.parseInt(getLblJueves().getText().split(" - ")[1]);
		} else if (dia == "Viernes") {
			proxDia = Integer.parseInt(getLblViernes().getText().split(" - ")[1]);
		} else if (dia == "Sábado") {
			proxDia = Integer.parseInt(getLblSabado().getText().split(" - ")[1]);
		} else {
			proxDia = Integer.parseInt(getLblDomingo().getText().split(" - ")[1]);
		}
		return proxDia;
	}

	private int obtenerHoraIntermedia(String inicio, String fin) {
		switch (inicio) {
		case "09:00":
			if (fin.equals("11:00"))
				return 10;
		case "10:00":
			if (fin.equals("12:00"))
				return 11;
		case "11:00":
			if (fin.equals("13:00"))
				return 12;
		case "12:00":
			if (fin.equals("14:00"))
				return 13;
		case "13:00":
			if (fin.equals("15:00"))
				return 14;
		case "14:00":
			if (fin.equals("16:00"))
				return 15;
		case "15:00":
			if (fin.equals("17:00"))
				return 16;
		case "16:00":
			if (fin.equals("18:00"))
				return 17;
		case "17:00":
			if (fin.equals("19:00"))
				return 18;
		case "18:00":
			if (fin.equals("20:00"))
				return 19;
		case "19:00":
			if (fin.equals("21:00"))
				return 20;
		case "20:00":
			if (fin.equals("22:00"))
				return 22;
		case "21:00":
			if (fin.equals("23:00"))
				return 22;
		default:
			return 23;
		}
	}

	private boolean findDay(int[] diasRestantes, int j) {
		for (int i : diasRestantes) {
			if (i == j)
				return true;
		}
		return false;
	}

	private int[] obtenerDiasRestantes(int day, int month, String dayOfTheWeek) {
		List<Integer> res = new ArrayList<Integer>();
		boolean meses31dias = month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10;
		boolean meses30dias = month == 4 || month == 6 || month == 9 || month == 11;
		while (true) {
			if (month < 12) {// si no es diciembre
				if (meses31dias) {
					if (day + 7 <= 31) {
						day += 7;
					} else {
						if (day == 25) {
							day = 1;
						} else if (day == 26) {
							day = 2;
						} else if (day == 27) {
							day = 3;
						} else if (day == 28) {
							day = 4;
						} else if (day == 29) {
							day = 5;
						} else if (day == 30) {
							day = 6;
						} else if (day == 31) {
							day = 7;
						}
						month++;
					}
				} else if (meses30dias) {
					if (day + 7 <= 30) {
						day += 7;
					} else {
						if (day == 24) {
							day = 1;
						} else if (day == 25) {
							day = 2;
						} else if (day == 26) {
							day = 3;
						} else if (day == 27) {
							day = 4;
						} else if (day == 28) {
							day = 5;
						} else if (day == 39) {
							day = 6;
						} else if (day == 30) {
							day = 7;
						}
						month++;
					}
				} else {
					if (day + 7 <= 28) {
						day += 7;
					} else {
						if (day == 22) {
							day = 1;
						} else if (day == 23) {
							day = 2;
						} else if (day == 24) {
							day = 3;
						} else if (day == 25) {
							day = 4;
						} else if (day == 26) {
							day = 5;
						} else if (day == 27) {
							day = 6;
						} else if (day == 28) {
							day = 7;
						}
						month++;
					}
				}
				res.add(day);
				mesesRestantes.add(month);
			} else {// si es diciembre
				if (day + 7 <= 31) {
					day += 7;
					res.add(day);
					mesesRestantes.add(month);
				} else {
					break;
				}
			}
		}
		int[] result = new int[res.size()];
		int k = 0;
		for (int i : res) {
			result[k] = i;
			k++;
		}
		return result;

	}

	protected boolean existsAlquiler(String fecha, String inicio, String fin, String instalacion) {
		List<Alquiler> alquileres = admin.listarAlquileres(instalacion);
		List<Alquiler> alquileresDia = new ArrayList<>();
		for (Alquiler a : alquileres) {
			if (a.getFecha().equals(fecha))
				alquileresDia.add(a);
		}
		for (Alquiler a : alquileresDia) {
			String inicioUsuario = inicio;
			int hInicio = Integer.parseInt(a.getHora_inicio().split(":")[0]) - 9;
			int hFin = Integer.parseInt(a.getHora_fin().split(":")[0]) - 9;
			int hIntermedia = (hFin - hInicio);
			String intermedio = hIntermedia + ":00";
			if (a.getHora_inicio().equals(inicioUsuario)) {// misma hora inicio
				return true;
			} else if (hIntermedia > 1 && intermedio.equals(inicioUsuario)) {// en el medio de otra actividad
				return true;
			}
		}
		return false;// al haber finalizado una actividad u otro caso
	}

	protected boolean existsActividad(String fecha, String inicio, String fin) {
		Actividad ac = admin.buscarActividad(getComboBoxTiposActividad().getSelectedItem().toString().split("@")[0],
				fecha, inicio, fin);
		String instalacion = ac.getInstalacion();
		List<Actividad> actividades = admin.listarActividadesPorInstalacion(instalacion);
		List<Actividad> actividadesDia = new ArrayList<>();
		for (Actividad a : actividades) {
			if (a.getFecha() != null) {
				if (a.getFecha().equals(fecha))
					actividadesDia.add(a);
			}
		}
		for (Actividad a : actividadesDia) {
			String inicioUsuario = inicio;
			int hInicio = Integer.parseInt(a.getHoraInicio().split(":")[0]) - 9;
			int hFin = Integer.parseInt(a.getHoraFin().split(":")[0]) - 9;
			int hIntermedia = (hFin - hInicio);
			String intermedio = hIntermedia + ":00";
			if (a.getHoraInicio().equals(inicioUsuario)) {// misma hora inicio
				return true;
			} else if (hIntermedia > 1 && intermedio.equals(inicioUsuario)) {// en el medio de otra actividad
				return true;
			}
		}
		return false;// al haber finalizado una actividad u otro caso

	}

	protected void planificarActividad(String newDate) {
		String fecha;
		String tipo = getComboBoxTiposActividad().getSelectedItem().toString().split("@")[0];
		if (newDate == null) {
			fecha = getTextFieldFechaPlanificacion().getText();
		} else {
			fecha = newDate;
		}
		String hora_inicio = getComboBoxHoraInicio().getSelectedItem().toString().split("@")[0].toLowerCase();
		String hora_fin = getComboBoxHoraFin().getSelectedItem().toString().split("@")[0].toLowerCase();
		// Comprobamos que la fecha sea posterior
		if (Integer.parseInt(fecha.split("/")[2]) >= this.year) {
			if (Integer.parseInt(fecha.split("/")[1]) >= this.month.getValue()) {
				if (fecha != null && !fecha.isEmpty()) {
					String id = admin.buscarActividad(tipo, fecha, hora_inicio, hora_fin).getId();
					admin.planificarActividad(tipo, fecha, hora_inicio, hora_fin, id);
					getLblPlanificaciónCorrecta().setForeground(Color.GREEN);
					getLblPlanificaciónCorrecta().setText("¡Hecho!");
					getTextFieldFechaPlanificacion().setBorder(LineBorder.createGrayLineBorder());
				} else {
					getTextFieldFechaPlanificacion().setBorder(new LineBorder(Color.RED));
				}
			} else {
				getLblPlanificaciónCorrecta().setForeground(Color.RED);
				getLblPlanificaciónCorrecta().setText("¡Fecha no válida!");
			}
		} else {
			getLblPlanificaciónCorrecta().setForeground(Color.RED);
			getLblPlanificaciónCorrecta().setText("¡Fecha no válida!");
		}
	}

	private JDateChooser getJdateChooser() {
		if (jDateChooser == null) {
			jDateChooser = new JDateChooser();
		}
		return jDateChooser;
	}

	private JLabel getLblPlanificaciónCorrecta() {
		if (lblPlanificaciónCorrecta == null) {
			lblPlanificaciónCorrecta = new JLabel("");
			lblPlanificaciónCorrecta.setForeground(Color.GREEN);
			lblPlanificaciónCorrecta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblPlanificaciónCorrecta;
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
			lblMiercoles = new JLabel("MIÉRCOLES");
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
			lblSabado = new JLabel("SÁBADO");
			lblSabado.setForeground(new Color(255, 0, 0));
			lblSabado.setHorizontalAlignment(SwingConstants.CENTER);
			lblSabado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblSabado;
	}

	private JLabel getLblDomingo() {
		if (lblDomingo == null) {
			lblDomingo = new JLabel("DOMINGO");
			lblDomingo.setForeground(new Color(255, 0, 0));
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
			panelHoras.add(getPanel9());
			panelHoras.add(getPanel10());
			panelHoras.add(getPanel11());
			panelHoras.add(getPanel12());
			panelHoras.add(getPanel13());
			panelHoras.add(getPanel14());
			panelHoras.add(getPanel15());
			panelHoras.add(getPanel16());
			panelHoras.add(getPanel17());
			panelHoras.add(getPanel18());
			panelHoras.add(getPanel19());
			panelHoras.add(getPanel20());
			panelHoras.add(getPanel21());
			panelHoras.add(getPanel22());
			panelHoras.add(getPanel23());
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
			pintarPanelesCalendario(getComboBoxIntalacionesCalendario_1().getItemAt(0), null);
		}
		return panelSemana;
	}

	private void pintarPanelesCalendario(String instalacion, String fechaCierre) {
		List<Actividad> actividades = admin.listarActividadesPorInstalacion(instalacion);
		List<Alquiler> alquileres = admin.listarAlquileres(instalacion);
		JButton bot;
		getPanelCeldasCalendario().removeAll();

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 7; j++) {
				bot = new JButton();
				bot.setBackground(new Color(152, 251, 152));
				asignarTexto(bot, i, j, actividades, alquileres, fechaCierre);
				getPanelCeldasCalendario().add(bot);
			}
		}
		validate();
	}

	private void automatizarAccionesBotonVacio(int i, int j) {
		String fecha = "";
		String dia = "";
		int month = Integer.parseInt(getLblSemanaFechaCalendario().getText().split("/")[0]);
		int monthYear = 0;
		int year = Integer.parseInt(getLblSemanaFechaCalendario().getText().split("/")[1]);
		switch (j) {
		case 0:
			getRdbtnRepetirActividadCadaDia_1()
					.setText("Repetir cada " + getLblLunes().getText().split(" - ")[0] + " (1 año)");
			dia = getLblLunes().getText().split(" - ")[1];
			if (lunesMixed) {
				if (month == 12) {
					monthYear = 1;
					year++;
				} else
					monthYear = month + 1;
			} else
				monthYear = month;
			break;
		case 1:
			getRdbtnRepetirActividadCadaDia_1()
					.setText("Repetir cada " + getLblMartes().getText().split(" - ")[0] + " (1 año)");
			dia = getLblMartes().getText().split(" - ")[1];
			if (martesMixed) {
				if (month == 12) {
					monthYear = 1;
					year++;
				} else
					monthYear = month + 1;
			} else
				monthYear = month;
			break;
		case 2:
			getRdbtnRepetirActividadCadaDia_1()
					.setText("Repetir cada " + getLblMiercoles().getText().split(" - ")[0] + " (1 año)");
			dia = getLblMiercoles().getText().split(" - ")[1];
			if (miercolesMixed) {
				if (month == 12) {
					monthYear = 1;
					year++;
				} else
					monthYear = month + 1;
			} else
				monthYear = month;
			break;
		case 3:
			getRdbtnRepetirActividadCadaDia_1()
					.setText("Repetir cada " + getLblJueves().getText().split(" - ")[0] + " (1 año)");
			dia = getLblJueves().getText().split(" - ")[1];
			if (juevesMixed) {
				if (month == 12) {
					monthYear = 1;
					year++;
				} else
					monthYear = month + 1;
			} else
				monthYear = month;
			break;
		case 4:
			getRdbtnRepetirActividadCadaDia_1()
					.setText("Repetir cada " + getLblViernes().getText().split(" - ")[0] + " (1 año)");
			dia = getLblViernes().getText().split(" - ")[1];
			if (viernesMixed) {
				if (month == 12) {
					monthYear = 1;
					year++;
				} else
					monthYear = month + 1;
			} else
				monthYear = month;
			break;
		case 5:
			getRdbtnRepetirActividadCadaDia_1()
					.setText("Repetir cada " + getLblSabado().getText().split(" - ")[0] + " (1 año)");
			dia = getLblSabado().getText().split(" - ")[1];
			if (sabadoMixed) {
				if (month == 12) {
					monthYear = 1;
					year++;
				} else
					monthYear = month + 1;
			} else
				monthYear = month;
			break;
		case 6:
			getRdbtnRepetirActividadCadaDia_1()
					.setText("Repetir cada " + getLblDomingo().getText().split(" - ")[0] + " (1 año)");
			dia = getLblDomingo().getText().split(" - ")[1];
			if (domingoMixed) {
				if (month == 12) {
					monthYear = 1;
					year++;
				} else
					monthYear = month + 1;
			} else
				monthYear = month;
			break;
		}
		getComboBoxHoraInicioAlqInst().setSelectedIndex(i);
		getComboBoxHoraInicio().setSelectedIndex(i);

		fecha = dia + "/" + monthYear + "/" + year;
		getTextFieldFechaPlanificacion().setText(fecha);
		getTextFieldFechaCierre().setText(fecha);
		getTextFieldFechaAlqInst().setText(fecha);
	}

	protected void automatizarAccionesBoton(Actividad a, String horainicio, String horafin) {
		getTextFieldFechaPlanificacion().setText(a.getFecha());
	}

	private void asignarTexto(JButton p, int i, int j, List<Actividad> actividades, List<Alquiler> alquileres,
			String fechaCierre) {
		int lunes = Integer.parseInt(getLblLunes().getText().split(" - ")[1]);
		int martes = Integer.parseInt(getLblMartes().getText().split(" - ")[1]);
		int miercoles = Integer.parseInt(getLblMiercoles().getText().split(" - ")[1]);
		int jueves = Integer.parseInt(getLblJueves().getText().split(" - ")[1]);
		int viernes = Integer.parseInt(getLblViernes().getText().split(" - ")[1]);
		int sabado = Integer.parseInt(getLblSabado().getText().split(" - ")[1]);
		int domingo = Integer.parseInt(getLblDomingo().getText().split(" - ")[1]);

		p.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				automatizarAccionesBotonVacio(i, j);
			}
		});

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
					} else if (month == this.month.getValue() + 1) {// dias de meses mezclados
						if (dia == lunes && this.lunesMixed) {
							if (j == 0) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == martes && this.martesMixed) {
							if (j == 1) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == miercoles && this.miercolesMixed) {
							if (j == 2) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == jueves && this.juevesMixed) {
							if (j == 3) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == viernes && this.viernesMixed) {
							if (j == 4) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == sabado && this.sabadoMixed) {
							if (j == 5) {
								pintarActividad(i, horainicio, horafin, p, a);
							}
						} else if (dia == domingo && this.domingoMixed) {
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
								pintarAlquiler(i, horainicio, horafin, p, a, fechaCierre);
							}
						} else if (dia == martes) {
							if (j == 1) {
								pintarAlquiler(i, horainicio, horafin, p, a, fechaCierre);
							}
						} else if (dia == miercoles) {
							if (j == 2) {
								pintarAlquiler(i, horainicio, horafin, p, a, fechaCierre);
							}
						} else if (dia == jueves) {
							if (j == 3) {
								pintarAlquiler(i, horainicio, horafin, p, a, fechaCierre);
							}
						} else if (dia == viernes) {
							if (j == 4) {
								pintarAlquiler(i, horainicio, horafin, p, a, fechaCierre);
							}
						} else if (dia == sabado) {
							if (j == 5) {
								pintarAlquiler(i, horainicio, horafin, p, a, fechaCierre);
							}
						} else if (dia == domingo) {
							if (j == 6) {
								pintarAlquiler(i, horainicio, horafin, p, a, fechaCierre);
							}
						}
					}
				}
			}
		}
	}

	private void pintarAlquiler(int i, String horainicio, String horafin, JButton bot, Alquiler a, String fechaCierre) {
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
		if (fechaCierre != null) {
			if (a.getFecha().equals(fechaCierre)) {
				switch (i) {
				// 9:00
				case 0:
					if (horainicio.equals("9:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (horafin.equals("9:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 9 && 9 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 10:00
				case 1:
					if (horainicio.equals("10:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio == 10) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 10 && 10 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 11:00
				case 2:
					if (horainicio.equals("11:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio == 11) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 11 && 11 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 12:00
				case 3:
					if (horainicio.equals("12:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 12 && 12 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 13:00
				case 4:
					if (horainicio.equals("13:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 13 && 13 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 14:00
				case 5:
					if (horainicio.equals("14:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 14 && 14 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 15:00
				case 6:
					if (horainicio.equals("15:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 15 && 15 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 16:00
				case 7:
					if (horainicio.equals("16:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 16 && 16 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 17:00
				case 8:
					if (horainicio.equals("17:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 17 && 17 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 18:00
				case 9:
					if (horainicio.equals("18:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 18 && 18 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 19:00
				case 10:
					if (horainicio.equals("19:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 19 && 19 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 20:00
				case 11:
					if (horainicio.equals("20:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 20 && 20 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
						;
					}
					break;
				// 21:00
				case 12:
					if (horainicio.equals("21:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 21 && 21 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 22:00
				case 13:
					if (horainicio.equals("22:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (diferencia > 1 && inicio < 22 && 22 < fin) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				// 23:00
				default:
					if (horainicio.equals("23:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					if (horafin.equals("23:00")) {
						bot.setText("CLOSED");
						bot.setBackground(new Color(162, 42, 42));
					}
					break;
				}
			}
		}
		bot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				automatizarAccionesBotonAlquiler(a, horainicio, horafin);
			}
		});
	}

	protected void automatizarAccionesBotonAlquiler(Alquiler a, String horainicio, String horafin) {
		getTextFieldFechaAlqInst().setText(a.getFecha());
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
//			if (horafin.equals("9:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("10:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("11:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("13:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("14:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("15:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("16:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("17:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("18:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("19:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("20:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("21:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
//			if (horafin.equals("22:00")) {
//				bot.setText(a.getTipo());
//				bot.setBackground(Color.ORANGE);
//			}
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
		bot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				automatizarAccionesBoton(a, horainicio, horafin);
			}
		});
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
				// meses de 31 días
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 días
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
			actualizarDiasMezclados(false, false, false, false, false, false, false);
			break;
		case WEDNESDAY:
			if (dia == 1) {
				// meses de 31 días
				if (meses31dias) {
					getLblMartes().setText("Mar - " + (31));
					getLblLunes().setText("Lun - " + (30));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, false, false, false, false, false);
			} else if (dia == 2) {
				getLblMartes().setText("Mar - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 días
				else if (meses30dias) {
					getLblLunes().setText("Lun - " + (30));
				} else {
					if (bisiesto) {
						getLblLunes().setText("Lun - " + (29));
					} else {
						getLblLunes().setText("Lun - " + (28));
					}
				}
				actualizarDiasMezclados(false, true, false, false, false, false, false);
			} else {
				getLblLunes().setText("Lun - " + (dia - 2));
				getLblMartes().setText("Mar - " + (dia - 1));
			}
			getLblJueves().setText("Jue - " + (dia + 1));
			getLblViernes().setText("Vier - " + (dia + 2));
			getLblSabado().setText("Sab - " + (dia + 3));
			getLblDomingo().setText("Dom - " + (dia + 4));
			getLblMiercoles().setText("Mier - " + (dia));
			actualizarDiasMezclados(false, false, false, false, false, false, false);
			break;
		case THURSDAY:
			if (dia == 1) {
				// meses de 31 días
				if (meses31dias) {
					getLblMiercoles().setText("Mier - " + (31));
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, false, false, false, false, false);
			} else if (dia == 2) {
				getLblMiercoles().setText("Mier - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblMartes().setText("Mar - " + (31));
					getLblLunes().setText("Lun - " + (30));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, true, false, false, false, false);
			} else if (dia == 3) {
				getLblMiercoles().setText("Mier - " + (2));
				getLblMartes().setText("Mar - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 días
				else if (meses30dias) {
					getLblLunes().setText("Lun - " + (30));
				} else {
					if (bisiesto) {
						getLblLunes().setText("Lun - " + (29));
					} else {
						getLblLunes().setText("Lun - " + (28));
					}
				}
				actualizarDiasMezclados(false, true, true, false, false, false, false);
			} else {
				getLblLunes().setText("Lun - " + (dia - 3));
				getLblMartes().setText("Mar - " + (dia - 2));
				getLblMiercoles().setText("Mier - " + (dia - 1));
			}
			getLblViernes().setText("Vier - " + (dia + 1));
			getLblSabado().setText("Sab - " + (dia + 2));
			getLblDomingo().setText("Dom - " + (dia + 3));
			getLblJueves().setText("Jue - " + (dia));
			actualizarDiasMezclados(false, false, false, false, false, false, false);
			break;
		case FRIDAY:
			if (dia == 1) {
				// meses de 31 días
				if (meses31dias) {
					getLblJueves().setText("Jue - " + (31));
					getLblMiercoles().setText("Mier - " + (30));
					getLblMartes().setText("Mar - " + (29));
					getLblLunes().setText("Lun - " + (28));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, false, false, false, false, false);
			} else if (dia == 2) {
				getLblJueves().setText("Jue - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblMiercoles().setText("Mier - " + (31));
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, false, true, false, false, false);
			} else if (dia == 3) {
				getLblJueves().setText("Jue - " + (2));
				getLblMiercoles().setText("Mier - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblMartes().setText("Mar - " + (31));
					getLblLunes().setText("Lun - " + (30));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, true, true, false, false, false);
			} else if (dia == 4) {
				getLblJueves().setText("Jue - " + (3));
				getLblMiercoles().setText("Mier - " + (2));
				getLblMartes().setText("Mar - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 días
				else if (meses30dias) {
					getLblLunes().setText("Lun - " + (30));
				} else {
					if (bisiesto) {
						getLblLunes().setText("Lun - " + (29));
					} else {
						getLblLunes().setText("Lun - " + (28));
					}
				}
				actualizarDiasMezclados(false, true, true, true, false, false, false);
			} else {
				getLblLunes().setText("Lun - " + (dia - 4));
				getLblMartes().setText("Mar - " + (dia - 3));
				getLblMiercoles().setText("Mier - " + (dia - 2));
				getLblJueves().setText("Jue - " + (dia - 1));
			}
			getLblViernes().setText("Vier - " + (dia));
			getLblSabado().setText("Sab - " + (dia + 1));
			getLblDomingo().setText("Dom - " + (dia + 2));
			actualizarDiasMezclados(true, true, true, true, false, false, false);
			break;
		case SATURDAY:
			if (dia == 1) {
				// meses de 31 días
				if (meses31dias) {
					getLblViernes().setText("Vier - " + (31));
					getLblJueves().setText("Jue - " + (30));
					getLblMiercoles().setText("Mier - " + (29));
					getLblMartes().setText("Mar - " + (28));
					getLblLunes().setText("Lun - " + (27));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, false, false, false, false, false);
			} else if (dia == 2) {
				getLblViernes().setText("Vier - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblJueves().setText("Jue - " + (31));
					getLblMiercoles().setText("Mier - " + (30));
					getLblMartes().setText("Mar - " + (29));
					getLblLunes().setText("Lun - " + (28));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, false, false, true, false, false);
			} else if (dia == 3) {
				getLblViernes().setText("Vier - " + (2));
				getLblJueves().setText("Jue - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblMiercoles().setText("Mier - " + (31));
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, false, true, true, false, false);
			} else if (dia == 4) {
				getLblViernes().setText("Vier - " + (3));
				getLblJueves().setText("Jue - " + (2));
				getLblMiercoles().setText("Mier - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblMartes().setText("Mar - " + (31));
					getLblLunes().setText("Lun - " + (30));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, true, true, true, false, false);
			} else if (dia == 5) {
				getLblViernes().setText("Vier - " + (4));
				getLblJueves().setText("Jue - " + (3));
				getLblMiercoles().setText("Mier - " + (2));
				getLblMartes().setText("Mar - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 días
				else if (meses30dias) {
					getLblLunes().setText("Lun - " + (30));
				} else {
					if (bisiesto) {
						getLblLunes().setText("Lun - " + (29));
					} else {
						getLblLunes().setText("Lun - " + (28));
					}
				}
				actualizarDiasMezclados(false, true, true, true, true, false, false);
			} else {
				getLblLunes().setText("Lun - " + (dia - 5));
				getLblMartes().setText("Mar - " + (dia - 4));
				getLblMiercoles().setText("Mier - " + (dia - 3));
				getLblJueves().setText("Jue - " + (dia - 2));
				getLblViernes().setText("Vier - " + (dia - 1));
			}
			getLblSabado().setText("Sab - " + (dia));
			getLblDomingo().setText("Dom - " + (dia + 1));
			actualizarDiasMezclados(false, false, false, false, false, false, false);
			break;
		default:// domingo
			if (dia == 1) {
				// meses de 31 días
				if (meses31dias) {
					getLblSabado().setText("Sab - " + (31));
					getLblViernes().setText("Vier - " + (30));
					getLblJueves().setText("Jue - " + (29));
					getLblMiercoles().setText("Mier - " + (28));
					getLblMartes().setText("Mar - " + (27));
					getLblLunes().setText("Lun - " + (26));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, false, false, false, false, false);
			} else if (dia == 2) {
				getLblSabado().setText("Sab - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblViernes().setText("Vier - " + (31));
					getLblJueves().setText("Jue - " + (30));
					getLblMiercoles().setText("Mier - " + (29));
					getLblMartes().setText("Mar - " + (28));
					getLblLunes().setText("Lun - " + (27));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, false, false, false, true, false);
			} else if (dia == 3) {
				getLblSabado().setText("Sab - " + (2));
				getLblViernes().setText("Vier - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblJueves().setText("Jue - " + (31));
					getLblMiercoles().setText("Mier - " + (30));
					getLblMartes().setText("Mar - " + (29));
					getLblLunes().setText("Lun - " + (28));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, false, false, true, true, false);
			} else if (dia == 4) {
				getLblSabado().setText("Sab - " + (3));
				getLblViernes().setText("Vier - " + (2));
				getLblJueves().setText("Jue - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblMiercoles().setText("Mier - " + (31));
					getLblMartes().setText("Mar - " + (30));
					getLblLunes().setText("Lun - " + (29));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, false, true, true, true, false);
			} else if (dia == 5) {
				getLblSabado().setText("Sab - " + (4));
				getLblViernes().setText("Vier - " + (3));
				getLblJueves().setText("Jue - " + (2));
				getLblMiercoles().setText("Mier - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblMartes().setText("Mar - " + (31));
					getLblLunes().setText("Lun - " + (30));
				} // meses de 30 días
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
				actualizarDiasMezclados(false, false, true, true, true, true, false);
			} else if (dia == 6) {
				getLblSabado().setText("Sab - " + (5));
				getLblViernes().setText("Vier - " + (4));
				getLblJueves().setText("Jue - " + (3));
				getLblMiercoles().setText("Mier - " + (2));
				getLblMartes().setText("Mar - " + (1));
				// meses de 31 días
				if (meses31dias) {
					getLblLunes().setText("Lun - " + (31));
				} // meses de 30 días
				else if (meses30dias) {
					getLblLunes().setText("Lun - " + (30));
				} else {
					if (bisiesto) {
						getLblLunes().setText("Lun - " + (29));
					} else {
						getLblLunes().setText("Lun - " + (28));
					}
				}
				actualizarDiasMezclados(false, true, true, true, true, true, false);
			} else {
				getLblLunes().setText("Lun - " + (dia - 6));
				getLblMartes().setText("Mar - " + (dia - 5));
				getLblMiercoles().setText("Mier - " + (dia - 4));
				getLblJueves().setText("Jue - " + (dia - 3));
				getLblViernes().setText("Vier - " + (dia - 2));
				getLblSabado().setText("Sab - " + (dia - 1));
			}
			getLblDomingo().setText("Dom - " + (dia));
			actualizarDiasMezclados(false, false, false, false, false, false, false);
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
							getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0], null);
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
				asignarValoresEtiquetas(25, 26, 27, 28, 29, 30, 31);
				this.year--;
			} else {
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
			}
			actualizarDiasMezclados(false, false, false, false, false, false, false);
		} else if (lastDay == 2) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				asignarValoresEtiquetas(26, 27, 28, 29, 30, 31, 1);
				actualizarDiasMezclados(false, false, false, false, false, false, true);
				this.year--;
			} else {
				asignarNuevoMes(previousMonth);
				if (meses31dias) {
					asignarValoresEtiquetas(26, 27, 28, 29, 30, 31, 1);
					actualizarDiasMezclados(false, false, false, false, false, false, true);
				} else if (meses30dias) {
					asignarValoresEtiquetas(25, 26, 27, 28, 29, 30, 1);
					actualizarDiasMezclados(false, false, false, false, false, false, true);
				} else {
					if (bisiesto) {
						asignarValoresEtiquetas(24, 25, 26, 27, 28, 29, 1);
						actualizarDiasMezclados(false, false, false, false, false, false, true);
					} else {
						asignarValoresEtiquetas(23, 24, 25, 26, 27, 28, 29);
						actualizarDiasMezclados(false, false, false, false, false, false, false);
					}
				}
			}
		} else if (lastDay == 3) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				asignarValoresEtiquetas(27, 28, 29, 30, 31, 1, 2);
				actualizarDiasMezclados(false, false, false, false, false, true, true);
				this.year--;
			} else {
				asignarNuevoMes(previousMonth);
				if (meses31dias) {
					asignarValoresEtiquetas(27, 28, 29, 30, 31, 1, 2);
					actualizarDiasMezclados(false, false, false, false, false, true, true);
				} else if (meses30dias) {
					asignarValoresEtiquetas(26, 27, 28, 29, 30, 1, 2);
					actualizarDiasMezclados(false, false, false, false, false, true, true);
				} else {
					if (bisiesto) {
						asignarValoresEtiquetas(25, 26, 27, 28, 29, 1, 2);
						actualizarDiasMezclados(false, false, false, false, false, true, true);
					} else {
						asignarValoresEtiquetas(24, 25, 26, 27, 28, 1, 2);
						actualizarDiasMezclados(false, false, false, false, false, true, true);
					}
				}
			}
		} else if (lastDay == 4) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				asignarValoresEtiquetas(28, 29, 30, 31, 1, 2, 3);
				actualizarDiasMezclados(false, false, false, false, true, true, true);
				this.year--;
			} else {
				asignarNuevoMes(previousMonth);
				if (meses31dias) {
					asignarValoresEtiquetas(28, 29, 30, 31, 1, 2, 3);
					actualizarDiasMezclados(false, false, false, false, true, true, true);
				} else if (meses30dias) {
					asignarValoresEtiquetas(27, 28, 29, 30, 1, 2, 3);
					actualizarDiasMezclados(false, false, false, false, true, true, true);
				} else {
					if (bisiesto) {
						asignarValoresEtiquetas(26, 27, 28, 29, 1, 2, 3);
						actualizarDiasMezclados(false, false, false, false, true, true, true);
					} else {
						asignarValoresEtiquetas(25, 26, 27, 28, 1, 2, 3);
						actualizarDiasMezclados(false, false, false, false, true, true, true);
					}
				}
			}
		} else if (lastDay == 5) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				asignarValoresEtiquetas(29, 30, 31, 1, 2, 3, 4);
				actualizarDiasMezclados(false, false, false, true, true, true, true);
				this.year--;
			} else {
				asignarNuevoMes(previousMonth);
				if (meses31dias) {
					asignarValoresEtiquetas(29, 30, 31, 1, 2, 3, 4);
					actualizarDiasMezclados(false, false, false, true, true, true, true);
				} else if (meses30dias) {
					asignarValoresEtiquetas(28, 29, 30, 1, 2, 3, 4);
					actualizarDiasMezclados(false, false, false, true, true, true, true);
				} else {
					if (bisiesto) {
						asignarValoresEtiquetas(27, 28, 29, 1, 2, 3, 4);
						actualizarDiasMezclados(false, false, false, true, true, true, true);
					} else {
						asignarValoresEtiquetas(26, 27, 28, 1, 2, 3, 4);
						actualizarDiasMezclados(false, false, false, true, true, true, true);
					}
				}
			}
		} else if (lastDay == 6) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				asignarValoresEtiquetas(30, 31, 1, 2, 3, 4, 5);
				actualizarDiasMezclados(false, false, true, true, true, true, true);
				this.year--;
			} else {
				asignarNuevoMes(previousMonth);
				if (meses31dias) {
					asignarValoresEtiquetas(30, 31, 1, 2, 3, 4, 5);
					actualizarDiasMezclados(false, false, true, true, true, true, true);
				} else if (meses30dias) {
					asignarValoresEtiquetas(29, 30, 1, 2, 3, 4, 5);
					actualizarDiasMezclados(false, false, true, true, true, true, true);
				} else {
					if (bisiesto) {
						asignarValoresEtiquetas(28, 29, 1, 2, 3, 4, 5);
						actualizarDiasMezclados(false, false, true, true, true, true, true);
					} else {
						asignarValoresEtiquetas(27, 28, 1, 2, 3, 4, 5);
						actualizarDiasMezclados(false, false, true, true, true, true, true);
					}
				}
			}
		} else if (lastDay == 7) {
			if (month == Month.JANUARY) {
				asignarNuevoMes(12);
				asignarValoresEtiquetas(31, 1, 2, 3, 4, 5, 6);
				actualizarDiasMezclados(false, true, true, true, true, true, true);
				this.year--;
			} else {
				asignarNuevoMes(previousMonth);
				if (meses31dias) {
					asignarValoresEtiquetas(31, 1, 2, 3, 4, 5, 6);
					actualizarDiasMezclados(false, true, true, true, true, true, true);
				} else if (meses30dias) {
					asignarValoresEtiquetas(30, 1, 2, 3, 4, 5, 6);
					actualizarDiasMezclados(false, true, true, true, true, true, true);
				} else {
					if (bisiesto) {
						asignarValoresEtiquetas(29, 1, 2, 3, 4, 5, 6);
						actualizarDiasMezclados(false, true, true, true, true, true, true);
					} else {
						asignarValoresEtiquetas(28, 1, 2, 3, 4, 5, 6);
						actualizarDiasMezclados(false, true, true, true, true, true, true);
					}
				}
			}
		} else {
			asignarValoresEtiquetas(lastDay - 7, lastDay - 6, lastDay - 5, lastDay - 4, lastDay - 3, lastDay - 2,
					lastDay - 1);
			actualizarDiasMezclados(false, false, false, false, false, false, false);
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
							getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0], null);
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
				actualizarDiasMezclados(false, false, false, false, false, false, false);

			} else if (lastDay == 30) {
				asignarValoresEtiquetas(31, 1, 2, 3, 4, 5, 6);
				actualizarDiasMezclados(false, true, true, true, true, true, true);

			} else if (lastDay == 29) {
				asignarValoresEtiquetas(30, 31, 1, 2, 3, 4, 5);
				actualizarDiasMezclados(false, false, true, true, true, true, true);

			} else if (lastDay == 28) {
				asignarValoresEtiquetas(29, 30, 31, 1, 2, 3, 4);
				actualizarDiasMezclados(false, false, false, true, true, true, true);

			} else if (lastDay == 27) {
				asignarValoresEtiquetas(28, 29, 30, 31, 1, 2, 3);
				actualizarDiasMezclados(false, false, false, false, true, true, true);

			} else if (lastDay == 26) {
				asignarValoresEtiquetas(27, 28, 29, 30, 31, 1, 2);
				actualizarDiasMezclados(false, false, false, false, false, true, true);

			} else if (lastDay == 25) {
				asignarValoresEtiquetas(26, 27, 28, 29, 30, 31, 1);
				actualizarDiasMezclados(false, false, false, false, false, false, true);

			} else {
				asignarValoresEtiquetas(lastDay + 1, lastDay + 2, lastDay + 3, lastDay + 4, lastDay + 5, lastDay + 6,
						lastDay + 7);
				actualizarDiasMezclados(false, false, false, false, false, false, false);

				cambioDeMes = false;
			}
		}
		// Si el mes tiene 30 dias
		else if (actualMes30dias) {
			if (lastDay == 30) {
				asignarValoresEtiquetas(1, 2, 3, 4, 5, 6, 7);
				actualizarDiasMezclados(false, false, false, false, false, false, false);

			} else if (lastDay == 29) {
				asignarValoresEtiquetas(30, 1, 2, 3, 4, 5, 6);
				actualizarDiasMezclados(false, true, true, true, true, true, true);

			} else if (lastDay == 28) {
				asignarValoresEtiquetas(29, 30, 1, 2, 3, 4, 5);
				actualizarDiasMezclados(false, false, true, true, true, true, true);

			} else if (lastDay == 27) {
				asignarValoresEtiquetas(28, 29, 30, 1, 2, 3, 4);
				actualizarDiasMezclados(false, false, false, true, true, true, true);

			} else if (lastDay == 26) {
				asignarValoresEtiquetas(27, 28, 29, 30, 1, 2, 3);
				actualizarDiasMezclados(false, false, false, false, true, true, true);

			} else if (lastDay == 25) {
				asignarValoresEtiquetas(26, 27, 28, 29, 30, 1, 2);
				actualizarDiasMezclados(false, false, false, false, false, true, true);

			} else if (lastDay == 24) {
				asignarValoresEtiquetas(25, 26, 27, 28, 29, 30, 1);
				actualizarDiasMezclados(false, false, false, false, false, false, true);

			} else {
				asignarValoresEtiquetas(lastDay + 1, lastDay + 2, lastDay + 3, lastDay + 4, lastDay + 5, lastDay + 6,
						lastDay + 7);
				actualizarDiasMezclados(false, false, false, false, false, false, false);

				cambioDeMes = false;
			}
		}
		// Si es febrero
		else if (month.getValue() == 2) {
			// si es un año bisiesto
			if (bisiesto) {
				if (lastDay == 29) {
					actualizarDiasMezclados(false, false, false, false, false, false, false);
					asignarValoresEtiquetas(1, 2, 3, 4, 5, 6, 7);

				} else if (lastDay == 28) {
					actualizarDiasMezclados(false, true, true, true, true, true, true);
					asignarValoresEtiquetas(29, 1, 2, 3, 4, 5, 6);

				} else if (lastDay == 27) {
					actualizarDiasMezclados(false, false, true, true, true, true, true);
					asignarValoresEtiquetas(28, 29, 1, 2, 3, 4, 5);

				} else if (lastDay == 26) {
					actualizarDiasMezclados(false, false, false, true, true, true, true);
					asignarValoresEtiquetas(27, 28, 29, 1, 2, 3, 4);

				} else if (lastDay == 25) {
					actualizarDiasMezclados(false, false, false, false, true, true, true);
					asignarValoresEtiquetas(26, 27, 28, 29, 1, 2, 3);

				} else if (lastDay == 24) {
					actualizarDiasMezclados(false, false, false, false, false, true, true);
					asignarValoresEtiquetas(25, 26, 27, 28, 29, 1, 2);

				} else if (lastDay == 23) {
					actualizarDiasMezclados(false, false, false, false, false, false, true);
					asignarValoresEtiquetas(24, 25, 26, 27, 28, 29, 1);

				} else {
					actualizarDiasMezclados(false, false, false, false, false, false, false);
					asignarValoresEtiquetas(lastDay + 1, lastDay + 2, lastDay + 3, lastDay + 4, lastDay + 5,
							lastDay + 6, lastDay + 7);

					cambioDeMes = false;
				}
			} else {
				if (lastDay == 28) {
					actualizarDiasMezclados(false, false, false, false, false, false, false);
					asignarValoresEtiquetas(1, 2, 3, 4, 5, 6, 7);

				} else if (lastDay == 27) {
					actualizarDiasMezclados(false, true, true, true, true, true, true);
					asignarValoresEtiquetas(28, 1, 2, 3, 4, 5, 6);

				} else if (lastDay == 26) {
					actualizarDiasMezclados(false, false, true, true, true, true, true);
					asignarValoresEtiquetas(27, 28, 1, 2, 3, 4, 5);

				} else if (lastDay == 25) {
					actualizarDiasMezclados(false, false, false, true, true, true, true);
					asignarValoresEtiquetas(26, 27, 28, 1, 2, 3, 4);

				} else if (lastDay == 24) {
					actualizarDiasMezclados(false, false, false, false, true, true, true);
					asignarValoresEtiquetas(25, 26, 27, 28, 1, 2, 3);

				} else if (lastDay == 23) {
					actualizarDiasMezclados(false, false, false, false, false, true, true);
					asignarValoresEtiquetas(24, 25, 26, 27, 28, 1, 2);

				} else if (lastDay == 22) {
					actualizarDiasMezclados(false, false, false, false, false, false, true);
					asignarValoresEtiquetas(23, 24, 25, 26, 27, 28, 1);

				} else {
					actualizarDiasMezclados(false, false, false, false, false, false, false);
					asignarValoresEtiquetas(lastDay + 1, lastDay + 2, lastDay + 3, lastDay + 4, lastDay + 5,
							lastDay + 6, lastDay + 7);
					cambioDeMes = false;
				}
			}
			getLblSemanaFechaCalendario().setText(actualMonth + "/" + actualYear);
		}

	}

	private void actualizarDiasMezclados(boolean b, boolean c, boolean d, boolean e, boolean f, boolean g, boolean h) {
		lunesMixed = b;
		martesMixed = c;
		miercolesMixed = d;
		juevesMixed = e;
		viernesMixed = f;
		sabadoMixed = g;
		domingoMixed = h;
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
					pintarPanelesCalendario(comboBoxIntalacionesCalendario.getSelectedItem().toString().split("@")[0],
							null);
					getLblInstalacionAlqInst().setText("Instalación: "
							+ getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0]);
					int max = admin.getPlazasPorInstalacion(
							getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0]
									.toLowerCase());
					spinner.setModel(new SpinnerNumberModel(max, 1, max, 1));
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

	private JPanel getPanelCancelacionAlquiler() {
		if (panelCancelacionAlquiler == null) {
			panelCancelacionAlquiler = new JPanel();
			panelCancelacionAlquiler.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelCancelacionAlquiler.setBackground(Color.WHITE);
			panelCancelacionAlquiler.setLayout(new GridLayout(3, 0, 0, 0));
			panelCancelacionAlquiler.add(getPanelSociosParaCancelar());
			panelCancelacionAlquiler.add(getPanelAlquiler());
			panelCancelacionAlquiler.add(getPanelAtrasCancelar());
		}
		return panelCancelacionAlquiler;
	}

	private JPanel getPanelSociosParaCancelar() {
		if (panelSociosParaCancelar == null) {
			panelSociosParaCancelar = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelSociosParaCancelar.getLayout();
			flowLayout.setVgap(80);
			flowLayout.setHgap(10);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelSociosParaCancelar.setBackground(Color.WHITE);
			panelSociosParaCancelar.add(getLblIdSocio());
			panelSociosParaCancelar.add(getComboBoxSocios());
		}
		return panelSociosParaCancelar;
	}

	private JPanel getPanelAlquiler() {
		if (panelAlquiler == null) {
			panelAlquiler = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelAlquiler.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setVgap(80);
			flowLayout.setHgap(10);
			panelAlquiler.setBackground(Color.WHITE);
			panelAlquiler.add(getLblAlquiler());
			panelAlquiler.add(getComboBoxAlquileresDeSocio());
		}
		return panelAlquiler;
	}

	private JPanel getPanelAtrasCancelar() {
		if (panelAtrasCancelar == null) {
			panelAtrasCancelar = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelAtrasCancelar.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			flowLayout.setVgap(180);
			panelAtrasCancelar.setBackground(Color.WHITE);
			panelAtrasCancelar.add(getBtnAtrasCancelarAlq());
			panelAtrasCancelar.add(getBtnCancelacionAlquiler());
		}
		return panelAtrasCancelar;
	}

	private JLabel getLblIdSocio() {
		if (lblIdSocio == null) {
			lblIdSocio = new JLabel("Id socio: ");
			lblIdSocio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblIdSocio;
	}

	private JComboBox<String> getComboBoxSocios() {
		if (comboBoxSocios == null) {
			comboBoxSocios = new JComboBox<String>();
			comboBoxSocios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getComboBoxAlquileresDeSocio().setModel(new DefaultComboBoxModel<String>(admin
							.listarAlquileresPorSocio(getComboBoxSocios().getSelectedItem().toString().split("@")[0])));
				}
			});
			comboBoxSocios.setModel(new DefaultComboBoxModel<String>(admin.listarSociosPorAlquileres()));
			comboBoxSocios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxSocios;
	}

	private JLabel getLblAlquiler() {
		if (lblAlquiler == null) {
			lblAlquiler = new JLabel("Alquiler:");
			lblAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblAlquiler;
	}

	private JComboBox<String> getComboBoxAlquileresDeSocio() {
		if (comboBoxAlquileresDeSocio == null) {
			comboBoxAlquileresDeSocio = new JComboBox<String>();
			comboBoxAlquileresDeSocio.setModel(new DefaultComboBoxModel<String>(
					admin.listarAlquileresPorSocio(getComboBoxSocios().getSelectedItem().toString().split("@")[0])));
			comboBoxAlquileresDeSocio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		return comboBoxAlquileresDeSocio;
	}

	private JButton getBtnAtrasCancelarAlq() {
		if (btnAtrasCancelarAlq == null) {
			btnAtrasCancelarAlq = new JButton("Atrás");
			btnAtrasCancelarAlq.setForeground(Color.WHITE);
			btnAtrasCancelarAlq.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelAcciones("panelBotones");
				}
			});
			btnAtrasCancelarAlq.setBackground(new Color(165, 42, 42));
			btnAtrasCancelarAlq.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnAtrasCancelarAlq;
	}

	private JButton getBtnCancelacionAlquiler() {
		if (btnCancelacionAlquiler == null) {
			btnCancelacionAlquiler = new JButton("Cancelar alquiler");
			btnCancelacionAlquiler.setForeground(Color.WHITE);
			btnCancelacionAlquiler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancelarAlquiler();
					pintarPanelesCalendario(
							getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0], null);
				}
			});
			btnCancelacionAlquiler.setBackground(new Color(0, 250, 154));
			btnCancelacionAlquiler.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnCancelacionAlquiler;
	}

	protected void cancelarAlquiler() {
		String socio = getComboBoxSocios().getSelectedItem().toString().split("@")[0];
		String instalacion = getComboBoxAlquileresDeSocio().getSelectedItem().toString().split("@")[0].split("-")[0];
		String fecha = getComboBoxAlquileresDeSocio().getSelectedItem().toString().split("@")[0].split("-")[1];
		String hora_inicio = getComboBoxAlquileresDeSocio().getSelectedItem().toString().split("@")[0].split("-")[2];
		String hora_fin = getComboBoxAlquileresDeSocio().getSelectedItem().toString().split("@")[0].split("-")[3];
		admin.cancelarAlquiler(socio, instalacion, fecha, hora_inicio, hora_fin);
		String[] s = admin.listarAlquileresPorSocio(socio);
		if (s == null || s.length == 0) {
			getComboBoxSocios().setModel(new DefaultComboBoxModel<String>(admin.listarSociosPorAlquileres()));
			getComboBoxAlquileresDeSocio().setModel(
					new DefaultComboBoxModel<String>(admin.listarAlquileresPorSocio(getComboBoxSocios().getItemAt(0))));
		} else {
			getComboBoxAlquileresDeSocio().setModel(new DefaultComboBoxModel<String>(s));
		}
	}

	private JPanel getPanelTipoActividadSelector() {
		if (panelTipoActividadSelector == null) {
			panelTipoActividadSelector = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelTipoActividadSelector.getLayout();
			flowLayout.setVgap(60);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelTipoActividadSelector.setBackground(Color.WHITE);
			panelTipoActividadSelector.add(getLblTipoActividad());
			panelTipoActividadSelector.add(getComboBoxTiposActividad());
		}
		return panelTipoActividadSelector;
	}

	private JLabel getLblspace() {
		if (lblspace == null) {
			lblspace = new JLabel("");
		}
		return lblspace;
	}

	private JPanel getPanelHorario() {
		if (panelHorario == null) {
			panelHorario = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelHorario.getLayout();
			flowLayout.setVgap(60);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelHorario.setBackground(Color.WHITE);
			panelHorario.add(getLblHorario());
			panelHorario.add(getComboBoxHoraInicio());
			panelHorario.add(getComboBoxHoraFin());
		}
		return panelHorario;
	}

	private JLabel getLblHorario() {
		if (lblHorario == null) {
			lblHorario = new JLabel("Horario:");
			lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblHorario;
	}

	private JComboBox<String> getComboBoxHoraInicio() {
		if (comboBoxHoraInicio == null) {
			comboBoxHoraInicio = new JComboBox<String>();
			comboBoxHoraInicio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] model = obtenerModelo(getComboBoxHoraInicio().getSelectedItem().toString().split("@")[0]);
					getComboBoxHoraFin().setModel(new DefaultComboBoxModel<String>(model));
				}
			});
			comboBoxHoraInicio.setModel(
					new DefaultComboBoxModel<String>(new String[] { "9:00", "10:00", "11:00", "12:00", "13:00", "14:00",
							"15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00" }));
			comboBoxHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxHoraInicio;
	}

	protected String[] obtenerModelo(String inicio) {
		String[] modelo = new String[2];
		switch (inicio) {
		case "9:00":
			modelo[0] = "10:00";
			modelo[1] = "11:00";
			break;
		case "10:00":
			modelo[0] = "11:00";
			modelo[1] = "12:00";
			break;
		case "11:00":
			modelo[0] = "12:00";
			modelo[1] = "13:00";
			break;
		case "12:00":
			modelo[0] = "13:00";
			modelo[1] = "14:00";
			break;
		case "13:00":
			modelo[0] = "14:00";
			modelo[1] = "15:00";
			break;
		case "14:00":
			modelo[0] = "15:00";
			modelo[1] = "16:00";
			break;
		case "15:00":
			modelo[0] = "16:00";
			modelo[1] = "17:00";
			break;
		case "16:00":
			modelo[0] = "17:00";
			modelo[1] = "18:00";
			break;
		case "17:00":
			modelo[0] = "18:00";
			modelo[1] = "19:00";
			break;
		case "18:00":
			modelo[0] = "19:00";
			modelo[1] = "20:00";
			break;
		case "19:00":
			modelo[0] = "20:00";
			modelo[1] = "21:00";
			break;
		case "20:00":
			modelo[0] = "21:00";
			modelo[1] = "22:00";
			break;
		case "21:00":
			modelo[0] = "22:00";
			modelo[1] = "23:00";
			break;
		default:
			modelo[0] = "23:00";
			modelo[1] = null;
			ArrayList<String> removedNull = new ArrayList<String>();
			for (String str : modelo)
				if (str != null)
					removedNull.add(str);
			return removedNull.toArray(new String[0]);
		}
		return modelo;
	}

	private JComboBox<String> getComboBoxHoraFin() {
		if (comboBoxHoraFin == null) {
			comboBoxHoraFin = new JComboBox<String>();
			comboBoxHoraFin.setModel(new DefaultComboBoxModel<String>(new String[] { "10:00", "11:00" }));
			comboBoxHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxHoraFin;
	}

	private JPanel getPanelAlquilarInstalacionASocio() {
		if (panelAlquilarInstalacionASocio == null) {
			panelAlquilarInstalacionASocio = new JPanel();
			panelAlquilarInstalacionASocio.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelAlquilarInstalacionASocio.setBackground(Color.WHITE);
			panelAlquilarInstalacionASocio.setLayout(new GridLayout(5, 0, 0, 0));
			panelAlquilarInstalacionASocio.add(getPanelIdSocioAlquilarInstalacion());
			panelAlquilarInstalacionASocio.add(getPanelInstalacionAlquInst());
			panelAlquilarInstalacionASocio.add(getPanelHoraInicioHoraFin());
			panelAlquilarInstalacionASocio.add(getPanelFechaAlqInst());
			panelAlquilarInstalacionASocio.add(getPaneBtnAtrasAlquilar());
		}
		return panelAlquilarInstalacionASocio;
	}

	private JPanel getPanelIdSocioAlquilarInstalacion() {
		if (panelIdSocioAlquilarInstalacion == null) {
			panelIdSocioAlquilarInstalacion = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelIdSocioAlquilarInstalacion.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setVgap(40);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelIdSocioAlquilarInstalacion.setBackground(Color.WHITE);
			panelIdSocioAlquilarInstalacion.add(getLblIdSocioAlquilarInst());
			panelIdSocioAlquilarInstalacion.add(getComboBoxIdSociosAlquilarInst());
		}
		return panelIdSocioAlquilarInstalacion;
	}

	private JLabel getLblIdSocioAlquilarInst() {
		if (lblIdSocioAlquilarInst == null) {
			lblIdSocioAlquilarInst = new JLabel("Id Socio:");
			lblIdSocioAlquilarInst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblIdSocioAlquilarInst;
	}

	private JComboBox<String> getComboBoxIdSociosAlquilarInst() {
		if (comboBoxIdSociosAlquilarInst == null) {
			comboBoxIdSociosAlquilarInst = new JComboBox<String>();
			comboBoxIdSociosAlquilarInst.setModel(new DefaultComboBoxModel<String>(admin.listarSocios()));
			comboBoxIdSociosAlquilarInst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxIdSociosAlquilarInst;
	}

	private JPanel getPanelInstalacionAlquInst() {
		if (panelInstalacionAlquInst == null) {
			panelInstalacionAlquInst = new JPanel();
			panelInstalacionAlquInst.setBackground(Color.WHITE);
			FlowLayout fl_panelInstalacionAlquInst = (FlowLayout) panelInstalacionAlquInst.getLayout();
			fl_panelInstalacionAlquInst.setHgap(10);
			fl_panelInstalacionAlquInst.setVgap(40);
			fl_panelInstalacionAlquInst.setAlignment(FlowLayout.LEFT);
			panelInstalacionAlquInst.add(getLblInstalacionAlqInst());
		}
		return panelInstalacionAlquInst;
	}

	private JLabel getLblInstalacionAlqInst() {
		if (lblInstalacionAlqInst == null) {
			lblInstalacionAlqInst = new JLabel(
					"Instalación: " + getComboBoxIntalacionesCalendario_1().getSelectedItem().toString().split("@")[0]);
			lblInstalacionAlqInst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblInstalacionAlqInst;
	}

	private JPanel getPanelHoraInicioHoraFin() {
		if (panelHoraInicioHoraFin == null) {
			panelHoraInicioHoraFin = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelHoraInicioHoraFin.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setVgap(40);
			panelHoraInicioHoraFin.setBackground(Color.WHITE);
			panelHoraInicioHoraFin.add(getLblHorario_1());
			panelHoraInicioHoraFin.add(getComboBoxHoraInicioAlqInst());
			panelHoraInicioHoraFin.add(getComboBoxHoraFinAlqInst());
		}
		return panelHoraInicioHoraFin;
	}

	private JLabel getLblHorario_1() {
		if (lblHorario_1 == null) {
			lblHorario_1 = new JLabel("Horario:");
			lblHorario_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblHorario_1;
	}

	private JComboBox<String> getComboBoxHoraInicioAlqInst() {
		if (comboBoxHoraInicioAlqInst == null) {
			comboBoxHoraInicioAlqInst = new JComboBox<String>();
			comboBoxHoraInicioAlqInst.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] model = obtenerModelo(
							getComboBoxHoraInicioAlqInst().getSelectedItem().toString().split("@")[0]);
					getComboBoxHoraFinAlqInst().setModel(new DefaultComboBoxModel<String>(model));
				}
			});
			comboBoxHoraInicioAlqInst.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxHoraInicioAlqInst.setModel(
					new DefaultComboBoxModel<String>(new String[] { "9:00", "10:00", "11:00", "12:00", "13:00", "14:00",
							"15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00" }));
		}
		return comboBoxHoraInicioAlqInst;
	}

	private JComboBox<String> getComboBoxHoraFinAlqInst() {
		if (comboBoxHoraFinAlqInst == null) {
			comboBoxHoraFinAlqInst = new JComboBox<String>();
			comboBoxHoraFinAlqInst.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxHoraFinAlqInst.setModel(new DefaultComboBoxModel<String>(new String[] { "10:00", "11:00" }));
		}
		return comboBoxHoraFinAlqInst;
	}

	private JPanel getPanelFechaAlqInst() {
		if (panelFechaAlqInst == null) {
			panelFechaAlqInst = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelFechaAlqInst.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setVgap(40);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelFechaAlqInst.setBackground(Color.WHITE);
			panelFechaAlqInst.add(getLblFechaAlqInst());
			panelFechaAlqInst.add(getTextFieldFechaAlqInst());
		}
		return panelFechaAlqInst;
	}

	private JLabel getLblFechaAlqInst() {
		if (lblFechaAlqInst == null) {
			lblFechaAlqInst = new JLabel("Fecha:");
			lblFechaAlqInst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblFechaAlqInst;
	}

	private JTextField getTextFieldFechaAlqInst() {
		if (textFieldFechaAlqInst == null) {
			textFieldFechaAlqInst = new JTextField();
			textFieldFechaAlqInst.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldFechaAlqInst.setColumns(10);
		}
		return textFieldFechaAlqInst;
	}

	private JPanel getPaneBtnAtrasAlquilar() {
		if (paneBtnAtrasAlquilar == null) {
			paneBtnAtrasAlquilar = new JPanel();
			FlowLayout flowLayout = (FlowLayout) paneBtnAtrasAlquilar.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			flowLayout.setVgap(90);
			paneBtnAtrasAlquilar.setBackground(Color.WHITE);
			paneBtnAtrasAlquilar.add(getLblAlquilerCorrecto());
			paneBtnAtrasAlquilar.add(getLblHorarioOcupado1());
			paneBtnAtrasAlquilar.add(getBtnAtrasAlquilar());
			paneBtnAtrasAlquilar.add(getBtnAlquilar());
			paneBtnAtrasAlquilar.add(getLblspace_1());
		}
		return paneBtnAtrasAlquilar;
	}

	private JLabel getLblAlquilerCorrecto() {
		if (lblAlquilerCorrecto == null) {
			lblAlquilerCorrecto = new JLabel("");
			lblAlquilerCorrecto.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblAlquilerCorrecto.setForeground(Color.GREEN);
		}
		return lblAlquilerCorrecto;
	}

	private JButton getBtnAtrasAlquilar() {
		if (btnAtrasAlquilar == null) {
			btnAtrasAlquilar = new JButton("Atrás");
			btnAtrasAlquilar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelAcciones("panelBotones");
					vaciarCampos();
				}
			});
			btnAtrasAlquilar.setVerticalAlignment(SwingConstants.BOTTOM);
			btnAtrasAlquilar.setHorizontalAlignment(SwingConstants.RIGHT);
			btnAtrasAlquilar.setForeground(Color.WHITE);
			btnAtrasAlquilar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAtrasAlquilar.setBackground(new Color(165, 42, 42));
		}
		return btnAtrasAlquilar;
	}

	private JButton getBtnAlquilar() {
		if (btnAlquilar == null) {
			btnAlquilar = new JButton("Alquilar");
			btnAlquilar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String fecha = getTextFieldFechaAlqInst().getText();
					String inicio = getComboBoxHoraInicioAlqInst().getSelectedItem().toString().split("@")[0];
					String fin = getComboBoxHoraFinAlqInst().getSelectedItem().toString().split("@")[0];
					String instalacion = getComboBoxIntalacionesCalendario_1().getSelectedItem().toString()
							.split("@")[0];
					if (!existsActividad(fecha, inicio, fin) && !existsAlquiler(fecha, inicio, fin, instalacion)) {
						getLblHorarioOcupado1().setVisible(false);
						alquilarInstalacion();
						getComboBoxSocios()
								.setModel(new DefaultComboBoxModel<String>(admin.listarSociosPorAlquileres()));
					} else {
						getLblHorarioOcupado1().setVisible(true);
					}
				}
			});
			btnAlquilar.setVerticalAlignment(SwingConstants.BOTTOM);
			btnAlquilar.setHorizontalAlignment(SwingConstants.RIGHT);
			btnAlquilar.setForeground(Color.WHITE);
			btnAlquilar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAlquilar.setBackground(new Color(0, 250, 154));
		}
		return btnAlquilar;
	}

	protected void alquilarInstalacion() {
		String fecha = getTextFieldFechaAlqInst().getText();
		if (fecha != null && !fecha.isEmpty()) {
			String id_socio = getComboBoxIdSociosAlquilarInst().getSelectedItem().toString().split("@")[0];
			String instalacion = getLblInstalacionAlqInst().getText().split(" ")[1];
			String hora_inicio = getComboBoxHoraInicioAlqInst().getSelectedItem().toString().split("@")[0];
			String hora_fin = getComboBoxHoraFinAlqInst().getSelectedItem().toString().split("@")[0];
			admin.crearAlquiler(id_socio, instalacion, hora_inicio, hora_fin, fecha);
			getTextFieldFechaAlqInst().setBorder(LineBorder.createGrayLineBorder());
			pintarPanelesCalendario(instalacion, null);
			getLblAlquilerCorrecto().setText("¡Alquilado!");
		} else {
			getTextFieldFechaAlqInst().setBorder(new LineBorder(Color.RED));
		}
	}

	private JLabel getLblspace_1() {
		if (lblspace_1 == null) {
			lblspace_1 = new JLabel("");
		}
		return lblspace_1;
	}

	private JLabel getLblHorarioOcupado() {
		if (lblHorarioOcupado == null) {
			lblHorarioOcupado = new JLabel("¡Horario no válido!");
			lblHorarioOcupado.setVisible(false);
			lblHorarioOcupado.setForeground(new Color(255, 0, 0));
		}
		return lblHorarioOcupado;
	}

	private JLabel getLblHorarioOcupado1() {
		if (lblHorarioOcupado1 == null) {
			lblHorarioOcupado1 = new JLabel("¡Horario ocupado!");
			lblHorarioOcupado1.setVisible(false);
			lblHorarioOcupado1.setForeground(new Color(255, 0, 0));
		}
		return lblHorarioOcupado1;
	}

	private JPanel getPanel9() {
		if (panel9 == null) {
			panel9 = new JPanel();
			panel9.setBackground(Color.WHITE);
			panel9.setLayout(new GridLayout(2, 1, 0, 0));
			panel9.add(getLbl9());
			panel9.add(getLbl10());
		}
		return panel9;
	}

	private JPanel getPanel10() {
		if (panel10 == null) {
			panel10 = new JPanel();
			panel10.setBackground(Color.WHITE);
			panel10.setLayout(new GridLayout(0, 1, 0, 0));
			panel10.add(getLbl11());
		}
		return panel10;
	}

	private JPanel getPanel11() {
		if (panel11 == null) {
			panel11 = new JPanel();
			panel11.setBackground(Color.WHITE);
			panel11.setLayout(new GridLayout(1, 0, 0, 0));
			panel11.add(getLbl12());
		}
		return panel11;
	}

	private JPanel getPanel12() {
		if (panel12 == null) {
			panel12 = new JPanel();
			panel12.setBackground(Color.WHITE);
			panel12.setLayout(new GridLayout(1, 0, 0, 0));
			panel12.add(getLbl13());
		}
		return panel12;
	}

	private JPanel getPanel13() {
		if (panel13 == null) {
			panel13 = new JPanel();
			panel13.setBackground(Color.WHITE);
			panel13.setLayout(new GridLayout(1, 0, 0, 0));
			panel13.add(getLbl14());
		}
		return panel13;
	}

	private JPanel getPanel14() {
		if (panel14 == null) {
			panel14 = new JPanel();
			panel14.setBackground(Color.WHITE);
			panel14.setLayout(new GridLayout(0, 1, 0, 0));
			panel14.add(getLbl15());
		}
		return panel14;
	}

	private JPanel getPanel15() {
		if (panel15 == null) {
			panel15 = new JPanel();
			panel15.setBackground(Color.WHITE);
			panel15.setLayout(new GridLayout(1, 0, 0, 0));
			panel15.add(getLbl16());
		}
		return panel15;
	}

	private JPanel getPanel16() {
		if (panel16 == null) {
			panel16 = new JPanel();
			panel16.setBackground(Color.WHITE);
			panel16.setLayout(new GridLayout(1, 0, 0, 0));
			panel16.add(getLbl17());
		}
		return panel16;
	}

	private JPanel getPanel17() {
		if (panel17 == null) {
			panel17 = new JPanel();
			panel17.setBackground(Color.WHITE);
			panel17.setLayout(new GridLayout(1, 0, 0, 0));
			panel17.add(getLbl18());
		}
		return panel17;
	}

	private JPanel getPanel18() {
		if (panel18 == null) {
			panel18 = new JPanel();
			panel18.setBackground(Color.WHITE);
			panel18.setLayout(new GridLayout(1, 0, 0, 0));
			panel18.add(getLbl19());
		}
		return panel18;
	}

	private JPanel getPanel19() {
		if (panel19 == null) {
			panel19 = new JPanel();
			panel19.setBackground(Color.WHITE);
			panel19.setLayout(new GridLayout(1, 0, 0, 0));
			panel19.add(getLbl20());
		}
		return panel19;
	}

	private JPanel getPanel20() {
		if (panel20 == null) {
			panel20 = new JPanel();
			panel20.setBackground(Color.WHITE);
			panel20.setLayout(new GridLayout(1, 0, 0, 0));
			panel20.add(getLbl21());
		}
		return panel20;
	}

	private JPanel getPanel21() {
		if (panel21 == null) {
			panel21 = new JPanel();
			panel21.setBackground(Color.WHITE);
			panel21.setLayout(new GridLayout(1, 0, 0, 0));
			panel21.add(getLbl22());
		}
		return panel21;
	}

	private JPanel getPanel22() {
		if (panel22 == null) {
			panel22 = new JPanel();
			panel22.setBackground(Color.WHITE);
			panel22.setLayout(new GridLayout(1, 0, 0, 0));
			panel22.add(getLbl23());
		}
		return panel22;
	}

	private JPanel getPanel23() {
		if (panel23 == null) {
			panel23 = new JPanel();
			panel23.setBackground(Color.WHITE);
		}
		return panel23;
	}

	private JLabel getLbl9() {
		if (lbl9 == null) {
			lbl9 = new JLabel("       9:00          ");
			lbl9.setVerticalAlignment(SwingConstants.TOP);
			lbl9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl9;
	}

	private JLabel getLbl10() {
		if (lbl10 == null) {
			lbl10 = new JLabel("     10:00    ");
			lbl10.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl10;
	}

	private JLabel getLbl11() {
		if (lbl11 == null) {
			lbl11 = new JLabel("     11:00    ");
			lbl11.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl11;
	}

	private JLabel getLbl12() {
		if (lbl12 == null) {
			lbl12 = new JLabel("     12:00    ");
			lbl12.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl12;
	}

	private JLabel getLbl13() {
		if (lbl13 == null) {
			lbl13 = new JLabel("     13:00    ");
			lbl13.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl13;
	}

	private JLabel getLbl14() {
		if (lbl14 == null) {
			lbl14 = new JLabel("     14:00    ");
			lbl14.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl14;
	}

	private JLabel getLbl15() {
		if (lbl15 == null) {
			lbl15 = new JLabel("     15:00    ");
			lbl15.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl15;
	}

	private JLabel getLbl16() {
		if (lbl16 == null) {
			lbl16 = new JLabel("     16:00    ");
			lbl16.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl16;
	}

	private JLabel getLbl17() {
		if (lbl17 == null) {
			lbl17 = new JLabel("     17:00    ");
			lbl17.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl17;
	}

	private JLabel getLbl18() {
		if (lbl18 == null) {
			lbl18 = new JLabel("     18:00    ");
			lbl18.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl18;
	}

	private JLabel getLbl19() {
		if (lbl19 == null) {
			lbl19 = new JLabel("     19:00    ");
			lbl19.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl19;
	}

	private JLabel getLbl20() {
		if (lbl20 == null) {
			lbl20 = new JLabel("     20:00    ");
			lbl20.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl20;
	}

	private JLabel getLbl21() {
		if (lbl21 == null) {
			lbl21 = new JLabel("     21:00    ");
			lbl21.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl21;
	}

	private JLabel getLbl22() {
		if (lbl22 == null) {
			lbl22 = new JLabel("     22:00    ");
			lbl22.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl22.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl22;
	}

	private JLabel getLbl23() {
		if (lbl23 == null) {
			lbl23 = new JLabel("     23:00    ");
			lbl23.setVerticalAlignment(SwingConstants.BOTTOM);
			lbl23.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl23;
	}

	private JRadioButton getRdbtnRepetirActividadCadaDia_1() {
		if (rdbtnRepetirActividadCadaDia == null) {
			rdbtnRepetirActividadCadaDia = new JRadioButton("Repetir cada día (1 año)");
			rdbtnRepetirActividadCadaDia.setBackground(Color.WHITE);
		}
		return rdbtnRepetirActividadCadaDia;
	}

	private JPanel getPanelFechaPlPrincipal() {
		if (panelFechaPlPrincipal == null) {
			panelFechaPlPrincipal = new JPanel();
			panelFechaPlPrincipal.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) panelFechaPlPrincipal.getLayout();
			flowLayout.setVgap(10);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelFechaPlPrincipal.add(getLblFechaPlanificar());
			panelFechaPlPrincipal.add(getTextFieldFechaPlanificacion());
		}
		return panelFechaPlPrincipal;
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

	private JPanel getPanelRepetirVariosDias() {
		if (panelRepetirVariosDias == null) {
			panelRepetirVariosDias = new JPanel();
			panelRepetirVariosDias.setBackground(Color.WHITE);
			panelRepetirVariosDias.setLayout(new GridLayout(0, 2, 0, 0));
			panelRepetirVariosDias.add(getRdbtnRepetirVariosDias());
			panelRepetirVariosDias.add(getScrollPaneDiasRepetir());
		}
		return panelRepetirVariosDias;
	}

	private JScrollPane getScrollPaneDiasRepetir() {
		if (scrollPaneDiasRepetir == null) {
			scrollPaneDiasRepetir = new JScrollPane();
			scrollPaneDiasRepetir.setMaximumSize(new Dimension(10, 32767));
			scrollPaneDiasRepetir.setMinimumSize(new Dimension(10, 23));
			scrollPaneDiasRepetir.setViewportView(getListDiasDisponibles());
		}
		return scrollPaneDiasRepetir;
	}

	private JList<String> getListDiasDisponibles() {
		if (listDiasDisponibles == null) {
			listDiasDisponibles = new JList<String>();
			listDiasDisponibles.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			listDiasDisponibles.setVisibleRowCount(Integer.MAX_VALUE);
			listDiasDisponibles.setValueIsAdjusting(true);
			listDiasDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 12));
			addDias();
			listDiasDisponibles.setModel(listDiasDisponiblesModel);
		}
		return listDiasDisponibles;
	}

	private void addDias() {
		listDiasDisponiblesModel.add(0, "Lunes");
		listDiasDisponiblesModel.add(1, "Martes");
		listDiasDisponiblesModel.add(2, "Miércoles");
		listDiasDisponiblesModel.add(3, "Jueves");
		listDiasDisponiblesModel.add(4, "Viernes");
		listDiasDisponiblesModel.add(5, "Sábado");
		listDiasDisponiblesModel.add(6, "Domingo");
	}

	private JRadioButton getRdbtnRepetirVariosDias() {
		if (rdbtnRepetirVariosDias == null) {
			rdbtnRepetirVariosDias = new JRadioButton("Repetir varios días (1 año)");
			rdbtnRepetirVariosDias.setBackground(Color.WHITE);
		}
		return rdbtnRepetirVariosDias;
	}

	private JRadioButton getRdbtnNoRepetir() {
		if (rdbtnNoRepetir == null) {
			rdbtnNoRepetir = new JRadioButton("No repetir");
			rdbtnNoRepetir.setBackground(Color.WHITE);
		}
		return rdbtnNoRepetir;
	}

	private JPanel getPanelCerrarInstalacion() {
		if (panelCerrarInstalacion == null) {
			panelCerrarInstalacion = new JPanel();
			panelCerrarInstalacion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			FlowLayout flowLayout = (FlowLayout) panelCerrarInstalacion.getLayout();
			flowLayout.setVgap(60);
			panelCerrarInstalacion.setBackground(Color.WHITE);
			panelCerrarInstalacion.add(getBtnNewButton());
		}
		return panelCerrarInstalacion;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Cerrar Instalación");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelAcciones("panelCerrarInstalacion");
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnNewButton;
	}

	private JPanel getPanelCerrarInstalacionAlquileres() {
		if (panelCerrarInstalacionAlquileres == null) {
			panelCerrarInstalacionAlquileres = new JPanel();
			panelCerrarInstalacionAlquileres.setBackground(Color.WHITE);
			panelCerrarInstalacionAlquileres.setLayout(new GridLayout(3, 0, 0, 0));
			panelCerrarInstalacionAlquileres.add(getPanelInstalacionesCerrar());
			panelCerrarInstalacionAlquileres.add(getPanelDiaCerrarInstalaciones());
			panelCerrarInstalacionAlquileres.add(getPanelAtrasCerrarInstalacion());
		}
		return panelCerrarInstalacionAlquileres;
	}

	private JPanel getPanelInstalacionesCerrar() {
		if (panelInstalacionesCerrar == null) {
			panelInstalacionesCerrar = new JPanel();
			panelInstalacionesCerrar.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) panelInstalacionesCerrar.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setVgap(120);
			panelInstalacionesCerrar.add(getLblInstalacionACerrar());
			panelInstalacionesCerrar.add(getComboBoxInstalacionesACerrar());
		}
		return panelInstalacionesCerrar;
	}

	private JPanel getPanelDiaCerrarInstalaciones() {
		if (panelDiaCerrarInstalaciones == null) {
			panelDiaCerrarInstalaciones = new JPanel();
			panelDiaCerrarInstalaciones.setBackground(Color.WHITE);
			FlowLayout flowLayout = (FlowLayout) panelDiaCerrarInstalaciones.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			flowLayout.setVgap(120);
			panelDiaCerrarInstalaciones.add(getLblFechaInstalacionCerrada());
			panelDiaCerrarInstalaciones.add(getTextFieldFechaCierre());
		}
		return panelDiaCerrarInstalaciones;
	}

	private JPanel getPanelAtrasCerrarInstalacion() {
		if (panelAtrasCerrarInstalacion == null) {
			panelAtrasCerrarInstalacion = new JPanel();
			panelAtrasCerrarInstalacion.setBackground(Color.WHITE);
			panelAtrasCerrarInstalacion.setLayout(new GridLayout(2, 0, 0, 0));
			panelAtrasCerrarInstalacion.add(getLblRecordatorioAlquileres());
			panelAtrasCerrarInstalacion.add(getPanelBotonesAtrasYCancelar());
		}
		return panelAtrasCerrarInstalacion;
	}

	private JComboBox<String> getComboBoxInstalacionesACerrar() {
		if (comboBoxInstalacionesACerrar == null) {
			comboBoxInstalacionesACerrar = new JComboBox<String>();
			comboBoxInstalacionesACerrar.setModel(new DefaultComboBoxModel<String>(admin.getInstalaciones()));
			comboBoxInstalacionesACerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return comboBoxInstalacionesACerrar;
	}

	private JLabel getLblInstalacionACerrar() {
		if (lblInstalacionACerrar == null) {
			lblInstalacionACerrar = new JLabel("Instalación: ");
			lblInstalacionACerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblInstalacionACerrar;
	}

	private JLabel getLblFechaInstalacionCerrada() {
		if (lblFechaInstalacionCerrada == null) {
			lblFechaInstalacionCerrada = new JLabel("Fecha de cierre: ");
			lblFechaInstalacionCerrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblFechaInstalacionCerrada;
	}

	private JTextField getTextFieldFechaCierre() {
		if (textFieldFechaCierre == null) {
			textFieldFechaCierre = new JTextField();
			textFieldFechaCierre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textFieldFechaCierre.setColumns(10);
		}
		return textFieldFechaCierre;
	}

	private JLabel getLblRecordatorioAlquileres() {
		if (lblRecordatorioAlquileres == null) {
			lblRecordatorioAlquileres = new JLabel("Recuerda que sólo se cerrará la instalación \npara alquileres");
			lblRecordatorioAlquileres.setVerticalAlignment(SwingConstants.TOP);
			lblRecordatorioAlquileres.setHorizontalAlignment(SwingConstants.CENTER);
			lblRecordatorioAlquileres.setForeground(new Color(139, 0, 0));
			lblRecordatorioAlquileres.setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
		return lblRecordatorioAlquileres;
	}

	private JPanel getPanelBotonesAtrasYCancelar() {
		if (panelBotonesAtrasYCancelar == null) {
			panelBotonesAtrasYCancelar = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelBotonesAtrasYCancelar.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			flowLayout.setVgap(80);
			panelBotonesAtrasYCancelar.setBackground(Color.WHITE);
			panelBotonesAtrasYCancelar.add(getLblTodoCorrectoCerrar());
			panelBotonesAtrasYCancelar.add(getBtnAtrasTipo_1_2());
			panelBotonesAtrasYCancelar.add(getBtnCrearTipo_1_2());
			panelBotonesAtrasYCancelar.add(getLblNewLabel());
		}
		return panelBotonesAtrasYCancelar;
	}

	private JButton getBtnAtrasTipo_1_2() {
		if (btnAtrasCerrar == null) {
			btnAtrasCerrar = new JButton("Atrás");
			btnAtrasCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					vaciarCampos();
					mostrarPanelAcciones("panelBotones");
				}
			});
			btnAtrasCerrar.setVerticalAlignment(SwingConstants.BOTTOM);
			btnAtrasCerrar.setHorizontalAlignment(SwingConstants.RIGHT);
			btnAtrasCerrar.setForeground(Color.WHITE);
			btnAtrasCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAtrasCerrar.setBackground(new Color(165, 42, 42));
		}
		return btnAtrasCerrar;
	}

	private JButton getBtnCrearTipo_1_2() {
		if (btnCrearCerrar == null) {
			btnCrearCerrar = new JButton("Cerrar");
			btnCrearCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrarInstalacion(getComboBoxInstalacionesACerrar().getSelectedItem().toString().split("@")[0],
							getTextFieldFechaCierre().getText());
					getLblTodoCorrectoCerrar().setVisible(true);
				}
			});
			btnCrearCerrar.setVerticalAlignment(SwingConstants.BOTTOM);
			btnCrearCerrar.setHorizontalAlignment(SwingConstants.RIGHT);
			btnCrearCerrar.setForeground(Color.WHITE);
			btnCrearCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCrearCerrar.setBackground(new Color(0, 250, 154));
		}
		return btnCrearCerrar;
	}

	protected void cerrarInstalacion(String instalacion, String fechaCierre) {
		admin.cerrarInstalacion(instalacion, fechaCierre);

		List<Alquiler> alquileres = admin.listarAlquileres(instalacion);
		List<Alquiler> alquileresCancelados = new ArrayList<>();// alquileres que se van a cancelar
		for (Alquiler a : alquileres) {
			if (a.getFecha().equals(fechaCierre))
				alquileresCancelados.add(a);
		}
		// Se eliminan los alquileres
		for (Alquiler a : alquileresCancelados)
			admin.actualizarAlquilerACanceladoPorCierre(a);

		pintarPanelesCalendario(instalacion, fechaCierre);

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
		}
		return lblNewLabel;
	}

	private JLabel getLblTodoCorrectoCerrar() {
		if (lblTodoCorrectoCerrar == null) {
			lblTodoCorrectoCerrar = new JLabel("¡Hecho!");
			lblTodoCorrectoCerrar.setVisible(false);
			lblTodoCorrectoCerrar.setForeground(Color.GREEN);
			lblTodoCorrectoCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblTodoCorrectoCerrar;
	}
}
