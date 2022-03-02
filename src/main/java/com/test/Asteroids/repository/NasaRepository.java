package com.test.Asteroids.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.test.Asteroids.exceptions.ExcededRangeException;
import com.test.Asteroids.model.Dates;
import com.test.Asteroids.model.NasaResult;

@Repository
public class NasaRepository {

	public NasaResult getNasaData(Dates dates) throws ExcededRangeException{
		
		NasaResult nasaResult = null;
		
		String url = getNasaUrlReplaced(dates);
		
		RestTemplate restTemplate = new RestTemplate();
		try {
			
			String result = restTemplate.getForObject(url, String.class);
			
			if(result != null) {
				nasaResult = deserializeNasaResult(result);
			}
			
		}catch(HttpClientErrorException e) {
			e.printStackTrace();
			throw new ExcededRangeException();
		}
		
		return nasaResult;
			
	}
	
	private String getNasaUrlReplaced(Dates dates) {
		
		String NasaUrl = "https://api.nasa.gov/neo/rest/v1/feed?start_date=$startDate&end_date=$endDate&api_key=DEMO_KEY";
		
		NasaUrl = StringUtils.replace(NasaUrl, "$startDate", dates.getFormattedDateFrom());
		NasaUrl = StringUtils.replace(NasaUrl, "$endDate", dates.getFormattedDateTo());
		
		return NasaUrl;
		
	}
	
	
	private NasaResult deserializeNasaResult(String json){
		
		Gson gson = new Gson();
	 	NasaResult nasaResult = gson.fromJson(json, NasaResult.class);
	 	nasaResult.convertToAsteroids();
        return nasaResult;
		
	}
	
}
