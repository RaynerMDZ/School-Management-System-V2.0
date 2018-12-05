package CoreJava.DAO;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AttendingDAO {

	/**
	 * This method gets all the attending courses.
	 * @return A list of attending courses.
	 * @author RaynerMDZ
	 */
    public List<Attending> getAttending() {
    	
    	List<Attending> list = new ArrayList<>();

    	String path = "src\\attending.csv";
    	
    	try {
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			
			String line = "";
			
			String[] attendingInfo;
			
			while ((line = bufferedReader.readLine()) != null) {
				
				attendingInfo = line.split(",");
				
				Attending attending = new Attending();
				
				attending.setCourseID(Integer.parseInt(attendingInfo[0]));
				attending.setStudentEmail(attendingInfo[1]);
				
				list.add(attending); 	
            }
			
            bufferedReader.close();

		} catch (Exception e) {
			System.err.println("\nFile does not exists. :(\n");
			System.out.println();
		}	
    	
		return list;
    }

    /**
     * This method register a student to a course.
     * @param attendings : List of all attending courses.
     * @param studentEmail : Student email.
     * @param courseID : Course ID.
     * @author RaynerMDZ.
     */
    public void registerStudentToCourse(List<Attending> attendings, String studentEmail, int courseID) {
    	
    	// Iterating through the attending list.
    	for (Attending attending : attendings) {
			
    		// Checks if the student email and course id are inside the list.
    		if (attending.getStudentEmail().equalsIgnoreCase(studentEmail) && attending.getCourseID() == courseID) {
    			
    			// If this condition is met then exits the method.
    			return;
			}
		}
    	
    	// Otherwise do this.
    	
    	// Creates a new attending object.
    	Attending attending2 = new Attending();
    	
    	// Fills the object with new data.
		attending2.setCourseID(courseID);
		attending2.setStudentEmail(studentEmail);
		
		// Add the object to a list.
		attendings.add(attending2);
		
		// Saves the list with the new update.
		saveAttending(attendings);	
    }

    /**
     * This method gets the students attending to a specific course.
     * @param courseList : List of all courses available.
     * @param attendings : List of all attending courses.
     * @param studentEmail : Student email.
     * @return A list of courses.
     * @author RaynerMDZ
     */
    public List<Course> getStudentCourses(List<Course> courseList, List<Attending> attendings, String studentEmail) {
    	
    	// Creates a new list of Course class.
    	List<Course> newList = new ArrayList<Course>();

    	// Iterating over the attending list.
    	for (Attending attending : attendings) {
    		
    		// Checks if this condition is true.
    		if (attending.getStudentEmail().equalsIgnoreCase(studentEmail)) {
    			
    			// Iterating over the Course list.
    			for (Course course : courseList) {
					
    				// If this condition is met then adds the course to the newList.
    				if (course.getID() == attending.getCourseID()) {
						
    					newList.add(course);
					}	
				}	
			}	
		}
    	return newList;
    }

    /**
     * This method saves the new attending courses to a file.
     * @param attending
     * @author RaynerMDZ
     */
    public void saveAttending(List<Attending> attending) {
		
		String path = "src\\attending.csv";
		
		FileWriter fileWriter;

		try {

			fileWriter = new FileWriter(path);

			for (Attending attending2 : attending) {

				fileWriter.write(attending2.getCourseID() + "," + attending2.getStudentEmail() + "\r\n");
			}

			fileWriter.close();

		} catch (IOException e) {
			System.err.println("\nFile does not exists. :(\n");
		}
    }

}
