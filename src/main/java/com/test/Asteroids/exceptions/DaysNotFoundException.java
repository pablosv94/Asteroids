package com.test.Asteroids.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Days parameter is null")
public class DaysNotFoundException extends RuntimeException{

}
