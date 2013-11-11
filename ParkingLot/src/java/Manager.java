import java.util.ArrayList;
import java.util.List;

public class Manager extends Component implements Parkable {
    private final List<Parkable> parkingBoys;
    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    public Manager(List<Parkable> parkingBoys) {
        this.parkingBoys = parkingBoys;
    }

    @Override
    public Ticket parkCar(Car car) {
        for (Parkable parkingBoy : parkingBoys) {
            return parkingBoy.parkCar(car);
        }
        return null;
    }

    @Override
    public Car getCar(Ticket ticket) {
        for (Parkable parkingBoy : parkingBoys) {
            return parkingBoy.getCar(ticket);
        }
        return null;
    }

    @Override
    public void add(Parkable parkable) {
        parkingLots.add((ParkingLot) parkable);
    }

    @Override
    public void remove(Parkable parkable) {
        parkingLots.remove(parkable);
    }

    @Override
    public Parkable getChild(int number) {
        return (Parkable) parkingLots.get(number);
    }

    @Override
    public void printResult() {
        System.out.print("Manager:  ");
        for (Parkable parkingBoy : parkingBoys) {
            System.out.print("\n------");
            parkingBoy.printResult();
        }
        for (ParkingLot parkingLot : parkingLots) {
            System.out.print("\n------");
            parkingLot.printResult();
        }
    }
}
