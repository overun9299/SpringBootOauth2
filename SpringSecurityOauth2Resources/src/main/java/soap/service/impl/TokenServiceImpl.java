package soap.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import soap.service.TokenService;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangPY on 2020/2/3
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
@Service
public class TokenServiceImpl implements TokenService {

    /** 请求类型 */
    @Value("${grantType}")
    private String grantType;

    /** 平台用户名 */
    @Value("${security.oauth2.client.client-id}")
    private String username;

    /** 平台密码 */
    @Value("${security.oauth2.client.client-secret}")
    private String password;

    /** 请求路径 */
    @Value("${get-access-token-by-code-url}")
    private String url;

    @Override
    public String getAccessTokenByCode(String code) {
        if (StringUtils.isNotBlank(code)) {
            try {
                String result = "";

                Map<String , String> requestMap = new HashMap<>();
                requestMap.put("grant_type", grantType);
                requestMap.put("username", username);
                requestMap.put("password", password);
                requestMap.put("code", code);
                /** 创建HttpClientBuilder */
                HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
                CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
                HttpPost httpPost = new HttpPost(url);
                /** 添加http头信息 */
                httpPost.addHeader("Authorization", "Basic " + Base64.getUrlEncoder().encodeToString((username + ":" + password).getBytes()));
                MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                requestMap.forEach((k,v)->{
                    builder.addPart(k, new StringBody(v, ContentType.MULTIPART_FORM_DATA));
                });

                HttpEntity postEntity = builder.build();
                httpPost.setEntity(postEntity);
                HttpResponse httpResponse = null;
                HttpEntity entity = null;

                try {
                    httpResponse = closeableHttpClient.execute(httpPost);
                    entity = httpResponse.getEntity();
                    if( entity != null ){
                        result = EntityUtils.toString(entity);
                    }
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 关闭连接
                closeableHttpClient.close();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "code无效！";
    }
}
