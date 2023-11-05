package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody //controller가 String을 반환하면 뷰의 주소값을 찾지만 @ResponseBody 를 달면 RestController와 같은 효과
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName, //요청 파라미터 애노테이션 사용
            @RequestParam("age") int memberAge){

            log.info("username={}, age={}", memberName, memberAge);
            return "ok"; //html body에 출력
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username, // http 파라미터 이름이 변수이름과 같으면 () 생략가능
            @RequestParam int age){

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){ // String, int, Integer 등 단순 타입이면 @RequestParam 생략가능
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam String username,
            @RequestParam(required = false) Integer age){ //@RequestParam(required = false) 생략가능 =null처리.
                                                        //기본형인 int에는 null이 들어갈 수 없기에 객체형인 Integer 선언
                                                        // null은 못들어가나, 빈문자("")는 들어갈 수 있다
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username, //기본값을 적용해주는 defaultValue를 쓰면 required는 의미가 없다.
            @RequestParam(defaultValue = "-1") int age){            //빈문자인경우에도 기본값 적용
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) { //파라미터의 값이 1개가 확실하다면 Map, 그렇지않다면 MultiValueMap 사용
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }
}
