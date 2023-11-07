package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello"; // controller + String 반환: 뷰 리졸버가 실행되어서 뷰를 찾고 렌더링한다
    }

    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) { //void를 반환하는 경우: 바디를 처리하는 파라미터가 없으면 URL을 논리뷰 이름으로 사용
        model.addAttribute("data", "hello!"); // 명시성이 너무 떨어지고 불명확해서 권장하는 방법은 아님
    }
}
