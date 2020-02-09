package soap.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soap.domain.AcUser;
import soap.domain.AcUserExample;
import soap.mapper.AcUserMapper;
import soap.service.AcUserService;
import soap.utils.BCryptUtil;

import java.util.*;

/**
 * Created by ZhangPY on 2020/2/7
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
@Service
public class AcUserServiceImpl implements AcUserService {

    @Autowired
    private AcUserMapper acUserMapper;

    @Override
    public String addAcUser(AcUser acUser) {
        Map<String , Object> result = new HashMap<>();
        if (acUser != null) {
            if (StringUtils.isNotBlank(acUser.getUsername())) {
                AcUserExample example = new AcUserExample();
                example.or().andUsernameEqualTo(acUser.getUsername());
                List<AcUser> acUsers = acUserMapper.selectByExample(example);
                if (acUsers.size() > 0) {
                    /** 报错，存在相同 */
                    result.put("msg" , "存在相同的用户");
                    result.put("succeed" , false);
                    return JSONObject.toJSONString(result);
                }
                /** 设置id */
                acUser.setId(String.valueOf(System.currentTimeMillis()));
                /** 加密密码 */
                acUser.setPassword(BCryptUtil.userEncode(acUser.getPassword()));
                /** 创建、更新时间 */
                acUser.setCreateTime(new Date());
                acUser.setUpdateTime(new Date());
                /** 设置状态 */
                acUser.setStatus("0");
                int insert = acUserMapper.insert(acUser);
                if (insert == 1) {
                    result.put("msg" , "新增成功");
                    result.put("succeed" , true);
                    return JSONObject.toJSONString(result);
                }
            }

        }
        result.put("msg" , "数据异常");
        result.put("succeed" , false);

        return JSONObject.toJSONString(result);
    }
}
