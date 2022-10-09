/**
 * 
 */
package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JTextField;

import logic.Administrador;

import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

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

	public VentanaAdministrador() {
		setMinimumSize(new Dimension(870, 570));
		getContentPane().setLayout(new CardLayout(0, 0));
		this.setTitle("Administrador");
		getContentPane().add(getPanelSelectorAccion(), "panelSelectorAction");
		getContentPane().add(getPanelCrearActividad(), "panelCrearActividad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	private JPanel getPanelSelectorAccion() {
		if (panelSelectorAccion == null) {
			panelSelectorAccion = new JPanel();
			panelSelectorAccion.setLayout(null);
			panelSelectorAccion.add(getLblAdministrador());
			panelSelectorAccion.add(getBtnMostrarCrearActividad());
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
					mostrarPanelCrearActividad();
				}
			});
			btnMostrarCrearActividad.setForeground(Color.WHITE);
			btnMostrarCrearActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnMostrarCrearActividad.setBackground(new Color(34, 139, 34));
			btnMostrarCrearActividad.setBounds(164, 122, 530, 62);
		}
		return btnMostrarCrearActividad;
	}

	protected void mostrarPanelCrearActividad() {
		this.setTitle("Administrador - Crear actividad");
		((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panelCrearActividad");
	}

	private JPanel getPanelCrearActividad() {
		if (panelCrearActividad == null) {
			panelCrearActividad = new JPanel();
			panelCrearActividad.setLayout(new BorderLayout(0, 0));
			panelCrearActividad.add(getLblAdministrador2(), BorderLayout.NORTH);
			panelCrearActividad.add(getPanelTextoActividad(), BorderLayout.SOUTH);
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
			panelTextoActividad.setLayout(new GridLayout(6, 1, 0, 0));
			panelTextoActividad.add(getPanelId());
			panelTextoActividad.add(getPanelNombreActividad());
			panelTextoActividad.add(getPanelIntensidadActividad());
			panelTextoActividad.add(getPanelRecursosActividad());
			panelTextoActividad.add(getPanelAccesoActividad());
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
		if (!admin.crearActividad(id, nombre, intensidad, recurso, acceso)) {
			getLblValidacionCampos().setEnabled(true);
			getLblValidacionCampos().setForeground(Color.RED);
			getLblValidacionCampos().setText("¡Los valores no son correctos, introdúcelos de nuevo!");
		} else {
			getLblValidacionCampos().setEnabled(true);
			getLblValidacionCampos().setForeground(Color.GREEN);
			getLblValidacionCampos().setText("¡Actividad creada!");
		}
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
					mostrarPanelSeleccionAccion();
				}
			});
			btnVolverSeleccionAccion.setForeground(new Color(255, 255, 255));
			btnVolverSeleccionAccion.setBackground(new Color(100, 149, 237));
			btnVolverSeleccionAccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnVolverSeleccionAccion;
	}

	protected void mostrarPanelSeleccionAccion() {
		((CardLayout) getContentPane().getLayout()).show(getContentPane(), "panelSelectorAction");
		getLblValidacionCampos().setText("");
		this.setTitle("Administrador");
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
}
