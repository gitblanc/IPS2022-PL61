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
import javax.swing.border.LineBorder;

import logic.Administrador;

public class NewVentanaAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Administrador admin = new Administrador();

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

	/**
	 * Create the frame.
	 */
	public NewVentanaAdmin() {
		setTitle("Aministrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 698);
		contentPane = new JPanel();
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
	}

	private JPanel getPanelCalendario() {
		if (panelCalendario == null) {
			panelCalendario = new JPanel();
			panelCalendario.setBackground(SystemColor.activeCaption);
		}
		return panelCalendario;
	}

	private JPanel getPanelAcciones() {
		if (panelAcciones == null) {
			panelAcciones = new JPanel();
			panelAcciones.setLayout(new CardLayout(0, 0));
			panelAcciones.add(getPanelBotones(), "panelBotones");
			panelAcciones.add(getPanelCrearActividad(), "panelCrearActividad");
		}
		return panelAcciones;
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setBackground(Color.PINK);
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
			btnPlanificarActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnPlanificarActividad;
	}

	private JPanel getPanelAlquilarASocio() {
		if (panelAlquilarASocio == null) {
			panelAlquilarASocio = new JPanel();
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
			btnAlquilarInstalacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnAlquilarInstalacion;
	}

	private JPanel getPanelCancelarAlquiler() {
		if (panelCancelarAlquiler == null) {
			panelCancelarAlquiler = new JPanel();
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
			lblInstalacion = new JLabel("Instalación:");
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
			btnAtrasTipo = new JButton("Atrás");
			btnAtrasTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
		if (acceso.equals("con reserva")) {
			int plazas = Integer.parseInt(getSpinner().getValue().toString());
			admin.crearActividad(id, tipo, intensidad, instalacion, recursos, acceso, plazas);
		} else {
			admin.crearActividad(id, tipo, intensidad, instalacion, recursos, acceso, -1);// el -1 es pq conlleva plazas
																							// ilimitadas
		}
		getLblParametrosCorrectosTipoA().setVisible(true);
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
			spinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
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
}
