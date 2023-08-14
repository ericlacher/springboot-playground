package name.lacher.test.spring.playground.errors.errors;

public class HandledRuntimeException extends RuntimeException {
    public HandledRuntimeException(String message, Throwable t){
        super(message, t);
    }
}
