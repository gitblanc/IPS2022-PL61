package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JList;
import java.awt.List;

public class VentanaSocio extends JFrame {

	private JPanel contentPane_VentanaSocio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSocio frame = new VentanaSocio();
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
	public VentanaSocio() {
		setTitle("¡Bienvenido!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 471);
		contentPane_VentanaSocio = new JPanel();
		contentPane_VentanaSocio.setBackground(new Color(255, 255, 255));
		contentPane_VentanaSocio.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane_VentanaSocio);
		contentPane_VentanaSocio.setLayout(new BoxLayout(contentPane_VentanaSocio, BoxLayout.X_AXIS));
		
		JPanel pn_Calendario = new JPanel();
		pn_Calendario.setBackground(new Color(255, 255, 255));
		contentPane_VentanaSocio.add(pn_Calendario);
		
		JTabbedPane tbp_MasInformacion = new JTabbedPane(JTabbedPane.TOP);
		tbp_MasInformacion.setBackground(new Color(255, 255, 255));
		contentPane_VentanaSocio.add(tbp_MasInformacion);
		
		JPanel pn_masInfo = new JPanel();
		pn_masInfo.setBackground(new Color(255, 255, 255));
		pn_masInfo.setName("");
		tbp_MasInformacion.addTab("Más información", null, pn_masInfo, null);
		pn_masInfo.setLayout(new BoxLayout(pn_masInfo, BoxLayout.X_AXIS));
		
		JList list_MisActividades = new JList();
		list_MisActividades.setName("Mis actividades");
		tbp_MasInformacion.addTab("Mis actividades", null, list_MisActividades, null);
	}

}
