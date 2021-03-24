package utility;

public class ParkingLot {

    private int parkingLotCapacity;

    public ParkingLot(int parkingLotCapacity) {
        this.parkingLotCapacity = parkingLotCapacity;
    }

    public void parking(Car car) {
        if(isParkingSlotAvailable()){
            this.parkingLotCapacity-=1;
            car.setStatus("CarParked");
        }
    }

    private boolean isParkingSlotAvailable() {
        if(parkingLotCapacity>0)return true;
        return false;
    }
}
