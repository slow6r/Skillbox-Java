public class Main {
    public static void main(String[] args) {
        Vehicle[] participants = {
                new Bicycle("Велосипед", 12),
                new Car("Автомобиль", 25),
                new Truck("Грузовик", 18)
        };
        ((Truck) participants[2]).loadCargo(200);

        Competition race = new Competition(300);
        Vehicle winner = race.race(participants);
        System.out.println("Победитель: " + winner.model);
    }
}