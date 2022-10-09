package gui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import database.business.actividad.ActividadService.ActividadBLDto;
import logic.Actividad;

public class VentanaSocio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pn_calendario;
	private JTabbedPane tb_masinfo;
	private JList listActividadesSocio;
	private JPanel pn_Botones_dias;
	private JPanel pn_Calendario2;
	private JButton bt_DiaAnterior;
	private JButton bt_SiguienteDia;
	private JPanel pn_masInfo;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	
	private Actividad actividad = new Actividad();
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public VentanaSocio() {
		setTitle("¡Bienvenido!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		contentPane.add(getPn_calendario());
		contentPane.add(getTb_masinfo());
	}

	private JPanel getPn_calendario() {
		if (pn_calendario == null) {
			pn_calendario = new JPanel();
			pn_calendario.setBackground(new Color(255, 255, 255));
			pn_calendario.setLayout(new BorderLayout(0, 0));
			pn_calendario.add(getPanel_2(), BorderLayout.SOUTH);
			pn_calendario.add(getPanel_1_1(), BorderLayout.CENTER);
		}
		return pn_calendario;
	}
	private JTabbedPane getTb_masinfo() {
		if (tb_masinfo == null) {
			tb_masinfo = new JTabbedPane(JTabbedPane.TOP);
			tb_masinfo.setBorder(new LineBorder(new Color(0, 0, 0)));
			tb_masinfo.setBackground(new Color(255, 255, 255));
			tb_masinfo.addTab("Más información", null, getPn_masInfo(), null);
			tb_masinfo.addTab("Mis actividades", null, getListActividadesSocio(), null);
		}
		return tb_masinfo;
	}
	private JList getListActividadesSocio() {
		if (listActividadesSocio == null) {
			listActividadesSocio = new JList();
		}
		return listActividadesSocio;
	}
	private JPanel getPanel_2() {
		if (pn_Botones_dias == null) {
			pn_Botones_dias = new JPanel();
			pn_Botones_dias.setBackground(new Color(255, 255, 255));
			pn_Botones_dias.add(getBt_DiaAnterior());
			pn_Botones_dias.add(getBt_SiguienteDia());
		}
		return pn_Botones_dias;
	}
	private JPanel getPanel_1_1() {
		if (pn_Calendario2 == null) {
			pn_Calendario2 = new JPanel();
			pn_Calendario2.setBorder(new LineBorder(new Color(0, 0, 0)));
			pn_Calendario2.setBackground(new Color(255, 255, 255));
			pn_Calendario2.setLayout(new BorderLayout(0, 0));
			pn_Calendario2.add(getPanel(), BorderLayout.NORTH);
			pn_Calendario2.add(getPanel_1(), BorderLayout.WEST);
			pn_Calendario2.add(getPanel_2_1(), BorderLayout.CENTER);
		}
		return pn_Calendario2;
	}
	private JButton getBt_DiaAnterior() {
		if (bt_DiaAnterior == null) {
			bt_DiaAnterior = new JButton("Día anterior");
		}
		return bt_DiaAnterior;
	}
	private JButton getBt_SiguienteDia() {
		if (bt_SiguienteDia == null) {
			bt_SiguienteDia = new JButton("Día siguiente");
		}
		return bt_SiguienteDia;
	}
	

	private JPanel getPn_masInfo() {
		if (pn_masInfo == null) {
			pn_masInfo = new JPanel();
			pn_masInfo.setBackground(new Color(255, 255, 255));
		}
		return pn_masInfo;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(152, 251, 152));
			panel.add(getLblNewLabel_17());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(152, 251, 152));
			panel_1.setLayout(new GridLayout(16, 1, 0, 0));
			panel_1.add(getLblNewLabel_2());
			panel_1.add(getLblNewLabel_3());
			panel_1.add(getLblNewLabel_4());
			panel_1.add(getLblNewLabel_5());
			panel_1.add(getLblNewLabel_6());
			panel_1.add(getLblNewLabel_7());
			panel_1.add(getLblNewLabel_8());
			panel_1.add(getLblNewLabel_1());
			panel_1.add(getLblNewLabel_9());
			panel_1.add(getLblNewLabel_10());
			panel_1.add(getLblNewLabel_11());
			panel_1.add(getLblNewLabel_12());
			panel_1.add(getLblNewLabel_13());
			panel_1.add(getLblNewLabel_14());
			panel_1.add(getLblNewLabel_15());
			panel_1.add(getLblNewLabel_16());
		}
		return panel_1;
	}
	
	
	
		
	private JPanel getPanel_2_1() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(250, 240, 230));
			panel_2.setLayout(new GridLayout(16, 0, 0, 0));
			
//			rellenarActividadesReserva();
		}
		return panel_2;
	}
	
//	private void rellenarActividadesReserva() {
//		for(ActividadBLDto a: actividad.actividadesReserva()) {
//			JButton bt = new JButton();
//			bt.setBackground(new Color(238, 232, 170));
//			if(a.horario.equals()) {
//				bt.setText(a.nombre);
//				getPanel_2_1().ad;
//			} else if(a.horario.equals("9:00")) {
//				
//			}
//		}
//		
//	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("15:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("08:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("09:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("10:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("11:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("12:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("13:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("14:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("16:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_9;
	}
	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel("17:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_10;
	}
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("18:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_11;
	}
	private JLabel getLblNewLabel_12() {
		if (lblNewLabel_12 == null) {
			lblNewLabel_12 = new JLabel("19:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_12;
	}
	private JLabel getLblNewLabel_13() {
		if (lblNewLabel_13 == null) {
			lblNewLabel_13 = new JLabel("20:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_13;
	}
	private JLabel getLblNewLabel_14() {
		if (lblNewLabel_14 == null) {
			lblNewLabel_14 = new JLabel("21:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_14;
	}
	private JLabel getLblNewLabel_15() {
		if (lblNewLabel_15 == null) {
			lblNewLabel_15 = new JLabel("22:00");
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
			}
		return lblNewLabel_15;
	}
	private JLabel getLblNewLabel_16() {
		if (lblNewLabel_16 == null) {
			lblNewLabel_16 = new JLabel("23:00");
			lblNewLabel_16.setBackground(new Color(154, 205, 50));
			lblNewLabel_2.setBackground(new Color(144, 238, 144));
		}
		return lblNewLabel_16;
	}
	private JLabel getLblNewLabel_17() {
		if (lblNewLabel_17 == null) {
			lblNewLabel_17 = new JLabel("HOY");
		}
		return lblNewLabel_17;
	}

}
