package com.test.Asteroids;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.test.Asteroids.controller.AsteroidsController;
import com.test.Asteroids.exceptions.DaysNotFoundException;

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

}
