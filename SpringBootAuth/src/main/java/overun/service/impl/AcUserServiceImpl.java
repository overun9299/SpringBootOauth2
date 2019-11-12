package overun.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import overun.mapper.AcUserMapper;
import overun.service.AcUserService;
import overun.vo.AcUser;
import overun.vo.AcUserExample;
import overun.vo.UserCust;

import java.util.List;

/**
 * @ClassName: AcUserServiceImpl
 * @Description:
 * @author: 壹米滴答-西安-ZhangPY
 * @version: V1.0
 * @date: 2019/11/12 13:58
 * @Copyright: 2019 www.yimidida.com Inc. All rights reserved.
 */
@Service
public class AcUserServiceImpl implements AcUserService {

    @Autowired
    private AcUserMapper acUserMapper;

    @Override
    public AcUser selectAcUserByUserName(String username) {
        if (StringUtils.isNotBlank(username)) {
            AcUserExample example = new AcUserExample();
            example.or().andUsernameEqualTo(username);
            List<AcUser> acUsers = acUserMapper.selectByExample(example);
            if (acUsers != null && acUsers.size() > 0) {
                return acUsers.get(0);
            }
        }
        return null;
    }
}
