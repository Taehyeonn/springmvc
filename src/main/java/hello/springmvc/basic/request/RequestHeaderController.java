package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String header(HttpServletRequest request,
                         HttpServletResponse response,
                         HttpMethod httpMethod,
                         Locale locale,
                         @RequestHeader MultiValueMap<String, String> headerMap, //MultiValueMap: 하나의 키에 여러 값을 받을 수 있다
                         @RequestHeader("host") String host,
                         @CookieValue(value = "myCookie", required = false) String cookie
                         ) {

        log.info("request={}", request); //request=org.apache.catalina.connector.RequestFacade@3af8fdb0
        log.info("response={}", response); //response=org.apache.catalina.connector.ResponseFacade@1c052ef1
        log.info("httpMethod={}", httpMethod); //httpMethod=GET
        log.info("locale={}", locale); //locale=ko_KR
        log.info("headerMap={}", headerMap); //headerMap={content-type=[application/json], user-agent=[PostmanRuntime/7.34.0], accept=[*/*], postman-token=[b667fd88-820a-4839-816e-d36e506bbb93], host=[localhost:8080], accept-encoding=[gzip, deflate, br], connection=[keep-alive], content-length=[29]}
        log.info("header host={}", host); //header host=localhost:8080
        log.info("myCookie={}", cookie); //myCookie=null

        return "ok";
    }
}
