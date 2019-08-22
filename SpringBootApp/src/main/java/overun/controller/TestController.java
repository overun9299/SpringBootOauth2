package overun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestController
 * @Description:
 * @author: 壹米滴答-西安-ZhangPY
 * @version: V1.0
 * @date: 2019/8/22 17:15
 * @Copyright: 2019 www.yimidida.com Inc. All rights reserved.
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test")
    public String test() {
        System.out.println("success");
        return "success";
    }
}
