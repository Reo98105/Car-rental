package carrental;

public abstract class Car {
    protected String model;
    protected int duration;
    
    public Car(String model, int duration){
        this.duration = duration;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public int getDuration() {
        return duration;
    }
    
    public abstract double calculateFee();
}