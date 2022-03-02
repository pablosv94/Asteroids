package com.test.Asteroids.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import com.test.Asteroids.exceptions.DaysNotFoundException;
import com.test.Asteroids.exceptions.ExcededRangeException;
import com.test.Asteroids.model.NasaResult;
import com.test.Asteroids.repository.NasaRepository;
import com.test.Asteroids.model.Asteroid;
import com.test.Asteroids.model.Dates;
import com.test.Asteroids.utils.DatesCalculator;
import com.test.Asteroids.utils.SortUtil;

@RestController
public class AsteroidsController {

	@Autowired
	NasaRepository nasaRepository;
	
	@RequestMapping("/asteroids")
	public List<Asteroid> getTopThreeBigAsteroidsWithImpactRiskOnEarth(@RequestParam(value="days", required = false) Integer days) throws DaysNotFoundException  {
		
		if(days == null) {
			throw new DaysNotFoundException();
		}
		
		Dates dates = DatesCalculator.getDatesToCalculateAsteroids(Calendar.getInstance().getTime(), days);
		
		try {
			
			NasaResult nasaResult = nasaRepository.getNasaData(dates);
			
			if(nasaResult != null) {
				return getSortedAsteroids(nasaResult);
			}
			
		}catch(HttpClientErrorException e) {
			throw new ExcededRangeException();
		}
		
		return null;
	}
	
	/**
	 *  Exponer un endpoint que reciba un número de días entre 1 y 7 y que devuelva un listado en
	 *	formato json con el top 3 de asteroides más grandes con potencial riesgo de impacto en el
	 *	planeta Tierra entre el día de hoy y la fecha obtenida de sumar a la fecha de hoy el número de
	 *	días introducido como parámetro.
	 * 
	 */
	private List<Asteroid> getSortedAsteroids(NasaResult nasaResult){
		return SortUtil.getTopThreeAsteroidsSortedBySizeRiskOnEarth(nasaResult.getAsteroids());
	}
	
}
