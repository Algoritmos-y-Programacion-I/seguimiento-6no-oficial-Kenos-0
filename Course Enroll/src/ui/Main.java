package ui;

import model.Controller;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Controller controller = new Controller();
        int option;

        do {
            System.out.println("\n1. Matricular estudiante\n2. Cancelar matrícula\n3. Asignar nota\n4. Ver notas\n5. Avanzar semana\n0. Salir");
            option = Integer.parseInt(scanner.nextLine());

            try {
                switch (option) {
                    case 1:
                        System.out.print("ID del estudiante: ");
                        controller.enrollStudent(scanner.nextLine());
                        break;
                
                    case 2:
                        System.out.print("ID del estudiante: ");
                        controller.cancelEnrollment(scanner.nextLine());
                        System.out.println("Matrícula cancelada exitosamente.");
                        break;
                
                    case 3:
                        System.out.print("ID del estudiante: ");
                        String id = scanner.nextLine();
                        System.out.print("Número de nota: ");
                        int gradeNumber = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nota: ");
                        double grade = Double.parseDouble(scanner.nextLine());
                        controller.assignGrade(id, gradeNumber, grade);
                        break;
                
                    case 4:
                        System.out.print("ID del estudiante: ");
                        System.out.println(controller.getStudentGrades(scanner.nextLine()));
                        break;
                
                    case 5:
                        controller.advanceWeek();
                        System.out.println("Semana avanzada.");
                        break;
                
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                
                    default:
                        System.out.println("Opción no válida.");
                }
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }
}