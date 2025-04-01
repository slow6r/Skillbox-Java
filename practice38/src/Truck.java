public class Truck extends Vehicle implements Loadable, LimitedResource {
    private int cargoWeight;
    private int resource = 500;

    public Truck(String model, int speed) {
        super(model, speed);
    }

    @Override
    public void loadCargo(int weight) {
        cargoWeight = weight;
        speed = Math.max(1, speed - weight / 50);
    }

    @Override
    public boolean isResourceExhausted() {
        return resource <= 0;
    }

    @Override
    public void move() {
        if (!isResourceExhausted()) {
            super.move();
            resource -= 10;
        }
    }
}