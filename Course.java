import java.io.*;
import java.util.*;

class Course {
	private String   courseName;				// Course name as a string
	private int      courseNodeValue;			// Node value used only for the topo sort
	private int      averageGrade;				// Average grade as an int value out of 100
	private Course[] prerequisites;	// List of course prerequisites
	private Course[] corequisites;	// List of course corequisites
	
	// Course constructor
	public Course(int value, String name, int grade, String prerequisites, String corequisites) {
		courseName =      name;
		courseNodeValue = value;
		averageGrade =    grade;
		String[] prerequisiteNames = prerequisites.split(",");
		String[] corequisitesNames = corequisites.split(",");
	}
	
	// ====== Getter Methods ====== //
	
	public String getCourseName() {
		return courseName;
	}
	
	public int getCourseNodeValue() {
		return courseNodeValue;
	}
	
	public int getAverageGrade() {
		return averageGrade;
	}
	
	public Course[] getCorequisites() {
		return corequisites;
	}
	
	public Course[] getPrerequisites() {
		return prerequisites;
	}
}