public class Competition {
    private final int distance;

    public Competition(int distance) {
        this.distance = distance;
    }

    public Vehicle race(Vehicle[] vehicles) {
        while (true) {
            for (Vehicle v : vehicles) {
                v.move();
                if (v.getX() >= distance) return v;
            }
        }
    }
}