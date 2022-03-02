package com.test.Asteroids.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.test.Asteroids.model.Asteroid;

public class SortUtil {

	private static Comparator<Asteroid> asteroidsComparator = (a1, a2) -> {
		
		double a1Size = a1.getEstimatedDiameter().getAvgDiameterInKilometers();
		double a1Body = a1.getCloseApproachData().get(0).getOrbitingBody().equalsIgnoreCase("Earth") ? 10 : 0;
		
		Double a1Comparator = a1Size + a1Body;
		
		double a2Size = a2.getEstimatedDiameter().getAvgDiameterInKilometers();
		double a2Body = a2.getCloseApproachData().get(0).getOrbitingBody().equalsIgnoreCase("Earth") ? 10 : 0;
		
		Double a2Comparator = a2Size + a2Body;
		
		return a2Comparator.compareTo(a1Comparator);
		
	};
	
	public static List<Asteroid> getTopThreeAsteroidsSortedBySizeRiskOnEarth(List<Asteroid> asteroids) {

		List<Asteroid> topThreeAsteroids = new ArrayList<Asteroid>();
		
		List<Asteroid> potentiallyRiskAsteroids = asteroids.stream().filter(Asteroid::isPotentiallyHazardousAsteroid).collect(Collectors.toList()); 
		
		if(!potentiallyRiskAsteroids.isEmpty()) {
			
			topThreeAsteroids = potentiallyRiskAsteroids.stream()
					.sorted(asteroidsComparator)
					.limit(3)
					.collect(Collectors.toList());
		}
		
		return topThreeAsteroids;
		    
	};
	
}
