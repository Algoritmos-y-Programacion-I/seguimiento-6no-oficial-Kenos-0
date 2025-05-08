package model;

public class Student {
    private String id;
    private double[] grades;

    public Student(String id, int totalGrades) {
        this.id = id;
        this.grades = new double[totalGrades];
    }

    public void setGrade(int gradeNumber, double grade) {
        grades[gradeNumber] = grade;
    }

    public double getGrade(int gradeNumber) {
        return grades[gradeNumber];
    }

    public String getId() {
        return id;
    }

    public int countSubmittedGrades() {
        int count = 0;
        for (double g : grades) {
            if (g > 0) count++;
        }
        return count;
    }

    public String showGrades() {
        String result = "";
        for (double g : grades) {
            result += g + " ";
        }
        return result.trim();
    }
}