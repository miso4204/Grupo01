package co.com.uniandes.stampidia.configurator.util;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {
	public static String getCurrentTime() {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(Calendar.getInstance().getTime());
		return timeStamp + " - ";
	}
}
