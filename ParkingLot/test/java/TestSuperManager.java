import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestSuperManager {
    private ParkingLot parkingLot;
    private ParkingLot parkingLotTwo;
    private List<ParkingLot> parkingLots;
    private List<ParkingLot> parkingLotsTwo;
    private List<ParkingLot> parkingLotsThree;
    private SmartParkingBoy smartParkingBoy;
    private List<Parkable> parkingBoys;
    private List<Parkable> managers;
    private Manager manager;
    private SuperManager superManager;
    private ParkingLot parkingLotThree;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(10, 1);
        parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot);

        parkingLotTwo = new ParkingLot(2, 2);
        parkingLotsTwo = new ArrayList<ParkingLot>();
        parkingLotsTwo.add(parkingLotTwo);

        smartParkingBoy = new SmartParkingBoy(parkingLots);

        parkingBoys = new ArrayList<Parkable>();
        parkingBoys.add(smartParkingBoy);
        manager = new Manager(parkingLotsTwo, parkingBoys);

        parkingLotThree = new ParkingLot(10, 3);
        parkingLotsThree = new ArrayList<ParkingLot>();
        parkingLotsThree.add(parkingLotThree);

        managers = new ArrayList<Parkable>();
        managers.add(manager);
        superManager = new SuperManager(parkingLotsThree, managers);
    }

    @Test
    public void shouldAskParkingBoyToPark() throws Exception {
        Car car = new Car(001);

        Ticket ticket = superManager.parkCar(car);

        assertThat(car, is(superManager.getCar(ticket)));
    }

    @Test
    public void shouldPrintOutResult() throws Exception {
        Car car = new Car(001);

        Ticket ticket = superManager.parkCar(car);
        superManager.printResult();

        assertThat(car, is(superManager.getCar(ticket)));
    }
}
