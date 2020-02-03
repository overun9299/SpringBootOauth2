package soap.service;

/**
 * Created by ZhangPY on 2020/2/3
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
public interface TokenService {

    /**
     * 通过code获取AccessToken
     * @param code
     * @return
     */
    String getAccessTokenByCode(String code);
}
