import java.io.*; 
import java.util.*; 

// This class represents a directed graph using adjacency list representation 
class Graph { 
	private int graphSize;   			// Total number of vertices
	private LinkedList<Integer> adj[]; 	// List of adjacent vertices
	private String[] courses; 			// List of course names indexed using 

	//Graph constructor
	Graph(int size) { 
		graphSize = size; 
		adj = new LinkedList[size]; 
		for (int i = 0; i < size; ++i)
			adj[i] = new LinkedList(); 
	} 
	
	// Function to add to array of course names
	void addCourses() {
		courses = new String[10];
		courses[0] = "csc10";
		courses[1] = "csc15";
		courses[2] = "csc20";
		courses[3] = "csc28";
		courses[4] = "csc35";
	}
	
	// Function for setting course prerequisites and corequisites
	public void addRequisites() {
		this.addEdge(0,1); 
		this.addEdge(1,2); 
		this.addEdge(2,3); 
		this.addEdge(2,4); 
	}
	
	// Function to add an edge into the graph 
	public void addEdge(int sourceVertice, int endVertice) {
		adj[sourceVertice].add(endVertice);
	} 

	// A recursive function used by topologicalSort 
	void topologicalSortUtil(int v, boolean visited[], Stack stack) 
	{ 
		// Mark the current node as visited. 
		visited[v] = true; 
		Integer i; 

		// Recursion for all the vertices adjacent to this vertex 
		Iterator<Integer> it = adj[v].iterator(); 
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