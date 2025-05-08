package customExceptions;

public class QuotaEnrollExceedException extends Exception {
    public QuotaEnrollExceedException(int quota) {
        super("Cupo máximo de " + quota + " estudiantes alcanzado.");
    }
}