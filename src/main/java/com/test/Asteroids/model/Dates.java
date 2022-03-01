package com.test.Asteroids.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dates {

	private Date dateFrom;
	private Date dateTo;
	
	public Dates(Date dateFrom, Date dateTo) {
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}

	public String getFormattedDateFrom() {
		return getFormattedDate(this.dateFrom);
	}
	
	public String getFormattedDateTo() {
		return getFormattedDate(this.dateTo);
	}
	
	private String getFormattedDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date); 
	}

}
