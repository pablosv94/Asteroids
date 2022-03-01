package com.test.Asteroids.controller;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.test.Asteroids.exceptions.DaysNotFoundException;
import com.test.Asteroids.model.Asteroid;
import com.test.Asteroids.model.AsteroidFullDataDeserializer;
import com.test.Asteroids.model.AsteroidFullData;
import com.test.Asteroids.model.Dates;
import com.test.Asteroids.utils.DatesCalculator;

@RestController
public class AsteroidsController {

	private static String NASA_URL = "https://api.nasa.gov/neo/rest/v1/feed?start_date=$startDate&end_date=$endDate&api_key=DEMO_KEY";
	
	@RequestMapping("/asteroids")
	public String getTopThreeRiskAsteroidsUntilDays(@RequestParam(value="days", required = false) Integer days) throws DaysNotFoundException  {
		
		if(days == null) {
			throw new DaysNotFoundException();
		}
		
		Dates dates = DatesCalculator.getDatesToCalculateAsteroids(Calendar.getInstance().getTime());
		
		NASA_URL = StringUtils.replace(NASA_URL, "$startDate", dates.getFormattedDateFrom());
		NASA_URL = StringUtils.replace(NASA_URL, "$endDate", dates.getFormattedDateTo());
		
		//https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-12-09&end_date=2021-12-12&api_key=DEMO_KEY
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(NASA_URL, String.class);
		
		if(result != null) {
			List<Asteroid> asteroids = getAsteroidsFromJSON(result);
		}
		
		return "";
		
	}
	
	private List<Asteroid> getAsteroidsFromJSON(String json){
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		AsteroidFullDataDeserializer deserializer = new AsteroidFullDataDeserializer();
		
		gsonBuilder.registerTypeAdapter(AsteroidFullData.class, deserializer);
		
		Gson customGson = gsonBuilder.create();  
		Type listType = new TypeToken<AsteroidFullData>(){}.getType();
		
		return customGson.fromJson(json, listType);
		
	}

}
