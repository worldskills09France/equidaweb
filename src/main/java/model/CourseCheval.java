package model;

public class CourseCheval {
	private Course course;
	private int classement;

	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getClassement() {
		return classement;
	}
	public void setClassement(int classement) {
		this.classement = classement;
	}
	
	public String toString() {
		return String.format("Prix %s le %s à %s : %d place en %s", course.getPrix(), course.getDate().toString(), course.getVille(), classement, course.getTemps());
	}

}
