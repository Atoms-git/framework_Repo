package com.comcast.crm.generic.fileutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javautil {

	public int getRandomNumber() {
		Random ran = new Random();
		int rannum= ran.nextInt(5000);
		return rannum;
	}
	public int getRandomNumberfrph() {
		Random ran = new Random();
		int ranfrph= ran.nextInt(100000000);
		return ranfrph;
	}
	
	public int getRandomNumberfrcamp() {
		Random ran = new Random();
		int ranfrph= ran.nextInt(3000);
		return ranfrph;
	}
	public int getRandomNumberfroppo() {
		Random ran = new Random();
		int ranfropp= ran.nextInt(1000);
		return ranfropp;
	}
	public String getSystemDateYYYYMMDD() {
		Date dateobj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date =sdf.format(dateobj);
		return date;
	}
	public String  getRequiredDateYYYYMMDD(int days ) {
		Date dt=new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String reqdate = sim.format(dt);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		 reqdate =sim.format(cal.getTime());
		return reqdate;
	}

	
	
}
