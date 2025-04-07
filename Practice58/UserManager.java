import java.util.*;

class User implements Comparable<User> {
    private final String passport;
    private final String name;
    private final int age;

    public User(String passport, String name, int age) {
        this.passport = passport;
        this.name = name;
        this.age = age;
    }

    public String getPassport() { return passport; }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public int compareTo(User other) {
        int ageCompare = Integer.compare(this.age, other.age);
        return ageCompare != 0 ? ageCompare : this.passport.compareTo(other.passport);
    }

    @Override
    public String toString() {
        return String.format("Паспорт: %s, Имя: %s, Возраст: %d", passport, name, age);
    }
}

public class UserManager {
    private final HashMap<String, User> usersByPassport = new HashMap<>();
    private final TreeSet<User> sortedUsers = new TreeSet<>();
    private long totalAge = 0;

    public static void main(String[] args) {
        UserManager manager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду (help для списка команд):");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "in" -> manager.addUser(scanner);
                case "del" -> manager.deleteUser(scanner);
                case "count" -> System.out.println("Количество пользователей: " + manager.usersByPassport.size());
                case "avg" -> manager.printAverageAge();
                case "median" -> manager.printMedianAge();
                case "young" -> manager.printYoungest();
                case "old" -> manager.printOldest();
                case "print" -> sortedPrint(manager.sortedUsers);
                case "help" -> printHelp();
                case "exit" -> {
                    System.out.println("Программа завершена");
                    return;
                }
                default -> System.out.println("Неизвестная команда. Попробуйте снова");
            }
        }
    }

    private void addUser(Scanner scanner) {
        System.out.print("Введите номер паспорта: ");
        String passport = scanner.nextLine().trim();
        
        if (usersByPassport.containsKey(passport)) {
            System.out.println("Пользователь с таким паспортом уже существует");
            return;
        }

        System.out.print("Введите имя: ");
        String name = scanner.nextLine().trim();
        
        int age = -1;
        while (age < 0) {
            System.out.print("Введите возраст: ");
            try {
                age = Integer.parseInt(scanner.nextLine().trim());
                if (age < 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Некорректный возраст. Введите целое неотрицательное число");
            }
        }

        User user = new User(passport, name, age);
        usersByPassport.put(passport, user);
        sortedUsers.add(user);
        totalAge += age;
        System.out.println("Пользователь добавлен");
    }

    private void deleteUser(Scanner scanner) {
        System.out.print("Введите номер паспорта: ");
        String passport = scanner.nextLine().trim();
        
        User user = usersByPassport.remove(passport);
        if (user != null) {
            sortedUsers.remove(user);
            totalAge -= user.getAge();
            System.out.println("Пользователь удалён");
        } else {
            System.out.println("Пользователь не найден");
        }
    }

    private void printAverageAge() {
        if (usersByPassport.isEmpty()) {
            System.out.println("Нет данных о пользователях");
            return;
        }
        System.out.printf("Средний возраст: %.1f%n", (double) totalAge / usersByPassport.size());
    }

    private void printMedianAge() {
        if (usersByPassport.isEmpty()) {
            System.out.println("Нет данных о пользователях");
            return;
        }
        List<Integer> ages = sortedUsers.stream().mapToInt(User::getAge).boxed().toList();
        int middle = ages.size() / 2;
        double median = ages.size() % 2 == 0 
            ? (ages.get(middle - 1) + ages.get(middle)) / 2.0 
            : ages.get(middle);
        System.out.printf("Медиана возраста: %.1f%n", median);
    }

    private void printYoungest() {
        if (sortedUsers.isEmpty()) System.out.println("Нет данных");
        else System.out.println("Самый молодой: " + sortedUsers.first());
    }

    private void printOldest() {
        if (sortedUsers.isEmpty()) System.out.println("Нет данных");
        else System.out.println("Самый старший: " + sortedUsers.last());
    }

    private static void sortedPrint(TreeSet<User> users) {
        if (users.isEmpty()) {
            System.out.println("Нет данных");
            return;
        }
        users.forEach(System.out::println);
    }

    private static void printHelp() {
        System.out.println("""
            Доступные команды:
            in - добавить пользователя
            del - удалить пользователя
            count - количество пользователей
            avg - средний возраст
            median - медиана возраста
            young - самый молодой
            old - самый старший
            print - список всех пользователей
            help - справка
            exit - выход""");
    }
}