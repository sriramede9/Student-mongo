package com.example.demo.model;

public class Subject {

	private String subjectName;
	private double marksObtained;
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public double getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(double marksObtained) {
		this.marksObtained = marksObtained;
	}
	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + ", marksObtained=" + marksObtained + "]";
	}
	
	
}
