package name.lacher.test.spring.playground.errors.errors;

public class HandledException extends Exception {
    public HandledException(String message, Throwable t){
        super(message, t);
    }
}
