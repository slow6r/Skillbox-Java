import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> numberCounts = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        System.out.println("Введите целые числа (для завершения введите пустую строку):");

        while (true) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;

            try {
                int number = Integer.parseInt(input);
                numberCounts.put(number, numberCounts.getOrDefault(number, 0) + 1);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не целое число. Попробуйте снова.");
            }
        }

        int sumUnique = 0;
        Set<Integer> seenDuplicates = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : numberCounts.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();

            if (count == 1) {
                sumUnique += number;
            } else if (!seenDuplicates.contains(number)) {
                duplicates.add(number);
                seenDuplicates.add(number);
            }
        }

        System.out.println("Сумма уникальных чисел: " + sumUnique);
        System.out.println("Повторяющиеся числа: " + duplicates);
    }
} 