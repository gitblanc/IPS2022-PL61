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
	private JPanel pn_fecha_hoy;
	private JLabel Lbl_Hoy;
	private JLabel lbl_Dia;
	private JPanel pn_actividades;
	private JPanel pn_filtrar;
	private JLabel lbl_Elegir_que_filtrar;
	private JButton btActividades;
	private JList<String> list_mis_actividades;
	private DefaultListModel<String> modelMisActividades;
	private JPanel pn_actividades_centro;
	private JPanel pn_todo_centro_FRASE;
	private JLabel lbl_todo_centro;
	private JPanel pn_todo_centro;
	private JPanel pn_filtro;
	private JPanel panel;
	private JButton bt_dia_anterior;
	private JButton bt_dia_siguiente;
	private JPanel pn_Añadir_Centro;
	private JButton btnNewButton;
	private JList<String> listActividadesCentro;
	private DefaultListModel<String> modelHorario;
	private JPanel pn_elegir_que_centro;
	private JLabel lbl_filtro_centro;
	private JButton bt_actividadea_centro;
	private JPanel pn_elegir_que_dia_centro;
	private JLabel lblNewLabel;
	private JComboBox<String> cb_dias_mas_proximos;
	private JButton bt_Cancelar;

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
			actualizarListaMisActividades();
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
		}
		return cb_usuarios;
	}
	private JPanel getPn_actividades_por_fecha() {
		if (pn_actividades_por_fecha == null) {
			pn_actividades_por_fecha = new JPanel();
			pn_actividades_por_fecha.setBackground(new Color(255, 255, 255));
			pn_actividades_por_fecha.setLayout(new BorderLayout(0, 0));
			pn_actividades_por_fecha.add(getPn_fecha_hoy(), BorderLayout.NORTH);
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
					actualizarHorario();
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
					eliminarActividad();
					actualizarBD();
				}
			});
			bt_Eliminar.setForeground(new Color(255, 255, 255));
			bt_Eliminar.setBackground(new Color(255, 0, 0));
		}
		return bt_Eliminar;
	}
	
	private void eliminarActividad() {
		List<String> elegidoEliminar = getList_mis_actividades().getSelectedValuesList();
		for(int i = 0; i < elegidoEliminar.size(); i++) {
			modelMisActividades.removeElement(elegidoEliminar.get(i));
		}
		getList_mis_actividades().setModel(modelMisActividades);
		
	}
	
	private void actualizarBD() {
		//TODO
	}
	private JPanel getPn_fecha_hoy() {
		if (pn_fecha_hoy == null) {
			pn_fecha_hoy = new JPanel();
			pn_fecha_hoy.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			pn_fecha_hoy.setBackground(new Color(152, 251, 152));
			pn_fecha_hoy.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pn_fecha_hoy.add(getLbl_Hoy());
			pn_fecha_hoy.add(getLbl_Dia());
		}
		return pn_fecha_hoy;
	}
	private JLabel getLbl_Hoy() {
		if (Lbl_Hoy == null) {
			Lbl_Hoy = new JLabel("HOY");
			Lbl_Hoy.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return Lbl_Hoy;
	}
	private JLabel getLbl_Dia() {
		if (lbl_Dia == null) {
			lbl_Dia = new JLabel((String) null);
			lbl_Dia.setText(fecha());
			lbl_Dia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return lbl_Dia;
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
	
	private JPanel getPn_actividades() {
		if (pn_actividades == null) {
			pn_actividades = new JPanel();
			pn_actividades.setBackground(new Color(255, 255, 255));
			pn_actividades.setLayout(new BorderLayout(0, 0));
			pn_actividades.add(getPn_filtrar(), BorderLayout.NORTH);
			pn_actividades.add(getList_mis_actividades(), BorderLayout.CENTER);
			pn_actividades.add(getPanel(), BorderLayout.SOUTH);
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
	private JList<String> getList_mis_actividades() {
		if (list_mis_actividades == null) {
			list_mis_actividades = new JList<String>();
			modelMisActividades = new DefaultListModel<String>();
			list_mis_actividades.setModel(modelMisActividades);
			list_mis_actividades.setBorder(new LineBorder(new Color(0, 0, 0)));
			actualizarHorarioPrincipio();
			actualizarListaMisActividades();
		}
		return list_mis_actividades;
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
		}
		return pn_todo_centro_FRASE;
	}
	private JLabel getLbl_todo_centro() {
		if (lbl_todo_centro == null) {
			lbl_todo_centro = new JLabel("TODO DEL CENTRO:");
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
			pn_todo_centro.add(getListActividadesCentro(), BorderLayout.CENTER);
		}
		return pn_todo_centro;
	}
	private JPanel getPn_filtro() {
		if (pn_filtro == null) {
			pn_filtro = new JPanel();
			pn_filtro.setBackground(new Color(255, 255, 255));
			pn_filtro.setLayout(new GridLayout(0, 1, 0, 0));
			pn_filtro.add(getPn_elegir_que_centro());
			pn_filtro.add(getPn_elegir_que_dia_centro());
		}
		return pn_filtro;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.add(getBt_dia_anterior());
			panel.add(getBt_dia_siguiente());
		}
		return panel;
	}
	private JButton getBt_dia_anterior() {
		if (bt_dia_anterior == null) {
			bt_dia_anterior = new JButton("Día anterior");
			bt_dia_anterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLbl_Dia().setText(un_dia_menos());
					getLbl_Hoy().setVisible(false);
				}
			});
		}
		return bt_dia_anterior;
	}
	private JButton getBt_dia_siguiente() {
		if (bt_dia_siguiente == null) {
			bt_dia_siguiente = new JButton("Día siguiente");
			bt_dia_siguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLbl_Dia().setText(un_dia_mas());
					getLbl_Hoy().setVisible(false);
				}
			});
		}
		return bt_dia_siguiente;
	}
	private JPanel getPn_Añadir_Centro() {
		if (pn_Añadir_Centro == null) {
			pn_Añadir_Centro = new JPanel();
			pn_Añadir_Centro.setBackground(new Color(255, 255, 255));
			pn_Añadir_Centro.add(getBtnNewButton());
			pn_Añadir_Centro.add(getBt_Cancelar());
		}
		return pn_Añadir_Centro;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Añadir");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirActividadAUsuario();
					actualizarListaMisActividades();
				}
			});
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(0, 128, 0));
		}
		return btnNewButton;
	}
//	protected void añadirActividadASocio() {
//		String correo_persona = getCb_usuarios().getSelectedItem().toString();
//		int actividad_seleccionada_numero = getListActividadesCentro().getSelectedIndex();
//		String[] actividad_seleccionada_id = Actividad.rellenarArrayConIds();
//		String id = actividad_seleccionada_id[actividad_seleccionada_numero];
//		socio.añadirActividadASocio(correo_persona, id);
//		
//	}
	private JList<String> getListActividadesCentro() {
		if (listActividadesCentro == null) {
			listActividadesCentro = new JList<String>();
			listActividadesCentro.setBorder(new LineBorder(new Color(0, 0, 0)));
			modelHorario = new DefaultListModel<String>();
			listActividadesCentro.setModel(modelHorario);
			listActividadesCentro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listActividadesCentro;
	}
	
	private void actualizarHorario() {
		List<String> listaActividades = Actividad.listarActividades();
		((DefaultListModel<String>) modelHorario).removeAllElements();
		for(int i = 0; i < listaActividades.size(); i++) {
			((DefaultListModel<String>) modelHorario).addElement(listaActividades.get(i));
			
		}
	}
	
	private void actualizarHorarioPrincipio() {
		List<String> listaActividades = Actividad.listarActividades();
		for(int i = 0; i < listaActividades.size(); i++) {
			((DefaultListModel<String>) modelHorario).addElement(listaActividades.get(i));
			
		}
	}
	
	
	private void añadirActividadAUsuario() {
		List<String> elegidoAñadir = getListActividadesCentro().getSelectedValuesList();
		for(int i = 0; i < elegidoAñadir.size(); i++) {
			modelMisActividades.addElement(elegidoAñadir.get(i));
		}
		
	}
	private JPanel getPn_elegir_que_centro() {
		if (pn_elegir_que_centro == null) {
			pn_elegir_que_centro = new JPanel();
			pn_elegir_que_centro.setBackground(new Color(255, 255, 255));
			pn_elegir_que_centro.add(getLbl_filtro_centro());
			pn_elegir_que_centro.add(getBt_actividadea_centro());
		}
		return pn_elegir_que_centro;
	}
	private JLabel getLbl_filtro_centro() {
		if (lbl_filtro_centro == null) {
			lbl_filtro_centro = new JLabel("Escoge qué quiere añadir: ");
		}
		return lbl_filtro_centro;
	}
	private JButton getBt_actividadea_centro() {
		if (bt_actividadea_centro == null) {
			bt_actividadea_centro = new JButton("Actividad");
			bt_actividadea_centro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarHorario();
				}
			});
		}
		return bt_actividadea_centro;
	}
	private JPanel getPn_elegir_que_dia_centro() {
		if (pn_elegir_que_dia_centro == null) {
			pn_elegir_que_dia_centro = new JPanel();
			pn_elegir_que_dia_centro.setBackground(new Color(255, 255, 255));
			pn_elegir_que_dia_centro.add(getLblNewLabel());
			pn_elegir_que_dia_centro.add(getCb_dias_mas_proximos());
		}
		return pn_elegir_que_dia_centro;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Escoge el día: ");
		}
		return lblNewLabel;
	}
	private JComboBox<String> getCb_dias_mas_proximos() {
		if (cb_dias_mas_proximos == null) {
			cb_dias_mas_proximos = new JComboBox<String>();
			cb_dias_mas_proximos.setModel(new DefaultComboBoxModel<String>(proximosDias()));
		}
		return cb_dias_mas_proximos;
	}
	
	private String[] proximosDias() {
		String[] dias = new String[15];
		for(int i = 0; i < 15; i++) {
			dias[i] = un_dia_mas();
		}
		return dias;
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
}
