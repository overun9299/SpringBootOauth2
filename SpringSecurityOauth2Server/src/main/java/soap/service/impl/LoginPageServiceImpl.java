package soap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import soap.service.LoginPageService;
import soap.utils.SessionUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ZhangPY on 2020/2/5
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
@Service
public class LoginPageServiceImpl implements LoginPageService {


    @Override
    public String loginOut() {
        /** 删除session */
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        
        SessionUtils.removeAttr(request , "SPRING_SECURITY_CONTEXT");
        SessionUtils.removeAttr(request , "org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository.CSRF_TOKEN");

        /** 删除redis */
        return null;
    }
}
