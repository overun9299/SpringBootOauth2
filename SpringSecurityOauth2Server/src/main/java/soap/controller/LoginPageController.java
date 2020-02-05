package soap.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import soap.utils.CookieUtil;
import soap.utils.SessionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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


    /**
     * 登出
     */
    @GetMapping("/auth/loginOut")
    @ResponseBody
    public void loginOut() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        SessionUtils.removeAttr(request , "SPRING_SECURITY_CONTEXT");
        SessionUtils.removeAttr(request , "org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository.CSRF_TOKEN");
    }


    /**
     * 取出cookie中的身份令牌
     * @return
     */
    private String getTokenFormCookie(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> map = CookieUtil.readCookie(request, "JSESSIONID");
        if(map!=null && map.get("JSESSIONID")!=null){
            String sessionId = map.get("JSESSIONID");
            return sessionId;
        }
        return null;
    }
}
