package model;

public class Controller {
    
    private Course course;

    public Controller() {
        this.course = new Course(5, 0.0, 5.0, 3);
    }

    public void enrollStudent(String id) throws Exception {
        course.enroll(id);
    }

    public void cancelEnrollment(String id) throws Exception {
        course.cancelEnrollment(id);
    }

    public void assignGrade(String id, int gradeNumber, double grade) throws Exception {
        course.setStudentGrade(id, gradeNumber, grade);
    }

    public String getStudentGrades(String id) throws Exception {
        return course.showStudentGrades(id);
    }

    public void advanceWeek() {
        course.advanceWeek();
    }
}