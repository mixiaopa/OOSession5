import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestSuperManager {
    private ParkingLot parkingLot;
    private ParkingLot parkingLotTwo;
    private SmartParkingBoy smartParkingBoy;
    private List<Parkable> parkingBoys;
    private Manager manager;
    private SuperManager superManager;
    private ParkingLot parkingLotThree;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(10, 1);
        smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.add(parkingLot);

        parkingBoys = new ArrayList<Parkable>();
        parkingBoys.add(smartParkingBoy);
        manager = new Manager(parkingBoys);
        parkingLotTwo = new ParkingLot(2, 2);
        manager.add(parkingLotTwo);

        parkingLotThree = new ParkingLot(10, 3);
        superManager = new SuperManager();
        superManager.add(parkingLotThree);
        superManager.add(manager);
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
