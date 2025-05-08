package model;

import customExceptions.QuotaEnrollExceedException;
import customExceptions.OutOfRangeGradeException;
import java.util.*;

public class Course {
    private double maxGrade, minGrade;
    private int currentWeek;
    private int totalGradesAmount;
    private int maxQuota;
    private List<Student> studentsEnrolled;

    public Course(int totalGrades, double min, double max, int quota) {
        this.maxGrade = max;
        this.minGrade = min;
        this.totalGradesAmount = totalGrades;
        this.maxQuota = quota;
        this.studentsEnrolled = new ArrayList<>();
        this.currentWeek = 1;
    }

    public void enroll(String id) throws QuotaEnrollExceedException, Exception {
        if (currentWeek > 2) throw new Exception("No se puede matricular después de la semana 2.");
        if (studentsEnrolled.size() >= maxQuota) throw new QuotaEnrollExceedException(maxQuota);
        if (findStudent(id) != null) throw new Exception("Estudiante ya matriculado.");
        studentsEnrolled.add(new Student(id, totalGradesAmount));
    }

    public void cancelEnrollment(String id) throws Exception {
        Student s = findStudent(id);
        if (s == null) throw new Exception("Estudiante no encontrado.");
        if (s.countSubmittedGrades() > totalGradesAmount / 2) {
            throw new Exception("No se puede cancelar. Más del 50% de trabajos enviados.");
        }
        studentsEnrolled.remove(s);
    }

    public void setStudentGrade(String id, int gradeNumber, double grade) throws OutOfRangeGradeException, Exception {
        if (grade > maxGrade || grade < minGrade) throw new OutOfRangeGradeException(grade);
        Student s = findStudent(id);
        if (s == null) throw new Exception("Estudiante no encontrado.");
        s.setGrade(gradeNumber, grade);
    }

    private Student findStudent(String id) {
        return studentsEnrolled.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public void advanceWeek() {
        currentWeek++;
    }

    public String showStudentGrades(String id) throws Exception {
        Student s = findStudent(id);
        if (s == null) throw new Exception("Estudiante no encontrado.");
        return s.showGrades();
    }
}