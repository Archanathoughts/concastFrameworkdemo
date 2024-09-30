package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random random=new Random();
		int nextInt = random.nextInt(5000);
	return nextInt;
	}
	public String getSystemDateYYYYDDmm()
	{
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		String data=sdf.format(dateobj);
		return data;
		
	}
	
	public String getRequiredDateYYYYDDmm(int days)
	{   
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		String start_Date=sdf.format(d);
		Calendar cal=sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate=sdf.format(cal.getTime());
//		 SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
//         Calendar cal = sdf.getCalendar();
//         cal.add(Calendar.DAY_OF_MONTH, days);
 //        String reqDate=sdf.format(cal.getTime());
         return reqDate;
		
	}
}
