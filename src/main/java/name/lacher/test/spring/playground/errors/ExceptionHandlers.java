package name.lacher.test.spring.playground.errors;

import name.lacher.test.spring.playground.errors.errors.FailingHandlerException;
import name.lacher.test.spring.playground.errors.errors.HandledException;
import name.lacher.test.spring.playground.errors.errors.HandledRuntimeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler
    public ResponseEntity<String> handle(HandledException handledException) {
        return ResponseEntity.internalServerError().body(handledException.toString());
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(HandledRuntimeException handledRuntimeException) {
        return ResponseEntity.internalServerError().body(handledRuntimeException.toString());
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(FailingHandlerException failingHandlerException) {
        // throwing in handler
        throw new RuntimeException("Failing to handle", failingHandlerException);
    }

    // If this is enabled, all endpoints' exceptions will get handled. The only exception logged by catalina will be
    // FailingHandlerException, due to the error being throw in the actual handler.
/*
    @ExceptionHandler
    public ResponseEntity<String> handle(Exception exception){
        return ResponseEntity.internalServerError().body(exception.toString());
    }
*/
}
