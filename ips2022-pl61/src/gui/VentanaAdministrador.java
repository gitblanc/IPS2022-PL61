package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Administrador;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaAdministrador extends JFrame {

	private JPanel contentPane;
	private Administrador admin = new Administrador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdministrador frame = new VentanaAdministrador();
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
	public VentanaAdministrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel labelAdmin = new JLabel("Administrador");
		labelAdmin.setForeground(Color.BLUE);
		labelAdmin.setBounds(6, 6, 90, 16);
		panel.add(labelAdmin);
		
		JButton btnCrearActividad = new JButton("Crear nueva actividad");
		btnCrearActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin.crearActividad();
			}
		});
		btnCrearActividad.setBackground(new Color(0, 255, 0));
		btnCrearActividad.setBounds(107, 99, 446, 70);
		panel.add(btnCrearActividad);
		
		JButton btnPlanificarActividad = new JButton("Planificar una actividad");
		btnPlanificarActividad.setBackground(new Color(233, 150, 122));
		btnPlanificarActividad.setBounds(107, 221, 446, 70);
		panel.add(btnPlanificarActividad);
	}
}
