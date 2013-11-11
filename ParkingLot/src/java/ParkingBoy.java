import java.util.ArrayList;
import java.util.List;

public class ParkingBoy implements Parkable {
    private List<Parkable> parkables = new ArrayList<Parkable>();

    @Override
    public Ticket parkCar(Car car) {
        for (Parkable parkable : parkables) {
            return parkable.parkCar(car);
        }
        return null;
    }

    @Override
    public Car getCar(Ticket ticket) {
        for (Parkable parkable : parkables) {
            Car car = parkable.getCar(ticket);
            return car;
        }
        return null;
    }

    @Override
    public void add(Parkable parkable) {
        parkables.add(parkable);
    }

    @Override
    public void remove(Parkable parkable) {
        parkables.remove(parkable);
    }

    @Override
    public Parkable getChild(int number) {
        return parkables.get(number);
    }

    @Override
    public void printResult() {
        System.out.print("ParkingBoy:  \n");
        for (Parkable parkable : parkables) {
            System.out.print("--");
            parkable.printResult();
        }
    }
}
