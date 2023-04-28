package name.lacher.test.spring.playground.customargs.config;

import name.lacher.test.spring.playground.customargs.ExtractedRequestInfoInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Component
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new ExtractedRequestInfoInterceptor());
    }
}
