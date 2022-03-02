package com.test.Asteroids.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Asteroid {
	
	@SerializedName("name")
	@Expose
	private String name;
	
	@SerializedName("is_potentially_hazardous_asteroid")
	private boolean isPotentiallyHazardousAsteroid;
	
	@SerializedName("estimated_diameter")
    @Expose
    private EstimatedDiameter estimatedDiameter;
	
	@SerializedName("close_approach_data")
    private List<CloseApproachDatum> closeApproachData;
	
	public String getName() {
		return name;
	}

	public boolean isPotentiallyHazardousAsteroid() {
		return isPotentiallyHazardousAsteroid;
	}

	public EstimatedDiameter getEstimatedDiameter() {
		return estimatedDiameter;
	}
	
	public List<CloseApproachDatum> getCloseApproachData() {
		return closeApproachData;
	}
	
}
