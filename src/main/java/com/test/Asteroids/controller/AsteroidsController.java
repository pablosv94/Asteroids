package com.test.Asteroids.controller;

import java.util.Calendar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.Asteroids.exceptions.DaysNotFoundException;
import com.test.Asteroids.model.Dates;
import com.test.Asteroids.utils.DatesCalculator;

@RestController
public class AsteroidsController {

	@RequestMapping("/asteroids")
	public int getTopThreeRiskAsteroidsUntilDays(@RequestParam(value="days", required = false) Integer days) throws DaysNotFoundException  {
		
		if(days == null) {
			throw new DaysNotFoundException();
		}
		
		Dates dates = DatesCalculator.getDatesToCalculateAsteroids(Calendar.getInstance().getTime());
		//https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-12-09&end_date=2021-12-12&api_key=DEMO_KEY
		
		return days;
		
	}

}
