package carrental;

public class Payment {
    private Info info;
    private double pay;
    
    public Payment(Info info, double pay){
        this.pay = pay;
        this.info = info;
    }
    
    //define getter
    public double getPay(){
        return pay;
    }
    
    public double returnFee(){
        double fee = (getPay() - info.calculateFee());
        return fee;
    }
    
    public String toString(){
        return String.format("<html>Payment amount: RM " + getPay() +
                             "<br>Return: RM " + returnFee());
    }
}