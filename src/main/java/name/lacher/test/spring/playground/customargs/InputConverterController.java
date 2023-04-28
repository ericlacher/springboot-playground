package name.lacher.test.spring.playground.customargs;

import name.lacher.test.spring.playground.customargs.dto.ExtractedRequestInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/customargs")
public class InputConverterController {

    @GetMapping("/info")
    public ExtractedRequestInfo handleConvertedRequest(ExtractedRequestInfo info){
        return info;
    }
}
