import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMWithdrawal {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 5000.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();

            if (pin != CORRECT_PIN) {
                throw new InvalidPinException("Invalid PIN. Access Denied.");
            }

            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();

            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful. Amount withdrawn: " + amount);
        } catch (InvalidPinException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values.");
        } finally {
            System.out.println("Remaining balance: " + balance);
            scanner.close();
        }
    }
}