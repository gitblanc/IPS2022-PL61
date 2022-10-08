package gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JList;

public class VentanaSocio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pn_calendario;
	private JTabbedPane tb_masinfo;
	private JPanel pnMasInfo;
	private JList listActividadesSocio;

	/**
	 * Create the frame.
	 */
	public VentanaSocio() {
		setTitle("¡Bienvenido!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 443);
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
		}
		return pn_calendario;
	}
	private JTabbedPane getTb_masinfo() {
		if (tb_masinfo == null) {
			tb_masinfo = new JTabbedPane(JTabbedPane.TOP);
			tb_masinfo.setBackground(new Color(255, 255, 255));
			tb_masinfo.addTab("Mas información", null, getPanel_1(), null);
			tb_masinfo.addTab("Mis actividades", null, getListActividadesSocio(), null);
		}
		return tb_masinfo;
	}
	private JPanel getPanel_1() {
		if (pnMasInfo == null) {
			pnMasInfo = new JPanel();
			pnMasInfo.setBackground(new Color(255, 255, 255));
		}
		return pnMasInfo;
	}
	private JList getListActividadesSocio() {
		if (listActividadesSocio == null) {
			listActividadesSocio = new JList();
		}
		return listActividadesSocio;
	}
}
