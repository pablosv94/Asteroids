package com.test.Asteroids.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EstimatedDiameter {

	@SerializedName("kilometers")
    @Expose
    private Kilometers kilometers;
	
	public double getAvgDiameterInKilometers(){
        return kilometers.getEstimatedDiameterAvg();
    }
	
}
