package DayFive;
import java.util.Calendar;

public class CalendarExample {
	public static void main (String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println("cureent date and time" + calendar.getTime());
		
		calendar.set(calendar.YEAR, 2025);
		calendar.set(Calendar.MONTH, Calendar.JULY);
		calendar.set(Calendar.DAY_OF_MONTH, 24);
		
		System.out.println("Specific date (July 24, 2025"+ calendar.getTime());
		
		calendar.add(Calendar.DAY_OF_MONTH, 10);
		
		System.out.println("days after adding 10 days" + calendar.getTime());
		System.out.println(("days after subtracting one month" ) + calendar.getTime());	
	}
}
