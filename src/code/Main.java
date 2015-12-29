package code;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Carlos Espino Timón
 *
 */
public class Main{
	
	public static int numStudent;
	
	public int getNumStudent(){
		return numStudent;
	}
	/**
     * MAIN method
     * 
     * @param args
     */
    public static void main(String[] args) {
		
    	
    	
    	// Start the Utilities class
		Utilities u = new Utilities();
		
		// List of students
		List<Student> allStudents = new ArrayList<Student>();
		
		// List of tables
		List<Table> allTables = new ArrayList<Table>();
		
		System.out.println("-----------------------------------------------");
    	System.out.println("Este programa ayuda a dividir a los alumnos de una clase\n"+
							"en grupos, en función de información ofrecida por la maestra,\n"+ 
							"permitiendo separar a los alumnos de manera homogénea o heterogénea\n");
		
		// Obtain the number of student
		System.out.println("-----------------------------------------------");
		System.out.println("¿Cuántos niños tiene la clase?");
    	numStudent = u.getNumber(); 
    	
    	// Add all the students
    	System.out.println("Este programa valora al alumno segun 3 criterios:\n"+
							"Autonomia (3=autonomo, 2=Semiautonomo, 1=necesita ayuda)\n"+
							"Comportamiento (3=no molesta, 2=molesta un poco, 1=molesta mucho)\n"+
							"Capacidades (3=altas, 2=medias, 1=bajas)\n"+
							"-----------------------------------------------\n");
    	for (int i=0; i<numStudent; i++){
			System.out.println("Niño " + (i+1));
			System.out.println("Nombre: ");
			Student student = new Student(u.getString());
			System.out.println("Autonomía: ");
			student.setAutonomy(u.getQualificationNumber());
			System.out.println("Comportamiento: ");
			student.setBehavior(u.getQualificationNumber());
			System.out.println("Capacidad: ");
			student.setCapacity(u.getQualificationNumber());
			allStudents.add(student);
		}
    	
    	System.out.println("-----------------------------------------------\n"+
    						"¿A qué le das mas prioridad a la hora de colocar a los alumnos?\n"+
							"Autonomia = 1\n"+
							"Comportamiento = 2\n"+
							"Capacitades = 3\n"+
							"\n"+
							"Ordena las prioridades\n");

		// Obtain the priorities for sort the children
		System.out.println("Inserta el número de tu primera prioridad");
		int firstPriority = u.getQualificationNumber(); 
		System.out.println("Inserta el número de tu segunda prioridad");
		int secondPriority = u.getQualificationNumber(); 

		
		// Obtain the number of tables
		System.out.println("¿En cuántas mesas quieres dividir el grupo?");
		int numTables = u.getNumber(); 
		
		// Create the tables
		for (int i=0; i<numTables; i++){
			Table table = new Table();
			allTables.add(table);
		}
		
		// Obtain the way of distribute
		System.out.println("¿Cómo quieres dividir el grupo?  (1 = homogéneo, 2 = heterogéneo)");
		int typeOfGroup = u.getGroup();
		
		allTables = u.printResult(allStudents, allTables, firstPriority, secondPriority, typeOfGroup);
		
		int num = 1;
		for(Table t : allTables){
			System.out.println("Mesa: " + num);
			num++;
			t.printTable();	
		}
    }



	

}
