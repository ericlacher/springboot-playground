package name.lacher.test.spring.playground.errors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErrorsApp {
    /*
    This app offers 5 endpoints (/errors/1 to /errors/5), which cause different behaviour (see controller).
    The main goal was to better understand how we could log all exceptions (handled and unhandled).
     */
    public static void main(String[] args) {
        SpringApplication.run(ErrorsApp.class, args);
    }
}
