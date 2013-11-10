import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestManager {
    private ParkingLot parkingLot;
    private ParkingLot parkingLotTwo;
    private List<ParkingLot> parkingLots;
    private List<ParkingLot> parkingLotsTwo;
    private SmartParkingBoy smartParkingBoy;
    private List<Parkable> parkingBoys;
    private Manager manager;

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
        parkingBoys.add(manager);
        manager = new Manager(parkingLotsTwo, parkingBoys);
    }

    @Test
    public void shouldAskParkingBoyToPark() throws Exception {
        Car car = new Car(001);

        Ticket ticket = manager.parkCar(car);

        assertThat(car, is(manager.getCar(ticket)));
    }
}
