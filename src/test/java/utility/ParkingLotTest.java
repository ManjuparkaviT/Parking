package utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotTest {

    @Test
    public void testIfCarIsParked(){
        ParkingLot parkingLot = new ParkingLot(20);
        Car car = new Car("AP 405987");

        parkingLot.parking(car);
        String actualCarStatus=car.getStatus();
        String expectedCarStatus="CarParked";

        assertEquals(expectedCarStatus,actualCarStatus);
    }




}
