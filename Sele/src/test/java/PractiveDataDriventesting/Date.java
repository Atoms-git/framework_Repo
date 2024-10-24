package PractiveDataDriventesting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		java.util.Date dateobj = new java.util.Date();
		System.out.println(dateobj.toString());
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateobj);
		System.out.println(sim.format(dateobj));
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,-30);
		sim.format(cal.getTime());
		
		
	}


}
