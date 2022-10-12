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
	private JPanel panelCalendario;
	private JPanel panelInfoActividad;
	private JLabel lblActividades;
	private JPanel panelActividades;
	private JPanel panelHorarioActividad;
	private JLabel lblHorarioActividad;
	private JComboBox<String> comboBoxHorario;
	// private JPanel panelCeldasCalendario;
	private JPanel panelHorario;
	private JLabel lblHorario;

	public VentanaAdministrador() {
		setMinimumSize(new Dimension(1000, 660));
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
			panelTextoActividad.setLayout(new GridLayout(7, 1, 0, 0));
			panelTextoActividad.add(getPanelId());
			panelTextoActividad.add(getPanelNombreActividad());
			panelTextoActividad.add(getPanelIntensidadActividad());
			panelTextoActividad.add(getPanelRecursosActividad());
			panelTextoActividad.add(getPanelAccesoActividad());
			panelTextoActividad.add(getPanelHorarioActividad());
			panelTextoActividad.add(getPanelHorario());
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
		String horario = getComboBoxHorario().getSelectedItem().toString().split("@")[0].toLowerCase();
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
		getComboBoxHorario().setSelectedIndex(0);
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
			panelPlanificarActividad.setLayout(new GridLayout(0, 2, 0, 0));
			panelPlanificarActividad.add(getPanelCalendario());
			panelPlanificarActividad.add(getPanelInfoActividad());
		}
		return panelPlanificarActividad;
	}

	private JPanel getPanelCalendario() {
		if (panelCalendario == null) {
			panelCalendario = new JPanel();
			panelCalendario.setBackground(new Color(95, 158, 160));
			panelCalendario.setLayout(new BorderLayout(0, 0));
			// panelCalendario.add(getPanelCeldasCalendario(), BorderLayout.CENTER);
		}
		return panelCalendario;
	}

	private JPanel getPanelInfoActividad() {
		if (panelInfoActividad == null) {
			panelInfoActividad = new JPanel();
			panelInfoActividad.setBackground(Color.WHITE);
			panelInfoActividad.setLayout(new BorderLayout(0, 0));
			panelInfoActividad.add(getLblActividades(), BorderLayout.NORTH);
			panelInfoActividad.add(getPanelActividades(), BorderLayout.CENTER);
		}
		return panelInfoActividad;
	}

	private JLabel getLblActividades() {
		if (lblActividades == null) {
			lblActividades = new JLabel("Actividades");
			lblActividades.setHorizontalAlignment(SwingConstants.CENTER);
			lblActividades.setFont(new Font("Times New Roman", Font.BOLD, 34));
		}
		return lblActividades;
	}

	private JPanel getPanelActividades() {
		if (panelActividades == null) {
			panelActividades = new JPanel();
			panelActividades.setBackground(Color.WHITE);
		}
		return panelActividades;
	}

//	private JPanel getPanelCeldasCalendario() {
//		if (panelCeldasCalendario == null) {
//			panelCeldasCalendario = new JPanel();
//			panelCeldasCalendario.setBackground(Color.WHITE);
//			panelCeldasCalendario.setLayout(new GridLayout(16, 8, 0, 0));
//			generarCeldasCalendario();
//		}
//		return panelCeldasCalendario;
//	}
	private JPanel getPanelHorarioActividad() {
		if (panelHorarioActividad == null) {
			panelHorarioActividad = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelHorarioActividad.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setVgap(30);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelHorarioActividad.add(getLblHorarioActividad());
			panelHorarioActividad.add(getComboBoxHorario());
		}
		return panelHorarioActividad;
	}

	private JLabel getLblHorarioActividad() {
		if (lblHorarioActividad == null) {
			lblHorarioActividad = new JLabel("Horario:");
			lblHorarioActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblHorarioActividad;
	}

	private JPanel getPanelHorario() {
		if (panelHorario == null) {
			panelHorario = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelHorario.getLayout();
			flowLayout.setVgap(30);
			flowLayout.setHgap(10);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panelHorario.add(getLblHorario());
			panelHorario.add(getComboBoxHorario());
		}
		return panelHorario;
	}

	private JLabel getLblHorario() {
		if (lblHorario == null) {
			lblHorario = new JLabel("Horario: ");
			lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblHorario;
	}

	private JComboBox<String> getComboBoxHorario() {
		if (comboBoxHorario == null) {
			comboBoxHorario = new JComboBox<String>();
			comboBoxHorario.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBoxHorario.setModel(new DefaultComboBoxModel<String>(
					new String[] { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00",
							"18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "" }));
		}
		return comboBoxHorario;
	}
}
