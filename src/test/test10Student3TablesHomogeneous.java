package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code.Student;
import code.Table;
import code.Utilities;

public class test10Student3TablesHomogeneous {

	@Test
	public void test() {
		
		Utilities u = new Utilities();
		
		// Create 10 Students
		Student s1 = new Student("Saray", 3, 3, 3);
		Student s2 = new Student("Daniel", 3, 3, 3);
		Student s3 = new Student("Carlos", 3, 3, 3);
		Student s4 = new Student("Ariana", 2, 3, 1);
		Student s5 = new Student("Juan", 2, 2, 1);
		Student s6 = new Student("Alba", 1, 2, 3);
		Student s7 = new Student("Jorge", 2, 1, 3);
		Student s8 = new Student("Luna", 1, 1, 2);
		Student s9 = new Student("Luis", 1, 3, 1);
		Student s10 = new Student("Javi", 1, 1, 3);
		
		// Add Student to List
		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		students.add(s7);
		students.add(s8);
		students.add(s9);
		students.add(s10);
		
		// Create 3 tables 
		Table table1 = new Table();
		Table table2 = new Table();
		Table table3 = new Table();
		
		// Add the tables to the list
		List<Table> tables = new ArrayList<Table>();
		tables.add(table1);
		tables.add(table2);
		tables.add(table3);
		
		// Select priorities
		int firstPriority = 3;
		int secondPriority = 2;
		
		// Select an homogeneous typeOfGroup
		int type = 1;
		
		// Call the method and store the result in tables
		List<Table> tables2 = u.printResult(students, tables, firstPriority, secondPriority, type);
		
		// Check if there are the same number of tables
		assertEquals(3, tables2.size());
		
		// Check if the list of student is the same
		List<Student> students2 = new ArrayList<Student>();
		for (Table t : tables2){
			students2.addAll(t.getStudents());
		}
		assertEquals(students.containsAll(students2), students2.containsAll(students));
		
		// Check if the difference between number of student per table is less than 1
		int min = 100;
		int max = 0;
		for (Table t : tables2){
			if (t.getStudents().size()>max){
				max = t.getStudents().size();
			}
			if (t.getStudents().size()<min){
				min = t.getStudents().size();
			}
		}
		assertTrue((-1<(max-min) && 2>(max-min)));
		
		// Check if the result is homogeneous
		Table table1Sorted = new Table();
		table1Sorted.addStudent(s1);
		table1Sorted.addStudent(s2);
		table1Sorted.addStudent(s3);
		table1Sorted.addStudent(s6);
		
		Table table2Sorted = new Table();
		table2Sorted.addStudent(s7);
		table2Sorted.addStudent(s10);
		table2Sorted.addStudent(s4);
		
		Table table3Sorted = new Table();
		table3Sorted.addStudent(s9);
		table3Sorted.addStudent(s5);
		table3Sorted.addStudent(s8);
		
		assertEquals(table1Sorted.getStudents().containsAll(tables2.get(0).getStudents()), tables2.get(0).getStudents().containsAll(table1Sorted.getStudents()));
		assertEquals(table2Sorted.getStudents().containsAll(tables2.get(1).getStudents()), tables2.get(1).getStudents().containsAll(table2Sorted.getStudents()));
		assertEquals(table3Sorted.getStudents().containsAll(tables2.get(2).getStudents()), tables2.get(2).getStudents().containsAll(table3Sorted.getStudents()));
		
	}

}
