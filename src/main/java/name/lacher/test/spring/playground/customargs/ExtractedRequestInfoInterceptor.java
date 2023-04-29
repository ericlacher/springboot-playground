package name.lacher.test.spring.playground.customargs;

import name.lacher.test.spring.playground.customargs.dto.ExtractedRequestInfo;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

// extract info from request into ExtractedRequestInfo
// use header 'x-custom' or query param 'custom" to modify input
public class ExtractedRequestInfoInterceptor implements HandlerMethodArgumentResolver {
    public static final String CUSTOM_HEADER = "x-custom";
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // only apply if argument is of type ExtractedRequestInfo
        return parameter.getParameter().getType().equals(ExtractedRequestInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        // extract custom info from request
        return ExtractedRequestInfo
                .builder()
                .customHeader(
                        servletRequest.getHeader(CUSTOM_HEADER)
                )
                .customQueryArg(
                        servletRequest.getParameter("custom")
                )
                .build();

    }
}
