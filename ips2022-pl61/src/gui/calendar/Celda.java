/**
 * 
 */
package gui.calendar;

import java.awt.Color;

import javax.swing.JButton;

/**
 * @author UO285176
 *
 */
public class Celda extends JButton {

	public Celda(int i, int j) {
		setContentAreaFilled(false);
		setBorder(null);
		asignarTexto(i, j);
	}

	private void asignarTexto(int x, int y) {
		if (x == 0) {
			asignarDias(y);
		} else if (y == 0) {
			asignarHoras(x);
		} else {
			asignarActividades(x, y);
		}

	}

	private void asignarActividades(int x, int y) {
		// Hora - 9
		if (x == 1) {
		}
		// Hora - 10
		if (x == 2) {
		}
		// Hora - 11
		if (x == 3) {
		}
		// Hora - 12
		if (x == 4) {
		}
		// Hora - 13
		if (x == 5) {
		}
		// Hora - 14
		if (x == 6) {
		}
		// Hora - 15
		if (x == 7) {
		}
		// Hora - 16
		if (x == 8) {
		}
		// Hora - 17
		if (x == 9) {
		}
		// Hora - 18
		if (x == 10) {
		}
		// Hora - 19
		if (x == 11) {
		}
		// Hora - 20
		if (x == 12) {
		}
		// Hora - 21
		if (x == 13) {
		}
		// Hora - 22
		if (x == 14) {
		}
		// Hora - 23
		if (x == 15) {
		}

	}

	private void asignarHoras(int x) {
		if (x == 1)
			setText("9:00");
		else if (x == 2)
			setText("10:00");
		else if (x == 3)
			setText("11:00");
		else if (x == 4)
			setText("12:00");
		else if (x == 5)
			setText("13:00");
		else if (x == 6)
			setText("14:00");
		else if (x == 7)
			setText("15:00");
		else if (x == 8)
			setText("16:00");
		else if (x == 9)
			setText("17:00");
		else if (x == 10)
			setText("18:00");
		else if (x == 11)
			setText("19:00");
		else if (x == 12)
			setText("20:00");
		else if (x == 13)
			setText("21:00");
		else if (x == 14)
			setText("22:00");
		else if (x == 15)
			setText("23:00");
	}

	private void asignarDias(int y) {
		if (y == 0) {
			setText("Horas");
			setForeground(Color.blue);
		} else if (y == 1)
			setText("L");
		else if (y == 2 || y == 3)
			setText("M");
		else if (y == 4)
			setText("J");
		else if (y == 5)
			setText("V");
		else if (y == 6) {
			setText("S");
			setForeground(Color.RED);
		} else if (y == 7) {
			setText("D");
			setForeground(Color.RED);
		}
	}
}
