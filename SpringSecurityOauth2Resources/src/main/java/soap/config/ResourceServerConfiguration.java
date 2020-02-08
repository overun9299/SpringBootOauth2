package soap.config;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import soap.domain.AcPermission;
import soap.service.AcPermissionService;

import java.util.List;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


    @Autowired
    private AcPermissionService acPermissionService;

    /**
     * /view/getAcPermissionNoAuth/** 路径放行
     * /auth2Res/** 路径需要有System权限
     * /view/getAcPermission/** 路径需要有SystemUserView权限
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        /** 此处可能有加载顺序bug，因为声明的顺序，必须先声明范围小的，
         * 再声明范围大的，但是数据库数据顺序可能错乱，
         * 所以建议数据库添加顺序字段，然后排序查询
         * https://blog.csdn.net/weixin_42844971/article/details/89338354 */


        /** 从ac_permission表获取数据 */
        List<AcPermission> acPermissionByClientId = acPermissionService.getAcPermissionByClientId();
        /** 声明 */
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry = http.authorizeRequests();
        /** 遍历 */
        for (AcPermission acPermission : acPermissionByClientId) {
            if ("0".equals(acPermission.getPermit())) {
                expressionInterceptUrlRegistry.antMatchers(acPermission.getUrl()).permitAll();
            } else {
                expressionInterceptUrlRegistry.antMatchers(acPermission.getUrl()).hasAuthority(acPermission.getEnname());
            }
        }
        /** 确认 */
        expressionInterceptUrlRegistry.and().formLogin();

//        /** 此处对应ac_permission这张表 */
//        http.authorizeRequests()
//                .antMatchers("/loginOut/**").permitAll()
//                .antMatchers("/getAccessTokenByCode/**").permitAll()
//                .antMatchers("/view/getAcPermissionNoAuth/**").permitAll()
//                .antMatchers("/addAcUser/**").hasAuthority("System")
//                .antMatchers("/view/getAcPermission/**").hasAuthority("SystemUserView").and().formLogin();
    }

}
