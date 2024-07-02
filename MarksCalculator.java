import java.util.Scanner;
public class MarksCalculator {

    public static double calculateTotal(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }
    public static double calculateAverage(double total, int numSubjects) {
        return total / numSubjects;
    }
    public static String determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        double[] marks = new double[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextDouble();
        }
        double totalMarks = calculateTotal(marks);
        double averagePercentage = calculateAverage(totalMarks, numSubjects);
        String grade = determineGrade(averagePercentage);
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}
