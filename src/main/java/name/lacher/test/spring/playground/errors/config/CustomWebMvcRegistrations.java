package name.lacher.test.spring.playground.errors.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;


@Configuration
public class CustomWebMvcRegistrations implements WebMvcRegistrations {
    // This will override the exceptionResolver for handled exceptions using WebMvcRegistrations
    @Override
    public ExceptionHandlerExceptionResolver getExceptionHandlerExceptionResolver() {
        return new LoggingExceptionHandlerExceptionResolver();
    }
}