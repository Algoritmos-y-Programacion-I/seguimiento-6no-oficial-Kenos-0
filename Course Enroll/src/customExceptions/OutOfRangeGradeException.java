package customExceptions;

public class OutOfRangeGradeException extends IllegalArgumentException {
    public OutOfRangeGradeException(double grade) {
        super("Nota fuera de rango: " + grade);
    }
}