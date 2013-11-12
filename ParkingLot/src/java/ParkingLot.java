import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements Parkable {
    private int leftLots;
    private List<Car> parkedCars;
    private int size;
    private int id;

    public ParkingLot(int size, int id) {
        this.size = size;
        this.leftLots = size;
        this.id = id;
        this.parkedCars = new ArrayList<Car>();
    }

    @Override
    public Ticket parkCar(Car car) {
        parkedCars.add(car);
        leftLots--;
        return new Ticket(car.getId());
    }

    public int getLeftLots() {
        return leftLots;
    }

    @Override
    public Car getCar(Ticket ticket) {
        leftLots++;
        int carId = ticket.getCarId();
        for (Car parkedCar : parkedCars) {
            if (parkedCar.getId() == carId) {
                return parkedCar;
            }
        }
        return null;
    }

    @Override
    public void add(Parkable parkable) {
        parkedCars.add((Car) parkable);
    }

    @Override
    public void remove(Parkable parkable) {
        parkedCars.remove(parkable);
    }

    @Override
    public Parkable getChild(int number) {
        return (Parkable) parkedCars.get(number);
    }

    @Override
    public String printResult(String prefix) {
        String result = prefix + "ParkingLot" +
                this.id + ": ( " + this.leftLots + " / " + this.size + " )\n";
        System.out.print(result);
        return result;
    }

    public int getSize() {
        return size;
    }

    public int getId() {
        return id;
    }
}
