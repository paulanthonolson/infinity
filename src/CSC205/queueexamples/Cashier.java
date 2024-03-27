package queueexamples;

public class Cashier {
    private int nextAvailableTime;

    public Cashier(int nextAvailableTime) {
        this.nextAvailableTime = nextAvailableTime;
    }

    public int getNextAvailableTime() {
        return nextAvailableTime;
    }

    public void setNextAvailableTime(int nextAvailableTime) {
        this.nextAvailableTime = nextAvailableTime;
    }
}
