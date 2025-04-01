public class Bicycle extends Vehicle implements Breakable {
    public Bicycle(String model, int speed) {
        super(model, speed);
    }

    @Override
    public boolean isBroken() {
        return Math.random() <= 0.25;
    }

    @Override
    public void move() {
        if (!isBroken()) super.move();
    }
}