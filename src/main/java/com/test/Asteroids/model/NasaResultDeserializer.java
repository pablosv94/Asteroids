package com.test.Asteroids.model;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class NasaResultDeserializer implements JsonDeserializer<NasaResult>{
	
	@Override
	public NasaResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
	 	Gson gson = new Gson();
	 	NasaResult nasaResult = gson.fromJson(json, NasaResult.class);
	 	nasaResult.convertToAsteroids();
        return nasaResult;
		
	}
	
	
	
}
