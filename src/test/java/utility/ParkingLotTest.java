package utility;
import org.junit.jupiter.api.Test;

import javax.naming.LimitExceededException;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void testIfCarIsParked(){
        ParkingLot parkingLot = new ParkingLot(20);
        Car car = new Car();

        assertDoesNotThrow(()->parkingLot.park(car));

    }

    @Test
    public void testThrowsExceptionIfCarIsAlreadyParked()
            throws CarIsAlreadyParkedException, LimitExceededException {
        ParkingLot parkingLot = new ParkingLot(20);
        Car car = new Car();

        parkingLot.park(car);

        assertThrows(CarIsAlreadyParkedException.class,()->parkingLot.park(car));
    }

    @Test
    public void testThrowsExceptionIfParkingSlotIsNotAvailable()
            throws LimitExceededException, CarIsAlreadyParkedException {
        ParkingLot parkingLot = new ParkingLot(2);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();

        parkingLot.park(firstCar);
        parkingLot.park(secondCar);
        Exception actual = assertThrows(LimitExceededException.class, () -> parkingLot.park(thirdCar));

        assertEquals("No Parking Slot Is Available",actual.getMessage());
    }

    @Test
    public void testIfCarIsUnParked()
            throws CarIsAlreadyParkedException, LimitExceededException {
        ParkingLot parkingLot=new ParkingLot(3);
        Car car=new Car();

        parkingLot.park(car);

        assertDoesNotThrow(() -> parkingLot.unPark(car));
    }

    @Test
    public void testThrowsExceptionIfTheCarToBeUnParkedIsNotAvailable(){
        ParkingLot parkingLot=new ParkingLot(3);
        Car car=new Car();

        assertThrows(CarIsNotAvailableException.class,() -> parkingLot.unPark(car));
    }
}
