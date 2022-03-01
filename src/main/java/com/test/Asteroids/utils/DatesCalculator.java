package com.test.Asteroids.utils;

import java.util.Calendar;
import java.util.Date;

import com.test.Asteroids.model.Dates;

public class DatesCalculator {

	private static final int DEFAULT_DATES_FOR_CALCULATE = 3;
	
	public static Dates getDatesToCalculateAsteroids(Date dateFrom) {
		
		Calendar datesCal = Calendar.getInstance();
		datesCal.setTime(dateFrom);
		
		datesCal.add(Calendar.DATE, DEFAULT_DATES_FOR_CALCULATE);
		Date dateTo = datesCal.getTime();
		
		return new Dates(dateFrom, dateTo);
		
	}

}
