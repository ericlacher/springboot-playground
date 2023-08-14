package name.lacher.test.spring.playground.errors.config;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
// HandlerExceptionResolver. Does the same as the extended (Spring default) one, except it logs all exceptions
public class LoggingExceptionHandlerExceptionResolver extends ExceptionHandlerExceptionResolver {

    @Override
    protected void logException(Exception ex, HttpServletRequest request) {
        // always log exception, do not check for spring.mvc.logResolvedException config.
        // see original implementation in AbstractHandlerExceptionResolver
        LoggerFactory.getLogger(ex.getClass()).error("Resolved Exception:", ex);
    }
}
