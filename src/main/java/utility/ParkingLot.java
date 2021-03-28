package utility;

import javax.naming.LimitExceededException;
import java.util.ArrayList;

public class ParkingLot{
    private final int parkingLotCapacity;
    private int availableParkingSlots;
    private ArrayList<Car> parkedCars = new ArrayList<Car>();
    private ParkingLotOwner parkingLotOwner;

    public ParkingLot(int parkingLotCapacity){
        this.parkingLotCapacity=parkingLotCapacity;
        this.availableParkingSlots=parkingLotCapacity;
    }

    public ParkingLot(int parkingLotCapacity,ParkingLotOwner parkingLotOwner) {
        this.parkingLotCapacity = parkingLotCapacity;
        this.availableParkingSlots = parkingLotCapacity;
        this.parkingLotOwner=parkingLotOwner;
    }

    public void park(Car car) throws LimitExceededException, CarIsAlreadyParkedException {

        if (parkedCars.contains(car)) {
            throw new CarIsAlreadyParkedException();
        }
        else if (isParkingSlotAvailable()) {
            this.availableParkingSlots -= 1;
            parkedCars.add(car);
            if(this.availableParkingSlots==0){
                parkingLotOwner.notifyFull();
            }
        }
        else {
            throw new LimitExceededException("No Parking Slot Is Available");
        }
    }

    public void unPark(Car car) throws CarIsNotAvailableException {

        if (parkedCars.contains(car)) {
            parkedCars.remove(car);
            this.availableParkingSlots+=1;
        }
        else {
            throw new CarIsNotAvailableException();
        }
    }

    private boolean isParkingSlotAvailable() {
        if (availableParkingSlots > 0) return true;
        return false;
    }


}
