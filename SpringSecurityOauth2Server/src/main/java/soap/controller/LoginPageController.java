package soap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ZhangPY on 2020/2/3
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
@Controller
public class LoginPageController {


    /**
     * 跳转登陆页面方法
     * @param model
     * @return
     */
    @GetMapping("/auth/login")
    public String loginPage(Model model) {

        model.addAttribute("loginProcessUrl", "/auth2/auth/authorize");

        return "base-login";
    }
}
