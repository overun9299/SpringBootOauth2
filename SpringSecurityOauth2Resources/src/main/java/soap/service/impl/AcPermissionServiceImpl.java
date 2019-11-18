package soap.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soap.domain.AcPermission;
import soap.mapper.AcPermissionMapper;
import soap.service.AcPermissionService;

import java.util.List;

/**
 * @ClassName: AcPermissionServiceImpl
 * @Description:
 * @author: 壹米滴答-西安-ZhangPY
 * @version: V1.0
 * @date: 2019/11/18 14:37
 * @Copyright: 2019 www.yimidida.com Inc. All rights reserved.
 */
@Service
public class AcPermissionServiceImpl implements AcPermissionService {

    @Autowired
    private AcPermissionMapper acPermissionMapper;

    @Override
    public String getAcPermission() {
        List<AcPermission> acPermissions = acPermissionMapper.selectByExample(null);
        return JSONObject.toJSONString(acPermissions);
    }
}
