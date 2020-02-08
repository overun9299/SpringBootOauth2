package soap.service;

import soap.domain.AcUser;

/**
 * Created by ZhangPY on 2020/2/7
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
public interface AcUserService  {

    /**
     * 新增user
     * @param acUser
     * @return
     */
    String addAcUser(AcUser acUser);
}
