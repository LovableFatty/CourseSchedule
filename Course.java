import java.io.*;
import java.util.*;

class Course {
	private String   courseName;				// Course name as a string
	private int      courseNodeValue;			// Node value used only for the topo sort
	private int      averageGrade;				// Average grade as an int value out of 100
	private LinkedList<Course> prerequisites;	// List of course prerequisites
	private LinkedList<Course> corequisites;	// List of course corequisites
	
	// Course constructor
	public Course(String name, int value, int grade) {
		courseName =      name;
		courseNodeValue = value;
		averageGrade =    grade;
	}
	
	public LinkedList<Course> getCorequisites() {
		return corequisites;
	}
	
	public LinkedList<Course> getPrerequisites() {
		return prerequisites;
	}
}