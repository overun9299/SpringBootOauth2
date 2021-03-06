package soap.config;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;


import javax.sql.DataSource;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * token保存在内存中（也可以保存在数据库、Redis中）
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
//        /** 基于 JDBC 实现，令牌保存到数据 */
//        return new JdbcTokenStore(dataSource);
        /** token保存在内存中（也可以保存在数据库、Redis中） */
        return new MyRedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public ClientDetailsService jdbcClientDetails() {
        /** 基于 JDBC 实现，需要事先在数据库配置客户端信息 */
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        /** 设置令牌 */
        endpoints.tokenStore(tokenStore());
        /** 最后一个参数为替换之后授权页面的url */
        endpoints.pathMapping("/oauth/confirm_access","/custom/confirm_access");
        /** 设置失效时间 */

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /** 读取客户端配置 */
        clients.withClientDetails(jdbcClientDetails());
    }
}
