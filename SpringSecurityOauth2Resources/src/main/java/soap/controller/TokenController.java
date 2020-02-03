package soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import soap.service.TokenService;

/**
 * Created by ZhangPY on 2020/2/3
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
@RestController
public class TokenController {


    @Autowired
    private TokenService tokenService;

    /**
     * 通过code获取AccessToken
     * @param code
     * @return
     */
    @GetMapping(value = "/getAccessTokenByCode")
    public String getAccessTokenByCode(String code) {

        return tokenService.getAccessTokenByCode(code);
    }
}
