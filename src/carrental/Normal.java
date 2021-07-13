package carrental;

public class Normal extends Car {
    private double HOURLYFEE = 6;

    public Normal(String model, int duration){
        super(model, duration);
    }
    
    public double calculateFee(){
        double total = getDuration() * HOURLYFEE;
        return total;
    }
}