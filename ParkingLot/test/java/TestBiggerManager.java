import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestBiggerManager {
    private ParkingLot parkingLot;
    private ParkingLot parkingLotTwo;
    private SmartParkingBoy smartParkingBoy;
    private Manager manager;
    private Manager biggerManager;
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
        biggerManager = new Manager();
        biggerManager.add(parkingLotThree);
        biggerManager.add(manager);
    }

    @Test
    public void shouldAskParkingBoyToPark() throws Exception {
        Car car = new Car(001);

        Ticket ticket = biggerManager.parkCar(car);

        assertThat(car, is(biggerManager.getCar(ticket)));
    }

    @Test
    public void shouldPrintOutResult() throws Exception {
        Car car = new Car(001);

        Ticket ticket = biggerManager.parkCar(car);
        String testResult = biggerManager.printResult("--");

        assertThat(car, is(biggerManager.getCar(ticket)));
        assertThat(testResult.contains(
                "--Manager:  \n" +
                "----ParkingLot3: ( 9 / 10 )\n" +
                "----Manager:  \n" +
                "------ParkingLot2: ( 2 / 2 )\n" +
                "------SmartParkingBoy:  \n" +
                "--------ParkingLot1: ( 10 / 10 )"), is(true));
    }
}
