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
@SuppressWarnings("serial")
public class Celda extends JButton{
	public Celda(int i, int j) {
		setContentAreaFilled(false);
		setBorder(null);
		pintarContenidoCelda(i,j);
	}

	private void pintarContenidoCelda(int x, int y) {
		//la hora y los dias de la semana
		if(x == 0) {
			pintarDias(y);
		}//las horas del dia
		else if(x > 0 && y == 0) {
			pintarHoras(x);
		}
	}

	private void pintarHoras(int x) {
		switch(x) {
		case 1: 
			this.setText("9:00");
			break;
		case 2: 
			this.setText("10:00");
			break;
		case 3: 
			this.setText("11:00");
			break;
		case 4: 
			this.setText("12:00");
			break;
		case 5: 
			this.setText("13:00");
			break;
		case 6: 
			this.setText("14:00");
			break;
		case 7: 
			this.setText("15:00");
			break;
		case 8: 
			this.setText("16:00");
			break;
		case 9: 
			this.setText("17:00");
			break;
		case 10: 
			this.setText("18:00");
			break;
		case 11: 
			this.setText("19:00");
			break;
		case 12: 
			this.setText("20:00");
			break;
		case 13: 
			this.setText("21:00");
			break;
		case 14: 
			this.setText("22:00");
			break;
		default: 
			this.setText("23:00");
			break;
		}
	}

	private void pintarDias(int y) {
		switch(y) {
		case 0:
			this.setText("Hora");
			this.setForeground(Color.BLUE);
			break;
		case 1:
			this.setText("L");
			break;
		case 2,3:
			this.setText("M");
			break;
		case 4:
			this.setText("J");
			break;
		case 5:
			this.setText("V");
			break;
		case 6:
			this.setText("S");
			this.setForeground(Color.RED);
			break;
		default:
			this.setText("D");
			this.setForeground(Color.RED);
			break;
		}
	}
}
