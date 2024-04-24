package com.example.rms;

import java.util.ArrayList;
import java.util.List;

public class StudentDto {
	private Long id;
	private String name;
	private String rollno;
	private String email;
	
    private List<MarkDto> att;
	
	public StudentDto(Long id, String rollno, String name, String email) {
		super();
		this.id = id;
		this.rollno = rollno;
		this.name = name;
		this.email = email;
	}
	
	public StudentDto() {
		super();
	}

	public List<MarkDto> getAtt() {
//		if (days == null) 
//		{
//        days = new ArrayList<>();
    
    return att;
	}
	public void setAtt(List<MarkDto> marks) {
		System.out.println(marks);
		this.att = marks;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
