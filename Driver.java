import java.io.*;
import java.util.*;
import java.io.FileReader;

class Driver {
	public static void main(String[] args) throws IOException {	
		File file = new File("courseList.txt");				// File location for course data for the scanner
		Scanner scanner = new Scanner(file);				// Scanner for reading list of course data
		String[] courseData = new String[classListSize()];	// Initial list of all course data per course
		
		// Loop that iterates through each line in the text file and separate by commas
		for (int i = 0; i < courseData.length; i++)
			courseData[i]  = scanner.nextLine();
	}
	
	// Calculate the number of courses
	public static int classListSize() throws IOException {
		FileReader file = new FileReader("courseList.txt");
		BufferedReader reader = new BufferedReader(file);
		int size = 0;
		while ((reader.readLine() != null))
			size++;
		return size;
	}
}