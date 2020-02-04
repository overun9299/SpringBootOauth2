package soap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    /**
     * /view/getAcPermissionNoAuth/** 路径放行
     * /auth2Res/** 路径需要有System权限
     * /view/getAcPermission/** 路径需要有SystemUserView权限
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        /** 此处对应ac_permission这张表 */
        http.authorizeRequests()
                .antMatchers("/view/getAcPermissionNoAuth/**").permitAll()
                .antMatchers("/auth2Res/**").hasAuthority("System")
                .antMatchers("/view/getAcPermission/**").hasAuthority("SystemUserView").and().formLogin();
    }

}