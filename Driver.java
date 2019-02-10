import java.io.*;
import java.util.*;

class Driver {
	public static void main(String[] args) {
		LinkedList<String> courseData[];	// Initial list of all course data per course
		LinkedList<Course> courseList[]; 	// List of course objects from text file

		//try (FileReader file = new FileReader("courseList.txt")) {}			//Read file of class information
		//catch (IOException e) { System.out.println("File Read Error"); }	//Produce error if file is not found
		Scanner scanner = new Scanner("courseList.txt");
		
		for (int i = 0; i < classListSize(); i++) {
			String scannedLine = scanner.nextLine();
			courseData[i] = new LinkedList();
			String[] output = scannedLine.split(",");
		}
	}
	
	public static int classListSize() {
		Scanner scanner = new Scanner("courseList.txt");
		int size = 0;
		while (scanner.hasNextLine()) { size++; }
		return size;
	}
}