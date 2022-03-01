package com.test.Asteroids.model;

import java.lang.reflect.Type;
import java.util.Arrays;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class AsteroidFullDataDeserializer implements JsonDeserializer<AsteroidFullData>{
	
	@Override
	public AsteroidFullData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		JsonObject node = json.getAsJsonObject();
	    
		if(node.get("near_earth_objects") != null) {
			//TODO obtener asteroides
		}
	    
	    return new AsteroidFullData(Arrays.asList(new Asteroid("")));
	}
	
	
	
}
