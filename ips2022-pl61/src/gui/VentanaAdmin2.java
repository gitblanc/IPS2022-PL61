package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;

public class VentanaAdmin2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdmin2 frame = new VentanaAdmin2();
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
	public VentanaAdmin2() {
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelPrincipal = new JPanel();
		contentPane.add(panelPrincipal, "name_193088540234600");
		panelPrincipal.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAcciones = new JPanel();
		panelAcciones.setBackground(Color.PINK);
		panelPrincipal.add(panelAcciones, BorderLayout.EAST);
		panelAcciones.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panelCrearTipoActividad = new JPanel();
		panelAcciones.add(panelCrearTipoActividad);
		
		JButton btnCrearTipoActividad = new JButton("New button");
		btnCrearTipoActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelCrearTipoActividad.add(btnCrearTipoActividad);
		
		JPanel panelPlanificarActividad = new JPanel();
		panelAcciones.add(panelPlanificarActividad);
		
		JPanel panelAlquilarASocio = new JPanel();
		panelAcciones.add(panelAlquilarASocio);
		
		JPanel panelCancelarAlquiler = new JPanel();
		panelAcciones.add(panelCancelarAlquiler);
		
		JPanel panel = new JPanel();
		panelPrincipal.add(panel, BorderLayout.CENTER);
	}

}
