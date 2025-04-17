public class Station {
    private String name;
    private String lineNumber;

    // Конструкторы, геттеры, сеттеры
    @Override
    public String toString() {
        return name + " (" + lineNumber + ")";
    }
}