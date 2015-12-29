package code;

import java.util.Comparator;
 
/**
 * This comparator compares two student by their total qualifications.
 * @author Carlos Espino Timón
 *
 */
public class StudentComparator implements Comparator<Student> {
 
    @Override
    public int compare(Student es1, Student es2) {
        return es2.getTotal() - es1.getTotal();
    }
}
