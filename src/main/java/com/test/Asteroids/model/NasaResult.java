package com.test.Asteroids.model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;


public class NasaResult {

	@SerializedName("near_earth_objects")
    private Map<String, JsonArray> near_earth_objects;
	
	private List<Asteroid> asteroids = new ArrayList<Asteroid>();

	public List<Asteroid> getAsteroids() {
		return asteroids;
	}

	public void convertToAsteroids() {
		this.asteroids = JsonToAsteroids(near_earth_objects);
	}
	
	private List<Asteroid> JsonToAsteroids(Map<String, JsonArray> near_earth_objects) {
		
        asteroids = new ArrayList<Asteroid>();
        
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Asteroid>>(){}.getType();
        
        for(Map.Entry<String,JsonArray> entry : near_earth_objects.entrySet()) {
        	asteroids.addAll(gson.fromJson(entry.getValue(), listType));
        }
        
        return asteroids;
        
    }
	
	
}
