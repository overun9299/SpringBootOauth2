package soap.service;

import soap.domain.AcPermission;

import java.util.List;

/**
 * @ClassName: AcPermissionService
 * @Description:
 * @author: 壹米滴答-西安-ZhangPY
 * @version: V1.0
 * @date: 2019/11/18 16:06
 * @Copyright: 2019 www.yimidida.com Inc. All rights reserved.
 */
public interface AcPermissionService {


    /**
     * 根据用户id查询权限
     * @param id
     * @return
     */
    List<AcPermission> selectPermissionByUserId(Long id);
}
