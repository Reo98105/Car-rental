package carrental;

public class MPV extends Car {
    private double HOURLYFEE = 10;
    private double CHARGEFEE = 10;

    public MPV(String model, int duration) {
        super(model, duration);
    }  
    public double calculateFee(){
        double total = (getDuration() * HOURLYFEE) + CHARGEFEE;
        return total;
    }
}