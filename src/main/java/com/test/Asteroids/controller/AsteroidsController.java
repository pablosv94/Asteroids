package com.test.Asteroids.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.Asteroids.exceptions.DaysNotFoundException;

@RestController
public class AsteroidsController {

	@RequestMapping("/asteroids")
	public int getTopThreeRiskAsteroidsUntilDays(@RequestParam(value="days", required = false) Integer days) throws DaysNotFoundException  {
		
		if(days == null) {
			throw new DaysNotFoundException();
		}
		
		return days;
		
	}

}
