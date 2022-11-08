package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pn_Botones;
	private JPanel pn_Salir;
	private JButton btSalir;
	private JButton btSocio;
	private JButton btAdministrador;
	private JButton btMonitor;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("¡Bienvenido!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPn_Botones(), BorderLayout.CENTER);
		contentPane.add(getPn_Salir(), BorderLayout.SOUTH);
	}

	private JPanel getPn_Botones() {
		if (pn_Botones == null) {
			pn_Botones = new JPanel();
			pn_Botones.setBackground(new Color(255, 255, 255));
			pn_Botones.setLayout(new GridLayout(0, 1, 0, 0));
			pn_Botones.add(getBtAdministrador());
			pn_Botones.add(getBtSocio());
			pn_Botones.add(getBtMonitor());
		}
		return pn_Botones;
	}
	private JPanel getPn_Salir() {
		if (pn_Salir == null) {
			pn_Salir = new JPanel();
			pn_Salir.setBackground(new Color(255, 255, 255));
			pn_Salir.add(getBtSalir());
		}
		return pn_Salir;
	}
	private JButton getBtSalir() {
		if (btSalir == null) {
			btSalir = new JButton("Salir");
			btSalir.setForeground(new Color(255, 255, 255));
			btSalir.setBackground(new Color(255, 0, 0));
		}
		return btSalir;
	}
	private JButton getBtSocio() {
		if (btSocio == null) {
			btSocio = new JButton("Socio");
			btSocio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NewVentanaSocio vs = new NewVentanaSocio();
					abrirVentana(vs);
				}
			});
			btSocio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btSocio;
	}
	private JButton getBtAdministrador() {
		if (btAdministrador == null) {
			btAdministrador = new JButton("Administrador");
			btAdministrador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NewVentanaAdmin va = new NewVentanaAdmin();
					abrirVentana(va);
				}
			});
			btAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btAdministrador;
	}
	private JButton getBtMonitor() {
		if (btMonitor == null) {
			btMonitor = new JButton("Monitor");
			btMonitor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btMonitor;
	}
	
	private void abrirVentana(JFrame frame) {
		frame.setVisible(true);
		this.setVisible(false);
		
	}
}
