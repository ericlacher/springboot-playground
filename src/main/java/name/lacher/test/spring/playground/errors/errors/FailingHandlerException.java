package name.lacher.test.spring.playground.errors.errors;

public class FailingHandlerException extends RuntimeException {
    public FailingHandlerException(String message, Throwable cause){
        super(message, cause);
    }
}
