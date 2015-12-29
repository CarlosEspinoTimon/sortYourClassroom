package code;

/**
 * @author Carlos Espino Timón
 *
 */
public class Student  {
	
	/** attributes definition */
	
	private String name;
	private int autonomy;
	private int behavior;
	private int capacity;
	private int total;
	
	
	/** constructor definition */
	
	public Student(String name){
		this.name = name;
		this.autonomy = 0;
		this.behavior = 0;
		this.capacity = 0;
		this.total = 0;
	}
	public Student(String name, int a, int b, int c){
		this.name = name;
		this.autonomy = a;
		this.behavior = b;
		this.capacity = c;
		this.total = 0;
	}
	
	/** method definition */
	
	public String getName(){
		return this.name;
	}
	
	public int getAutonomy(){
		return this.autonomy;
	}
	
	public void setAutonomy(int autonomy){
		this.autonomy = autonomy;
	}
	
	public int getBehavior(){
		return this.behavior;
	}
	
	public void setBehavior(int behavior){
		this.behavior = behavior;
	}
	
	public int getCapacity(){
		return this.capacity;
	}
	
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}
	
	public int getTotal(){
		return this.total;
	}
	
	public void setTotal(int total){
		this.total = total;
	}
	
	/**
	 *  This function calculates the total mark of the child
	 *
	 */
	public void calculateTotal(int first, int second){
		switch (first){
			case 1:
				this.autonomy = this.autonomy * 3;
				break;
			case 2:
				this.behavior = this.behavior * 3;
				break;
			case 3:
				this.capacity = this.capacity * 3;
				break;
		}
		switch (second){
			case 1:
				this.autonomy = this.autonomy * 2;
				break;
			case 2:
				this.behavior = this.behavior * 2;
				break;
			case 3:
				this.capacity = this.capacity * 2;
				break;
		}
		
		this.total = getAutonomy() + getBehavior() + getCapacity();
	}
	
	
	public int compareTo(Object o) {
		Student student = (Student)o;        
		return (this.getTotal() - student.getTotal());     
    }
   
}
