package utility;

import org.junit.jupiter.api.Test;

import javax.naming.LimitExceededException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingLotTest {

    @Test
    public void testIfCarIsParked() throws LimitExceededException {
        ParkingLot parkingLot = new ParkingLot(20);
        Car car = new Car("AP 405987");

        parkingLot.parking(car);
        String actualCarStatus=car.getStatus();
        String expectedCarStatus="CarParked";

        assertEquals(expectedCarStatus,actualCarStatus);
    }

    @Test
    public void testThrowsExceptionIfParkingSlotIsNotAvailable() throws LimitExceededException {
        ParkingLot parkingLot = new ParkingLot(2);
        Car firstCar = new Car("AP 405987");
        Car secondCar = new Car("TN 405987");
        Car thirdCar = new Car("AP 405642");

        parkingLot.parking(firstCar);
        parkingLot.parking(secondCar);
        Exception actual = assertThrows(LimitExceededException.class, () -> parkingLot.parking(thirdCar));

        assertEquals("No Parking Slot Is Available",actual.getMessage());

    }
}
