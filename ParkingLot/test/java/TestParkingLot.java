import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestParkingLot {
    private ParkingLot parkingLot;

    @Before
    public void setUp() throws Exception {
        parkingLot = new ParkingLot(1000, 1);
    }

    @Test
    public void shouldChangeStatusOfParkingLotWhenNewCarParked() throws Exception {
        Car car = new Car(001);

        parkingLot.parkCar(car);

        assertThat(parkingLot.getLeftLots(), is(999));
    }

    @Test
    public void shouldSetStatusTwiceWhenTwoCarsParked() throws Exception {
        Car car = new Car(001);
        Car carTwo = new Car(002);

        parkingLot.parkCar(car);
        parkingLot.parkCar(carTwo);

        assertThat(parkingLot.getLeftLots(), is(998));
    }

    @Test
    public void shouldSetStatusToLeaveWhenCarLeaveParkingLot() throws Exception {
        Car car = new Car(10000);

        Ticket ticket = parkingLot.parkCar(car);
        Car carBack = parkingLot.getCar(ticket);

        assertThat(car, is(carBack));
        assertThat(parkingLot.getLeftLots(), is(1000));
    }

    @Test
    public void shouldSetStatusToLeaveWhenTwoCarLeaveParkingLot() throws Exception {
        Car car = new Car(10000);
        Car carTwo = new Car(200);

        Ticket ticket = parkingLot.parkCar(car);
        Ticket ticketTwo = parkingLot.parkCar(carTwo);
        Car carBack = parkingLot.getCar(ticket);
        Car carBackTwo = parkingLot.getCar(ticketTwo);

        assertThat(car, is(carBack));
        assertThat(carTwo, is(carBackTwo));
        assertThat(ticket.getCarId(), is(car.getId()));
        assertThat(ticketTwo.getCarId(), is(carTwo.getId()));
        assertThat(parkingLot.getLeftLots(), is(1000));
    }

}
