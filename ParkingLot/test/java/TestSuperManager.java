import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestSuperManager {
    private ParkingLot parkingLot;
    private ParkingLot parkingLotTwo;
    private SmartParkingBoy smartParkingBoy;
    private Manager manager;
    private Manager manager1;
    private ParkingLot parkingLotThree;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(10, 1);
        smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.add(parkingLot);

        parkingLotTwo = new ParkingLot(2, 2);

        manager = new Manager();
        manager.add(parkingLotTwo);
        manager.add(smartParkingBoy);

        parkingLotThree = new ParkingLot(10, 3);
        manager1 = new Manager();
        manager1.add(parkingLotThree);
        manager1.add(manager);
    }

    @Test
    public void shouldAskParkingBoyToPark() throws Exception {
        Car car = new Car(001);

        Ticket ticket = manager1.parkCar(car);

        assertThat(car, is(manager1.getCar(ticket)));
    }

    @Test
    public void shouldPrintOutResult() throws Exception {
        Car car = new Car(001);

        Ticket ticket = manager1.parkCar(car);
        manager1.printResult();

        assertThat(car, is(manager1.getCar(ticket)));
    }
}
