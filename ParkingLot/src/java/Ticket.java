public class Ticket {
    private int lotId;
    private int carId;

    public Ticket(int carId) {
        this.carId = carId;

    }

    public Ticket(int carId, int lotId) {
        this.carId = carId;
        this.lotId = lotId;
    }

    public int getLotId() {
        return lotId;
    }

    public int getCarId() {
        return carId;
    }
}
