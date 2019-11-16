package soap.service;

import soap.domain.AcUser;

/**
 * @ClassName: AcUserService
 * @Description:
 * @author: 壹米滴答-西安-ZhangPY
 * @version: V1.0
 * @date: 2019/11/12 13:50
 * @Copyright: 2019 www.yimidida.com Inc. All rights reserved.
 */
public interface AcUserService {


    /**
     * 通过用户名查询用户信息
     *
     * @param username
     * @return
     */
    AcUser selectAcUserByUserName(String username);
}
