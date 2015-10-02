package agendatech.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	
	public static Date parse(String value) throws ParseException {
		if(!value.trim().isEmpty()) {
			Date date = formatter.parse(value);
			return date;
		}
		return null;
	}

	public static String print(Date value) {
		if(value != null) {
			return formatter.format(value.getTime());
		}
		return "";
	}
	
	
}