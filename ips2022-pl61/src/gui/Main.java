/**
 * 
 */
package gui;

import java.awt.EventQueue;

import javax.swing.UIManager;

/**
 * @author UO285176
 *
 */
public class Main {

	/**
	 * Lanza la aplicación
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					VentanaAdministrador frame = new VentanaAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

}
