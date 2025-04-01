public abstract class Vehicle {
    protected String model;
    protected int speed;
    protected int x;

    public Vehicle(String model, int speed) {
        this.model = model;
        this.speed = speed;
        this.x = 0;
    }

    public void move() {
        x += speed;
    }

    public int getX() {
        return x;
    }
}