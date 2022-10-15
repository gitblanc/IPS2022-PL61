package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logic.Actividad;
import logic.Socio;

import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Dimension;

public class VentanaSocio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList<String> listaHorario;
	private DefaultListModel<String> modelHorario;
	private JPanel pnContenidos;
	private JPanel pnHorario;
	private JPanel pnInicioSesionCorrecto;
	private JPanel pn_Dia;
	private JPanel pn_botones;
	private JLabel Lbl_Hoy;
	private JLabel lbl_Dia;
	private JButton btAnterior;
	private JButton btSiguiente;
	private JPanel pnUsuario;
	private JButton bt_MisActividades;
	private JPanel panel_boton_atras;
	private JButton bt_volverHorario;
	private JPanel pn_SusActividades;
	private JLabel lbl_TusActividades;
	private JLabel lblNombreUsuario;
	private JLabel lbl_Hola;
	private JPanel pn_IniciarSesion;
	private JPanel pn_mensajeBienvenida;
	private JPanel pn_IniciarSesionUsuario;
	private JLabel lbl_Bienvenida;
	private JPanel pn_Botones_Atras_Siguiente;
	private JButton bt_Atras_2;
	private JButton bt_Siguiente_2;
	private JPanel pn_Correo;
	private JPanel pn_Contraseña;
	private JPanel panel_relleno;
	private JPanel panel_relleno2;
	private JPanel panel_relleno3;
	private JLabel lbl_Correo;
	private JTextField txf_Correo;
	private JLabel lbl_Contraseña;
	private JPasswordField pw_contraseña;
	


	/**
	 * Create the frame.
	 */
	public VentanaSocio() {
		setTitle("¡Bienvenido!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnContenidos(), BorderLayout.CENTER);
		actualizarHorario();
	}
	
	private String un_dia_mas() {
		String[] linea = getLbl_Dia().getText().split("/");
		int dia = Integer.parseInt(linea[0]);
		int mes = Integer.parseInt(linea[1]);
		int año = Integer.parseInt(linea[2]);
		
		if(dia >= 1 && dia < 30) {
			dia = dia +1;
		} else if(dia == 30 && mes < 12) {
			mes = mes +1;
			dia = 1;
		} else {
			año = año +1;
			mes = 1;
			dia = 1;
		}
		
		return dia + "/" + mes + "/" + año;
	
	}
	
	private String un_dia_menos() {
		String[] linea = getLbl_Dia().getText().split("/");
		int dia = Integer.parseInt(linea[0]);
		int mes = Integer.parseInt(linea[1]);
		int año = Integer.parseInt(linea[2]);
		
		if(dia > 1 && dia <= 30) {
			dia = dia -1;
		} else if(dia == 1 && mes < 12) {
			mes = mes -1;
			dia = 30;
		} else {
			año = año -1;
			mes = 12;
			dia = 30;
		}
		
		return dia + "/" + mes + "/" + año;
	
	}
	
	private String fecha() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf.format(LocalDateTime.now());
	}
	
	
	private void actualizarHorario() {
		List<String> listaActividades = Actividad.listarActividades();
		((DefaultListModel<String>) modelHorario).removeAllElements();
		for(int i = 0; i < listaActividades.size(); i++) {
			if(Actividad.comprobarDia(getLbl_Dia().getText())) {
				((DefaultListModel<String>) modelHorario).addElement(listaActividades.get(i));
			}
			
		}
	}
	private JPanel getPnContenidos() {
		if (pnContenidos == null) {
			pnContenidos = new JPanel();
			pnContenidos.setBackground(new Color(255, 255, 255));
			pnContenidos.setLayout(new CardLayout(0, 0));
			pnContenidos.add(getPnHorario(), "pn_Horario");
			pnContenidos.add(getPnInicioSesionCorrecto(), "pn_InicioSesionCorrecto");
			pnContenidos.add(getPn_IniciarSesion(), "pn_InicioSesion");
		}
		return pnContenidos;
	}
	private JPanel getPnHorario() {
		if (pnHorario == null) {
			pnHorario = new JPanel();
			pnHorario.setBackground(new Color(255, 255, 255));
			pnHorario.setLayout(new BorderLayout(0, 0));
			pnHorario.add(getPn_Dia(), BorderLayout.NORTH);
			pnHorario.add(getPn_botones(), BorderLayout.SOUTH);
			pnHorario.add(getListaHorario(), BorderLayout.CENTER);
			pnHorario.add(getPnUsuario(), BorderLayout.EAST);
		}
		return pnHorario;
	}
	private JPanel getPnInicioSesionCorrecto() {
		if (pnInicioSesionCorrecto == null) {
			pnInicioSesionCorrecto = new JPanel();
			pnInicioSesionCorrecto.setBackground(new Color(255, 255, 255));
			pnInicioSesionCorrecto.setLayout(new BorderLayout(0, 0));
			pnInicioSesionCorrecto.add(getPanel_boton_atras(), BorderLayout.SOUTH);
			pnInicioSesionCorrecto.add(getPn_SusActividades(), BorderLayout.NORTH);
		}
		return pnInicioSesionCorrecto;
	}
	private JPanel getPn_Dia() {
		if (pn_Dia == null) {
			pn_Dia = new JPanel();
			pn_Dia.setBackground(new Color(152, 251, 152));
			pn_Dia.add(getLbl_Hoy());
			pn_Dia.add(getLbl_Dia());
		}
		return pn_Dia;
	}
	private JPanel getPn_botones() {
		if (pn_botones == null) {
			pn_botones = new JPanel();
			pn_botones.setBackground(new Color(255, 255, 255));
			pn_botones.add(getBtAnterior());
			pn_botones.add(getBtSiguiente());
		}
		return pn_botones;
	}
	private JList<String> getListaHorario() {
		if (listaHorario == null) {
			listaHorario = new JList<String>();
			listaHorario.setBorder(new LineBorder(new Color(0, 0, 0)));
			modelHorario = new DefaultListModel<String>();
			listaHorario.setModel(modelHorario);
			listaHorario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			actualizarHorario();
			
		}
		return listaHorario;
	}
	private JLabel getLbl_Hoy() {
		if (Lbl_Hoy == null) {
			Lbl_Hoy = new JLabel("HOY");
			Lbl_Hoy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return Lbl_Hoy;
	}
	private JLabel getLbl_Dia() {
		if (lbl_Dia == null) {
			lbl_Dia = new JLabel((String) null);
			lbl_Dia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbl_Dia.setText(fecha());
		}
		return lbl_Dia;
	}
	private JButton getBtAnterior() {
		if (btAnterior == null) {
			btAnterior = new JButton("Anterior día");
			btAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLbl_Dia().setText(un_dia_menos());
					actualizarHorario();
				}
			});
		}
		return btAnterior;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente día");
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLbl_Dia().setText(un_dia_mas());
					actualizarHorario();
				}
			});
		}
		return btSiguiente;
	}
	private JPanel getPnUsuario() {
		if (pnUsuario == null) {
			pnUsuario = new JPanel();
			pnUsuario.setBackground(new Color(255, 255, 255));
			pnUsuario.setLayout(new GridLayout(0, 1, 0, 0));
			pnUsuario.add(getBt_MisActividades());
		}
		return pnUsuario;
	}
	private JButton getBt_MisActividades() {
		if (bt_MisActividades == null) {
			bt_MisActividades = new JButton("Mis actividades");
			bt_MisActividades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarInicioSesion();
				}
			});
			bt_MisActividades.setToolTipText("Pulse aquí para ver sus actividades próximas");
			bt_MisActividades.setFont(new Font("Tahoma", Font.PLAIN, 12));
			bt_MisActividades.setForeground(new Color(0, 0, 0));
			bt_MisActividades.setBackground(new Color(220, 220, 220));
		}
		return bt_MisActividades;
	}
	
	private void mostrarInicioSesion() {
		((CardLayout) getPnContenidos().getLayout()).show(pnContenidos, "pn_InicioSesion");
		contentPane.getRootPane().setDefaultButton(bt_MisActividades);
	}
	
	private void mostrarInicioSesionCorrecto() {
		((CardLayout) getPnContenidos().getLayout()).show(pnContenidos, "pn_InicioSesionCorrecto");
		contentPane.getRootPane().setDefaultButton(bt_Siguiente_2);
	}
	
	private void mostrarHorario() {
		((CardLayout) getPnContenidos().getLayout()).show(pnContenidos, "pn_Horario");
		contentPane.getRootPane().setDefaultButton(bt_volverHorario);
	}
	
	
	private JPanel getPanel_boton_atras() {
		if (panel_boton_atras == null) {
			panel_boton_atras = new JPanel();
			panel_boton_atras.setBackground(new Color(255, 255, 255));
			panel_boton_atras.add(getBt_volverHorario());
		}
		return panel_boton_atras;
	}
	private JButton getBt_volverHorario() {
		if (bt_volverHorario == null) {
			bt_volverHorario = new JButton("Atrás");
			bt_volverHorario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarHorario();
				}
			});
			bt_volverHorario.setForeground(new Color(255, 255, 255));
			bt_volverHorario.setFont(new Font("Tahoma", Font.PLAIN, 12));
			bt_volverHorario.setBackground(new Color(255, 0, 0));
		}
		return bt_volverHorario;
	}
	private JPanel getPn_SusActividades() {
		if (pn_SusActividades == null) {
			pn_SusActividades = new JPanel();
			pn_SusActividades.setBackground(new Color(152, 251, 152));
			pn_SusActividades.add(getLbl_Hola());
			pn_SusActividades.add(getLblNombreUsuario());
			pn_SusActividades.add(getLbl_TusActividades());
		}
		return pn_SusActividades;
	}
	private JLabel getLbl_TusActividades() {
		if (lbl_TusActividades == null) {
			lbl_TusActividades = new JLabel("tus actividades son:");
			lbl_TusActividades.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl_TusActividades;
	}
	private JLabel getLblNombreUsuario() {
		if (lblNombreUsuario == null) {
			lblNombreUsuario = new JLabel("");
			lblNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblNombreUsuario;
	}
	private JLabel getLbl_Hola() {
		if (lbl_Hola == null) {
			lbl_Hola = new JLabel("¡Hola!");
			lbl_Hola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl_Hola;
	}
	private JPanel getPn_IniciarSesion() {
		if (pn_IniciarSesion == null) {
			pn_IniciarSesion = new JPanel();
			pn_IniciarSesion.setBackground(new Color(255, 255, 255));
			pn_IniciarSesion.setLayout(new BorderLayout(0, 0));
			pn_IniciarSesion.add(getPn_mensajeBienvenida(), BorderLayout.NORTH);
			pn_IniciarSesion.add(getPn_IniciarSesionUsuario(), BorderLayout.CENTER);
			pn_IniciarSesion.add(getPn_Botones_Atras_Siguiente(), BorderLayout.SOUTH);
		}
		return pn_IniciarSesion;
	}
	private JPanel getPn_mensajeBienvenida() {
		if (pn_mensajeBienvenida == null) {
			pn_mensajeBienvenida = new JPanel();
			pn_mensajeBienvenida.setBackground(new Color(255, 255, 255));
			pn_mensajeBienvenida.add(getLbl_Bienvenida());
		}
		return pn_mensajeBienvenida;
	}
	private JPanel getPn_IniciarSesionUsuario() {
		if (pn_IniciarSesionUsuario == null) {
			pn_IniciarSesionUsuario = new JPanel();
			pn_IniciarSesionUsuario.setBackground(new Color(255, 255, 255));
			pn_IniciarSesionUsuario.setLayout(new GridLayout(6, 1, 0, 0));
			pn_IniciarSesionUsuario.add(getPanel_relleno());
			pn_IniciarSesionUsuario.add(getPn_Correo());
			pn_IniciarSesionUsuario.add(getPn_Contraseña());
			pn_IniciarSesionUsuario.add(getPanel_relleno2());
			pn_IniciarSesionUsuario.add(getPanel_relleno3());
		}
		return pn_IniciarSesionUsuario;
	}
	private JLabel getLbl_Bienvenida() {
		if (lbl_Bienvenida == null) {
			lbl_Bienvenida = new JLabel("¡Bienvenido! Introduzca sus datos personales:");
			lbl_Bienvenida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		}
		return lbl_Bienvenida;
	}
	private JPanel getPn_Botones_Atras_Siguiente() {
		if (pn_Botones_Atras_Siguiente == null) {
			pn_Botones_Atras_Siguiente = new JPanel();
			pn_Botones_Atras_Siguiente.setBackground(Color.WHITE);
			pn_Botones_Atras_Siguiente.add(getBt_Atras_2());
			pn_Botones_Atras_Siguiente.add(getBt_Siguiente_2());
		}
		return pn_Botones_Atras_Siguiente;
	}
	private JButton getBt_Atras_2() {
		if (bt_Atras_2 == null) {
			bt_Atras_2 = new JButton("Atrás");
			bt_Atras_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarHorario();
				}
			});
			bt_Atras_2.setForeground(Color.WHITE);
			bt_Atras_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			bt_Atras_2.setBackground(Color.RED);
		}
		return bt_Atras_2;
	}
	private JButton getBt_Siguiente_2() {
		if (bt_Siguiente_2 == null) {
			bt_Siguiente_2 = new JButton("Siguiente");
			bt_Siguiente_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarInicioSesionCorrecto();
					getLblNombreUsuario().setText(getName());
				}
			});
			bt_Siguiente_2.setForeground(Color.WHITE);
			bt_Siguiente_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			bt_Siguiente_2.setBackground(new Color(34, 139, 34));
		}
		return bt_Siguiente_2;
	}
	private JPanel getPn_Correo() {
		if (pn_Correo == null) {
			pn_Correo = new JPanel();
			pn_Correo.setBackground(new Color(255, 255, 255));
			pn_Correo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pn_Correo.add(getLbl_Correo());
			pn_Correo.add(getTxf_Correo());
		}
		return pn_Correo;
	}
	private JPanel getPn_Contraseña() {
		if (pn_Contraseña == null) {
			pn_Contraseña = new JPanel();
			pn_Contraseña.setPreferredSize(new Dimension(15, 14));
			pn_Contraseña.setBackground(new Color(255, 255, 255));
			pn_Contraseña.add(getLbl_Contraseña());
			pn_Contraseña.add(getPw_contraseña());
		}
		return pn_Contraseña;
	}
	private JPanel getPanel_relleno() {
		if (panel_relleno == null) {
			panel_relleno = new JPanel();
			panel_relleno.setBackground(new Color(255, 255, 255));
		}
		return panel_relleno;
	}
	private JPanel getPanel_relleno2() {
		if (panel_relleno2 == null) {
			panel_relleno2 = new JPanel();
			panel_relleno2.setBackground(new Color(255, 255, 255));
		}
		return panel_relleno2;
	}
	private JPanel getPanel_relleno3() {
		if (panel_relleno3 == null) {
			panel_relleno3 = new JPanel();
			panel_relleno3.setBackground(new Color(255, 255, 255));
		}
		return panel_relleno3;
	}
	private JLabel getLbl_Correo() {
		if (lbl_Correo == null) {
			lbl_Correo = new JLabel("Correo electrónico: ");
			lbl_Correo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbl_Correo;
	}
	private JTextField getTxf_Correo() {
		if (txf_Correo == null) {
			txf_Correo = new JTextField();
			txf_Correo.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txf_Correo.setColumns(10);
		}
		return txf_Correo;
	}
	private JLabel getLbl_Contraseña() {
		if (lbl_Contraseña == null) {
			lbl_Contraseña = new JLabel("Contraseña: ");
			lbl_Contraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbl_Contraseña;
	}
	private JPasswordField getPw_contraseña() {
		if (pw_contraseña == null) {
			pw_contraseña = new JPasswordField();
			pw_contraseña.setColumns(10);
			pw_contraseña.setMinimumSize(new Dimension(14, 22));
			pw_contraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
			pw_contraseña.setBounds(20,100,80,30);
		}
		return pw_contraseña;
	}
}
