package soap.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.redis.JdkSerializationStrategy;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStoreSerializationStrategy;
import org.springframework.stereotype.Service;
import soap.domain.AcPermission;
import soap.mapper.AcPermissionMapper;
import soap.redis.JedisTools;
import soap.service.AcPermissionService;
import soap.utils.SerializeUtil;

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

    @Autowired
    private JedisTools jedisTools;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Override
    public String getAcPermission() {
        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
        OAuth2RefreshToken oAuth2RefreshToken = redisTokenStore.readRefreshToken("d2e17f0d-7ac9-485f-89d5-b2e1794f3586");
        OAuth2Authentication oAuth2Authentication = redisTokenStore.readAuthentication("bc1757e8-8d07-4bcd-92c6-9fbf413d1fa7");
        OAuth2AccessToken oAuth2AccessToken = redisTokenStore.readAccessToken("bc1757e8-8d07-4bcd-92c6-9fbf413d1fa7");





        List<AcPermission> acPermissions = acPermissionMapper.selectByExample(null);
        return JSONObject.toJSONString(acPermissions);
    }
}
