import java.util.ArrayList;
import java.util.List;

public class ParkingBoy implements Parkable {
    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    @Override
    public Ticket parkCar(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            return parkingLot.parkCar(car);
        }
        return null;
    }

    @Override
    public Car getCar(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.getCar(ticket);
            return car;
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
        System.out.print("ParkingBoy:  ");
        for (ParkingLot parkingLot : parkingLots) {
            System.out.print("\n--------");
            parkingLot.printResult();
        }
    }
}
