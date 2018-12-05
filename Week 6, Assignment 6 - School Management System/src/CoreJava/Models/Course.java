package CoreJava.Models;

public class Course {

	private String name, instructor;
	private int ID;

	public Course() {
		
		this.ID = 0;
		this.name = "";
		this.instructor = "";
	}
	
	public Course(int courseID, String name, String instructor) {
		this.ID = courseID;
		this.name = name;
		this.instructor = instructor;
	}

	public int getID() {
		return ID;
	}

	public void setCourseID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setCourseName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructorName(String instructor) {
		this.instructor = instructor;
	}

}
