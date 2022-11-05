package gui.calendar;

import java.awt.*;
import java.time.LocalDateTime;

public class CalendarEmptyClickEvent extends AWTEvent {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDateTime dateTime;

    public CalendarEmptyClickEvent(Object source, LocalDateTime dateTime) {
        super(source, 0);
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
