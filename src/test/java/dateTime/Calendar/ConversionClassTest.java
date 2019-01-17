package dateTime.Calendar;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConversionClassTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void CalendarToLocalDate() {
		Calendar cl = Calendar.getInstance();
		cl.set(2019, Calendar.FEBRUARY, 21);
		LocalDate ld = ConversionClass.convertCalendarToLocalDate(cl);
		assertEquals(LocalDate.of(2019, Calendar.FEBRUARY, 21), ld);
	}
	@Test
	public void CalendarToLocalTime() {
		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.HOUR,10);
		cl.set(Calendar.MINUTE,35);
		cl.set(Calendar.SECOND,25);
		LocalTime ld = ConversionClass.convertCalendarToLocalTime(cl);
		assertEquals(LocalTime.of(10, 35, 25), ld);
	}
	@Test
	public void DateToLocalDate() {
		try {
			String srcstr = "Wed, Jan 02 2019 23:37:50";
			SimpleDateFormat srcDf  = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
			Date date = srcDf.parse(srcstr);
			LocalDate ld = ConversionClass.convertDateToLocalDate(date);
			String str = "2019-01-02";
			LocalDate sd = LocalDate.parse(str);
			assertEquals(sd, ld);
			
		}catch(ParseException e){
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("deprecation")
	@Test
	public void LocalDateToDate() {
		LocalDate ld = LocalDate.of(2019, Calendar.FEBRUARY, 26);
		Date d = ConversionClass.convertLocalDateToDate(ld);
		Date f = new Date();
		f.setDate(26);
		f.setMonth(01);
		f.setYear(2019);
		assertEquals(f, d);
	}
	
	@Test
	public void LocalTimeToDate() {
		LocalTime lt = LocalTime.of(07,55,54);
		Date d = ConversionClass.convertLocalTimeToDate(lt);
		Date f = new Date();
		f.setHours(07);
		f.setMinutes(55);
		f.setSeconds(54);
		assertEquals(f, d);
	}
	
	@Test
	public void LocalDateToCalender() throws ParseException {
		String srcstr = "2019-01-02";
		//SimpleDateFormat disDf  = new SimpleDateFormat("yyyy-LLLL-dd");
		//DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-LLLL-dd");
		LocalDate ld = LocalDate.parse(srcstr);
		Calendar d = ConversionClass.convertLocalDateToCalendar(ld);
		Date dt = d.getTime();
		//LocalDate sd = LocalDate.of(dt.getYear(), dt.getMonth(), dt.getDay());
		String desDtr = "Wed, Jan 02 2019 00:00:00";
		SimpleDateFormat srcDf  = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
		Date date = srcDf.parse(desDtr);
		assertEquals(date,dt);
		
	}
	@Test
	public void LocalDateTimeToZonedDateTime() {
		String srcstr = "22-1-2015 10:15:55 AM";
		LocalDateTime ldt = LocalDateTime.parse(srcstr,DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss a"));
		ZonedDateTime zdt = ConversionClass.convertLocalDateTimeToZonedDateTime(ldt);
		Instant instant = zdt.toInstant();
		String desstr = "22-1-2015 03:15:55 PM";
		LocalDateTime ldttt = LocalDateTime.parse(desstr,DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss a"));
		Instant inst = ldttt.toInstant(ZoneOffset.UTC);
		assertEquals(instant,inst);
	}
	@Test
	public void OffsetDateTimeToInstant() {
		OffsetDateTime offsetdattime = OffsetDateTime.of(2018, 05, 25, 05, 54, 57, 0, ZoneOffset.UTC);
		Instant inst = Instant.parse("2018-05-25T05:54:57Z");
		assertEquals(inst, ConversionClass.convertOffsetDateTimeToInstant(offsetdattime));
	}
	@Test
	public void OffsetDateTimeToLocalDateTime() {
		OffsetDateTime offsetdattime = OffsetDateTime.of(2018, 05, 25, 05, 54, 57, 0, ZoneOffset.ofHours(+6));
		assertEquals(LocalDateTime.of(2018, 05, 25, 05, 54,57), ConversionClass.convertOffsetDateTimeToLocalDateTime(offsetdattime));
	}
	@Test
	public void LocalDateTimeToOffset() {
		//test
		LocalDateTime localdatetime = LocalDateTime.of(2018, 05, 25, 05, 54,58);
		assertEquals(OffsetDateTime.of(2018, 05, 25, 05, 54, 58, 0, ZoneOffset.ofHours(+6)), ConversionClass.convertLocalDateTimeToOffsetDateTime(localdatetime));
	}

}
