import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Expense {
    private String category;
    private double amount;
    private String description;
    private String date;

    public Expense(String category, double amount, String description, String date) {
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Category: " + category + ", Amount: " + amount + ", Description: " + description + ", Date: " + date;
    }
}

class ExpenseTracker {
    private ArrayList<Expense> expenses;
    private Map<String, Double> budgetLimits;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        budgetLimits = new HashMap<>();
    }

    public void addExpense(String category, double amount, String description, String date) {
        Expense expense = new Expense(category, amount, description, date);
        expenses.add(expense);
    }

    public void setBudgetLimit(String category, double limit) {
        budgetLimits.put(category, limit);
    }

    public void displayExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public void displayBudgetLimits() {
        for (Map.Entry<String, Double> entry : budgetLimits.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Budget Limit: " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker expenseTracker = new ExpenseTracker();



        int choice;
        do {
            System.out.println("\nExpense Tracker Application");
            System.out.println("1. Add Expense");
            System.out.println("2. Set Budget Limit");
            System.out.println("3. View Expenses");
            System.out.println("4. View Budget Limits");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    expenseTracker.addExpense(category, amount, description, date);
                    System.out.println("Expense added successfully!");
                    break;
                case 2:
                    System.out.print("Category: ");
                    String categoryLimit = scanner.nextLine();
                    System.out.print("Budget Limit:");
                    double limit = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    expenseTracker.setBudgetLimit(categoryLimit, limit);
                    System.out.println("Budget limit set successfully!");
                    break;
                case 3:
                    System.out.println("\nExpenses:");
                    expenseTracker.displayExpenses();
                    break;
                case 4:
                    System.out.println("\nBudget Limits:");
                    expenseTracker.displayBudgetLimits();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
