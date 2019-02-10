import java.io.*;
import java.util.*;
import java.io.FileReader;
//import Graph;

public class Driver {
	public static void main(String[] args) throws IOException {	
		File file = new File("courseList.txt");				// File location for course data for the scanner
		Scanner scanner = new Scanner(file);				// Scanner for reading list of course data
        Scanner kb = new Scanner(System.in);                   
		String[] courseData = new String[classListSize()];	// Initial list of all course data per course
        Graph schedule = new Graph(classListSize());
        String[] topoSort = new String[classListSize()];
        Student Noah = new Student(schedule); 
		int totalCoursesTaken = Noah.queryInputs(kb);
        String[] coursesTaken = new String[totalCoursesTaken];
		// Loop that iterates through each line in the text file and separate by commas
		for (int i = 0; i < courseData.length; i++){
			courseData[i]  = scanner.nextLine();
        }
        Noah.queryInputsUtil(kb,coursesTaken);
        System.out.println("Courses taken: ");
        for (int j = 0; j < coursesTaken.length; j++){
            System.out.print(coursesTaken[j] + " ");
        }
        System.out.println();
        //schedule.addCourses();
        //schedule.addPrequisites();
		System.out.println("The following is a optimized class order"); 
		//schedule.topologicalSort();
        schedule.topologicalSortTest(topoSort);
        for (int i = 0; i < 7; i++){
            System.out.print(topoSort[i] + " ");
        }
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