package carrental;

public class Info {
    
    private String name;
    private String ic;
    private Date date;
    private Car car;

    public Info(){
        
    }
    public Info(String name, String ic, Date date, Car car){
        this.name = name;
        this.ic = ic;
        this.date = date;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public String getIc() {
        return ic;
    }

    public Date getDate() {
        return date;
    }
    
    public Car getCar(){
        return car;
    }
    
    public double calculateFee(){
        return car.calculateFee();
    }

    public String toString(){
        return String.format("<html>Name: " + getName() + 
                             "<br>IC: " + getIc() +
                             "<br>Date: " + getDate());
    }
}