package utility;

public class Car {
    private String status;
    String registrationNumber;

    public Car(String registrationNumber) {
        this.registrationNumber=registrationNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
