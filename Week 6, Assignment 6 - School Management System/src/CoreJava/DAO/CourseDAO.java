package CoreJava.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import CoreJava.Models.Course;

public class CourseDAO {
	
	/**
	 * This method returns a list with all courses from a .csv file.
	 * @return A list of courses.
	 * @author RaynerMDZ
	 */
    public List<Course> getAllCourses() {

    	List<Course> list = new ArrayList<>();

    	String path = "src\\courses.csv";
    	
    	try {
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			
			String line = "";
			
			String[] courseInfo;
			
			while ((line = bufferedReader.readLine()) != null) {
				
				courseInfo = line.split(",");
				
				Course course = new Course();
				course.setCourseID(Integer.parseInt(courseInfo[0]));
				course.setCourseName(courseInfo[1]);
				course.setInstructorName(courseInfo[2]);
				
				list.add(course); 	
            }
			
            bufferedReader.close();

		} catch (Exception e) {
			System.err.println("\nFile does not exists. :(\n");
			System.out.println();
		}	
    	
		return list;
    	
    }
}
