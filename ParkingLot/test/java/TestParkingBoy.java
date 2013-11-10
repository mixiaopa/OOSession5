import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestParkingBoy {

    private ParkingBoy parkingBoy;
    private ParkingLot parkingLot;
    private List<ParkingLot> parkingLots;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(10, 1);
        parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot);
        parkingBoy = new ParkingBoy(parkingLots);
    }

    @Test
    public void shouldParkCarAndChangeStatusForLot() throws Exception {
        Car car = new Car(001);

        Ticket ticket = parkingBoy.parkCar(car);

        assertThat(ticket.getCarId(), is(car.getId()));
        assertThat(parkingLot.getLeftLots(), is(9));
    }

    @Test
    public void shouldParkTwoCarsInLot() throws Exception {
        Car car = new Car(001);
        Car carTwo = new Car(002);

        Ticket ticket = parkingBoy.parkCar(car);
        Ticket ticketTwo = parkingBoy.parkCar(carTwo);

        assertThat(ticket.getCarId(), is(car.getId()));
        assertThat(ticketTwo.getCarId(), is(carTwo.getId()));
        assertThat(parkingLot.getLeftLots(), is(8));
    }

    @Test
    public void shouldParkTwoCarsAndGetCarsInLot() throws Exception {
        Car car = new Car(001);
        Car carTwo = new Car(002);

        Ticket ticket = parkingBoy.parkCar(car);
        Ticket ticketTwo = parkingBoy.parkCar(carTwo);

        assertThat(ticket.getCarId(), is(car.getId()));
        assertThat(ticketTwo.getCarId(), is(carTwo.getId()));
        assertThat(parkingLot.getLeftLots(), is(8));
        assertThat(car, is(parkingBoy.getCar(ticket)));
        assertThat(carTwo, is(parkingBoy.getCar(ticketTwo)));
    }
}
