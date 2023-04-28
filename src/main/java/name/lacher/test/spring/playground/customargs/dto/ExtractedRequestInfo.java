package name.lacher.test.spring.playground.customargs.dto;

import lombok.Builder;
import lombok.Getter;
// actual class we want to allow as RequestMapping param
@Builder
@Getter
public class ExtractedRequestInfo {
    private String customHeader;
    private String customQueryArg;
}
