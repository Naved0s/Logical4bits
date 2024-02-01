import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nSelect operation: \n1. Fibonacci Series\n2. Prime Factors\n3. Palindrome Checker\n4. Armstrong Number Checker\n5. Factorial Calculator\n6. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the number of terms for Fibonacci series:");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print(fibonacci(i) + " ");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter a number to find its prime factors:");
                    int num = scanner.nextInt();
                    primeFactors(num);
                    break;
                case 3:
                    System.out.println("Enter a string to check if it's a palindrome:");
                    String str = scanner.nextLine();
                    str = scanner.nextLine();
                    System.out.println(isPalindrome(str) ? "It's a palindrome" : "It's not a palindrome");
                    break;
                case 4:
                    System.out.println("Enter a number to check if it's an Armstrong number:");
                    int num2 = scanner.nextInt();
                    System.out.println(isArmstrong(num2) ? "It's an Armstrong number" : "It's not an Armstrong number");
                    break;
                case 5:
                    System.out.println("Enter a number to calculate its factorial:");
                    int num3 = scanner.nextInt();
                    System.out.println("Factorial: " + factorial(num3));
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 6);
    }

    private static int fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static void primeFactors(int n) {
        int i;
        for (i = 2; i <= n; i++) {
            while ((n % i) == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }
        System.out.println();
    }

    private static boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isArmstrong(int num) {
        int originalNum, remainder, result = 0, n = 0;
        originalNum = num;
        while (originalNum != 0) {
            originalNum /= 10;
            ++n;
        }
        originalNum = num;
        while (originalNum != 0) {
            remainder = originalNum % 10;
            result += Math.pow(remainder, n);
            originalNum /= 10;
        }
        return result == num;
    }

    private static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
