package soap.service;

import soap.domain.AcPermission;

import java.util.List;

/**
 * @ClassName: AcPermissionService
 * @Description:
 * @author: 壹米滴答-西安-ZhangPY
 * @version: V1.0
 * @date: 2019/11/18 14:37
 * @Copyright: 2019 www.yimidida.com Inc. All rights reserved.
 */
public interface AcPermissionService {

    /**
     * 获取的权限（测试）
     * @return
     */
    String getAcPermission();

    /**
     * 获取client对应的AcPermission
     * @return
     */
    List<AcPermission> getAcPermissionByClientId();
}
