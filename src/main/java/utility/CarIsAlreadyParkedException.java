package utility;

public class CarIsAlreadyParkedException extends Exception {

    public CarIsAlreadyParkedException(){
        super("Your car is already parked");
    }
}
