import java.util.List;

public class Manager extends Component implements Parkable {
    private final List<ParkingLot> parkingLots;
    private final List<Parkable> parkingBoys;

    public Manager(List<ParkingLot> parkingLots, List<Parkable> parkingBoys) {
        this.parkingLots = parkingLots;
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
        parkingBoys.add(parkable);
    }

    @Override
    public void remove(Parkable parkable) {
        parkingBoys.remove(parkable);
    }

    @Override
    public Parkable getChild(int number) {
        return (Parkable) parkingBoys.get(number);
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
