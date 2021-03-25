package utility;

import javax.naming.LimitExceededException;
import java.util.ArrayList;

public class ParkingLot {
    private final int parkingLotCapacity;
    private int availableParkingSlots;
    private ArrayList<Car> parkedCars = new ArrayList<Car>();

    public ParkingLot(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
        this.availableParkingSlots = parkingLotCapacity;
    }

    public void park(Car car) throws LimitExceededException, CarIsAlreadyParkedException {

        if (parkedCars.contains(car)) {
            throw new CarIsAlreadyParkedException();
        } else if (isParkingSlotAvailable()) {
            this.availableParkingSlots -= 1;
            parkedCars.add(car);
        } else {
            throw new LimitExceededException("No Parking Slot Is Available");
        }
    }

    public void unPark(Car car) throws CarIsNotAvailableException {

        if (parkedCars.contains(car)) parkedCars.remove(car);
        else {
            throw new CarIsNotAvailableException();
        }
    }

    private boolean isParkingSlotAvailable() {

        if (availableParkingSlots > 0) return true;
        return false;
    }
}
