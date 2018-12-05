package CoreJava.DAO;

import CoreJava.Models.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	/**
	 * Reads the Students.csv file and returns the data as a List.
	 * @return A list of students.
	 * @author RaynerMDZ.
	 */
    public List<Student> getStudents(){
    	
    	Student student;
    	
    	List<Student> list = new ArrayList<>();

    	String path = "src\\students.csv";
    	
    	try {
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			
			String line = "";
			
			String[] studentInfo;
			
			while ((line = bufferedReader.readLine()) != null) {
				
				studentInfo = line.split(",");
				
				student = new Student();
				student.setEmail(studentInfo[0]);
				student.setName(studentInfo[1]);
				student.setPassword(studentInfo[2]);
				
				list.add(student); 	
            }
			
            bufferedReader.close();

		} catch (Exception e) {
			System.err.println("\nFile does not exists. :(\n");
			System.out.println();
		}	

		return list;
    	
    }

    /**
     * Reads the studentList list and returns the specified student that matches studentEmail.
     * @param studentList : List of all students.
     * @param studentEmail : Email of the student you are looking for.
     * @return A Student object.
     * @author RaynerMDZ.
     */
    public Student getStudentByEmail(List<Student> studentList, String studentEmail) {
    	
    	// Linear search for the student until they both match the email.
    	for (Student student : studentList) {
    		
    		// When the Student is found, returns that student.
    		if (student.getEmail().equalsIgnoreCase(studentEmail)) {
    			
    			return student;
			}
		}
		return null;
    }

    /**
     * Verifies if the credentials are correct.
     * @param studentList : List of all students.
     * @param studentEmail : Student's email.
     * @param studentPass : Student's password.
     * @return A boolean statement.
     * @author RaynerMDZ.
     */
    public boolean validateUser(List<Student> studentList, String studentEmail, String studentPass) {
    	
    	// Iterate over the students list and check if the email and password are correct
    	for (Student student : studentList) {
    		
    		if (student.getEmail().equalsIgnoreCase(studentEmail) && student.getPassword().equalsIgnoreCase(studentPass)) {
				
    			return true;
			}
		}
		return false;
    }
}
