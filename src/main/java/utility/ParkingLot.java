package utility;

import javax.naming.LimitExceededException;

public class ParkingLot {
    private int parkingLotCapacity;

    public ParkingLot(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
    }

    public void parking(Car car) throws LimitExceededException {
        if(isParkingSlotAvailable())
        {
            this.parkingLotCapacity-=1;
            car.setStatus("CarParked");
        }
        else {
            throw new LimitExceededException("No Parking Slot Is Available");
        }
    }

    private boolean isParkingSlotAvailable() {
        if(parkingLotCapacity>0)return true;
        return false;
    }
}
