package overun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: SpringBootAuth
 * @Description: Oauth2授权模块
 * @author: 壹米滴答-西安-ZhangPY
 * @version: V1.0
 * @date: 2019/8/21 15:12
 * @Copyright: 2019 www.yimidida.com Inc. All rights reserved.
 */

@SpringBootApplication
public class SpringBootAuth {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAuth.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}
