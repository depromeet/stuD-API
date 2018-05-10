package com.depromeet.common.utils;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtils {
	
	public static Date getFirstDayOfWeek(int year, int month, int week) {
		Calendar cal = calendarInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.WEEK_OF_MONTH, week);
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return cal.getTime();
	}
	
	public static int getYear(Date date) {
		Calendar cal = calendarInstance();
		cal.setTime(date);
		
		return cal.get(Calendar.YEAR);
	}
	
	public static int getMonth(Date date) {
		Calendar cal = calendarInstance();
		cal.setTime(date);
		
		return cal.get(Calendar.MONTH) + 1;
	}
	
	public static int getWeek(Date date) {
		Calendar cal = calendarInstance();
		cal.setTime(date);
		
		return cal.get(Calendar.WEEK_OF_MONTH);
	}
	
	private static Calendar calendarInstance() {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		
		return cal;
	}
}
