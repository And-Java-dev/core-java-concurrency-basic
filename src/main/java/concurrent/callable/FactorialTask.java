package concurrent.callable;

import java.util.concurrent.Callable;

public class FactorialTask implements Callable {
    int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    public Integer call() throws InvalidParameterException {
        int fact = 1;
        if (number < 0){

            throw new InvalidParameterException("Number must be positive");
        }

        for (int i = number; i >1; i--) {
            fact = fact * i;
        }
        return fact;
    }

    private static class InvalidParameterException extends  Exception{
        public InvalidParameterException(String message){
            super(message);
        }
    }
}
