package soap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import soap.utils.HttpClientUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZhangPY on 2020/2/5
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */

@RestController
public class LoginController {



    @GetMapping(value = "/loginOut")
    public void loginOut() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpClientUtil.doGet("http://localhost:8848/auth2/auth/loginOut" , null);
    }



}
