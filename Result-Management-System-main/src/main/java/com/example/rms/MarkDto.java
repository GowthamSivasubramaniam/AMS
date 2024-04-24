package com.example.rms;

import java.util.List;

public class MarkDto {
	private Long id;
    private String month;
    private String days;
    private String year;

	public MarkDto(Long id, String month, String days , String year) {
		super();
		this.id = (long)1;
		this.month = month;
		this.days = days;
		this.year= year;
	}
	public MarkDto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getmonth() {
		return month;
	}
	public void setmonth(String month) {
		this.month = month;
	}
	public String getdays() {
		return days;
	}
	public void setdays(String days) {
		this.days = days;
	}
	public String getyear() {
		return year;
	}
	public void setyear(String year) {
		this.year = year;
	}
	
}
