public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Alice", 30);
        Person person3 = new Person("Bob", 25);

        System.out.println("person1.equals(person2): " + person1.equals(person2)); // true
        System.out.println("person1.equals(person3): " + person1.equals(person3)); // false
        System.out.println("Хеш-код person1: " + person1.hashCode());
        System.out.println("Хеш-код person2: " + person2.hashCode());
        System.out.println("Информация о person1: " + person1.toString());

        double earthRadius = 6371.0; // Радиус Земли в километрах
        System.out.println("\nЗначение PI: " + MathUtils.PI);
        System.out.println(
                "Площадь поверхности Земли: " +
                        String.format("%.2f", MathUtils.calculateSurfaceArea(earthRadius)) + " км²"
        );
        System.out.println(
                "Длина экватора Земли: " +
                        String.format("%.2f", MathUtils.calculateEquatorLength(earthRadius)) + " км"
        );
    }
}