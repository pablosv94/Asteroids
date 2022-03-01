package com.test.Asteroids;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
import com.test.Asteroids.model.Dates;
import com.test.Asteroids.utils.DatesCalculator;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AsteroidsApplicationTests {

	@Autowired 
	private AsteroidsController asteroidsController;
	
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
		
		 assertThatThrownBy(() -> asteroidsController.getTopThreeRiskAsteroidsUntilDays(null)) 
	        .isInstanceOf(DaysNotFoundException.class);
		
	}
	
	@Test
	void testAsteroidsDatesCalculator() {
		
		Calendar dummyCal = Calendar.getInstance();
		dummyCal.set(Calendar.DAY_OF_MONTH, 1);
		dummyCal.set(Calendar.MONTH, 0);
		dummyCal.set(Calendar.YEAR, 2000);
		
		Dates dates = DatesCalculator.getDatesToCalculateAsteroids(dummyCal.getTime());
		
		assertThat(dates.getFormattedDateFrom().equals("01/01/2000"));
		assertThat(dates.getFormattedDateTo().equals("03/01/2000"));
		
	}

}
