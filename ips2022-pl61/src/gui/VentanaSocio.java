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
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import logic.Actividad;

public class VentanaSocio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnHorario;
	private JList<String> listaHorario;
	private ListModel<String> modelHorario;
	private JPanel pn_botones;
	private JPanel pn_Dia;
	private JButton btAnterior;
	private JButton btSiguiente;
	private JLabel Lbl_Hoy;
	private JLabel lbl_Dia;


	/**
	 * Create the frame.
	 */
	public VentanaSocio() {
		setTitle("¡Bienvenido!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnHorario());
		actualizarHorario();
	}

	private JPanel getPnHorario() {
		if (pnHorario == null) {
			pnHorario = new JPanel();
			pnHorario.setBackground(new Color(255, 255, 255));
			pnHorario.setLayout(new BorderLayout(0, 0));
			pnHorario.add(getListaHorario());
			pnHorario.add(getPn_botones(), BorderLayout.SOUTH);
			pnHorario.add(getPn_Dia(), BorderLayout.NORTH);
		}
		return pnHorario;
	}
	private JList<String> getListaHorario() {
		if (listaHorario == null) {
			listaHorario = new JList<String>();
			modelHorario = new DefaultListModel<String>();
			listaHorario.setModel(modelHorario);
			listaHorario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
		}
		return listaHorario;
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
	private JPanel getPn_Dia() {
		if (pn_Dia == null) {
			pn_Dia = new JPanel();
			pn_Dia.setBackground(new Color(152, 251, 152));
			pn_Dia.add(getLbl_Hoy());
			pn_Dia.add(getLbl_Dia());
		}
		return pn_Dia;
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
	
	private JLabel getLbl_Hoy() {
		if (Lbl_Hoy == null) {
			Lbl_Hoy = new JLabel("HOY");
			Lbl_Hoy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return Lbl_Hoy;
	}
	private JLabel getLbl_Dia() {
		if (lbl_Dia == null) {
			lbl_Dia = new JLabel("New label");
			lbl_Dia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbl_Dia.setText(fecha());
		}
		return lbl_Dia;
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
		getListaHorario().setModel(modelHorario);
	}
}
