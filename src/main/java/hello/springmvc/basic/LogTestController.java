package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller // 메서드의 반환값이 String 이면 뷰 이름으로 인식. 그래서 뷰를 찾고 뷰가 랜더링 된다
@RestController // 메서드의 반환값이 HTTP 메세지 바디에 바로 입력된다
@Slf4j
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass()); // lombok의 @Slf4j와 같다

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name); //name = Spring
        log.info("info log = {}", name);
        // 2023-11-05 11:24:51.093  INFO 8407 --- [nio-8080-exec-1] hello.springmvc.basic.LogTestController  : info log=Spring
        // 시간 날짜               log level           [실행한 쓰레드]            컨트롤러 이름:                            메세지

        log.trace("trace log={}", name); // local pc / 디버깅시 사용 // application.properties 에서 설정해야 보인다
        log.debug("debug log={}", name); // 개발서버는 debug level // application.properties 에서 설정해야 보인다
        log.info("info log = {}", name); // 운영서버는 info level
        log.warn("info log={}", name);
        log.error("error log={}", name);

//        log.trace("trace log={}" + name); // 문자열의 연산이 먼저 일어나 의미없는 리소스를 사용하기 때문에 사용하면 안된다.

        return "ok"; //html body에 그대로 찍힌다
    }
}
