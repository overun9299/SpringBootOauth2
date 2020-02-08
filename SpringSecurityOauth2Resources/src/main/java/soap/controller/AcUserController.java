package soap.controller;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soap.domain.AcUser;
import soap.service.AcUserService;

/**
 * 新增登陆user
 * Created by ZhangPY on 2020/2/7
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
@RestController
public class AcUserController {

    @Autowired
    private AcUserService acUserService;

    /**
     * 新增用户
     * @param acUser
     * @return
     */
    @RequestMapping(value = "/addAcUser")
    public String addAcUser(AcUser acUser) {
        return acUserService.addAcUser(acUser);
    }
}
