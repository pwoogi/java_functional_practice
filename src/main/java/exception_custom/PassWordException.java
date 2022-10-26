package exception_custom;

public class PassWordException extends IllegalArgumentException{

    public PassWordException(String message){
        super(message);
    }
}
