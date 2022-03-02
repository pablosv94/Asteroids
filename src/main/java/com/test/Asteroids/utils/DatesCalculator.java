package com.test.Asteroids.utils;

import java.util.Calendar;
import java.util.Date;

import com.test.Asteroids.model.Dates;

public class DatesCalculator {

	public static Dates getDatesToCalculateAsteroids(Date dateFrom, int days) {
		
		Calendar datesCal = Calendar.getInstance();
		datesCal.setTime(dateFrom);
		
		datesCal.add(Calendar.DATE, days);
		Date dateTo = datesCal.getTime();
		
		return new Dates(dateFrom, dateTo);
		
	}

}
