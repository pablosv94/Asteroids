package com.test.Asteroids;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.test.Asteroids.controller.AsteroidsController;
import com.test.Asteroids.exceptions.DaysNotFoundException;
import com.test.Asteroids.exceptions.ExcededRangeException;
import com.test.Asteroids.model.Dates;
import com.test.Asteroids.model.NasaResult;
import com.test.Asteroids.repository.NasaRepository;
import com.test.Asteroids.utils.DatesCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AsteroidsApplicationTests {

	@Autowired 
	private AsteroidsController asteroidsController;
	
	@Autowired
	private NasaRepository nasaRepository;
	
	@BeforeEach
	public void setUp() {
	}
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	void testAsteroidsController() {
		assertThat(asteroidsController).isNotNull();
	}
	
	@Test
	void testNullDays() {
		
		 assertThatThrownBy(() -> asteroidsController.getTopThreeBigAsteroidsWithImpactRiskOnEarth(null)) 
	        .isInstanceOf(DaysNotFoundException.class);
		
	}
	
	@Test
	void testAsteroidsDatesCalculator() {
		
		Calendar dummyCal = Calendar.getInstance();
		dummyCal.set(Calendar.DATE, 1);
		dummyCal.set(Calendar.MONTH, 0);
		dummyCal.set(Calendar.YEAR, 2000);
		
		Dates dates = DatesCalculator.getDatesToCalculateAsteroids(dummyCal.getTime(), 3);
		
		assertEquals(dates.getFormattedDateFrom(), "2000-01-01");
		assertEquals(dates.getFormattedDateTo(), "2000-01-04");
		
	}
	
	@Test
	void testExcededDaysCallToNasa() {
		
		Calendar todayCal = Calendar.getInstance();
		Dates dates = DatesCalculator.getDatesToCalculateAsteroids(todayCal.getTime(), 10);
		
		assertThatThrownBy(() -> nasaRepository.getNasaData(dates)) 
        .isInstanceOf(ExcededRangeException.class);
		
	}
	
	@Test
	void testGoodCallToNasa() {
		
		Calendar todayCal = Calendar.getInstance();
		Dates dates = DatesCalculator.getDatesToCalculateAsteroids(todayCal.getTime(), 3);
		
		NasaResult nasaResult = nasaRepository.getNasaData(dates);
		
		assertNotNull(nasaResult);
		
	}

}
