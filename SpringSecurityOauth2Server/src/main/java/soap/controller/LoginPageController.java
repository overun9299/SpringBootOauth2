package soap.controller;



import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import soap.service.LoginPageService;
import soap.utils.SessionUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZhangPY on 2020/2/3
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
@Controller
public class LoginPageController {

    @Autowired
    private LoginPageService loginPageService;

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


    /**
     * 登出
     */
    @GetMapping("/auth/loginOut")
    @ResponseBody
    public String loginOut() {
        return loginPageService.loginOut();
    }
}
