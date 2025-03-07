import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();

            if (num < 0) {
                throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
            }

            double sqrt = Math.sqrt(num);
            System.out.println("Square root of " + num + " is: " + sqrt);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a numeric value.");
        } finally {
            scanner.close();
        }
    }
}
