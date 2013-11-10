import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestSmartParkingBoy {
    private SmartParkingBoy smartParkingBoy;
    private ParkingLot parkingLot;
    private ParkingLot parkingLotTwo;
    private List<ParkingLot> parkingLots;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(10, 1);
        parkingLotTwo = new ParkingLot(2, 2);
        parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot);
        parkingLots.add(parkingLotTwo);
        smartParkingBoy = new SmartParkingBoy(parkingLots);
    }

    @Test
    public void shouldParkToLotWithLessUsage() throws Exception {
        Car car = new Car(001);
        Car carTwo = new Car(002);

        parkingLot.parkCar(carTwo);
        Ticket ticket = smartParkingBoy.parkCar(car);

        assertThat(parkingLotTwo.getLeftLots(), is(1));
        assertThat(ticket.getLotId(), is(2));
        assertThat(parkingLot.getLeftLots(), is(9));
        assertThat(car, is(smartParkingBoy.getCar(ticket)));
    }

    @Test
    public void shouldParkTwoCarToLotWithLessUsage() throws Exception {
        Car car = new Car(001);
        Car carTwo = new Car(002);
        Car carThree = new Car(003);
        parkingLot.parkCar(carThree);

        Ticket ticket = smartParkingBoy.parkCar(car);
        Ticket ticketTwo = smartParkingBoy.parkCar(carTwo);

        assertThat(ticket.getLotId(), is(2));
        assertThat(ticketTwo.getLotId(), is(1));
        assertThat(parkingLotTwo.getLeftLots(), is(1));
        assertThat(parkingLot.getLeftLots(), is(8));
        assertThat(car, is(smartParkingBoy.getCar(ticket)));
        assertThat(carTwo, is(smartParkingBoy.getCar(ticketTwo)));
    }
}
