package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Actividad;
import logic.Aplicacion;
import logic.Monitor;
import logic.Socio;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaMonitor1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Monitor monitor;
	private Aplicacion aplicacion;
	private Actividad actividad = new Actividad();;
	private JPanel contentPane;
	private JPanel panelOpciones;
	private JPanel panelListaAsistencia;
	private JPanel panelApuntarSocios;
	private JPanel panelRegistrarAsistencia;
	private JPanel panelBotonesOpciones;
	private JButton btnListaAsistencia;
	private JButton btnRegistrarAsistencia;
	private JButton btnApuntarSocios;
	private JPanel panelNorte;
	private JComboBox cbActividades;
	private JLabel lblSelectAct;
	private JLabel lblListaAsistencia;
	private JScrollPane scrollPaneListaAsistencia;
	private JTextArea txtAListaAsistencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMonitor1 frame = new VentanaMonitor1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMonitor1() {
		
		setTitle("Ventana Monitor");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelOpciones(), "opciones");
		contentPane.add(getPanelListaAsistencia(), "lista");
		contentPane.add(getPanelApuntarSocios(), "apuntar");
		contentPane.add(getPanelRegistrarAsistencia(), "registrar");
		
	}

	private JPanel getPanelOpciones() {
		if (panelOpciones == null) {
			panelOpciones = new JPanel();
			panelOpciones.setLayout(new BorderLayout(0, 0));
			panelOpciones.add(getPanelBotonesOpciones(), BorderLayout.CENTER);
		}
		return panelOpciones;
	}
	private JPanel getPanelListaAsistencia() {
		if (panelListaAsistencia == null) {
			panelListaAsistencia = new JPanel();
			panelListaAsistencia.setLayout(new BorderLayout(0, 0));
			panelListaAsistencia.add(getLblListaAsistencia(), BorderLayout.NORTH);
			panelListaAsistencia.add(getScrollPaneListaAsistencia(), BorderLayout.CENTER);
		}
		return panelListaAsistencia;
	}
	private JPanel getPanelApuntarSocios() {
		if (panelApuntarSocios == null) {
			panelApuntarSocios = new JPanel();
		}
		return panelApuntarSocios;
	}
	private JPanel getPanelRegistrarAsistencia() {
		if (panelRegistrarAsistencia == null) {
			panelRegistrarAsistencia = new JPanel();
		}
		return panelRegistrarAsistencia;
	}
	private JPanel getPanelBotonesOpciones() {
		if (panelBotonesOpciones == null) {
			panelBotonesOpciones = new JPanel();
			panelBotonesOpciones.setLayout(new GridLayout(0, 1, 0, 0));
			panelBotonesOpciones.add(getPanel_1());
			panelBotonesOpciones.add(getBtnListaAsistencia());
			panelBotonesOpciones.add(getBtnRegistrarAsistencia());
			panelBotonesOpciones.add(getBtnApuntarSocios());
		}
		return panelBotonesOpciones;
	}
	private JButton getBtnListaAsistencia() {
		if (btnListaAsistencia == null) {
			btnListaAsistencia = new JButton("Lista de asistencia");
			btnListaAsistencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					comprobarMonitor();					
				}
			});
			btnListaAsistencia.setBackground(Color.LIGHT_GRAY);
			btnListaAsistencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnListaAsistencia;
	}
//	protected void comprobarMonitor() {
//		String name = JOptionPane.showInputDialog("Escriba el identificador de monitor");
//		if (actividad.comprobarMonitorActividad(name, getCbActividades().getSelectedItem().toString())) {
//			mostrarListaAsistencia();
//		}
//		JOptionPane.showMessageDialog(null, "Lo siento, no puede acceder a esta información ya que no es el monitor de esta actividad ");
//		
//	}

//	protected void mostrarListaAsistencia() {
//		((CardLayout) getContentPane().getLayout()).show(getContentPane(), "lista");
//		getTxtAListaAsistencia().setText(mostrarSocios());
//	}

//	private String mostrarSocios() {
//		String s = new String();
//		List<Socio> socios = actividad.getSociosApuntados();
//		for (int i=0; i<socios.size(); i++) {
//			s = s + socios.get(i).getNombreSocio() + " " + socios.get(i).getApellidosSocio()+  "\n";
//		}
//		return s;
//	}

	private JButton getBtnRegistrarAsistencia() {
		if (btnRegistrarAsistencia == null) {
			btnRegistrarAsistencia = new JButton("RegistrarAsistencia");
			btnRegistrarAsistencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					registrarAsistencia();
				}
			});
			btnRegistrarAsistencia.setBackground(Color.LIGHT_GRAY);
			btnRegistrarAsistencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnRegistrarAsistencia;
	}
	protected void registrarAsistencia() {
		((CardLayout) getContentPane().getLayout()).show(getContentPane(), "asistencia");
		
	}

	private JButton getBtnApuntarSocios() {
		if (btnApuntarSocios == null) {
			btnApuntarSocios = new JButton("Apuntar socios");
			btnApuntarSocios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					apuntarSocios();
				}
			});
			btnApuntarSocios.setBackground(Color.LIGHT_GRAY);
			btnApuntarSocios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return btnApuntarSocios;
	}
	protected void apuntarSocios() {
		((CardLayout) getContentPane().getLayout()).show(getContentPane(), "asistencia");
		
	}

	private JPanel getPanel_1() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setLayout(new GridLayout(2, 1, 0, 0));
			panelNorte.add(getLblSelectAct());
	//		panelNorte.add(getCbActividades());
		}
		return panelNorte;
	}
//	private JComboBox<String> getCbActividades() {
//		if (cbActividades == null) {
//			
//			cbActividades = new JComboBox();
//			cbActividades.setModel(new DefaultComboBoxModel<String>(actividad.actividadesId()));
//			
//			cbActividades.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		}
//		return cbActividades;
//	}
	private JLabel getLblSelectAct() {
		if (lblSelectAct == null) {
			lblSelectAct = new JLabel("Seleccionar Actividad");
			lblSelectAct.setHorizontalAlignment(SwingConstants.CENTER);
			lblSelectAct.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lblSelectAct;
	}
	private JLabel getLblListaAsistencia() {
		if (lblListaAsistencia == null) {
			lblListaAsistencia = new JLabel("Lista de asistencia ");
			lblListaAsistencia.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblListaAsistencia.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblListaAsistencia;
	}
	private JScrollPane getScrollPaneListaAsistencia() {
		if (scrollPaneListaAsistencia == null) {
			scrollPaneListaAsistencia = new JScrollPane();
			scrollPaneListaAsistencia.setViewportView(getTxtAListaAsistencia());
		}
		return scrollPaneListaAsistencia;
	}
	private JTextArea getTxtAListaAsistencia() {
		if (txtAListaAsistencia == null) {
			txtAListaAsistencia = new JTextArea();
			txtAListaAsistencia.setLineWrap(true);
			txtAListaAsistencia.setEditable(false);
		}
		return txtAListaAsistencia;
	}
}
