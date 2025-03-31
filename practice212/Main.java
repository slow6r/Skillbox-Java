import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

enum OperationType {
    INCOME, EXPENSE
}

record Transaction(String description, double amount, OperationType type, LocalDate date) {}

class FinancialAccounting {
    private final List<Transaction> allTransactions = new ArrayList<>();
    private final Transaction[] lastTransactions = new Transaction[5];
    private int lastTransactionsCount = 0;

    public void addTransaction(Transaction transaction) {
        allTransactions.add(transaction);
        updateLastTransactions(transaction);
    }

    private void updateLastTransactions(Transaction transaction) {
        if (lastTransactionsCount < 5) {
            lastTransactions[lastTransactionsCount++] = transaction;
        } else {
            System.arraycopy(lastTransactions, 1, lastTransactions, 0, 4);
            lastTransactions[4] = transaction;
        }
    }

    public double getTotalIncome() {
        return allTransactions.stream()
                .filter(t -> t.type() == OperationType.INCOME)
                .mapToDouble(Transaction::amount)
                .sum();
    }

    public double getTotalExpense() {
        return allTransactions.stream()
                .filter(t -> t.type() == OperationType.EXPENSE)
                .mapToDouble(Transaction::amount)
                .sum();
    }

    public double getBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    public Transaction[] getLastTransactions() {
        return Arrays.copyOf(lastTransactions, lastTransactionsCount);
    }
}

class UserMenu {
    private final FinancialAccounting accounting = new FinancialAccounting();
    private final Scanner scanner = new Scanner(System.in);
    private boolean isRunning = true;

    public void start() {
        printHelp();
        while (isRunning) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            processInput(input);
        }
        scanner.close();
    }

    private void processInput(String input) {
        if (input.equalsIgnoreCase("HELP")) {
            printHelp();
        } else if (input.equalsIgnoreCase("REPORT")) {
            printReport();
        } else if (input.equalsIgnoreCase("EXIT")) {
            printReport();
            isRunning = false;
        } else if (!input.isEmpty()) {
            processTransaction(input);
        }
    }

    private void processTransaction(String input) {
        String[] parts = input.split(";");
        if (parts.length != 4) {
            System.out.println("Ошибка: неверный формат.");
            return;
        }
        try {
            String desc = parts[0].trim();
            double amount = Double.parseDouble(parts[1].trim());
            OperationType type = OperationType.valueOf(parts[2].trim().toUpperCase());
            LocalDate date = LocalDate.parse(parts[3].trim(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            accounting.addTransaction(new Transaction(desc, amount, type, date));
            System.out.println("Добавлено: " + desc);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void printHelp() {
        System.out.println("""
            Команды:
            HELP - справка
            REPORT - отчёт
            EXIT - выход
            Формат ввода: Описание; Сумма; Тип; Дата(дд.мм.гггг)
            Пример: Билет на Марс; 2499.99; EXPENSE; 24.03.2036
            """);
    }

    private void printReport() {
        System.out.printf("Общий доход: %.2f%n", accounting.getTotalIncome());
        System.out.printf("Общие расходы: %.2f%n", accounting.getTotalExpense());
        System.out.printf("Баланс: %.2f%n%n", accounting.getBalance());
        System.out.println("Последние транзакции:");
        printTransactionsTable();
    }

    private void printTransactionsTable() {
        System.out.println("------------------------------------------------------------");
        System.out.printf("| %-12s | %-10s | %-8s | %-30s |%n", "Дата", "Сумма", "Тип", "Описание");
        System.out.println("------------------------------------------------------------");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        for (Transaction t : accounting.getLastTransactions()) {
            System.out.printf("| %-12s | %-10.2f | %-8s | %-30s |%n",
                    t.date().format(formatter),
                    t.amount(),
                    t.type(),
                    t.description());
        }
        System.out.println("------------------------------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        new UserMenu().start();
    }
}