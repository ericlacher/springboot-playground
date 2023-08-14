package name.lacher.test.spring.playground.errors;

import name.lacher.test.spring.playground.errors.errors.FailingHandlerException;
import name.lacher.test.spring.playground.errors.errors.HandledException;
import name.lacher.test.spring.playground.errors.errors.HandledRuntimeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/errors")
public class RestController {
    // throwing an exception which is handled in ExceptionHandlers
    @GetMapping("/1")
    public String myException() throws HandledException {
        throw new HandledException(
                "MyException",
                new Exception("Cause")
        );
    }

    // throwing a runtime exception which is handled in ExceptionHandlers
    @GetMapping("/2")
    public String myRuntimeException(){
        throw new HandledRuntimeException(
                "MyRuntimeException",
                new RuntimeException("Cause")
        );
    }

    // throwing an exception which is not handled in ExceptionHandlers
    @GetMapping("/3")
    public String exception() throws Exception {
        throw new Exception(
                "Exception",
                new Exception("Cause")
        );
    }

    // throwing a runtime exception which is not handled in ExceptionHandlers
    @GetMapping("/4")
    public String runtimeException(){

        throw new RuntimeException(
                "RuntimeException",
                new RuntimeException("Cause")
        );
    }

    // throwing an exception which is handled in ExceptionHandlers, but the handler will throw
    @GetMapping("/5")
    public String failingHandlerException(){

        throw new FailingHandlerException(
                "failingHandlerException",
                new RuntimeException("Cause")
        );
    }
}
