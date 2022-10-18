package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logic.Actividad;
import logic.Aplicacion;
import logic.Monitor;
import logic.MonitorBase;
import logic.Socio;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class VentanaMonitor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MonitorBase monitorBase= new MonitorBase();
	private String actividad ="";
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
	private JLabel lblSelectAct;
	private JLabel lblListaAsistencia;
	private JScrollPane scrollPaneListaAsistencia;
	private JTextArea txtAListaAsistencia;
	private JComboBox<String> cbActividad;
	private JLabel lblApuntarSocios;
	private JPanel pnNumeroSocios;
	private JLabel lblPlazasLibres;
	private JLabel lblSociosApuntados;
	private JPanel pnApuntar;
	private JTextField txtNombre;
	private JButton btnApuntar;
	private JLabel lblApuntar;
	private JPanel pnLista;
	private JPanel pnExplicacion;
	private JLabel lblPasarLista;
	private JButton btnFinalizarR;
	private JButton btnFinalizarA;
	private JButton btnFinalizarL;
	private JTextField txtPlazasLibres;
	private JTextField txtApuntados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMonitor frame = new VentanaMonitor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la ventana del monitor
	 */
	public VentanaMonitor() {
		setTitle("Ventana Monitor");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelOpciones(), "opciones"); //panel con las 3 opciones del monitor
		contentPane.add(getPanelListaAsistencia(), "lista"); //panel que sirve para pasar lista de asistencia a los socios
		contentPane.add(getPanelApuntarSocios(), "apuntar"); //panel que apunta socios a actividades con plazas libres
		contentPane.add(getPanelRegistrarAsistencia(), "registrar"); //panel que registra la asistencia de socios a la actividad
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
			panelApuntarSocios.setLayout(new BorderLayout(0, 0));
			panelApuntarSocios.add(getLblApuntarSocios(), BorderLayout.NORTH);
			panelApuntarSocios.add(getPnNumeroSocios(), BorderLayout.CENTER);
			panelApuntarSocios.add(getPnApuntar(), BorderLayout.SOUTH);
		}
		return panelApuntarSocios;
	}
	private JPanel getPanelRegistrarAsistencia() {
		if (panelRegistrarAsistencia == null) {
			panelRegistrarAsistencia = new JPanel();
			panelRegistrarAsistencia.setLayout(new BorderLayout(0, 0));
			panelRegistrarAsistencia.add(getPnLista(), BorderLayout.CENTER);
			panelRegistrarAsistencia.add(getPnExplicacion(), BorderLayout.NORTH);
			panelRegistrarAsistencia.add(getBtnFinalizarR(), BorderLayout.SOUTH);
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
			btnListaAsistencia.setMnemonic('l');
			btnListaAsistencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					comprobarMonitor();	
					mostrarPanelListaAsistencia();
					getListaSociosLista();
				}
			});
			btnListaAsistencia.setBackground(new Color(245, 222, 179));
			btnListaAsistencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnListaAsistencia.setEnabled(false);
		}
		return btnListaAsistencia;
	}
	
	/*
	 * Muestra el panel que permite pasar una lista de asistencia a los socios de la actividad
	 */
	protected void mostrarPanelListaAsistencia() {
		((CardLayout) getContentPane().getLayout()).show(getContentPane(), "lista");
		
	}
	
	/*
	 * Muestra el panel que permite apuntar nuevos socios a una actividad
	 */
	protected void mostrarPanelApuntar() {
		((CardLayout) getContentPane().getLayout()).show(getContentPane(), "apuntar");
		
	}
	
	/**
	 * Muestra el panel que tiene las opciones a elegir
	 */
	protected void mostrarPanelOpciones() {
		((CardLayout) getContentPane().getLayout()).show(getContentPane(), "opciones");
		
	}
	
	/**
	 * Muestra el panel que permite registrar la asistencia de los socios a la actividad
	 */
	protected void mostrarPanelRegistrar() {
		((CardLayout) getContentPane().getLayout()).show(getContentPane(), "registrar");
		
	}


	private JButton getBtnRegistrarAsistencia() {
		if (btnRegistrarAsistencia == null) {
			btnRegistrarAsistencia = new JButton("RegistrarAsistencia");
			btnRegistrarAsistencia.setMnemonic('r');
			btnRegistrarAsistencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelRegistrar();
					getListaSociosAsistencia();
				}
			});
			btnRegistrarAsistencia.setBackground(new Color(255, 218, 185));
			btnRegistrarAsistencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnRegistrarAsistencia.setEnabled(false);;
		}
		return btnRegistrarAsistencia;
	}
	

	private JButton getBtnApuntarSocios() {
		if (btnApuntarSocios == null) {
			btnApuntarSocios = new JButton("Apuntar socios");
			btnApuntarSocios.setMnemonic('a');
			btnApuntarSocios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelApuntar();

					comprobarNumeroSocios(actividad);
					mostrarNumeroSocios();
				}
			});
			btnApuntarSocios.setBackground(new Color(238, 232, 170));
			btnApuntarSocios.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnApuntarSocios.setEnabled(false);
		}
		return btnApuntarSocios;
	}
	

	protected void comprobarNumeroSocios(String actividad) {
		int max = monitorBase.getPlazas(actividad);
		int sociosApuntados = monitorBase.getSocios(actividad).size();
		int dif = max -sociosApuntados;
		if (dif>0) {
			getBtnApuntar().setEnabled(true);
			getTxtPlazasLibres().setText(String.valueOf(dif));
		}else {
			getBtnApuntar().setEnabled(false);
			getTxtPlazasLibres().setText("0");
		}
		
	}

	private JPanel getPanel_1() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setLayout(new GridLayout(2, 1, 0, 0));
			panelNorte.add(getLblSelectAct());
			panelNorte.add(getCbActividad());
		}
		return panelNorte;
	}

	private JLabel getLblSelectAct() {
		if (lblSelectAct == null) {
			lblSelectAct = new JLabel("Seleccionar Actividad");
			lblSelectAct.setDisplayedMnemonic('s');
			lblSelectAct.setLabelFor(getCbActividad());
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
			scrollPaneListaAsistencia.setRowHeaderView(getBtnFinalizarL());
		}
		return scrollPaneListaAsistencia;
	}
	private JTextArea getTxtAListaAsistencia() {
		if (txtAListaAsistencia == null) {
			txtAListaAsistencia = new JTextArea();
			txtAListaAsistencia.setFont(new Font("Monospaced", Font.BOLD, 21));
			txtAListaAsistencia.setLineWrap(true);
			txtAListaAsistencia.setEditable(false);
			txtAListaAsistencia.setText("Lista de socios apuntados\n");
		}
		return txtAListaAsistencia;
	}

	/**
	 * Método que devuelve la lista de socios dependiendo de la actividad seleccionada
	 * @return lista socios
	 */
	private List<String> getListaSociosLista() {
		List<String> lista= monitorBase.getSocios(actividad);
		for (int i=0; i<lista.size(); i++) {
			getTxtAListaAsistencia().append("\t"+ lista.get(i) + "\n");
			JCheckBox c = new JCheckBox();
			String name = lista.get(i);
			c.setText(name);
			pnLista.add(c);
		} 
		return lista;
	}
	private List<String> getListaSociosAsistencia() {
		List<String> lista= monitorBase.getSocios(actividad);
		for (int i=0; i<lista.size(); i++) {
			JCheckBox c = new JCheckBox();
			String name = lista.get(i);
			c.setText(name);
			pnLista.add(c);
		} 
		return lista;
	}
	

	private JComboBox<String> getCbActividad() {
		if (cbActividad == null) {
			cbActividad = new JComboBox<String>();
			cbActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cbActividad.setBackground(new Color(255, 255, 255));
			cbActividad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					activarBotones();
					setActividad((String)getCbActividad().getSelectedItem());
				}
			});					
			
			cbActividad.setModel(new DefaultComboBoxModel<String>((String[]) monitorBase.getActividadesArray())); //simulando el uso de la base de datos
//			cbActividad.setModel(new DefaultComboBoxModel<String>((String[]) actividad.listarActividades().toArray())); usando la base de datos
		}
		return cbActividad;
	}

	protected void setActividad(String act) {
		this.actividad = act;
		
	}

	protected void activarBotones() {
		getBtnApuntarSocios().setEnabled(true);
		getBtnListaAsistencia().setEnabled(true);
		getBtnRegistrarAsistencia().setEnabled(true);
	}
	private JLabel getLblApuntarSocios() {
		if (lblApuntarSocios == null) {
			lblApuntarSocios = new JLabel("Apuntar socios");
			lblApuntarSocios.setHorizontalAlignment(SwingConstants.CENTER);
			lblApuntarSocios.setFont(new Font("Tahoma", Font.PLAIN, 24));
		}
		return lblApuntarSocios;
	}
	private JPanel getPnNumeroSocios() {
		if (pnNumeroSocios == null) {
			pnNumeroSocios = new JPanel();
			pnNumeroSocios.setLayout(new GridLayout(0, 2, 0, 0));
			pnNumeroSocios.add(getLblPlazasLibres());
			pnNumeroSocios.add(getLblSociosApuntados());
			pnNumeroSocios.add(getTxtPlazasLibres());
			pnNumeroSocios.add(getTxtApuntados());
		}
		return pnNumeroSocios;
	}
	private JLabel getLblPlazasLibres() {
		if (lblPlazasLibres == null) {
			lblPlazasLibres = new JLabel("Plazas libres:");
			lblPlazasLibres.setFont(new Font("Tahoma", Font.PLAIN, 21));
			lblPlazasLibres.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPlazasLibres;
	}
	private JLabel getLblSociosApuntados() {
		if (lblSociosApuntados == null) {
			lblSociosApuntados = new JLabel("N\u00FAmero de socios apuntados:");
			lblSociosApuntados.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblSociosApuntados.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblSociosApuntados;
	}
	private JPanel getPnApuntar() {
		if (pnApuntar == null) {
			pnApuntar = new JPanel();
			pnApuntar.setBackground(new Color(255, 255, 255));
			pnApuntar.setLayout(new GridLayout(0, 4, 0, 0));
			pnApuntar.add(getLblApuntar());
			pnApuntar.add(getTxtNombre());
			pnApuntar.add(getBtnApuntar());
			pnApuntar.add(getBtnFinalizarA());
		}
		return pnApuntar;
	}
	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}
	private JButton getBtnApuntar() {
		if (btnApuntar == null) {
			btnApuntar = new JButton("Apuntar");
			btnApuntar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					apuntarSocio();
					mostrarNumeroSocios();
				}
			});
			btnApuntar.setBackground(new Color(0, 128, 0));
			btnApuntar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btnApuntar;
	}
	protected void apuntarSocio() {
		int x =Integer.parseInt(getTxtPlazasLibres().getText()) ;
		if (x-1 > 0) {
			getTxtPlazasLibres().setText(String.valueOf(x-1));
		}else {
			getTxtPlazasLibres().setText(String.valueOf(0));
			getBtnApuntar().setEnabled(false);
		}
	}

	private JLabel getLblApuntar() {
		if (lblApuntar == null) {
			lblApuntar = new JLabel("Introducir ID para apuntar al socio:");
			lblApuntar.setBackground(new Color(255, 255, 255));
			lblApuntar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblApuntar;
	}
	private JPanel getPnLista() {
		if (pnLista == null) {
			pnLista = new JPanel();
			pnLista.setLayout(new GridLayout(1, 0, 0, 0));
			
		}
		return pnLista;
	}

	private JPanel getPnExplicacion() {
		if (pnExplicacion == null) {
			pnExplicacion = new JPanel();
			pnExplicacion.add(getLblPasarLista());
		}
		return pnExplicacion;
	}
	
	private JLabel getLblPasarLista() {
		if (lblPasarLista == null) {
			lblPasarLista = new JLabel("Pasar Lista de asistentes a la actividad");
			lblPasarLista.setFont(new Font("Arial", Font.PLAIN, 17));
		}
		return lblPasarLista;
	}
	
	private JButton getBtnFinalizarR() {
		if (btnFinalizarR == null) {
			btnFinalizarR = new JButton("Finalizar");
			btnFinalizarR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelOpciones();
					getBtnRegistrarAsistencia().setEnabled(false);
					getCbActividad().setEnabled(false);
				}
			});
			btnFinalizarR.setBackground(new Color(0, 139, 139));
		}
		return btnFinalizarR;
	}

	private JButton getBtnFinalizarA() {
		if (btnFinalizarA == null) {
			btnFinalizarA = new JButton("Finalizar");
			btnFinalizarA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelOpciones();
					getBtnApuntarSocios().setEnabled(false);
					getCbActividad().setEnabled(false);
				}
			});
			btnFinalizarA.setBackground(new Color(0, 206, 209));
			btnFinalizarA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btnFinalizarA;
	}
	private JButton getBtnFinalizarL() {
		if (btnFinalizarL == null) {
			btnFinalizarL = new JButton("Finalizar");
			btnFinalizarL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelOpciones();
					getBtnListaAsistencia().setEnabled(false);
					getCbActividad().setEnabled(false);
				}
			});
			btnFinalizarL.setBackground(new Color(0, 191, 255));
			btnFinalizarL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btnFinalizarL;
	}
	private JTextField getTxtPlazasLibres() {
		if (txtPlazasLibres == null) {
			txtPlazasLibres = new JTextField();
			txtPlazasLibres.setEditable(false);
			txtPlazasLibres.setHorizontalAlignment(SwingConstants.CENTER);
			txtPlazasLibres.setFont(new Font("Tahoma", Font.PLAIN, 22));
			txtPlazasLibres.setColumns(10);
		}
		return txtPlazasLibres;
	}
	private JTextField getTxtApuntados() {
		if (txtApuntados == null) {
			txtApuntados = new JTextField();
			txtApuntados.setEditable(false);
			txtApuntados.setHorizontalAlignment(SwingConstants.CENTER);
			txtApuntados.setFont(new Font("Tahoma", Font.PLAIN, 22));
			txtApuntados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarNumeroSocios();
				}
			});
			txtApuntados.setColumns(10);
		}
		return txtApuntados;
	}

	protected void mostrarNumeroSocios() {
		int x =Integer.parseInt(getTxtPlazasLibres().getText()) ;
		int y = getListaSociosAsistencia().size();
		getTxtApuntados().setText(String.valueOf(x+y));
	}
}
