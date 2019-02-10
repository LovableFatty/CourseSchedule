import java.io.*; 
import java.util.*; 

// This class represents a directed graph using adjacency list representation 
class Graph { 
	private int 				graphSize;   		// Total number of vertices
	private LinkedList<Integer> adjacentNodes[]; 	// List of adjacent vertices
	private String[] 			courses; 			// List of course names indexed using 
	private Graph[][] 			concurrentClasses;	// List of classes that can be taken together
		
	//Graph constructor
	Graph(int size) { 
		graphSize = size; 
		adjacentNodes = new LinkedList[size]; 
		for (int i = 0; i < size; ++i)
			adjacentNodes[i] = new LinkedList(); 
	} 
	
	// Function to add to array of course names
	void addCourses() {
		courses = new String[12];
		courses[0] = "CSC 10";
		courses[1] = "CSC 15";
		courses[2] = "CSC 20";
		courses[3] = "CSC 28";
		courses[4] = "CSC 35";
		courses[5] = "CSC 60";
		courses[6] = "MATH 26A";
		courses[7] = "MATH 30";
		courses[8] = "MATH 26B";
		courses[9] = "MATH 31";
		courses[10] = "STAT 50";
		courses[11] = "ENGR 115";	
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
		// Mark the current node as visited. 
		visited[v] = true; 
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
	void topologicalSort() 
	{ 
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

	public static void main(String args[]) { 
		// Create a graph given in the above diagram 
		Graph roadMap = new Graph(5);
		roadMap.addCourses();
		roadMap.addRequisites();
		System.out.println("The following is the optimized class order"); 
		roadMap.topologicalSort();
	} 
}