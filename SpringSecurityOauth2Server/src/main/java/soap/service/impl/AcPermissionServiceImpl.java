package soap.service.impl;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soap.domain.AcPermission;
import soap.mapper.AcUserMapper;
import soap.service.AcPermissionService;

import java.util.List;

/**
 * @ClassName: AcPermissionServiceImpl
 * @Description:
 * @author: 壹米滴答-西安-ZhangPY
 * @version: V1.0
 * @date: 2019/11/18 16:06
 * @Copyright: 2019 www.yimidida.com Inc. All rights reserved.
 */
@Service
public class AcPermissionServiceImpl implements AcPermissionService {

    @Autowired
    AcUserMapper acUserMapper;

    @Override
    public List<AcPermission> selectPermissionByUserId(Long id) {
        return acUserMapper.selectPermissionByUserId(id);
    }
}
