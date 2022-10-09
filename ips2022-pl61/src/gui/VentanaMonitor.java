package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Label;

public class VentanaMonitor extends JFrame {

	private JPanel contentPane;
	private JPanel pnDrch;
	private JPanel panel;
	private JScrollPane scrollPanelActividades;
	private JPanel pnFecha;
	private JLabel lblDia;
	private JPanel pnLista;
	private JPanel pnPasarListaSocios;
	private JScrollPane scrollPane;
	private JPanel pnPlazasAñadir;
	private JPanel pnNumPlazas;
	private JPanel pnAñadirSocios;
	private JButton btnPasarLista;
	private JTextField txtNumeroPlazasDis;
	private JTextField txtNmeroDePlazas;
	private JPanel pnIDok;
	private JButton btnOk;
	private JLabel lblAñadirSocio;
	private JPanel pnID;
	private JLabel lblIntroducirID;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMonitor frame = new VentanaMonitor();
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
	public VentanaMonitor() {
		setTitle("VentanaMonitor");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 796, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pnlIzq = new JPanel();
		contentPane.add(pnlIzq);
		pnlIzq.setLayout(new BorderLayout(0, 0));
		pnlIzq.add(getPanel_1(), BorderLayout.NORTH);
		contentPane.add(getPnDrch());
	}

	private JPanel getPnDrch() {
		if (pnDrch == null) {
			pnDrch = new JPanel();
			pnDrch.setLayout(new BorderLayout(0, 0));
			pnDrch.add(getPanel_1_2(), BorderLayout.NORTH);
			pnDrch.add(getPanel_1_3(), BorderLayout.CENTER);
		}
		return pnDrch;
	}
	private JPanel getPanel_1() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getScrollPanelActividades_1());
			panel.add(getPanel_1_1(), BorderLayout.NORTH);
		}
		return panel;
	}
	private JScrollPane getScrollPanelActividades_1() {
		if (scrollPanelActividades == null) {
			scrollPanelActividades = new JScrollPane();
		}
		return scrollPanelActividades;
	}
	private JPanel getPanel_1_1() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			pnFecha.add(getLblDia());
		}
		return pnFecha;
	}
	private JLabel getLblDia() {
		if (lblDia == null) {
			lblDia = new JLabel("Hoy");
			lblDia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblDia;
	}
	private JPanel getPanel_1_2() {
		if (pnLista == null) {
			pnLista = new JPanel();
			pnLista.add(getBtnPasarLista());
		}
		return pnLista;
	}
	private JPanel getPanel_1_3() {
		if (pnPasarListaSocios == null) {
			pnPasarListaSocios = new JPanel();
			pnPasarListaSocios.setLayout(new GridLayout(1, 1, 0, 0));
			pnPasarListaSocios.add(getScrollPane());
			pnPasarListaSocios.add(getPanel_1_4());
		}
		return pnPasarListaSocios;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
		}
		return scrollPane;
	}
	private JPanel getPanel_1_4() {
		if (pnPlazasAñadir == null) {
			pnPlazasAñadir = new JPanel();
			pnPlazasAñadir.setLayout(new GridLayout(0, 1, 0, 0));
			pnPlazasAñadir.add(getPanel_1_5());
			pnPlazasAñadir.add(getPnAñadirSocios());
		}
		return pnPlazasAñadir;
	}
	private JPanel getPanel_1_5() {
		if (pnNumPlazas == null) {
			pnNumPlazas = new JPanel();
			pnNumPlazas.setLayout(new GridLayout(0, 1, 0, 0));
			pnNumPlazas.add(getTxtNmeroDePlazas());
			pnNumPlazas.add(getTxtNumeroPlazasDis());
		}
		return pnNumPlazas;
	}
	private JPanel getPnAñadirSocios() {
		if (pnAñadirSocios == null) {
			pnAñadirSocios = new JPanel();
			pnAñadirSocios.setLayout(new BorderLayout(0, 0));
			pnAñadirSocios.add(getPanel_1_6());
		}
		return pnAñadirSocios;
	}
	private JButton getBtnPasarLista() {
		if (btnPasarLista == null) {
			btnPasarLista = new JButton("Pasar Lista");
			btnPasarLista.setBackground(new Color(0, 128, 128));
			btnPasarLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btnPasarLista;
	}
	private JTextField getTxtNumeroPlazasDis() {
		if (txtNumeroPlazasDis == null) {
			txtNumeroPlazasDis = new JTextField();
			txtNumeroPlazasDis.setText("N\u00FAmero de plazas disponibles: Y");
			txtNumeroPlazasDis.setColumns(10);
		}
		return txtNumeroPlazasDis;
	}
	private JTextField getTxtNmeroDePlazas() {
		if (txtNmeroDePlazas == null) {
			txtNmeroDePlazas = new JTextField();
			txtNmeroDePlazas.setText("N\u00FAmero de plazas: X");
			txtNmeroDePlazas.setColumns(10);
		}
		return txtNmeroDePlazas;
	}
	private JPanel getPanel_1_6() {
		if (pnIDok == null) {
			pnIDok = new JPanel();
			pnIDok.setLayout(new BorderLayout(0, 0));
			pnIDok.add(getBtnOk(), BorderLayout.EAST);
			pnIDok.add(getLblAñadirSocio(), BorderLayout.NORTH);
			pnIDok.add(getPanel_1_7(), BorderLayout.CENTER);
		}
		return pnIDok;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.setBackground(new Color(0, 128, 0));
		}
		return btnOk;
	}
	private JLabel getLblAñadirSocio() {
		if (lblAñadirSocio == null) {
			lblAñadirSocio = new JLabel("A\u00F1adir nuevo socio");
			lblAñadirSocio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblAñadirSocio;
	}
	private JPanel getPanel_1_7() {
		if (pnID == null) {
			pnID = new JPanel();
			pnID.setLayout(new GridLayout(2, 0, 0, 0));
			pnID.add(getLblIntroducirID());
			pnID.add(getTxtID());
		}
		return pnID;
	}
	private JLabel getLblIntroducirID() {
		if (lblIntroducirID == null) {
			lblIntroducirID = new JLabel("Introduzca ID del socio: ");
			lblIntroducirID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lblIntroducirID;
	}
	private JTextField getTxtID() {
		if (txtID == null) {
			txtID = new JTextField();
			txtID.setColumns(10);
		}
		return txtID;
	}
}
