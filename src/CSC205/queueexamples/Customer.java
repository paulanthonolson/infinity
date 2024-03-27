package queueexamples;

public class Customer {
    private int arrivalTime, departureTime;

    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;
        departureTime = 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int totalTime() {
        return departureTime - arrivalTime;
    }
}