package com.test.Asteroids.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CloseApproachDatum {

	 @SerializedName("relative_velocity")
     @Expose
     private RelativeVelocity relativeVelocity;
	 
	 @SerializedName("close_approach_date")
     @Expose
     private String closeApproachDate;
	 
	 @SerializedName("orbiting_body")
     @Expose
     private String orbitingBody;
	 
	 public RelativeVelocity getRelativeVelocity() {
		 return relativeVelocity;
	 }
	 
	 public String getCloseApproachDate() {
        return closeApproachDate;
     }

	 public String getOrbitingBody() {
		return orbitingBody;
	 }
	
}
