package code;

import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Iterator;

/**
 * @author Carlos Espino Timón
 *
 */
public class Utilities  {

	private Scanner reader;
	private Scanner reader2;
	private Scanner reader3;



	public Utilities(){
	}
	
	public int getQualificationNumber(){
		boolean correct = false;
		
		while (!correct){
			reader = new Scanner(System.in);
			int n = reader.nextInt(); // Scans the next token of the input as an int.
			if (0 < n && n< 4){
				return n;
			}else{
				System.out.println("ERROR --> El número debe ser 1, 2 o 3");
			}
		}
		return 0;
	}
	
	
	public int getNumber(){
		boolean correct = false;
		
		while (!correct){
			reader2 = new Scanner(System.in);
			int n = reader2.nextInt(); // Scans the next token of the input as an int.
			if (0 < n){
				return n;
			}else{
				System.out.println("ERROR --> El número debe ser un entero mayor que 0");
			}
		}
		return 0;
	}
	
	public int getGroup(){
		boolean correct = false;
		
		while (!correct){
			reader3 = new Scanner(System.in);
			int n = reader3.nextInt(); // Scans the next token of the input as an int.
			if (0 < n && n < 3){
				return n;
			}else{
				System.out.println("ERROR --> El número debe ser 1 o 2");
			}
		}
		return 0;
	}
	
	
	public String getString(){
		reader3 = new Scanner(System.in);
		return reader3.nextLine();
	}
	
	/**
     * Method to sort the children by the total qualification
     * 
     * 
     */
    public static void sortList(List<Student> l){
		Collections.sort(l, new StudentComparator());
	}
	
	/**
     * Method to sort homogeneously the children by the total qualification
     * 
     * 
     */
    public List<Table> distributeHomogeneous(List<Table> tables, List<Student> students, int perTable, int spare){
		Iterator<Student> itrStudent = students.iterator(); 
		Iterator<Table> itrTable = tables.iterator();
		
		while(spare>0 && itrStudent.hasNext() && itrTable.hasNext()){
			Table nextTable = itrTable.next();
			for (int i=0; i<perTable; i++){
				Student nextStudent = itrStudent.next();
				nextTable.addStudent(nextStudent);
			}
			spare--;
		}
		while(itrStudent.hasNext() && itrTable.hasNext()){
			Table nextTable = itrTable.next();
			for (int i=0; i<perTable-1; i++){
				Student nextStudent = itrStudent.next();
				nextTable.addStudent(nextStudent);
			}
		}
		return tables;
	}
	
	
	
	/**
     * Method to sort heterogeneously the children by the total qualification
     * 
     * 
     */
    public List<Table> distributeHeterogeneous(List<Table> tables, List<Student> students, int perTable, int spare){
		Iterator<Student> itrStudent = students.iterator(); 
		Iterator<Table> itrTable = tables.iterator();
		
		while (itrStudent.hasNext()){
			Student nextStudent = itrStudent.next();
			if(itrTable.hasNext()){
				Table nextTable = itrTable.next();
				nextTable.addStudent(nextStudent);
			}else{
				itrTable = tables.iterator();
				Table nextTable = itrTable.next();
				nextTable.addStudent(nextStudent);
			}
		}
		return tables;
	}
	
    /**
     * 
     * @param students the List of student
     * @param tables the List of tables
     * @param firstPriority the first priority  
     * @param secondPriority the second priority
     * @param type of group
     * @return the list o tables filled with the student
     * 
     */
    public List<Table> printResult(List<Student> students, List<Table> tables, Integer firstPriority, Integer secondPriority, Integer type){
		
    	int studentPerTable = (students.size()/tables.size())+1;
		int spareStudents = (students.size()%tables.size());
		
		

		// Calculate the total for each Student
		for (Student student : students){
			student.calculateTotal(firstPriority, secondPriority);
		}
		
		// Sort the students by total qualification
        sortList(students);
        
        // Distribute the children
     	if (type == 1){
     		tables = distributeHomogeneous(tables, students, studentPerTable, spareStudents);
     	}else{
     		tables =distributeHeterogeneous(tables, students, studentPerTable, spareStudents);
     	}
    	
    	return tables;
    }

}
