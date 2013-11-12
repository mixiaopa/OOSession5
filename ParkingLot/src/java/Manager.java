import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy {
    private List<Parkable> parkables = new ArrayList<Parkable>();

    @Override
    public Ticket parkCar(Car car) {
        for (Parkable parkable : this.parkables) {
            return parkable.parkCar(car);
        }
        return null;
    }

    @Override
    public Car getCar(Ticket ticket) {
        for (Parkable parkable : this.parkables) {
            return parkable.getCar(ticket);
        }
        return null;
    }

    @Override
    public void add(Parkable parkable) {
        parkables.add(parkable);
    }

    @Override
    public String printResult(String prefix) {
        String result = prefix + "Manager:  \n";
        System.out.print(result);
        prefix += "--";
        for (Parkable parkable : parkables) {
            result += parkable.printResult(prefix);
        }
        return result;
    }
}
