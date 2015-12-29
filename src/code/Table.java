package code;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Carlos Espino Timón
 *
 */
public class Table {
	
	/** attributes definition */
	
	public List<Student> students;
	
	
	/** constructor definition */
	
	public Table(){
		this.students = new ArrayList<Student>();
	}
	
	/** method definition */
	public void addStudent(Student st){
		students.add(st);
	}
	
	public List<Student> getStudents(){
		return students;
	}
	
	public void printTable(){
		for(Student student : students) {
            System.out.println(student.getName() + "\t" + student.getTotal());
        }
	}
	
}
