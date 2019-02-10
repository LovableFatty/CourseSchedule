import java.io.*; 
import java.util.*;

// This class represents a directed graph using adjacency list representation 
class Graph { 
	private int 				graphSize;   		   // Total number of vertices
	private LinkedList<Integer> adjacentNodes[]; // List of adjacent vertices
	private Course[] 			courses; 			   // List of course names indexed using 
	private String[] 			courseData;			   // Initial list of all course data per course
		
	//Graph constructor - also initializes graph size
	Graph(int size) { 
		graphSize = size; 
		adjacentNodes = new LinkedList[size]; 
		for (int i = 0; i < size; ++i) 
			adjacentNodes[i] = new LinkedList(); 
	} 
	
	// Calculate the number of courses
	int classListSize() throws IOException {
		FileReader file = new FileReader("courseList.txt");
		BufferedReader reader = new BufferedReader(file);
		int size = 0;
		while ((reader.readLine() != null))
			size++;
		return size;
	}
	
	// Loop that iterates through each line in the text file and separate by commas
	void addCourseData() throws IOException{
		File file = new File("courseList.txt");		// File location for course data for the scanner
		Scanner scanner = new Scanner(file);			// Scanner for reading list of course data
		
		courseData = new String[classListSize()];		// Create new array with size of number of classes
		for (int i = 0; i < courseData.length; i++)	// Iterate through text file and save each line to array
			courseData[i]  = scanner.nextLine();
			
	}
	
	// Function to add to array of course names
	void addCourses() {
		courses = new Course[graphSize + 10];
		for (int i = 0; i < graphSize; i++) {
			String[] parsedData = new String[4];
			parsedData = courseData[i].split("|"); //Integer.valueOf(parsedData[3].replaceAll("\\s+",""))
			Course course = new Course(i , parsedData[0], 3, parsedData[1], parsedData[2]);
		   courses[i] = course;
      }	
	}
	
	// Function for setting course prerequisites and corequisites
	public void addRequisites() {
		this.addRequisite(0,1); 
		this.addRequisite(1,2); 
		this.addRequisite(2,3); 
		this.addRequisite(2,4); 
	}
	
	// Function to add an edge into the graph 
	public void addRequisite(int sourceVertice, int endVertice) {
		adjacentNodes[sourceVertice].add(endVertice);
	} 

	// A recursive function used by topologicalSort 
	void topologicalSortUtil(int v, boolean visited[], Stack stack) 
	{ 
		visited[v] = true; // Mark the current node as visited. 
		int i; 

		// Recursion for all the vertices adjacent to this vertex 
		Iterator<Integer> it = adjacentNodes[v].iterator(); 
		while (it.hasNext()) { 
			i = it.next(); 
			if (!visited[i]) 
				topologicalSortUtil(i, visited, stack); 
		} 

		// Push current vertex to stack which stores result 
		stack.push(new Integer(v)); 
	} 

	// Main function for sorting. Uses topologicalSortUtil() recursively
	void topologicalSort() { 
		Stack stack = new Stack(); 

		// Start each vertex as not visited
		boolean visited[] = new boolean[graphSize]; 
		for (int i = 0; i < graphSize; i++) 
			visited[i] = false; 

		// Recursively calls topologicalSortUtil() until all vertices are counted
		for (int i = 0; i < graphSize; i++) 
			if (visited[i] == false) 
				topologicalSortUtil(i, visited, stack); 

		// Prints contents of the resulting stack
		while (stack.empty() == false) 
			System.out.print(courses[(int) stack.pop()] + " --> "); 
	} 

	public static void main(String args[]) throws IOException { 
		// Create a graph given in the above diagram 
		Graph roadMap = new Graph(5);
      roadMap.addCourseData();
		roadMap.addCourses();
		System.out.println("The following is the optimized class order"); 
		roadMap.topologicalSort();
	} 
}