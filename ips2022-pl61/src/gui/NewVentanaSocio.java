package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logic.Actividad;
import logic.Socio;

public class NewVentanaSocio extends JFrame {

	/**
	 * 
	 */
	private Socio socio = new Socio()
;	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pn_contenidos;
	private JPanel pn_Mis_Actividades;
	private JPanel pn_quien_soy;
	private JPanel pn_MIsActividades;
	private JLabel lbl_bienvenida;
	private JComboBox<String> cb_usuarios;
	private JPanel pn_actividades_por_fecha;
	private JPanel pn_botones_acciones;
	private JButton bt_Añadir;
	private JButton bt_Eliminar;
	private JPanel pn_actividades;
	private JPanel pn_filtrar;
	private JLabel lbl_Elegir_que_filtrar;
	private JButton btActividades;
	private JPanel pn_actividades_centro;
	private JPanel pn_todo_centro_FRASE;
	private JLabel lbl_todo_centro;
	private JPanel pn_todo_centro;
	private JPanel pn_filtro;
	private JPanel pn_Añadir_Centro;
	private JButton btnNewButton;
	private JButton bt_Cancelar;
	private JList<String> list_misActividades;
	private JPanel pn_lista_con_botones;
	private JPanel pn_dia_anterior_siguiente;
	private JButton bt_anterior;
	private JButton bt_siguiente;
	private JLabel lbl_Hoy;
	private JLabel lbl_Fecha;
	private JList<String> lista_Todas_Las_Actividades_Centro;
	private DefaultListModel<String> modelMisActividades = new DefaultListModel<String>();
	private DefaultListModel<String> modelTodasLasActividadesCentro = new DefaultListModel<String>();

	/**
	 * Create the frame.
	 */
	public NewVentanaSocio() {
		setTitle("Ventana del socio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 521);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPn_contenidos(), BorderLayout.CENTER);
		mostrarHorarioCentro();
		
	}
	private JPanel getPn_contenidos() {
		if (pn_contenidos == null) {
			pn_contenidos = new JPanel();
			pn_contenidos.setBackground(new Color(255, 255, 255));
			pn_contenidos.setLayout(new CardLayout(0, 0));
			pn_contenidos.add(getPn_Mis_Actividades(), "panel_1");
			pn_contenidos.add(getPn_actividades_centro(), "panel_2");
		}
		return pn_contenidos;
	}
	private JPanel getPn_Mis_Actividades() {
		if (pn_Mis_Actividades == null) {
			pn_Mis_Actividades = new JPanel();
			pn_Mis_Actividades.setBorder(new LineBorder(new Color(0, 0, 0)));
			pn_Mis_Actividades.setBackground(new Color(255, 255, 255));
			pn_Mis_Actividades.setLayout(new BorderLayout(0, 0));
			pn_Mis_Actividades.add(getPn_quien_soy(), BorderLayout.NORTH);
			pn_Mis_Actividades.add(getPn_MIsActividades(), BorderLayout.CENTER);
		}
		return pn_Mis_Actividades;
	}
	private JPanel getPn_quien_soy() {
		if (pn_quien_soy == null) {
			pn_quien_soy = new JPanel();
			pn_quien_soy.setBackground(new Color(255, 255, 255));
			pn_quien_soy.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pn_quien_soy.add(getLbl_bienvenida());
			pn_quien_soy.add(getCb_usuarios());
		}
		return pn_quien_soy;
	}
	private JPanel getPn_MIsActividades() {
		if (pn_MIsActividades == null) {
			pn_MIsActividades = new JPanel();
			pn_MIsActividades.setBackground(new Color(255, 255, 255));
			pn_MIsActividades.setLayout(new BorderLayout(0, 0));
			pn_MIsActividades.add(getPn_actividades_por_fecha(), BorderLayout.CENTER);
			pn_MIsActividades.add(getPn_botones_acciones(), BorderLayout.EAST);
		}
		return pn_MIsActividades;
	}
	private JLabel getLbl_bienvenida() {
		if (lbl_bienvenida == null) {
			lbl_bienvenida = new JLabel("¡Hola! Indiquénos quién es a través del correo:");
			lbl_bienvenida.setBackground(new Color(255, 255, 255));
		}
		return lbl_bienvenida;
	}
	private JComboBox<String> getCb_usuarios() {
		if (cb_usuarios == null) {
			cb_usuarios = new JComboBox<String>();
			cb_usuarios.setModel(new DefaultComboBoxModel<String>(Socio.listarSociosPorCorreo()));
			actualizarListaMisActividades();
		}
		return cb_usuarios;
	}
	private JPanel getPn_actividades_por_fecha() {
		if (pn_actividades_por_fecha == null) {
			pn_actividades_por_fecha = new JPanel();
			pn_actividades_por_fecha.setBackground(new Color(255, 255, 255));
			pn_actividades_por_fecha.setLayout(new BorderLayout(0, 0));
			pn_actividades_por_fecha.add(getPn_actividades(), BorderLayout.CENTER);
		}
		return pn_actividades_por_fecha;
	}
	private JPanel getPn_botones_acciones() {
		if (pn_botones_acciones == null) {
			pn_botones_acciones = new JPanel();
			pn_botones_acciones.setLayout(new GridLayout(0, 1, 0, 0));
			pn_botones_acciones.add(getBt_Añadir());
			pn_botones_acciones.add(getBt_Eliminar());
		}
		return pn_botones_acciones;
	}
	private JButton getBt_Añadir() {
		if (bt_Añadir == null) {
			bt_Añadir = new JButton("Añadir");
			bt_Añadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) getPn_contenidos().getLayout()).show(getPn_contenidos(), "panel_2");
					contentPane.getRootPane().setDefaultButton(getBt_Añadir());
					mostrarHorarioCentro();
				}
			});
			bt_Añadir.setForeground(new Color(255, 255, 255));
			bt_Añadir.setBackground(new Color(0, 128, 0));
		}
		return bt_Añadir;
	}
	private JButton getBt_Eliminar() {
		if (bt_Eliminar == null) {
			bt_Eliminar = new JButton("Eliminar");
			bt_Eliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String correo = getCb_usuarios().getSelectedItem().toString();
					String id_actividad = getIdActividad(getList_misActividades().getSelectedValue());
					eliminarActividad(correo, id_actividad);
				}
			});
			bt_Eliminar.setForeground(new Color(255, 255, 255));
			bt_Eliminar.setBackground(new Color(255, 0, 0));
		}
		return bt_Eliminar;
	}
	
	private String un_dia_mas() {
		String[] linea = getLbl_Fecha().getText().split("/");
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
		String[] linea = getLbl_Fecha().getText().split("/");
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
	
	private JPanel getPn_actividades() {
		if (pn_actividades == null) {
			pn_actividades = new JPanel();
			pn_actividades.setBackground(new Color(255, 255, 255));
			pn_actividades.setLayout(new BorderLayout(0, 0));
			pn_actividades.add(getPn_filtrar(), BorderLayout.NORTH);
			pn_actividades.add(getList_misActividades(), BorderLayout.CENTER);
		}
		return pn_actividades;
	}
	private JPanel getPn_filtrar() {
		if (pn_filtrar == null) {
			pn_filtrar = new JPanel();
			pn_filtrar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			pn_filtrar.setBackground(new Color(152, 251, 152));
			pn_filtrar.add(getLabel_1());
			pn_filtrar.add(getBtActividades());
		}
		return pn_filtrar;
	}
	private JLabel getLabel_1() {
		if (lbl_Elegir_que_filtrar == null) {
			lbl_Elegir_que_filtrar = new JLabel("Escoja que quiere mirar: ");
		}
		return lbl_Elegir_que_filtrar;
	}
	private JButton getBtActividades() {
		if (btActividades == null) {
			btActividades = new JButton("Actividades");
			btActividades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarListaMisActividades();
				}
			});
		}
		return btActividades;
	}
	
	private void actualizarListaMisActividades() {
		String correo = cb_usuarios.getSelectedItem().toString();
		List<String> listaMisActividades = socio.findActivitiesBySocio(correo);
		((DefaultListModel<String>) modelMisActividades).removeAllElements();
		for(int i = 0; i < listaMisActividades.size(); i++) {
			((DefaultListModel<String>) modelMisActividades).addElement(listaMisActividades.get(i));
			
		}
		
	}
	
	
	private JPanel getPn_actividades_centro() {
		if (pn_actividades_centro == null) {
			pn_actividades_centro = new JPanel();
			pn_actividades_centro.setBorder(new LineBorder(new Color(0, 0, 0)));
			pn_actividades_centro.setBackground(new Color(255, 255, 255));
			pn_actividades_centro.setLayout(new BorderLayout(0, 0));
			pn_actividades_centro.add(getPn_todo_centro_FRASE(), BorderLayout.NORTH);
			pn_actividades_centro.add(getPn_todo_centro(), BorderLayout.CENTER);
		
		}
		return pn_actividades_centro;
	}
	private JPanel getPn_todo_centro_FRASE() {
		if (pn_todo_centro_FRASE == null) {
			pn_todo_centro_FRASE = new JPanel();
			pn_todo_centro_FRASE.setBackground(new Color(152, 251, 152));
			pn_todo_centro_FRASE.add(getLbl_todo_centro());
			pn_todo_centro_FRASE.add(getLbl_Hoy());
			pn_todo_centro_FRASE.add(getLbl_Fecha());
		}
		return pn_todo_centro_FRASE;
	}
	private JLabel getLbl_todo_centro() {
		if (lbl_todo_centro == null) {
			lbl_todo_centro = new JLabel("TODO DEL CENTRO:");
			lbl_todo_centro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lbl_todo_centro;
	}
	private JPanel getPn_todo_centro() {
		if (pn_todo_centro == null) {
			pn_todo_centro = new JPanel();
			pn_todo_centro.setBorder(new LineBorder(new Color(0, 0, 0)));
			pn_todo_centro.setBackground(new Color(255, 255, 255));
			pn_todo_centro.setLayout(new BorderLayout(0, 0));
			pn_todo_centro.add(getPn_filtro(), BorderLayout.NORTH);
			pn_todo_centro.add(getPn_Añadir_Centro(), BorderLayout.SOUTH);
			pn_todo_centro.add(getPanel_1(), BorderLayout.CENTER);
		}
		return pn_todo_centro;
	}
	private JPanel getPn_filtro() {
		if (pn_filtro == null) {
			pn_filtro = new JPanel();
			pn_filtro.setBackground(new Color(255, 255, 255));
			pn_filtro.setLayout(new GridLayout(0, 1, 0, 0));
		}
		return pn_filtro;
	}
	private JPanel getPn_Añadir_Centro() {
		if (pn_Añadir_Centro == null) {
			pn_Añadir_Centro = new JPanel();
			pn_Añadir_Centro.setBackground(new Color(255, 255, 255));
			pn_Añadir_Centro.add(getAñadirActividad());
			pn_Añadir_Centro.add(getBt_Cancelar());
		}
		return pn_Añadir_Centro;
	}
	private JButton getAñadirActividad() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Añadir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String correo = getCb_usuarios().getSelectedItem().toString();
					String actividad = getIdActividad(lista_Todas_Las_Actividades_Centro.getSelectedValue());
					añadirNuevaActividadASocio(correo, actividad);
				}
			});
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(0, 128, 0));
		}
		return btnNewButton;
	}
	
 	private JButton getBt_Cancelar() {
		if (bt_Cancelar == null) {
			bt_Cancelar = new JButton("Cancelar");
			bt_Cancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) getPn_contenidos().getLayout()).show(getPn_contenidos(), "panel_1");
					contentPane.getRootPane().setDefaultButton(bt_Cancelar);
				}
			});
			bt_Cancelar.setForeground(new Color(255, 255, 255));
			bt_Cancelar.setBackground(new Color(255, 0, 0));
		}
		return bt_Cancelar;
	}
	private JList<String> getList_misActividades() {
		if (list_misActividades == null) {
			list_misActividades = new JList<String>();
			list_misActividades.setBackground(new Color(255, 255, 255));
			list_misActividades.setBorder(new LineBorder(new Color(0, 0, 0)));
			modelMisActividades = new DefaultListModel<String>();
			list_misActividades.setModel(modelMisActividades);
			list_misActividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return list_misActividades;
	}
	private JPanel getPanel_1() {
		if (pn_lista_con_botones == null) {
			pn_lista_con_botones = new JPanel();
			pn_lista_con_botones.setBackground(new Color(255, 255, 255));
			pn_lista_con_botones.setLayout(new BorderLayout(0, 0));
			pn_lista_con_botones.add(getPanel_2(), BorderLayout.SOUTH);
			pn_lista_con_botones.add(getLista_Todas_Las_Actividades_Centro(), BorderLayout.CENTER);
		}
		return pn_lista_con_botones;
	}
	private JPanel getPanel_2() {
		if (pn_dia_anterior_siguiente == null) {
			pn_dia_anterior_siguiente = new JPanel();
			pn_dia_anterior_siguiente.setBackground(new Color(255, 255, 255));
			pn_dia_anterior_siguiente.setLayout(new GridLayout(0, 2, 0, 0));
			pn_dia_anterior_siguiente.add(getBt_anterior());
			pn_dia_anterior_siguiente.add(getBt_siguiente());
		}
		return pn_dia_anterior_siguiente;
	}
	private JButton getBt_anterior() {
		if (bt_anterior == null) {
			bt_anterior = new JButton("<--- Anterior");
			bt_anterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLbl_Fecha().setText(un_dia_menos());
					getLbl_Hoy().setText("");
					mostrarHorarioCentro();
				}
			});
		}
		return bt_anterior;
	}
	private JButton getBt_siguiente() {
		if (bt_siguiente == null) {
			bt_siguiente = new JButton("Siguiente --->");
			bt_siguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLbl_Fecha().setText(un_dia_mas());
					getLbl_Hoy().setText("");
					mostrarHorarioCentro();
					
				}
			});
		}
		return bt_siguiente;
	}
	private JLabel getLbl_Hoy() {
		if (lbl_Hoy == null) {
			lbl_Hoy = new JLabel("HOY");
			lbl_Hoy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lbl_Hoy;
	}
	private JLabel getLbl_Fecha() {
		if (lbl_Fecha == null) {
			lbl_Fecha = new JLabel("");
			lbl_Fecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbl_Fecha.setText(fecha());
		}
		return lbl_Fecha;
	}
	private JList<String> getLista_Todas_Las_Actividades_Centro() {
		if (lista_Todas_Las_Actividades_Centro == null) {
			lista_Todas_Las_Actividades_Centro = new JList<String>();
			lista_Todas_Las_Actividades_Centro.setBackground(new Color(255, 255, 255));
			lista_Todas_Las_Actividades_Centro.setBorder(new LineBorder(new Color(0, 0, 0)));
			modelTodasLasActividadesCentro = new DefaultListModel<String>();
			lista_Todas_Las_Actividades_Centro.setModel(modelTodasLasActividadesCentro);
			lista_Todas_Las_Actividades_Centro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return lista_Todas_Las_Actividades_Centro;
	}
	
	private void mostrarHorarioCentro() {
		List<String> listaActividades = Actividad.listarActividades(getLbl_Fecha().getText());
		((DefaultListModel<String>) modelTodasLasActividadesCentro).removeAllElements();
		for(int i = 0; i < listaActividades.size(); i++) {
			((DefaultListModel<String>) modelTodasLasActividadesCentro).addElement(listaActividades.get(i));
			
		}
	}
	
	private void añadirNuevaActividadASocio(String correo, String id_actividad) {
		List<String> elegidoAñadir = getLista_Todas_Las_Actividades_Centro().getSelectedValuesList();
		for(int i = 0; i < elegidoAñadir.size(); i++) {
			modelMisActividades.addElement(elegidoAñadir.get(i));
		}
		getList_misActividades().setModel(modelMisActividades);
		
		Socio.añadirActividadASocio(correo, id_actividad);
	}
	
	
	private void eliminarActividad(String correo, String id_actividad) {
		List<String> elegidoEliminar = getList_misActividades().getSelectedValuesList();
		for(int i = 0; i < elegidoEliminar.size(); i++) {
			modelMisActividades.removeElement(elegidoEliminar.get(i));
		}
		getList_misActividades().setModel(modelMisActividades);
		
		Socio.eliminarActividadSocio(correo, id_actividad);
	}
	
	private String getIdActividad(String cadena) {
		String[] valores = cadena.split(" ------ ");
		return valores[0];
	}
}
