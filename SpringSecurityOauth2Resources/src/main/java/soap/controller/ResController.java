package soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soap.service.AcPermissionService;

/**
 * @ClassName: ResController
 * @Description:
 * @author: 壹米滴答-西安-ZhangPY
 * @version: V1.0
 * @date: 2019/11/18 14:34
 * @Copyright: 2019 www.yimidida.com Inc. All rights reserved.
 */

@RestController
@RequestMapping(value = "/view")
public class ResController {

    @Autowired
    private AcPermissionService acPermissionService;

    @RequestMapping(value = "/getAcPermission")
    public String getAcPermission() {
        return acPermissionService.getAcPermission();
    }
}
