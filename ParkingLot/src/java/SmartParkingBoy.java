import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends Component implements Parkable {
    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    @Override
    public Ticket parkCar(Car car) {
        ParkingLot comparedLot = parkingLots.get(0);
        for (ParkingLot lot : parkingLots) {
            double percentageForCompared = (double) comparedLot.getLeftLots() / (double) comparedLot.getSize();
            double percentageForLoop = (double) lot.getLeftLots() / (double) lot.getSize();
            if (percentageForCompared <= percentageForLoop) {
                comparedLot = lot;
            }
        }
        comparedLot.parkCar(car);
        return new Ticket(car.getId(), comparedLot.getId());
    }

    @Override
    public Car getCar(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getId() == ticket.getLotId()) {
                return parkingLot.getCar(ticket);
            }
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
        System.out.print("SmartParkingBoy:  ");
        for (ParkingLot parkingLot : parkingLots) {
            System.out.print("\n--------");
            parkingLot.printResult();
        }
    }
}
