package HW2;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException (String message){
        super("incorrect data "+ message);
    }

}
