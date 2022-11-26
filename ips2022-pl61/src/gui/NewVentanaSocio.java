package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logic.Actividad;
import logic.Administrador;
import logic.Alquiler;
import logic.Socio;
import javax.swing.SwingConstants;

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
	private JPanel pn_actividades_centro;
	private JPanel pn_todo_centro_FRASE;
	private JLabel lbl_todo_centro;
	private JPanel pn_todo_centro;
	private JPanel pn_Añadir_Centro;
	private JButton bt_AÑadir_Algo;
	private JButton bt_Cancelar;
	private JPanel pn_lista_con_botones;
	private JLabel lbl_Hoy;
	private JLabel lbl_Fecha;
	private DefaultListModel<String> modelMisActividades = new DefaultListModel<String>();
	private DefaultListModel<String> modelMisAlquileres = new DefaultListModel<String>();
	private DefaultListModel<String> modelTodasLasActividadesCentro = new DefaultListModel<String>();
	private JPanel pn_listas;
	private JPanel pn_miis_listas;
	private JPanel pn_lista_mis_actividades;
	private JPanel pn_lista_mis_instalaciones;
	private JPanel pn_infor_Actividades;
	private JList<String> list_misActividades;
	private JPanel pn_infor_instalaciones;
	private JLabel lbl_actividades;
	private JLabel lbl_instlaciones;
	private JList<String> list_MisInstalaciones;
	private JPanel pn_Todas_Las_Actividades;
	private JPanel pn_Tods_Las_Instalaciones;
	private JList<String> lista_Todas_Las_Actividades_Centro;
	private JPanel pn_Nombre_1;
	private JPanel pn_Nombre_2;
	private JLabel lbl_actividades_1;
	private JLabel lbl_Instalaciones;
	private JPanel pn_reserva_instalaciones;
	private JPanel pn_dia_anterior_siguiente;
	private JButton bt_anterior;
	private JButton bt_siguiente;
	private JPanel pn_escoger_instalacion;
	private JPanel pn_escoger_fecha;
	private JPanel pn_escoger_horas;
	private JLabel lnl_escoger_instalacion;
	private JComboBox<String> cb_Instalacion;
	private JLabel lbl_fecha_instalacion;
	private JTextField txtfield_fecha_instalacion;
	private JLabel lblHoras;
	private JPanel pn_Horas_instalacion;
	private JComboBox<String> comboBox_1;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBox_2;
	private JPanel pn_Boton_Añadir_Actividad;
	private JButton bt_Añadido_actividad;
	
	private Administrador admin = new Administrador();
	private JPanel pn_botones_1;
	private JPanel pn_botones_2;
	private JButton bt_eliminar_instalacion;
	private JButton bt_refrescar_alquileres;
	private JButton bt_ver_cancelados;
	private JPanel panel;
	private JButton bt_refrescar_actividades;
	private JPanel panel_1;

	/**
	 * Create the frame.
	 */
	public NewVentanaSocio() {
		setTitle("Ventana del socio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 543);
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
			pn_botones_acciones.add(getPn_botones_1());
			pn_botones_acciones.add(getPn_botones_2());
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
			bt_Eliminar = new JButton("Eliminar actividad");
			bt_Eliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String correo = getCb_usuarios().getSelectedItem().toString();
					if(seleccionActividad()) {
						String id_actividad = getIdActividad(getList_misActividades().getSelectedValue());
						eliminarActividad(correo, id_actividad);
					} 
					
				}
			});
			bt_Eliminar.setForeground(new Color(255, 255, 255));
			bt_Eliminar.setBackground(new Color(255, 0, 0));
		}
		return bt_Eliminar;
	}
	
	private boolean seleccionActividad() {
		if(getList_misActividades().getSelectedValue() != null) {
			return true;
		} 
		
		return false;
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
			pn_actividades.add(getPn_miis_listas(), BorderLayout.CENTER);
		}
		return pn_actividades;
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
			pn_todo_centro.add(getPn_Añadir_Centro(), BorderLayout.SOUTH);
			pn_todo_centro.add(getPanel_1(), BorderLayout.CENTER);
		}
		return pn_todo_centro;
	}
	private JPanel getPn_Añadir_Centro() {
		if (pn_Añadir_Centro == null) {
			pn_Añadir_Centro = new JPanel();
			pn_Añadir_Centro.setBackground(new Color(255, 255, 255));
			pn_Añadir_Centro.add(getAñadirInstalacion());
			pn_Añadir_Centro.add(getBt_Cancelar());
		}
		return pn_Añadir_Centro;
	}
	private JButton getAñadirInstalacion() {
		if (bt_AÑadir_Algo == null) {
			bt_AÑadir_Algo = new JButton("Añadir");
			bt_AÑadir_Algo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String correo = getCb_usuarios().getSelectedItem().toString();
					String instalacion = getCb_Instalacion().getSelectedItem().toString();
					String fecha = getTxtfield_fecha_instalacion().getText();
					String hora_inicio = getComboBox_1().getSelectedItem().toString();
					String hora_fin = getComboBox_2().getSelectedItem().toString();
					
					if(!AlquilerNoMasDeDosHoras(hora_inicio, hora_fin)) {
						showMEssageDialog();
					} else {
						añadirAlquiler(correo, instalacion, fecha, hora_inicio, hora_fin);
					}
					actualizarListaMisInstalaciones();
					
				}
			});
			bt_AÑadir_Algo.setForeground(new Color(255, 255, 255));
			bt_AÑadir_Algo.setBackground(new Color(0, 128, 0));
		}
		return bt_AÑadir_Algo;
	}
	
	private void showMEssageDialog() {
		JOptionPane.showMessageDialog(this, "No se puede añadir una actividad de mas de dos horas");
	}
	
	private boolean AlquilerNoMasDeDosHoras(String inicio, String final_hora) {
		String[] i = inicio.split(":");
		int value1 = Integer.parseInt(i[0]);
		
		String[] j = final_hora.split(":");
		int value2 = Integer.parseInt(j[0]);
		
		if(Math.abs(value2 - value1) > 2) {
			return false;
		}
		return true;
	}
	private void añadirAlquiler(String socio, String instalacion, String fecha, String inicio, String fin) {
		String correo = getCb_usuarios().getSelectedItem().toString();
		String id_socio = Socio.getIdSocio(correo);
		if(Alquiler.comprobarRequisitosAlquilerCorrecto(LocalDate.now(), fecha) && Alquiler.comprobarHoras(inicio, fin)) {
			if(!Alquiler.comprobarRequisitoNoTieneMasAlquileres(id_socio,fecha, inicio, fin) && !Socio.comprobarNotieneActividades(id_socio,fecha, inicio, fin)) {
				admin.crearAlquiler(id_socio, instalacion, inicio, fin, fecha);
				JOptionPane.showMessageDialog(this, "Añadido correcto");
			} else {
				JOptionPane.showMessageDialog(this, "Error: No se puede añadir el alquiler", "Error añadir alquiler", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
		}
		else {
			JOptionPane.showMessageDialog(this, "Error: No se puede añadir el alquiler", "Error añadir alquiler", JOptionPane.INFORMATION_MESSAGE);
		}
		
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
	private JPanel getPanel_1() {
		if (pn_lista_con_botones == null) {
			pn_lista_con_botones = new JPanel();
			pn_lista_con_botones.setBackground(new Color(255, 255, 255));
			pn_lista_con_botones.setLayout(new BorderLayout(0, 0));
			pn_lista_con_botones.add(getPn_listas(), BorderLayout.CENTER);
		}
		return pn_lista_con_botones;
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
	
	private void mostrarHorarioCentro() {
		List<String> listaActividades = Actividad.listarActividades(getLbl_Fecha().getText());
		((DefaultListModel<String>) modelTodasLasActividadesCentro).removeAllElements();
		for(int i = 0; i < listaActividades.size(); i++) {
			((DefaultListModel<String>) modelTodasLasActividadesCentro).addElement(listaActividades.get(i));
			
		}
	}
	
	private void añadirNuevaActividadASocio(String correo, String id_actividad) {
		if(!Socio.añadirActividadASocio(correo, id_actividad)) {
			JOptionPane.showMessageDialog(this, "Error: No se puede añadir la actividad", "Error añadir actividad", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Añadido correcto");
			List<String> elegidoAñadir = getLista_Todas_Las_Actividades_Centro_1().getSelectedValuesList();
			for(int i = 0; i < elegidoAñadir.size(); i++) {
				modelMisActividades.addElement(elegidoAñadir.get(i));
			}
			getList_misActividades().setModel(modelMisActividades);
		}
		actualizarListaMisActividades();
		
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
		if(cadena == null) {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado item en lista", "Error seleccionar actividad", JOptionPane.INFORMATION_MESSAGE);
		}
		String[] valores = cadena.split(" ------ ");
		return valores[0];
	}
	private JPanel getPn_listas() {
		if (pn_listas == null) {
			pn_listas = new JPanel();
			pn_listas.setBackground(new Color(255, 255, 255));
			pn_listas.setLayout(new GridLayout(2, 1, 0, 0));
			pn_listas.add(getPn_Todas_Las_Actividades());
			pn_listas.add(getPanel_1_2());
		}
		return pn_listas;
	}
	
	private void actualizarListaMisActividades() {
		String correo = cb_usuarios.getSelectedItem().toString();
		List<String> listaMisActividades = socio.findActivitiesBySocio(correo);
		((DefaultListModel<String>) modelMisActividades).removeAllElements();
		for(int i = 0; i < listaMisActividades.size(); i++) {
			((DefaultListModel<String>) modelMisActividades).addElement(listaMisActividades.get(i));
			
		}
		
	}
	
	private void actualizarListaMisInstalaciones() {
		String correo = cb_usuarios.getSelectedItem().toString();
		List<String> listaMisAlquileres = socio.findAlquilersBySocio(correo);
		((DefaultListModel<String>) modelMisAlquileres).removeAllElements();
		for(int i = 0; i < listaMisAlquileres.size(); i++) {
			((DefaultListModel<String>) modelMisAlquileres).addElement(listaMisAlquileres.get(i));
			
		}
		
	}
	private JPanel getPn_miis_listas() {
		if (pn_miis_listas == null) {
			pn_miis_listas = new JPanel();
			pn_miis_listas.setBackground(new Color(255, 255, 255));
			pn_miis_listas.setLayout(new GridLayout(2, 0, 0, 0));
			pn_miis_listas.add(getPn_lista_mis_actividades());
			pn_miis_listas.add(getPanel_1_1());
		}
		return pn_miis_listas;
	}
	private JPanel getPn_lista_mis_actividades() {
		if (pn_lista_mis_actividades == null) {
			pn_lista_mis_actividades = new JPanel();
			pn_lista_mis_actividades.setBackground(new Color(255, 255, 255));
			pn_lista_mis_actividades.setLayout(new BorderLayout(0, 0));
			pn_lista_mis_actividades.add(getPanel_3(), BorderLayout.NORTH);
			pn_lista_mis_actividades.add(getList_misActividades(), BorderLayout.CENTER);
		}
		return pn_lista_mis_actividades;
	}
	private JPanel getPanel_1_1() {
		if (pn_lista_mis_instalaciones == null) {
			pn_lista_mis_instalaciones = new JPanel();
			pn_lista_mis_instalaciones.setBackground(new Color(255, 255, 255));
			pn_lista_mis_instalaciones.setLayout(new BorderLayout(0, 0));
			pn_lista_mis_instalaciones.add(getPanel_4(), BorderLayout.NORTH);
			pn_lista_mis_instalaciones.add(getList_MisInstalaciones(), BorderLayout.CENTER);
		}
		return pn_lista_mis_instalaciones;
	}
	private JPanel getPanel_3() {
		if (pn_infor_Actividades == null) {
			pn_infor_Actividades = new JPanel();
			pn_infor_Actividades.setBorder(new LineBorder(new Color(0, 0, 0)));
			pn_infor_Actividades.setBackground(new Color(152, 251, 152));
			pn_infor_Actividades.setLayout(new BorderLayout(0, 0));
			pn_infor_Actividades.add(getLbl_actividades());
			pn_infor_Actividades.add(getPanel_1_4(), BorderLayout.EAST);
		}
		return pn_infor_Actividades;
	}
	private JList<String> getList_misActividades() {
		if (list_misActividades == null) {
			list_misActividades = new JList<String>();
			list_misActividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list_misActividades.setBorder(new LineBorder(new Color(0, 0, 0)));
			list_misActividades.setBackground(Color.WHITE);
			list_misActividades.setModel(modelMisActividades);
		}
		return list_misActividades;
	}
	private JPanel getPanel_4() {
		if (pn_infor_instalaciones == null) {
			pn_infor_instalaciones = new JPanel();
			pn_infor_instalaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
			pn_infor_instalaciones.setBackground(new Color(152, 251, 152));
			pn_infor_instalaciones.setLayout(new BorderLayout(0, 0));
			pn_infor_instalaciones.add(getLbl_instlaciones(), BorderLayout.CENTER);
			pn_infor_instalaciones.add(getPanel(), BorderLayout.EAST);
		}
		return pn_infor_instalaciones;
	}
	private JLabel getLbl_actividades() {
		if (lbl_actividades == null) {
			lbl_actividades = new JLabel("Actividades:");
			lbl_actividades.setFont(new Font("Tahoma", Font.BOLD, 15));
		}
		return lbl_actividades;
	}
	private JLabel getLbl_instlaciones() { 
		if (lbl_instlaciones == null) {
			lbl_instlaciones = new JLabel("Alquileres:");
			lbl_instlaciones.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbl_instlaciones.setBackground(new Color(152, 251, 152));
		}
		return lbl_instlaciones;
	}
	private JList<String> getList_MisInstalaciones() {
		if (list_MisInstalaciones == null) {
			list_MisInstalaciones = new JList<String>();
			list_MisInstalaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list_MisInstalaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
			list_MisInstalaciones.setModel(modelMisAlquileres);
		}
		return list_MisInstalaciones;
	}
	private JPanel getPn_Todas_Las_Actividades() {
		if (pn_Todas_Las_Actividades == null) {
			pn_Todas_Las_Actividades = new JPanel();
			pn_Todas_Las_Actividades.setBackground(new Color(255, 255, 255));
			pn_Todas_Las_Actividades.setLayout(new BorderLayout(0, 0));
			pn_Todas_Las_Actividades.add(getLista_Todas_Las_Actividades_Centro_1());
			pn_Todas_Las_Actividades.add(getPn_Nombre_1(), BorderLayout.NORTH);
			pn_Todas_Las_Actividades.add(getPn_dia_anterior_siguiente(), BorderLayout.SOUTH);
			pn_Todas_Las_Actividades.add(getPn_Boton_Añadir_Actividad(), BorderLayout.EAST);
		}
		return pn_Todas_Las_Actividades;
	}
	private JPanel getPanel_1_2() {
		if (pn_Tods_Las_Instalaciones == null) {
			pn_Tods_Las_Instalaciones = new JPanel();
			pn_Tods_Las_Instalaciones.setBackground(new Color(255, 255, 255));
			pn_Tods_Las_Instalaciones.setLayout(new BorderLayout(0, 0));
			pn_Tods_Las_Instalaciones.add(getPanel_1_3(), BorderLayout.NORTH);
			pn_Tods_Las_Instalaciones.add(getPn_reserva_instalaciones(), BorderLayout.CENTER);
		}
		return pn_Tods_Las_Instalaciones;
	}
	private JList<String> getLista_Todas_Las_Actividades_Centro_1() {
		if (lista_Todas_Las_Actividades_Centro == null) {
			lista_Todas_Las_Actividades_Centro = new JList<String>();
			lista_Todas_Las_Actividades_Centro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lista_Todas_Las_Actividades_Centro.setBorder(new LineBorder(new Color(0, 0, 0)));
			lista_Todas_Las_Actividades_Centro.setBackground(Color.WHITE);
			lista_Todas_Las_Actividades_Centro.setModel(modelTodasLasActividadesCentro);
		}
		return lista_Todas_Las_Actividades_Centro;
	}
	private JPanel getPn_Nombre_1() {
		if (pn_Nombre_1 == null) {
			pn_Nombre_1 = new JPanel();
			pn_Nombre_1.setBackground(new Color(255, 255, 255));
			pn_Nombre_1.add(getLbl_actividades_1());
		}
		return pn_Nombre_1;
	}
	private JPanel getPanel_1_3() {
		if (pn_Nombre_2 == null) {
			pn_Nombre_2 = new JPanel();
			pn_Nombre_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			pn_Nombre_2.setBackground(new Color(255, 255, 255));
			pn_Nombre_2.add(getLbl_Instalaciones());
		}
		return pn_Nombre_2;
	}
	private JLabel getLbl_actividades_1() {
		if (lbl_actividades_1 == null) {
			lbl_actividades_1 = new JLabel("Actividades");
			lbl_actividades_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl_actividades_1;
	}
	private JLabel getLbl_Instalaciones() {
		if (lbl_Instalaciones == null) {
			lbl_Instalaciones = new JLabel("Reserva de instalaciones");
			lbl_Instalaciones.setBackground(new Color(255, 255, 255));
			lbl_Instalaciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbl_Instalaciones;
	}
	private JPanel getPn_reserva_instalaciones() {
		if (pn_reserva_instalaciones == null) {
			pn_reserva_instalaciones = new JPanel();
			pn_reserva_instalaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
			pn_reserva_instalaciones.setBackground(new Color(255, 255, 255));
			pn_reserva_instalaciones.setLayout(new GridLayout(1, 0, 0, 0));
			pn_reserva_instalaciones.add(getPn_escoger_instalacion());
			pn_reserva_instalaciones.add(getPn_escoger_fecha());
			pn_reserva_instalaciones.add(getPn_escoger_horas());
		}
		return pn_reserva_instalaciones;
	}
	private JPanel getPn_dia_anterior_siguiente() {
		if (pn_dia_anterior_siguiente == null) {
			pn_dia_anterior_siguiente = new JPanel();
			pn_dia_anterior_siguiente.setBackground(Color.WHITE);
			pn_dia_anterior_siguiente.setLayout(new GridLayout(0, 2, 0, 0));
			pn_dia_anterior_siguiente.add(getBt_anterior_1());
			pn_dia_anterior_siguiente.add(getBt_siguiente_1());
		}
		return pn_dia_anterior_siguiente;
	}
	private JButton getBt_anterior_1() {
		if (bt_anterior == null) {
			bt_anterior = new JButton("<--- Anterior");
			bt_anterior.setBackground(new Color(255, 204, 204));
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
	private JButton getBt_siguiente_1() {
		if (bt_siguiente == null) {
			bt_siguiente = new JButton("Siguiente --->");
			bt_siguiente.setBackground(new Color(255, 204, 204));
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
	private JPanel getPn_escoger_instalacion() {
		if (pn_escoger_instalacion == null) {
			pn_escoger_instalacion = new JPanel();
			pn_escoger_instalacion.setBackground(new Color(255, 255, 255));
			pn_escoger_instalacion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pn_escoger_instalacion.add(getLnl_escoger_instalacion());
			pn_escoger_instalacion.add(getCb_Instalacion());
		}
		return pn_escoger_instalacion;
	}
	private JPanel getPn_escoger_fecha() {
		if (pn_escoger_fecha == null) {
			pn_escoger_fecha = new JPanel();
			pn_escoger_fecha.setBackground(new Color(255, 255, 255));
			pn_escoger_fecha.add(getLbl_fecha_instalacion());
			pn_escoger_fecha.add(getTxtfield_fecha_instalacion());
		}
		return pn_escoger_fecha;
	}
	private JPanel getPn_escoger_horas() {
		if (pn_escoger_horas == null) {
			pn_escoger_horas = new JPanel();
			pn_escoger_horas.setBackground(new Color(255, 255, 255));
			pn_escoger_horas.setLayout(new BorderLayout(0, 0));
			pn_escoger_horas.add(getLblHoras(), BorderLayout.NORTH);
			pn_escoger_horas.add(getPanel_2(), BorderLayout.CENTER);
		}
		return pn_escoger_horas;
	}
	private JLabel getLnl_escoger_instalacion() {
		if (lnl_escoger_instalacion == null) {
			lnl_escoger_instalacion = new JLabel("Instalación:");
			lnl_escoger_instalacion.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lnl_escoger_instalacion;
	}
	private JComboBox<String> getCb_Instalacion() {
		if (cb_Instalacion == null) {
			cb_Instalacion = new JComboBox<String>();
			cb_Instalacion.setModel(new DefaultComboBoxModel<String>(admin.getInstalaciones()));
		}
		return cb_Instalacion;
	}
	private JLabel getLbl_fecha_instalacion() {
		if (lbl_fecha_instalacion == null) {
			lbl_fecha_instalacion = new JLabel("Fecha:");
		}
		return lbl_fecha_instalacion;
	}
	private JTextField getTxtfield_fecha_instalacion() {
		if (txtfield_fecha_instalacion == null) {
			txtfield_fecha_instalacion = new JTextField();
			txtfield_fecha_instalacion.setColumns(10);
		}
		return txtfield_fecha_instalacion;
	}
	private JLabel getLblHoras() {
		if (lblHoras == null) {
			lblHoras = new JLabel("Escoge las horas");
			lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
			lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblHoras;
	}
	private JPanel getPanel_2() {
		if (pn_Horas_instalacion == null) {
			pn_Horas_instalacion = new JPanel();
			pn_Horas_instalacion.setBackground(new Color(255, 255, 255));
			pn_Horas_instalacion.add(getComboBox_1());
			pn_Horas_instalacion.add(getLblNewLabel());
			pn_Horas_instalacion.add(getComboBox_2());
		}
		return pn_Horas_instalacion;
	}
	private JComboBox<String> getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox<String>();
			comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"}));
		}
		return comboBox_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("a");
		}
		return lblNewLabel;
	}
	private JComboBox<String> getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox<String>();
			comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"}));
		}
		return comboBox_2;
	}
	private JPanel getPn_Boton_Añadir_Actividad() {
		if (pn_Boton_Añadir_Actividad == null) {
			pn_Boton_Añadir_Actividad = new JPanel();
			pn_Boton_Añadir_Actividad.setBackground(new Color(255, 255, 255));
			pn_Boton_Añadir_Actividad.setLayout(new GridLayout(1, 0, 0, 0));
			pn_Boton_Añadir_Actividad.add(getBt_Añadido_actividad());
		}
		return pn_Boton_Añadir_Actividad;
	}
	private JButton getBt_Añadido_actividad() {
		if (bt_Añadido_actividad == null) {
			bt_Añadido_actividad = new JButton("Añadir actividad");
			bt_Añadido_actividad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String correo = getCb_usuarios().getSelectedItem().toString();
					String actividad = getIdActividad(lista_Todas_Las_Actividades_Centro.getSelectedValue());
					añadirNuevaActividadASocio(correo, actividad);
					
				}
			});
			bt_Añadido_actividad.setForeground(new Color(255, 250, 250));
			bt_Añadido_actividad.setBackground(new Color(0, 128, 0));
		}
		return bt_Añadido_actividad;
	}
	private JPanel getPn_botones_1() {
		if (pn_botones_1 == null) {
			pn_botones_1 = new JPanel();
			pn_botones_1.setBackground(new Color(255, 255, 255));
			pn_botones_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			pn_botones_1.setLayout(new GridLayout(0, 1, 0, 0));
			pn_botones_1.add(getBt_Añadir());
			pn_botones_1.add(getBt_Eliminar());
		}
		return pn_botones_1;
	}
	private JPanel getPn_botones_2() {
		if (pn_botones_2 == null) {
			pn_botones_2 = new JPanel();
			pn_botones_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			pn_botones_2.setBackground(new Color(255, 255, 255));
			pn_botones_2.setLayout(new GridLayout(0, 1, 0, 0));
			pn_botones_2.add(getBt_eliminar_instalacion());
		}
		return pn_botones_2;
	}
	private JButton getBt_eliminar_instalacion() {
		if (bt_eliminar_instalacion == null) {
			bt_eliminar_instalacion = new JButton("Eliminar alquiler");
			bt_eliminar_instalacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String correo = getCb_usuarios().getSelectedItem().toString();
					if(seleccionAlquiler()) {
						String id_alquiler = getIdAlquiler(getList_MisInstalaciones().getSelectedValue());
						eliminarAlquiler(correo, id_alquiler);
					} 
				}
			});
			bt_eliminar_instalacion.setForeground(new Color(255, 255, 255));
			bt_eliminar_instalacion.setBackground(new Color(255, 0, 0));
		}
		return bt_eliminar_instalacion;
	}
	
	protected void eliminarAlquiler(String correo, String id_alquiler) {
		List<String> elegidoEliminar = getList_misActividades().getSelectedValuesList();
		for(int i = 0; i < elegidoEliminar.size(); i++) {
			modelMisAlquileres.removeElement(elegidoEliminar.get(i));
		}
		getList_MisInstalaciones().setModel(modelMisAlquileres);
		
		Socio.eliminarAlquiler(correo, id_alquiler);
		
	}
	private boolean seleccionAlquiler() {
		if(getList_MisInstalaciones().getSelectedValue() != null) {
			return true;
		} 
		
		return false;
	}
	
	private String getIdAlquiler(String cadena) {
		if(cadena == null) {
			JOptionPane.showMessageDialog(this, "No se ha seleccionado item en lista", "Error seleccionar alquiler", JOptionPane.INFORMATION_MESSAGE);
		}
		String[] valores = cadena.split(" ------ ");
		return valores[0];
	}
	
	
	private JButton getBt_refrescar_alquileres() {
		if (bt_refrescar_alquileres == null) {
			bt_refrescar_alquileres = new JButton("Refrescar alquileres");
			bt_refrescar_alquileres.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarListaMisInstalaciones();
				}
			});
		}
		return bt_refrescar_alquileres;
	}
	private JButton getBt_ver_cancelados() {
		if (bt_ver_cancelados == null) {
			bt_ver_cancelados = new JButton("Ver cancelados");
			bt_ver_cancelados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarMisAlquileresCancelados();
				}
			});
		}
		return bt_ver_cancelados;
	}
	protected void actualizarMisAlquileresCancelados() {
		String correo = cb_usuarios.getSelectedItem().toString();
		List<String> listaMisAlquileresCancelados = socio.findAlquilersBySocioCancelados(correo);
		((DefaultListModel<String>) modelMisAlquileres).removeAllElements();
		for(int i = 0; i < listaMisAlquileresCancelados.size(); i++) {
			((DefaultListModel<String>) modelMisAlquileres).addElement(listaMisAlquileresCancelados.get(i));
		}
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(152, 251, 152));
			panel.add(getBt_refrescar_alquileres());
			panel.add(getBt_ver_cancelados());
		}
		return panel;
	}
	private JButton getBt_refrescar_actividades() {
		if (bt_refrescar_actividades == null) {
			bt_refrescar_actividades = new JButton("Refrescar actividades");
			bt_refrescar_actividades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarListaMisActividades();
				}
			});
		}
		return bt_refrescar_actividades;
	}
	private JPanel getPanel_1_4() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(152, 251, 152));
			panel_1.add(getBt_refrescar_actividades());
		}
		return panel_1;
	}
}
