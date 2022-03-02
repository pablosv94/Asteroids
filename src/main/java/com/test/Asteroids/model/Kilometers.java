package com.test.Asteroids.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kilometers {

	@SerializedName("estimated_diameter_min")
    @Expose
    private Double estimatedDiameterMin;

    @SerializedName("estimated_diameter_max")
    @Expose
    private Double estimatedDiameterMax;
    
    public Double getEstimatedDiameterAvg(){
        return (estimatedDiameterMax + estimatedDiameterMin)/2;
    }
	
}
