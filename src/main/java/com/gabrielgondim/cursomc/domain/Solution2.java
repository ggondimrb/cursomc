package com.gabrielgondim.cursomc.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Solution2 {

	public int freeIntervalDays(List<String> pastDay,List<String> actuallyDay) {		
		
		Calendar pastDayStart = null;
		Calendar pastDayEnd = Calendar.getInstance();

		Collections.sort(pastDay, String.CASE_INSENSITIVE_ORDER);
		for(String past: pastDay) {

			if(pastDayStart == null) {
				pastDayStart = Calendar.getInstance();

				String hourStart = past.substring(0, 2);
				String minuteStart = past.substring(3, 5);


				pastDayStart.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hourStart));
				pastDayStart.set(Calendar.MINUTE, Integer.parseInt(minuteStart));
				pastDayStart.set(Calendar.SECOND, 0);
				pastDayStart.add(Calendar.DAY_OF_MONTH, 1);
			}

			String hour = past.substring(6, 8);
			String minute = past.substring(9, 11);

			pastDayEnd.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
			pastDayEnd.set(Calendar.MINUTE, Integer.parseInt(minute));
			pastDayEnd.set(Calendar.SECOND, 0);

		}

		Calendar acTuallyDayStart = null;
		Calendar acTuallyDayEnd = Calendar.getInstance();

		Collections.sort(actuallyDay, String.CASE_INSENSITIVE_ORDER);
		for(String actyually: actuallyDay) {

			if(acTuallyDayStart == null) {
				acTuallyDayStart = Calendar.getInstance();

				String hourStart = actyually.substring(0, 2);
				String minuteStart = actyually.substring(3, 5);

				acTuallyDayStart.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hourStart));
				acTuallyDayStart.set(Calendar.MINUTE, Integer.parseInt(minuteStart));
				acTuallyDayStart.set(Calendar.SECOND, 0);
				acTuallyDayStart.add(Calendar.DAY_OF_MONTH, 1);
			}


			String hour = actyually.substring(6, 8);
			String minute = actyually.substring(9, 11);

			acTuallyDayEnd.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
			acTuallyDayEnd.set(Calendar.MINUTE, Integer.parseInt(minute));
			acTuallyDayEnd.set(Calendar.SECOND, 0);

		}

		Date d1 = pastDayEnd.getTime();
		Date d2 = acTuallyDayStart.getTime();

		long diffMs = d1.getTime() - d2.getTime();
		long diffSec = diffMs / 1000;
		long min = diffSec / 60;

		return (int) (min * -1);
	}
	
	private int setIntervalMinutes(int intervalControl, int intervalMinutes) {
		if(intervalControl > intervalMinutes) {
			intervalMinutes = intervalControl;
		}
		return intervalMinutes;
	}

	public int solution(String S) {

		int intervalMinutes = 0;
		int intervalControl = 0;

		List<String> mon = new ArrayList<>(Arrays.asList());
		List<String> tue = new ArrayList<>(Arrays.asList());
		List<String> wed = new ArrayList<>(Arrays.asList());
		List<String> thu = new ArrayList<>(Arrays.asList());
		List<String> fri = new ArrayList<>(Arrays.asList());
		List<String> sat = new ArrayList<>(Arrays.asList());
		List<String> sun = new ArrayList<>(Arrays.asList());

		String[] meetingsS = S.split("\n");

		for (String date : meetingsS) {

			if(date.substring(0, 3).equals("Mon")) {
				mon.add("00:00-00:00");
				mon.add((date.substring(4)));
			} else if(date.substring(0, 3).equals("Tue")) {
				tue.add((date.substring(4)));
			} else if(date.substring(0, 3).equals("Wed")) {
				wed.add((date.substring(4)));
			} else if(date.substring(0, 3).equals("Thu")) {
				thu.add((date.substring(4)));
			} else if(date.substring(0, 3).equals("Fri")) {
				fri.add((date.substring(4)));
			} else if(date.substring(0, 3).equals("Sat")) {
				sat.add((date.substring(4)));
			} else if(date.substring(0, 3).equals("Sun")) {
				sun.add((date.substring(4)));
			} 

		}
		
		intervalControl = freeIntervalDays(mon,tue);
		intervalMinutes = setIntervalMinutes(intervalControl,intervalMinutes);

		intervalControl = freeIntervalDays(tue,wed);
		intervalMinutes = setIntervalMinutes(intervalControl,intervalMinutes);
		
		intervalControl = freeIntervalDays(wed,thu);
		intervalMinutes = setIntervalMinutes(intervalControl,intervalMinutes);
		
		intervalControl = freeIntervalDays(thu,fri);
		intervalMinutes = setIntervalMinutes(intervalControl,intervalMinutes);
		
		intervalControl = freeIntervalDays(fri,sat);
		intervalMinutes = setIntervalMinutes(intervalControl,intervalMinutes);
		
		intervalControl = freeIntervalDays(sat,sun);
		intervalMinutes = setIntervalMinutes(intervalControl,intervalMinutes);
		
		intervalControl = freeIntervalDays(sun,mon);
		intervalMinutes = setIntervalMinutes(intervalControl,intervalMinutes);				
		
		return intervalMinutes;
	}

}
