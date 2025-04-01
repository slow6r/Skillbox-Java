public class Car extends Vehicle implements Refuellable, Breakable {
    private int fuel = 100;

    public Car(String model, int speed) {
        super(model, speed);
    }

    @Override
    public void refuel() {
        fuel = 100;
    }

    @Override
    public boolean isBroken() {
        return Math.random() <= 0.15;
    }

    @Override
    public void move() {
        if (fuel <= 0) {
            refuel();
            return;
        }
        if (!isBroken()) {
            super.move();
            fuel -= 15;
        }
    }
}