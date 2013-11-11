import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestManager {
    private ParkingLot parkingLot;
    private ParkingLot parkingLotTwo;
    private SmartParkingBoy smartParkingBoy;
    private List<Parkable> parkingBoys;
    private Manager manager;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(10, 1);
        smartParkingBoy = new SmartParkingBoy();
        smartParkingBoy.add(parkingLot);

        parkingLotTwo = new ParkingLot(2, 2);

        parkingBoys = new ArrayList<Parkable>();
        parkingBoys.add(smartParkingBoy);
        parkingBoys.add(manager);

        manager = new Manager(parkingBoys);
        manager.add(parkingLotTwo);
    }

    @Test
    public void shouldAskParkingBoyToPark() throws Exception {
        Car car = new Car(001);

        Ticket ticket = manager.parkCar(car);

        assertThat(car, is(manager.getCar(ticket)));
    }
}
