import java.util.List;

public class SuperManager extends Component implements Parkable {
    private final List<ParkingLot> parkingLots;
    private final List<Parkable> managers;

    public SuperManager(List<ParkingLot> parkingLots, List<Parkable> managers) {
        this.parkingLots = parkingLots;
        this.managers = managers;
    }

    @Override
    public Ticket parkCar(Car car) {
        for (Parkable manager : this.managers) {
            return manager.parkCar(car);
        }
        return null;
    }

    @Override
    public Car getCar(Ticket ticket) {
        for (Parkable manager : this.managers) {
            return manager.getCar(ticket);
        }
        return null;
    }

    @Override
    public void add(Parkable parkable) {
        managers.add(parkable);
    }

    @Override
    public void remove(Parkable parkable) {
        managers.remove(parkable);
    }

    @Override
    public Parkable getChild(int number) {
        return (Parkable) managers.get(number);
    }

    @Override
    public void printResult() {
        System.out.print("--SuperManager:  ");
        for (Parkable manager : managers) {
            System.out.print("\n----");
            manager.printResult();
        }
        for (ParkingLot parkingLot : parkingLots) {
            System.out.print("\n----");
            parkingLot.printResult();
        }
    }
}
