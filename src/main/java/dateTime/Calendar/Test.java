package dateTime.Calendar;



import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		
		String srcstr = "22-1-2015 10:15:55 AM";
		LocalDateTime ldt = LocalDateTime.parse(srcstr,DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss a"));
		ZonedDateTime zdt = ConversionClass.convertLocalDateTimeToZonedDateTime(ldt);
		Instant instant = zdt.toInstant();
//		Instant inst = ldt.toInstant(ZoneOffset.UTC);
		String desstr = "22-1-2015 03:15:55 PM";
		LocalDateTime ldttt = LocalDateTime.parse(desstr,DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss a"));
		Instant inst = ldttt.toInstant(ZoneOffset.UTC);
		//String str = zdt.toString();
		//str = str.substring(0,ldt.toString().length());
		
		//LocalDateTime ld = LocalDateTime.parse(str);
		System.out.println(instant);
		System.out.println(inst);
	}
}
