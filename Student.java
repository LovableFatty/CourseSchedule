import java.io.*;
import java.util.*;

public class Student{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Graph roadmap = new Graph(7);
        Student Noah = new Student(roadmap);
        System.out.println("end");
    }
    int max = 0;

    //Constructor 
    Student(Graph roadmap) 
    {  
        // list of completed courses
    } 
    
    // Ask for inputs
    // Stores in Array 
    public int queryInputs(Scanner sc){
        System.out.println("How many CSC courses have you taken/completed? ");
        int taken = sc.nextInt();
        return taken;
    }
    
    public void queryInputsUtil(Scanner sc, String[] coursesTaken){
        int i = 0;
        while (!sc.nextLine().toUpperCase().equals("NO")){
            System.out.println("What CSc course have you taken? (ex. Csc 10) ");
            coursesTaken[i] = sc.nextLine();
            System.out.println("Did you take any other CSc courses? ");
            i++;
        }
    }
}