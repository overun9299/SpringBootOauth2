package soap.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;
import soap.domain.AcUser;
import soap.service.AcUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义用户认证与授权
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2019-04-04 23:57:04
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClientDetailsService clientDetailsService;

    @Autowired
    private AcUserService acUserService;

    /**
     * 校验用户信息，并返回用户信息（密码模式会先走这一步）
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
//        /** 取出身份，如果身份为空说明没有认证 */
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        /** 没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret */
//        if(authentication==null){
//            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
//            if(clientDetails!=null){
//                /** 密码 */
//                String clientSecret = clientDetails.getClientSecret();
//                return new User(username,clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
//            }
//        }
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        /** 远程调用用户中心根据账号查询用户信息 */
        AcUser userext = acUserService.selectAcUserByUserName(username);
        if(userext == null){
            /** 返回空给spring security表示用户不存在 */
            return null;
        }

        /** 取出正确密码（hash值） */
        String password = userext.getPassword();
        /** 从数据库获取权限 */
        List<String> user_permission = new ArrayList<>();
        /** 这里先放入假数据，真实环境使用从数据库获取 */
        user_permission.add("course_get_baseinfo");
        user_permission.add("course_find_pic");

        /** 声明用户授权 */
        user_permission.forEach(permission -> {
            if (permission != null && StringUtils.isNotBlank(permission)) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission);
                grantedAuthorities.add(grantedAuthority);
            }
        });

        return new User(userext.getUsername() , userext.getPassword() , grantedAuthorities);
    }
}
