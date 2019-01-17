package dateTime.Calendar;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ConversionClass {
	public static LocalDate convertCalendarToLocalDate(Calendar c) {
		LocalDate ld = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		return ld;
		
	}
	public static LocalTime convertCalendarToLocalTime(Calendar c) {
		LocalTime lt = LocalTime.of(c.get(Calendar.HOUR), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
		return lt;
		
	}
	public static LocalDate convertDateToLocalDate(Date d) {
		Instant i = d.toInstant();
		ZonedDateTime zd = i.atZone(ZoneId.systemDefault());
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-LLLL-dd");
		String str = zd.format(date);
		String dataStr = str.substring(0, 5)+"0"+str.substring(5, str.length());
		LocalDate ld = LocalDate.parse(dataStr);
		return ld;
	}
	public static Date convertLocalDateToDate(LocalDate ld) {
		Date d = new Date();
		d.setYear(ld.getYear());
		d.setMonth(ld.getMonthValue());
		d.setDate(ld.getDayOfMonth());
		return d;
	}
	public static Date convertLocalTimeToDate(LocalTime ld) {
		Date d = new Date();
		d.setHours(ld.getHour());
		d.setMinutes(ld.getMinute());
		d.setSeconds(ld.getSecond());
		return d;
	}
	public static Calendar convertLocalDateToCalendar(LocalDate ld) {
		GregorianCalendar gc = GregorianCalendar.from(ld.atStartOfDay(ZoneId.systemDefault()));
		return gc;
	}
	public static ZonedDateTime convertLocalDateTimeToZonedDateTime(LocalDateTime ldt) {
		//Instant instant = ldt.toInstant(ZoneOffset.UTC);
		ZoneId newyorkZoneId = ZoneId.of("America/New_York");
		ZonedDateTime zdt = ldt.atZone(newyorkZoneId);
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss a");
		ZonedDateTime x = ZonedDateTime.parse(zdt.toString(), DateTimeFormatter.ISO_ZONED_DATE_TIME);
		//String str = zdt.format(dtf);
		//System.out.println(str);
		//ZonedDateTime x = ZonedDateTime.parse(str);
		System.out.println(x);
		
		return x;
	}
	public static Instant convertOffsetDateTimeToInstant(OffsetDateTime ofs) {
		return ofs.toInstant();
	}
	public static LocalDateTime convertOffsetDateTimeToLocalDateTime(OffsetDateTime ofs) {
		return ofs.toLocalDateTime();
	}
	public static OffsetDateTime convertLocalDateTimeToOffsetDateTime(LocalDateTime ldt) {
		return ldt.atOffset(ZoneOffset.ofHours(+6));
	}
	
}
