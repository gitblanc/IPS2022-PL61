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
import java.awt.CardLayout;
import java.awt.GridLayout;

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
	private JPanel pnInicioSesion;
	private JPanel pn_Dia;
	private JPanel pn_botones;
	private JLabel Lbl_Hoy;
	private JLabel lbl_Dia;
	private JButton btAnterior;
	private JButton btSiguiente;
	private JPanel pnUsuario;
	private JButton bt_MisActividades;
	private JPanel panel;
	private JButton bt_volverHorario;
	private JPanel pn_SusActividades;
	private JLabel lbl_TusActividades;
	private JLabel blbNombreUsuario;
	private JLabel lbl_Hola;


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
			pnContenidos.add(getPnInicioSesion(), "pn_InicioSesion");
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
	private JPanel getPnInicioSesion() {
		if (pnInicioSesion == null) {
			pnInicioSesion = new JPanel();
			pnInicioSesion.setBackground(new Color(255, 255, 255));
			pnInicioSesion.setLayout(new BorderLayout(0, 0));
			pnInicioSesion.add(getPanel(), BorderLayout.SOUTH);
			pnInicioSesion.add(getPn_SusActividades(), BorderLayout.NORTH);
		}
		return pnInicioSesion;
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
	
	private void mostrarHorario() {
		((CardLayout) getPnContenidos().getLayout()).show(pnContenidos, "pn_Horario");
		contentPane.getRootPane().setDefaultButton(bt_volverHorario);
	}
	
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.add(getBt_volverHorario());
		}
		return panel;
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
			pn_SusActividades.add(getBlbNombreUsuario());
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
	private JLabel getBlbNombreUsuario() {
		if (blbNombreUsuario == null) {
			blbNombreUsuario = new JLabel("");
			blbNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return blbNombreUsuario;
	}
	private JLabel getLbl_Hola() {
		if (lbl_Hola == null) {
			lbl_Hola = new JLabel("¡Hola!");
			lbl_Hola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl_Hola;
	}
}
