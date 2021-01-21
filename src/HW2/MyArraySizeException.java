package HW2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(){
        super("Array size is incorrect");
    }
}
