package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView modelAndView = new ModelAndView("/response/hello")
                .addObject("data", "안녕v1");

        return modelAndView;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "하이하이v2");
        return "/response/hello";
    }

    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "하이하이v3");
    }

    /*
    * @Controller를 사용하면서 HttpServletResponse, OutputStream(Writer)과 같은
    * HTTP 메세지 바디 처리 파라미터가 없으면 요청 URL 참고해서 논리적 뷰를 반환한다.
    * 직관적이지 않아 사용이 지양됨.
    * 요청 URL: '/response/hello'
          실행: templates'/response/hello'.html
    * */
}
