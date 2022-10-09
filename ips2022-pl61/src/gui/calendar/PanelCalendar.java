package gui.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PanelCalendar extends JFrame {

	private JPanel contentPane;
	private JPanel panelCalendario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelCalendar frame = new PanelCalendar();
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
	public PanelCalendar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 570);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelCalendario(), BorderLayout.CENTER);

		pintarCeldasCalendario();
	}

	private JPanel getPanelCalendario() {
		if (panelCalendario == null) {
			panelCalendario = new JPanel();
			panelCalendario.setBackground(Color.GRAY);
			panelCalendario.setLayout(new GridLayout(16, 8, 0, 0));
		}
		return panelCalendario;
	}

	private void pintarCeldasCalendario() {
		Celda celda;
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 8; j++) {
				celda = new Celda(i, j);
				getPanelCalendario().add(celda);
			}
		}
		validate();
	}
}
