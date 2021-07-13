package carrental;

public class CustomException extends Exception{
    public CustomException(){
        super("Invalid user!");
    }
}

class CustomException2 extends Exception{
    public CustomException2(){
        super("Invalid password!");
    }
}
